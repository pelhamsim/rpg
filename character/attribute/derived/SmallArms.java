package space.game.rpg.character.attribute.derived;

import java.util.ArrayList;
import java.util.List;

import space.game.rpg.character.attribute.base.Endurance;
import space.game.rpg.character.attribute.base.Luck;
import space.game.rpg.character.attribute.base.Strength;
import space.game.rpg.character.attribute.logic.Attribute;
import space.game.rpg.character.attribute.logic.DependantAttribute;

public class SmallArms extends DependantAttribute {
	
	public SmallArms(int baseValue) {
		super(baseValue);
	}
	
	private void addAttributes(List<Attribute> attributes) {
		for (Attribute alpha: attributes) {
			if (alpha instanceof Endurance || alpha instanceof Strength) {
				otherAttributes.add(alpha);
			} else if (alpha instanceof Luck) {
				feelingLucky(alpha);
			}
		}
	}
	
	@Override
	public int calculateValue(List<Attribute> attributes) {
		addAttributes(attributes);
		return calculateValue();
	}
}
