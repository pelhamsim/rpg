package space.game.rpg.character.classes.weapons;

import java.util.ArrayList;
import java.util.List;

import space.game.rpg.character.attribute.logic.FinalDeBuff;
import space.game.rpg.character.attribute.logic.RawBuff;
import space.game.rpg.character.classes.logic.FinalClipBuff;
import space.game.rpg.character.classes.logic.FinalClipDeBuff;
import space.game.rpg.character.classes.logic.FinalWeaponBuff;
import space.game.rpg.character.classes.logic.FinalWeaponDeBuff;
import space.game.rpg.character.classes.logic.RawClipBuff;
import space.game.rpg.character.classes.logic.RawClipDeBuff;
import space.game.rpg.character.classes.logic.RawWeaponBuff;
import space.game.rpg.character.classes.logic.RawWeaponDeBuff;

public abstract class WeaponAbility {
	public int[] allowedClasses;
	private int baseDmg;
	private String weaponName;
	private int baseClipSize;
	
	protected int weaponId;
	protected int netDmg;
	protected int netClipSize;
	protected String weaponTypeName;
	
	private List<RawWeaponBuff> rawDmgBonuses = new ArrayList<>();
	private List<FinalWeaponBuff> finalDmgBonuses = new ArrayList<>();
	private List<RawWeaponDeBuff> rawDmgDeBuffs = new ArrayList<>();
	private List<FinalWeaponDeBuff> finalDmgDeBuffs = new ArrayList<>();
	
	private List<RawClipBuff> rawClipBonuses = new ArrayList<>();
	private List<FinalClipBuff> finalClipBonuses = new ArrayList<>();
	private List<RawClipDeBuff> rawClipDeBuffs = new ArrayList<>();
	private List<FinalClipDeBuff> finalClipDeBuffs = new ArrayList<>();
	
	public abstract void fireWeapon();
	public abstract void reloadWeapon();
	
	public void addRawWeaponDeBuff(RawWeaponDeBuff buffy) {
		this.rawDmgDeBuffs.add(buffy);
	}
	
	public void addRawClipDeBuff(RawClipDeBuff buffy) {
		this.rawClipDeBuffs.add(buffy);
	}
	
	public void addFinalWeaponDeBuff(FinalWeaponDeBuff buffy) {
		this.finalDmgDeBuffs.add(buffy);
	}
	
	public void addFinalClipDeBuff(FinalClipDeBuff buffy) {
		this.finalClipDeBuffs.add(buffy);
	}

	public void addRawWeaponBonus(RawWeaponBuff bone) {
		this.rawDmgBonuses.add(bone);
	}
		
	public void addRawClipBonus(RawClipBuff buffy) {
		this.rawClipBonuses.add(buffy);
	}
	
	public void addFinalWeaponBonus(FinalWeaponBuff bone) {
		this.finalDmgBonuses.add(bone);
	}
	
	public void addFinalClipBonus(FinalClipBuff buffy) {
		this.finalClipBonuses.add(buffy);
	}
	
	public void removeRawWeaponDeBuff(RawWeaponDeBuff buffy) {
		if (rawDmgDeBuffs.indexOf(buffy) >= 0) {
			rawDmgDeBuffs.remove(rawDmgDeBuffs.indexOf(buffy));
		}
	}
	
	public void removeRawClipDeBuff(RawClipDeBuff buffy) {
		if (rawClipDeBuffs.indexOf(buffy) >= 0) {
			rawClipDeBuffs.remove(rawClipDeBuffs.indexOf(buffy));
		}
	}
	
	public void removeFinalWeaponBonus(FinalWeaponBuff bone) {
		if (finalDmgBonuses.indexOf(bone) >= 0) {
			finalDmgBonuses.remove(finalDmgBonuses.indexOf(bone));
		}
	}
	
	public void removeFinalClipBonus(FinalClipBuff buffy) {
		if (finalClipBonuses.indexOf(buffy) >= 0) {
			finalClipBonuses.remove(finalClipBonuses.indexOf(buffy));
		}
	}
	
	public void removeRawBonus(RawWeaponBuff bone) {
		if (rawDmgBonuses.indexOf(bone) >= 0) {
			rawDmgBonuses.remove(rawDmgBonuses.indexOf(bone));
		}
	}
	
	public void removeRawClipBonus(RawClipBuff buffy) {
		if (rawClipBonuses.indexOf(buffy) >= 0) {
			rawClipBonuses.remove(rawClipBonuses.indexOf(buffy));
		}
	}
	
