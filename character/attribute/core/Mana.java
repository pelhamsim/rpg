package space.game.rpg.character.attribute.core;

public class Mana extends CoreAttribute {
	private static final String ATTRIBUTE_NAME = "Mana";
	
	public Mana(int baseValue) {
		super(baseValue);
	}

	@Override
	public void applyLevelModifier(int intelligence, int perception) {
		int bonusAmount = (int)(this.baseValue * .2);
		bonusAmount += intelligence + perception;
		this.baseValue += bonusAmount;
	}

	@Override
	public String getAttributeName() {
		return ATTRIBUTE_NAME;
	}
}
