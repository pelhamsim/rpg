package space.game.rpg.character.classes.logic;

import space.game.rpg.character.attribute.logic.BaseAttribute;

public class RawClipBuff extends BaseAttribute {
	
	public RawClipBuff(int baseValue, double multiplier) {
		super(baseValue, multiplier);
	}
	
	public RawClipBuff(int baseValue) {
		super(baseValue);
	}
}
