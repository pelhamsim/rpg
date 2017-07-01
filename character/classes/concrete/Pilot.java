package space.game.rpg.character.classes.concrete;

import space.game.rpg.character.classes.abilities.pilot.CloseAirSupport;
import space.game.rpg.character.classes.abilities.pilot.DroneStrike;
import space.game.rpg.character.classes.abilities.pilot.SupplyDrop;
import space.game.rpg.character.classes.logic.ProtoClass;
import space.game.rpg.util.ExpanseConstants;

public class Pilot extends ProtoClass {
	private static final int CLASS_ID = ExpanseConstants.CLASS_ID_PILOT;
	private static final String CLASS_NAME = "Pilot";
	
	public Pilot() {
		super(CLASS_ID);
	}

	@Override
	public void applyClassBonus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aquireNewAbility() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void levelUp() {
		// TODO Auto-generated method stub
		
	}
	
}
