package space.game.rpg.character.classes.abilities.botanist;

import space.game.rpg.character.classes.abilities.ClassAbility;
import space.game.rpg.util.ExpanseConstants;

public class Poison extends ClassAbility {
	private static final int CLASS_ID = ExpanseConstants.CLASS_ID_BOTANIST;
	private static final String ABILITY_NAME = "Poison";
	private static final String ABILITY_DESCRIPTION = "Eh...its kinda like \"Infect\"";
		
	@Override
	public void useLevelOne() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useLevelTwo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useLevelThree() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useLevelFour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coolDown() {
		// TODO Auto-generated method stub
	}
	
	public String getAbilityName() {
		return ABILITY_NAME;
	}
	
	public String getAbilityDescription() {
		return ABILITY_DESCRIPTION;
	}
}