	public void removeFinalDeBuff(FinalDeBuff buffy) {
		if (finalDmgDeBuffs.indexOf(buffy) >= 0) {
			finalDmgDeBuffs.remove(finalDmgDeBuffs.indexOf(buffy));
		}
	}
	
	public void removeFinalClipDeBuff(FinalClipDeBuff buffy) {
		if (finalClipDeBuffs.indexOf(buffy) >= 0) {
			finalClipDeBuffs.remove(finalClipDeBuffs.indexOf(buffy));
		}
	}
	
	public void applyRawWeaponDeBuffs() {
		int rawWeaponDeBuffValue = 0;
		double rawWeaponDeBuffMultiplier = 0D;
		
		for (RawWeaponDeBuff buffy: rawDmgDeBuffs) {
			rawWeaponDeBuffValue += buffy.getBaseValue();
			rawWeaponDeBuffMultiplier *= (1 + buffy.getBaseValue());
		}
		
		this.netDmg -= (rawWeaponDeBuffValue *= (1 + rawWeaponDeBuffMultiplier));
	}
	
	public void applyRawClipDeBuffs() {
		int rawClipDeBuffValue = 0;
		double rawClipDeBuffMultiplier = 0D;
		
		for (RawClipDeBuff buffy: rawClipDeBuffs) {
			rawClipDeBuffValue += buffy.getBaseValue();
			rawClipDeBuffMultiplier *= (1 + buffy.getBaseValue());
		}
		
		this.netClipSize -= (rawClipDeBuffValue *= (1 + rawClipDeBuffMultiplier));
	}
	
	public void applyFinalWeaponDeBuffs() {
		int finalDeBuffValue = 0;
		double finalDeBuffMultiplier = 0D;
		
		for (FinalWeaponDeBuff buffy: finalDmgDeBuffs) {
			finalDeBuffValue += buffy.getBaseValue();
			finalDeBuffMultiplier *= (1 + buffy.getBaseValue());
		}
		netDmg -= (finalDeBuffValue *= (1 + finalDeBuffMultiplier));
	}
	
	public void applyFinalClipDeBuffs() {
		int finalDeBuffValue = 0;
		double finalDeBuffMultiplier = 0D;
		
		for (FinalClipDeBuff buffy: finalClipDeBuffs) {
			finalDeBuffValue += buffy.getBaseValue();
			finalDeBuffMultiplier *= (1 + buffy.getBaseValue());
		}
		
		netClipSize -= (finalDeBuffValue *= (1 + finalDeBuffMultiplier));
	}
	
	public void applyRawWeaponBonuses() {
		int rawBonusValue = 0;
		double rawBonusMultiplier = 0D;
		
		for (RawWeaponBuff bone: rawDmgBonuses) {
			rawBonusValue += bone.getBaseValue();
			rawBonusMultiplier *= (1 + bone.getMultiplier());
		}
		netDmg += rawBonusValue;
		netDmg *= (1 + rawBonusMultiplier);
	}
	
	public void applyRawClipBonuses() {
		int rawBonusValue = 0;
		double rawBonusMultiplier = 0D;
		
		for (RawClipBuff buffy: rawClipBonuses) {
			rawBonusValue += buffy.getBaseValue();
			rawBonusMultiplier *= (1 + buffy.getMultiplier());
		}
		
		netClipSize += rawBonusValue;
		netClipSize *= (1 + rawBonusMultiplier);
	}
	
	public void applyFinalWeaponBonuses() {
		int finalBonusValue = 0;
		double finalBonusMultiplier = 0D;
		
		for (FinalWeaponBuff bone: finalDmgBonuses) {
			finalBonusValue += bone.getBaseValue();
			finalBonusMultiplier *= (1 + bone.getMultiplier());
		}
		netDmg += finalBonusValue;
		netDmg *= (1 + finalBonusMultiplier);
	}
	
	public void applyFinalClipBonuses() {
		int finalBonusValue = 0;
		double finalBonusMultiplier = 0D;
		
		for (FinalClipBuff buffy: finalClipBonuses) {
			finalBonusValue += buffy.getBaseValue();
			finalBonusMultiplier *= (1 + buffy.getMultiplier());
		}
		
		netClipSize += finalBonusValue;
		netClipSize *= (1 + finalBonusMultiplier);
	}
	
	public int calculateDmg() {
		netDmg = baseDmg;
		applyRawWeaponBonuses();
		applyFinalWeaponBonuses();
		applyRawWeaponDeBuffs();
		applyFinalWeaponDeBuffs();
		return netDmg;
	}
	
