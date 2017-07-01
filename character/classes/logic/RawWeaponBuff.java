package space.game.rpg.character.classes.logic;

import space.game.rpg.character.attribute.logic.BaseAttribute;

public class RawWeaponBuff extends BaseAttribute {
	
	public RawWeaponBuff(int baseValue, double multiplier) {
		super(baseValue, multiplier);
	}
	
	public RawWeaponBuff(int baseValue) {
		super(baseValue);
	}
}
