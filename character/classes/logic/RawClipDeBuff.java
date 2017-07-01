package space.game.rpg.character.classes.logic;

import space.game.rpg.character.attribute.logic.BaseAttribute;

public class RawClipDeBuff extends BaseAttribute {
	
	public RawClipDeBuff(int baseValue, double multiplier) {
		super(baseValue, multiplier);
	}
	
	public RawClipDeBuff(int baseValue) {
		super(baseValue);
	}
}
