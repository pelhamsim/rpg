package space.game.rpg.character.attribute.logic;

import java.util.ArrayList;
import java.util.List;

import space.game.rpg.character.attribute.base.Agility;
import space.game.rpg.character.attribute.base.Charisma;
import space.game.rpg.character.attribute.base.Endurance;
import space.game.rpg.character.attribute.base.Intelligence;
import space.game.rpg.character.attribute.base.Luck;
import space.game.rpg.character.attribute.base.Perception;
import space.game.rpg.character.attribute.base.Strength;

public abstract class Attribute extends BaseAttribute {
	private List<RawBuff> rawBonuses = new ArrayList<>();
	private List<FinalBuff> finalBonuses = new ArrayList<>();
	private List<FinalDeBuff> finalDeBuffs = new ArrayList<>();
	private List<RawDeBuff> rawDeBuffs = new ArrayList<>();
	private int netValue;
	
	public void addRawDeBuff(RawDeBuff buffy) {
		this.rawDeBuffs.add(buffy);
	}
	
	public void addFinalDeBuff(FinalDeBuff buffy) {
		this.finalDeBuffs.add(buffy);
	}

	public void addRawBonus(RawBuff bone) {
		this.rawBonuses.add(bone);
	}
	
	public void addFinalBonus(FinalBuff bone) {
		this.finalBonuses.add(bone);
	}
	
	public void removeRawDeBuff(RawDeBuff buffy) {
		if (rawDeBuffs.indexOf(buffy) >= 0) {
			rawDeBuffs.remove(rawDeBuffs.indexOf(buffy));
		}
	}
	
	public void removeFinalBonus(FinalBuff bone) {
		if (finalBonuses.indexOf(bone) >= 0) {
			finalBonuses.remove(finalBonuses.indexOf(bone));
		}
	}
	
	public void removeRawBonus(RawBuff bone) {
		if (rawBonuses.indexOf(bone) >= 0) {
			rawBonuses.remove(rawBonuses.indexOf(bone));
		}
	}
	
	public void removeFinalDeBuff(FinalDeBuff buffy) {
		if (finalDeBuffs.indexOf(buffy) >= 0) {
			finalDeBuffs.remove(finalDeBuffs.indexOf(buffy));
		}
	}
	
	public void applyRawDeBuffs() {
		int rawDeBuffValue = 0;
		double rawDeBuffMultiplier = 0D;
		
		for (RawDeBuff buffy: rawDeBuffs) {
			rawDeBuffValue += buffy.getBaseValue();
			rawDeBuffMultiplier *= (1 + buffy.getBaseValue());
		}
		
		netValue -= (rawDeBuffValue *= (1 + rawDeBuffMultiplier));
	}
	
	public void applyFinalDeBuffs() {
		int finalDeBuffValue = 0;
		double finalDeBuffMultiplier = 0D;
		
		for (FinalDeBuff buffy: finalDeBuffs) {
			finalDeBuffValue += buffy.getBaseValue();
			finalDeBuffMultiplier *= (1 + buffy.getBaseValue());
		}
		netValue -= (finalDeBuffValue *= (1 + finalDeBuffMultiplier));
	}
	
	public void applyRawBonuses() {
		int rawBonusValue = 0;
		double rawBonusMultiplier = 0D;
		
		for (RawBuff bone: rawBonuses) {
			rawBonusValue += bone.getBaseValue();
			rawBonusMultiplier *= (1 + bone.getMultiplier());
		}
		netValue += rawBonusValue;
		netValue *= (1 + rawBonusMultiplier);
	}
	
	public void applyFinalBonuses() {
		int finalBonusValue = 0;
		double finalBonusMultiplier = 0D;
		
		for (FinalBuff bone: finalBonuses) {
			finalBonusValue += bone.getBaseValue();
			finalBonusMultiplier *= (1 + bone.getMultiplier());
		}
		netValue += finalBonusValue;
		netValue *= (1 + finalBonusMultiplier);
	}
	
	public int calculateValue() {
		netValue = baseValue;
		applyRawBonuses();
		applyFinalBonuses();
		applyFinalDeBuffs();
		
		return netValue;
	}
	
	public void incrementAttribute(int amount) {
		baseValue += amount;
	}
	
	public void applyLevelModifier(int level) {
		//TODO make more explicit
		baseValue += level;
	}
	
	public Attribute(int baseValue) {
		super(baseValue);
	}
	
	public Attribute(int baseValue, int multiplier) {
		super(baseValue, multiplier);
	}
	
	public Attribute() {
		super();
	}
}