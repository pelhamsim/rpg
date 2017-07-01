package space.game.rpg.character.attribute.core;

import java.util.ArrayList;
import java.util.List;

import space.game.rpg.character.attribute.logic.BaseAttribute;

public abstract class CoreAttribute extends BaseAttribute {
	
	public CoreAttribute(int baseValue) {
		super(baseValue);
	}
	
	public abstract void applyLevelModifier(int paramOne, int paramTwo);
	public abstract String getAttributeName();
	
	public static List<CoreAttribute> initializeCoreAttributes() {
		List<CoreAttribute> coreAttributes = new ArrayList<>();
		coreAttributes.add(new Health(100));
		coreAttributes.add(new Mana(25));
		coreAttributes.add(new Stamina(50));
		return coreAttributes;
	}

	public CoreAttribute(int baseValue, String attributeName) {
		super(baseValue);
	}
}
