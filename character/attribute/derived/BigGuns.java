package space.game.rpg.character.attribute.derived;

import java.util.List;

import space.game.rpg.character.attribute.logic.Attribute;
import space.game.rpg.character.attribute.logic.DependantAttribute;

public class BigGuns extends DependantAttribute {
	
	public BigGuns(int value) {
		super(value);
	}
	
	private void addAttributes(List<Attribute> attributes) {
		//TODO
	}
	
	@Override
	public int calculateValue(List<Attribute> attributes) {
		addAttributes(attributes);
		return calculateValue();
	}
}
