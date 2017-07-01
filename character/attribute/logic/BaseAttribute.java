package space.game.rpg.character.attribute.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import space.game.rpg.character.attribute.base.Agility;
import space.game.rpg.character.attribute.base.Charisma;
import space.game.rpg.character.attribute.base.Dexterity;
import space.game.rpg.character.attribute.base.Endurance;
import space.game.rpg.character.attribute.base.Intelligence;
import space.game.rpg.character.attribute.base.Luck;
import space.game.rpg.character.attribute.base.Perception;
import space.game.rpg.character.attribute.base.Strength;
import space.game.rpg.character.attribute.derived.Accuracy;
import space.game.rpg.character.attribute.derived.AttackSpeed;
import space.game.rpg.character.attribute.derived.BigGuns;
import space.game.rpg.character.attribute.derived.Dodge;
import space.game.rpg.character.attribute.derived.Explosives;
import space.game.rpg.character.attribute.derived.Hacking;
import space.game.rpg.character.attribute.derived.HeavyArmor;
import space.game.rpg.character.attribute.derived.LightArmor;
import space.game.rpg.character.attribute.derived.Medicine;
import space.game.rpg.character.attribute.derived.Repair;
import space.game.rpg.character.attribute.derived.Science;
import space.game.rpg.character.attribute.derived.SmallArms;
import space.game.rpg.util.ExpanseConstants;

public abstract class BaseAttribute {
	protected int baseValue;
	protected double multiplier;
	
	public BaseAttribute(int baseValue) {
		super();
		this.baseValue = baseValue;
		this.multiplier = 1.0D;
	}
	
	public BaseAttribute(int baseValue, double multiplier) {
		super();
		this.baseValue = baseValue;
		this.multiplier = multiplier;
	}
	
	public BaseAttribute() {
		
	}

	public int getBaseValue() {
		return baseValue;
	}
	public void setBaseValue(int baseValue) {
		this.baseValue = baseValue;
	}
	public double getMultiplier() {
		return multiplier;
	}
	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}
	
	public static Map<String, Attribute> initializeBaseAttributes() {
		Map<String, Attribute> attributes = new HashMap<>();
		attributes.put(ExpanseConstants.AGI, new Agility(10));
		attributes.put(ExpanseConstants.CHR, new Charisma(10));
		attributes.put(ExpanseConstants.END, new Endurance(10));
		attributes.put(ExpanseConstants.INT, new Intelligence(10));
		attributes.put(ExpanseConstants.LCK, new Luck(10));
		attributes.put(ExpanseConstants.PER, new Perception(10));
		attributes.put(ExpanseConstants.STR, new Strength(10));
		attributes.put(ExpanseConstants.DEX, new Dexterity(10));
		return attributes;
	}
	
	public static Map<String, DependantAttribute> initializeDependantAttributes() {
		Map<String, DependantAttribute> attributes = new HashMap<>();
		attributes.put(ExpanseConstants.ACCURACY, new Accuracy(5));
		attributes.put(ExpanseConstants.SMALL_ARMS, new SmallArms(5));
		attributes.put(ExpanseConstants.HACKING, new Hacking(5));
		attributes.put(ExpanseConstants.ATTACK_SPEED, new AttackSpeed(5));
		attributes.put(ExpanseConstants.BIG_GUNS, new BigGuns(5));
		attributes.put(ExpanseConstants.DODGE, new Dodge(5));
		attributes.put(ExpanseConstants.EXPLOSIVES, new Explosives(5));
		attributes.put(ExpanseConstants.HEAVY_ARMOR, new HeavyArmor(5));
		attributes.put(ExpanseConstants.LIGHT_ARMOR, new LightArmor(5));
		attributes.put(ExpanseConstants.MEDICINE, new Medicine(5));
		attributes.put(ExpanseConstants.REPAIR, new Repair(5));
		attributes.put(ExpanseConstants.SCIENCE, new Science(5));
		return attributes;
	}
}
