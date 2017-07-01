package space.game.rpg.character.classes.logic;

import space.game.rpg.character.attribute.logic.BaseAttribute;

public class RawWeaponDeBuff extends BaseAttribute {
	
	public RawWeaponDeBuff(int baseValue, double multiplier) {
		super(baseValue, multiplier);
	}
	
	public RawWeaponDeBuff(int baseValue) {
		super(baseValue);
	}
}
