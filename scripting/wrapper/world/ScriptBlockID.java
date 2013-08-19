package scripting.wrapper.world;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.block.Block;

/**
 * See {@link net.minecraft.block.Block}.
 * Fields generated by {@link ScriptBlockID#printAll()}
 *
 */
public class ScriptBlockID {

	/**
	 * Method used to generate the fields.
	 */
	private static void printAll() {
		for (Field f : Block.class.getDeclaredFields()) {
			f.setAccessible(true);
			if (Modifier.isStatic(f.getModifiers()) && Modifier.isFinal(f.getModifiers()) &&  Block.class.isAssignableFrom(f.getType())) {
				String name = f.getName();
				System.out.println("public static final int " + name + " = Block." + name + ".blockID;");
			}
		}
	}

	public static final int stone = Block.stone.blockID;
	public static final int grass = Block.grass.blockID;
	public static final int dirt = Block.dirt.blockID;
	public static final int cobblestone = Block.cobblestone.blockID;
	public static final int planks = Block.planks.blockID;
	public static final int sapling = Block.sapling.blockID;
	public static final int bedrock = Block.bedrock.blockID;
	public static final int waterMoving = Block.waterMoving.blockID;
	public static final int waterStill = Block.waterStill.blockID;
	public static final int lavaMoving = Block.lavaMoving.blockID;
	public static final int lavaStill = Block.lavaStill.blockID;
	public static final int sand = Block.sand.blockID;
	public static final int gravel = Block.gravel.blockID;
	public static final int oreGold = Block.oreGold.blockID;
	public static final int oreIron = Block.oreIron.blockID;
	public static final int oreCoal = Block.oreCoal.blockID;
	public static final int wood = Block.wood.blockID;
	public static final int leaves = Block.leaves.blockID;
	public static final int sponge = Block.sponge.blockID;
	public static final int glass = Block.glass.blockID;
	public static final int oreLapis = Block.oreLapis.blockID;
	public static final int blockLapis = Block.blockLapis.blockID;
	public static final int dispenser = Block.dispenser.blockID;
	public static final int sandStone = Block.sandStone.blockID;
	public static final int music = Block.music.blockID;
	public static final int bed = Block.bed.blockID;
	public static final int railPowered = Block.railPowered.blockID;
	public static final int railDetector = Block.railDetector.blockID;
	public static final int pistonStickyBase = Block.pistonStickyBase.blockID;
	public static final int web = Block.web.blockID;
	public static final int tallGrass = Block.tallGrass.blockID;
	public static final int deadBush = Block.deadBush.blockID;
	public static final int pistonBase = Block.pistonBase.blockID;
	public static final int pistonExtension = Block.pistonExtension.blockID;
	public static final int cloth = Block.cloth.blockID;
	public static final int pistonMoving = Block.pistonMoving.blockID;
	public static final int plantYellow = Block.plantYellow.blockID;
	public static final int plantRed = Block.plantRed.blockID;
	public static final int mushroomBrown = Block.mushroomBrown.blockID;
	public static final int mushroomRed = Block.mushroomRed.blockID;
	public static final int blockGold = Block.blockGold.blockID;
	public static final int blockIron = Block.blockIron.blockID;
	public static final int stoneDoubleSlab = Block.stoneDoubleSlab.blockID;
	public static final int stoneSingleSlab = Block.stoneSingleSlab.blockID;
	public static final int brick = Block.brick.blockID;
	public static final int tnt = Block.tnt.blockID;
	public static final int bookShelf = Block.bookShelf.blockID;
	public static final int cobblestoneMossy = Block.cobblestoneMossy.blockID;
	public static final int obsidian = Block.obsidian.blockID;
	public static final int torchWood = Block.torchWood.blockID;
	public static final int fire = Block.fire.blockID;
	public static final int mobSpawner = Block.mobSpawner.blockID;
	public static final int stairsWoodOak = Block.stairsWoodOak.blockID;
	public static final int chest = Block.chest.blockID;
	public static final int redstoneWire = Block.redstoneWire.blockID;
	public static final int oreDiamond = Block.oreDiamond.blockID;
	public static final int blockDiamond = Block.blockDiamond.blockID;
	public static final int workbench = Block.workbench.blockID;
	public static final int crops = Block.crops.blockID;
	public static final int tilledField = Block.tilledField.blockID;
	public static final int furnaceIdle = Block.furnaceIdle.blockID;
	public static final int furnaceBurning = Block.furnaceBurning.blockID;
	public static final int signPost = Block.signPost.blockID;
	public static final int doorWood = Block.doorWood.blockID;
	public static final int ladder = Block.ladder.blockID;
	public static final int rail = Block.rail.blockID;
	public static final int stairsCobblestone = Block.stairsCobblestone.blockID;
	public static final int signWall = Block.signWall.blockID;
	public static final int lever = Block.lever.blockID;
	public static final int pressurePlateStone = Block.pressurePlateStone.blockID;
	public static final int doorIron = Block.doorIron.blockID;
	public static final int pressurePlatePlanks = Block.pressurePlatePlanks.blockID;
	public static final int oreRedstone = Block.oreRedstone.blockID;
	public static final int oreRedstoneGlowing = Block.oreRedstoneGlowing.blockID;
	public static final int torchRedstoneIdle = Block.torchRedstoneIdle.blockID;
	public static final int torchRedstoneActive = Block.torchRedstoneActive.blockID;
	public static final int stoneButton = Block.stoneButton.blockID;
	public static final int snow = Block.snow.blockID;
	public static final int ice = Block.ice.blockID;
	public static final int blockSnow = Block.blockSnow.blockID;
	public static final int cactus = Block.cactus.blockID;
	public static final int blockClay = Block.blockClay.blockID;
	public static final int reed = Block.reed.blockID;
	public static final int jukebox = Block.jukebox.blockID;
	public static final int fence = Block.fence.blockID;
	public static final int pumpkin = Block.pumpkin.blockID;
	public static final int netherrack = Block.netherrack.blockID;
	public static final int slowSand = Block.slowSand.blockID;
	public static final int glowStone = Block.glowStone.blockID;
	public static final int portal = Block.portal.blockID;
	public static final int pumpkinLantern = Block.pumpkinLantern.blockID;
	public static final int cake = Block.cake.blockID;
	public static final int redstoneRepeaterIdle = Block.redstoneRepeaterIdle.blockID;
	public static final int redstoneRepeaterActive = Block.redstoneRepeaterActive.blockID;
	public static final int lockedChest = Block.lockedChest.blockID;
	public static final int trapdoor = Block.trapdoor.blockID;
	public static final int silverfish = Block.silverfish.blockID;
	public static final int stoneBrick = Block.stoneBrick.blockID;
	public static final int mushroomCapBrown = Block.mushroomCapBrown.blockID;
	public static final int mushroomCapRed = Block.mushroomCapRed.blockID;
	public static final int fenceIron = Block.fenceIron.blockID;
	public static final int thinGlass = Block.thinGlass.blockID;
	public static final int melon = Block.melon.blockID;
	public static final int pumpkinStem = Block.pumpkinStem.blockID;
	public static final int melonStem = Block.melonStem.blockID;
	public static final int vine = Block.vine.blockID;
	public static final int fenceGate = Block.fenceGate.blockID;
	public static final int stairsBrick = Block.stairsBrick.blockID;
	public static final int stairsStoneBrick = Block.stairsStoneBrick.blockID;
	public static final int mycelium = Block.mycelium.blockID;
	public static final int waterlily = Block.waterlily.blockID;
	public static final int netherBrick = Block.netherBrick.blockID;
	public static final int netherFence = Block.netherFence.blockID;
	public static final int stairsNetherBrick = Block.stairsNetherBrick.blockID;
	public static final int netherStalk = Block.netherStalk.blockID;
	public static final int enchantmentTable = Block.enchantmentTable.blockID;
	public static final int brewingStand = Block.brewingStand.blockID;
	public static final int cauldron = Block.cauldron.blockID;
	public static final int endPortal = Block.endPortal.blockID;
	public static final int endPortalFrame = Block.endPortalFrame.blockID;
	public static final int whiteStone = Block.whiteStone.blockID;
	public static final int dragonEgg = Block.dragonEgg.blockID;
	public static final int redstoneLampIdle = Block.redstoneLampIdle.blockID;
	public static final int redstoneLampActive = Block.redstoneLampActive.blockID;
	public static final int woodDoubleSlab = Block.woodDoubleSlab.blockID;
	public static final int woodSingleSlab = Block.woodSingleSlab.blockID;
	public static final int cocoaPlant = Block.cocoaPlant.blockID;
	public static final int stairsSandStone = Block.stairsSandStone.blockID;
	public static final int oreEmerald = Block.oreEmerald.blockID;
	public static final int enderChest = Block.enderChest.blockID;
	public static final int tripWireSource = Block.tripWireSource.blockID;
	public static final int tripWire = Block.tripWire.blockID;
	public static final int blockEmerald = Block.blockEmerald.blockID;
	public static final int stairsWoodSpruce = Block.stairsWoodSpruce.blockID;
	public static final int stairsWoodBirch = Block.stairsWoodBirch.blockID;
	public static final int stairsWoodJungle = Block.stairsWoodJungle.blockID;
	public static final int commandBlock = Block.commandBlock.blockID;
	public static final int beacon = Block.beacon.blockID;
	public static final int cobblestoneWall = Block.cobblestoneWall.blockID;
	public static final int flowerPot = Block.flowerPot.blockID;
	public static final int carrot = Block.carrot.blockID;
	public static final int potato = Block.potato.blockID;
	public static final int woodenButton = Block.woodenButton.blockID;
	public static final int skull = Block.skull.blockID;
	public static final int anvil = Block.anvil.blockID;
	public static final int chestTrapped = Block.chestTrapped.blockID;
	public static final int pressurePlateGold = Block.pressurePlateGold.blockID;
	public static final int pressurePlateIron = Block.pressurePlateIron.blockID;
	public static final int redstoneComparatorIdle = Block.redstoneComparatorIdle.blockID;
	public static final int redstoneComparatorActive = Block.redstoneComparatorActive.blockID;
	public static final int daylightSensor = Block.daylightSensor.blockID;
	public static final int blockRedstone = Block.blockRedstone.blockID;
	public static final int oreNetherQuartz = Block.oreNetherQuartz.blockID;
	public static final int hopperBlock = Block.hopperBlock.blockID;
	public static final int blockNetherQuartz = Block.blockNetherQuartz.blockID;
	public static final int stairsNetherQuartz = Block.stairsNetherQuartz.blockID;
	public static final int railActivator = Block.railActivator.blockID;
	public static final int dropper = Block.dropper.blockID;
	/*
	 * Since these blocks are obfuscated, we use their unlocalized names (UN)
	 */
	public static final int clayHardenedStained = Block.field_111039_cA.blockID; /*ID 159; UN:clayHardenedStained*/
	public static final int hayBlock = Block.field_111038_cB.blockID; /*ID 170; UN:hayBlock*/
	public static final int woolCarpet = Block.field_111031_cC.blockID; /*ID 171; UN:woolCarpet*/
	public static final int clayHardened = Block.field_111032_cD.blockID; /*ID 172; UN:clayHardened*/
	public static final int blockCoal = Block.field_111034_cE.blockID; /*ID 173; UN:blockCoal*/

}