package space.game.rpg.character.attribute.derived;

import java.util.List;

import space.game.rpg.character.attribute.base.Endurance;
import space.game.rpg.character.attribute.base.Intelligence;
import space.game.rpg.character.attribute.base.Luck;
import space.game.rpg.character.attribute.logic.Attribute;
import space.game.rpg.character.attribute.logic.DependantAttribute;

public class Explosives extends DependantAttribute {
	
	public Explosives(int value) {
		super(value);
	}
	
	private void addAttributes(List<Attribute> attributes) {
		for (Attribute alpha: attributes) {
			if (alpha instanceof Endurance || alpha instanceof Intelligence) {
				addAttribute(alpha);
			} else if (alpha instanceof Luck) {
				feelingLucky(alpha);
			}
		}
	}
	
	public int calculateValue(List<Attribute> attributes) {
		addAttributes(attributes);
		return calculateValue();
	}
}
