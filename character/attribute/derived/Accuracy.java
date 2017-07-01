package space.game.rpg.character.attribute.derived;

import java.util.List;

import space.game.rpg.character.attribute.base.Agility;
import space.game.rpg.character.attribute.base.Luck;
import space.game.rpg.character.attribute.base.Perception;
import space.game.rpg.character.attribute.logic.Attribute;
import space.game.rpg.character.attribute.logic.DependantAttribute;

public class Accuracy extends DependantAttribute {
	
	public Accuracy(int value) {
		super(value);
	}
	
	private void addAttributes(List<Attribute> attributes) {
		for (Attribute alpha: attributes) {
			if (alpha instanceof Perception || alpha instanceof Agility) {
				addAttribute(alpha);
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
