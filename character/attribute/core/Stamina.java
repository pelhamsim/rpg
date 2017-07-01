package space.game.rpg.character.attribute.core;

public class Stamina extends CoreAttribute {
	private static final String ATTRIBUTE_NAME = "Stamina";
	
	public Stamina(int baseValue) {
		super(baseValue);
	}

	@Override
	public void applyLevelModifier(int strength, int agility) {
		int bonusAmount = (int)(this.baseValue * .2);
		bonusAmount += strength + agility;
		this.baseValue += bonusAmount;
	}

	@Override
	public String getAttributeName() {
		return ATTRIBUTE_NAME;
	}
}