	public int calculateClipSize() {
		netClipSize = baseClipSize;
		applyRawClipBonuses();
		applyFinalClipBonuses();
		applyRawClipDeBuffs();
		applyFinalWeaponDeBuffs();
		return netClipSize;
	}
	
	public void incrementDmg(int amount) {
		netDmg += amount;
	}
	
	public void incrementClipSize(int amount) {
		netClipSize += amount;
	}
	
	public void applyLevelModifier(int level) {
		//TODO make more explicit
		baseDmg += level;
	}
	
	public int[] getAllowedClasses() {
		return allowedClasses;
	}
	
	public void setAllowedClasses(int[] allowedClasses) {
		this.allowedClasses = allowedClasses;
	}
	
	public int getBaseDmg() {
		return baseDmg;
	}
	
	public void setBaseDmg(int baseDmg) {
		this.baseDmg = baseDmg;
	}
	
	public String getWeaponName() {
		return weaponName;
	}
	
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	
	public int getBaseClipSize() {
		return baseClipSize;
	}
	
	public void setBaseClipSize(int baseClipSize) {
		this.baseClipSize = baseClipSize;
	}
	
	public int getNetDmg() {
		return netDmg;
	}
	
	public void setNetDmg(int netDmg) {
		this.netDmg = netDmg;
	}
	
	public int getNetClipSize() {
		return netClipSize;
	}
	
	public void setNetClipSize(int netClipSize) {
		this.netClipSize = netClipSize;
	}
	
	public List<RawWeaponBuff> getRawDmgBonuses() {
		return rawDmgBonuses;
	}
	
	public void setRawDmgBonuses(List<RawWeaponBuff> rawDmgBonuses) {
		this.rawDmgBonuses = rawDmgBonuses;
	}
	
	public List<FinalWeaponBuff> getFinalDmgBonuses() {
		return finalDmgBonuses;
	}
	
	public void setFinalDmgBonuses(List<FinalWeaponBuff> finalDmgBonuses) {
		this.finalDmgBonuses = finalDmgBonuses;
	}
	
	public List<RawWeaponDeBuff> getRawDmgDeBuffs() {
		return rawDmgDeBuffs;
	}
	
	public void setRawDmgDeBuffs(List<RawWeaponDeBuff> rawDmgDeBuffs) {
		this.rawDmgDeBuffs = rawDmgDeBuffs;
	}
	
	public List<FinalWeaponDeBuff> getFinalDmgDeBuffs() {
		return finalDmgDeBuffs;
	}
	
	public void setFinalDmgDeBuffs(List<FinalWeaponDeBuff> finalDmgDeBuffs) {
		this.finalDmgDeBuffs = finalDmgDeBuffs;
	}
	
	public List<RawClipBuff> getRawClipBonuses() {
		return rawClipBonuses;
	}
	
	public void setRawClipBonuses(List<RawClipBuff> rawClipBonuses) {
		this.rawClipBonuses = rawClipBonuses;
	}
	
	public List<FinalClipBuff> getFinalClipBonuses() {
		return finalClipBonuses;
	}
	
	public void setFinalClipBonuses(List<FinalClipBuff> finalClipBonuses) {
		this.finalClipBonuses = finalClipBonuses;
	}
	
	public List<RawClipDeBuff> getRawClipDeBuffs() {
		return rawClipDeBuffs;
	}
	
	public void setRawClipDeBuffs(List<RawClipDeBuff> rawClipDeBuffs) {
		this.rawClipDeBuffs = rawClipDeBuffs;
	}
	
	public List<FinalClipDeBuff> getFinalClipDeBuffs() {
		return finalClipDeBuffs;
	}
	
	public void setFinalClipDeBuffs(List<FinalClipDeBuff> finalClipDeBuffs) {
		this.finalClipDeBuffs = finalClipDeBuffs;
	}
	
	@Override
	public String toString() {
		return this.weaponName + ":\nWeapon Class: " + getWeaponTypeName() + "\nClip Size: " + this.calculateClipSize() + "\nDMG: " + this.calculateDmg() + "\n";
	}
	
	public String getWeaponTypeName() {
		return weaponTypeName;
	}
	
	public int getWeaponId() {
		return weaponId;
	}
	
	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}
	
	public void setWeaponTypeName(String weaponTypeName) {
		this.weaponTypeName = weaponTypeName;
	}
	
	public WeaponAbility(String weaponName, int baseClipSize, int baseDmg) {
		super();
		this.baseDmg = baseDmg;
		this.weaponName = weaponName;
		this.baseClipSize = baseClipSize;
	}
	
	public WeaponAbility() {
		super();
	}
}
