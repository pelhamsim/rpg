package space.game.rpg.util;

public class ExpanseConstants {
	
	//BASE ABILITIES
	public static final String STR = "STRENGTH";
	public static final String PER = "PERCEPTION";
	public static final String END = "ENDURANCE";
	public static final String CHR = "CHARISMA";
	public static final String INT = "INTELLIGENCE";
	public static final String AGI = "AGILITY";
	public static final String LCK = "LUCK";
	public static final String DEX = "DEXTERITY";
	
	public static final String[] BASE_ABILITY_KEYS = {
		ExpanseConstants.STR, 
		ExpanseConstants.PER, 
		ExpanseConstants.END,
		ExpanseConstants.CHR, 
		ExpanseConstants.INT, 
		ExpanseConstants.AGI, 
		ExpanseConstants.LCK, 
		ExpanseConstants.DEX
		};
	
	//SKILLS
	public static final String ACCURACY = "ACCURACY";
	public static final String ATTACK_SPEED = "ATTACK_SPEED";
	public static final String BIG_GUNS = "BIG_GUNS";
	public static final String DODGE = "DODGE";
	public static final String EXPLOSIVES = "EXPLOSIVES";
	public static final String HACKING = "HACKING";
	public static final String HEAVY_ARMOR = "HEAVY_ARMOR";
	public static final String LIGHT_ARMOR = "LIGHT_ARMOR";
	public static final String MEDICINE = "MEDICINE";
	public static final String REPAIR = "REPAIR";
	public static final String SCIENCE = "SCIENCE";
	public static final String SMALL_ARMS = "SMALL_ARMS";
	
	public static final String[] SKILL_KEYS = {
		ExpanseConstants.ACCURACY,
		ExpanseConstants.ATTACK_SPEED,
		ExpanseConstants.BIG_GUNS,
		ExpanseConstants.DODGE,
		ExpanseConstants.EXPLOSIVES,
		ExpanseConstants.HACKING,
		ExpanseConstants.HEAVY_ARMOR,
		ExpanseConstants.LIGHT_ARMOR,
		ExpanseConstants.MEDICINE,
		ExpanseConstants.REPAIR,
		ExpanseConstants.SCIENCE,
		ExpanseConstants.SMALL_ARMS};
	
	//player classes
	public static final int CLASS_ID_PILOT = 101;
	public static final int CLASS_ID_MECHANIC = 102;
	public static final int CLASS_ID_ENGINEER = 103;
	public static final int CLASS_ID_BOTANIST = 104;
	public static final int CLASS_ID_CAPTAIN = 105;
	
	//weapon classes
	public static final int WEAPON_ID_PISTOL = 501;
	public static final int WEAPON_ID_SMG = 502;
	public static final int WEAPON_ID_ASSAULT_RIFLE = 503;
	public static final int WEAPON_ID_SPECIAL = 504;

	
	//NPC enemy classes
	public static final int CLASS_ID_SOLDIER = 202;
	
}
