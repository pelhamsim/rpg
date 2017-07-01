package space.game.rpg.character.attribute.core;

public class Health extends CoreAttribute {
	private static final String ATTRIBUTE_NAME = "Health";
	
	public Health(int baseValue) {
		super(baseValue);
	}

	@Override
	public void applyLevelModifier(int strength, int endurance) {
		int bonusAmount = (int)(this.baseValue * .2);
		bonusAmount += strength + endurance;
		this.baseValue += bonusAmount;
	}

	@Override
	public String getAttributeName() {
		return ATTRIBUTE_NAME;
	}
}
