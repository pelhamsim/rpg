package space.game.rpg.character.attribute.derived;

import java.util.List;

import space.game.rpg.character.attribute.base.Intelligence;
import space.game.rpg.character.attribute.base.Luck;
import space.game.rpg.character.attribute.base.Perception;
import space.game.rpg.character.attribute.logic.Attribute;
import space.game.rpg.character.attribute.logic.DependantAttribute;

public class Hacking extends DependantAttribute {
	
	public Hacking(int value) {
		super(value);
	}

	private void addOtherAttributes(List<Attribute> attributes) {
		for (Attribute alpha: attributes) {
			if (alpha instanceof Intelligence || alpha instanceof Perception) {
				addAttribute(alpha);
			} else if (alpha instanceof Luck) {
				feelingLucky(alpha);
			}
		}
	}
	
	@Override
	public int calculateValue(List<Attribute> attributes) {
		addOtherAttributes(attributes);
		return calculateValue();
	}
}
