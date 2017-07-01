package space.game.rpg.character.attribute.logic;

import java.util.ArrayList;
import java.util.List;

public abstract class DependantAttribute extends Attribute {
	protected List<Attribute> otherAttributes = new ArrayList<>();
	protected double chanceModifier;
	private int netValue;
	
	public void clearAttributes() {
		System.out.println("Before: " + otherAttributes.size());
		for (Attribute alpha: otherAttributes) {
			removeAttribute(alpha);
		}
		System.out.println("After: " + otherAttributes.size());
	}
	
	public void addAttribute(Attribute attribute) {
		this.otherAttributes.add(attribute);
	}
	
	public void removeAttribute(Attribute attribute) {
		if (this.otherAttributes.indexOf(attribute) >= 0) {
			this.otherAttributes.remove(this.otherAttributes.indexOf(attribute));
		}
	}
	
	public abstract int calculateValue(List<Attribute> attributes);
	
	@Override
	public int calculateValue() {
		netValue = baseValue;
		for (Attribute alpha: otherAttributes) {
			netValue += (alpha.calculateValue() / 2);
		}
		return netValue *= (1 + chanceModifier);
	}
	
	public void feelingLucky(Attribute luck) {
		this.chanceModifier = (luck.calculateValue() * .5D) / 10;
	}
	
	public void applyLevelModifier(int level) {
		baseValue += level; 
	}
	
	public double getChanceModifier() {
		return chanceModifier;
	}
	
	public DependantAttribute(int baseValue) {
		super(baseValue);
	}
	
	public DependantAttribute(int baseValue, int multiplier) {
		super(baseValue, multiplier);
	}
	
	public DependantAttribute() {
		super();
	}
}
