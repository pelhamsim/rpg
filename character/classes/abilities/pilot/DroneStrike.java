package space.game.rpg.character.classes.abilities.pilot;

import space.game.rpg.character.classes.abilities.ClassAbility;
import space.game.rpg.util.ExpanseConstants;

public class DroneStrike extends ClassAbility {
	private static final int CLASS_ID = ExpanseConstants.CLASS_ID_PILOT;
	private static final String ABILITY_NAME = "Drone Strike";
	private static final String ABILITY_DESCRIPTION = "Call in an auto-drone to aid your friends!";
	
	public DroneStrike() {
		super();		
		this.level = 0;
	}

	@Override
	public void coolDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useLevelOne() {
		System.out.println("Level One Drone Strike!");
		
	}

	@Override
	public void useLevelTwo() {
		System.out.println("Level Two Drone Strike!");
		
	}

	@Override
	public void useLevelThree() {
		System.out.println("Level Three Drone Strike!");
	}

	@Override
	public void useLevelFour() {
		System.out.println("Max Level Drone Strike!");
		
	}

}
