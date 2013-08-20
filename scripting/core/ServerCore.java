package scripting.core;

import static scripting.ScriptingMod.SECTION;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import scripting.Config;
import scripting.ScriptingMod;
import scripting.Selection;
import scripting.core.script.BasicScript;
import scripting.core.script.FilterScript;
import scripting.core.script.JSScript;
import scripting.packet.ScriptPacket;
import scripting.packet.ScriptPacket.PacketType;
import scripting.packet.SettingsPacket;
import scripting.wrapper.ScriptSelection;
import scripting.wrapper.entity.ScriptPlayer;
import scripting.wrapper.settings.Setting;
import scripting.wrapper.world.ScriptWorld;
import cpw.mods.fml.common.network.PacketDispatcher;

public class ServerCore extends ScriptCore {

	public ServerCore(File dir, Map<String, Object> props, Map<String, Class<?>> abbreviations) {
		super(ScriptLoader.loadAllScripts(dir, false), props, abbreviations);

		System.out.println("[SCRIPTS] Server core initialized on " + Thread.currentThread());
	}

	@Override
	public boolean hasScripts() {
		if (scripts.isEmpty())
			return false;
		for (JSScript script : scripts.values())
			if (script instanceof BasicScript)
				return true;
		return false;
	}

	public List<String> getFilterScripts() {
		List<String> filters = new ArrayList<String>();
		for (JSScript script : scripts.values())
			if (script instanceof FilterScript) //Remove .filter extension
				filters.add(script.name.substring(0,script.name.length() - 7));
		Collections.sort(filters);
		return filters;
	}

	/**
	 * Notifies OPs/whitelisted users of the script crash.
	 */
	@Override
	protected void notifyCrash(JSScript script, Exception e) {
		PacketDispatcher.sendPacketToAllPlayers(ScriptPacket.getPacket(PacketType.CLOSE_GUI));

		ServerConfigurationManager manager = MinecraftServer.getServer().getConfigurationManager();
		List<EntityPlayer> players = (List<EntityPlayer>) MinecraftServer.getServer().getConfigurationManager().playerEntityList;
		for (EntityPlayer p : players) 
			if(Config.hasPermission(p)) {
				p.addChatMessage(SECTION + "cServer script \"" + script.name + "\" has crashed");
				p.addChatMessage(SECTION + "cCheck the console/log for more information");
				p.addChatMessage(SECTION + "cFor now, the script has been disabled");
				p.addChatMessage(SECTION + "cFix the script and restart the server to reload it");
			}

	}

	public void runFilter(EntityPlayerMP player, String name) {
		if (!name.endsWith(".filter"))
			name += ".filter";
		JSScript script = scripts.get(name);
		if (script instanceof FilterScript) {
			FilterScript fs = (FilterScript) script;
			Selection sel = ScriptingMod.instance.getSelection(player);
			if (sel.isEmpty()) 
				player.addChatMessage(SECTION + "cNo selection! Unable to run filter");
			else if (fs.hasOptions()) 
				sendFilterOptions(player, fs);
			else 
				runFilter(player, sel, null, fs);
		}
		else
			player.addChatMessage(SECTION + "cUnknown filter \"" + name + "\"");
	}

	public void runFilter(EntityPlayerMP player, SettingsPacket pkt) {
		JSScript script = scripts.get(pkt.script);
		if (script instanceof FilterScript) {
			Selection sel = ScriptingMod.instance.getSelection(player);
			if (sel.isEmpty()) 
				player.addChatMessage(SECTION + "cNo selection! Unable to run filter");
			else {
				Map<String, Object> options = new HashMap<String, Object>();
				for (Setting s : pkt.settings)
					options.put(s.display, s.getValue());
				runFilter(player, sel, options, (FilterScript)script);
			}
		}
		else
			player.addChatMessage(SECTION + "cError finding \"" + pkt.script  + "\". It must have crashed.");
	}

	private void sendFilterOptions(EntityPlayerMP player, FilterScript fs) {
		try {
			curScript = new Executing(fs, false);
			Object result =  fs.getOptions().call(context, fs.getScope(), fs.getScope(), new Object[0]);
			Setting[] settings = (Setting[]) context.jsToJava(result, Setting[].class);
			if (settings == null)
				throw new ScriptException("No settings returned");
			player.playerNetServerHandler.sendPacketToPlayer(ScriptPacket.getPacket(PacketType.SETTINGS, fs.name, settings));
		}
		catch(Exception e) {
			scriptCrash(fs, e);
		}
		finally {
			curScript = null;
		}
	}

	/**
	 * Calls the Filter script's method "run(player, world, selection, options)"
	 */
	private void runFilter(EntityPlayer player, Selection sel, Map<String, Object> options, FilterScript fs) {
		try {
			curScript = new Executing(fs, false);
			fs.getRun().call(context, fs.getScope(), fs.getScope(), new Object[] { 
				new ScriptPlayer(player), new ScriptWorld(player.worldObj), new ScriptSelection(sel, player), options
			});
		}
		catch(Exception e) {
			scriptCrash(fs, e);
		}
		finally {
			curScript = null;
		}
	}

}
