package space.game.rpg.character.classes.weapons;

import space.game.rpg.util.ExpanseConstants;

public class AssaultRifle extends WeaponAbility {
	private int roundsRemaining;
	private String weaponTypeName = "Assault Rifle";
	private int weaponId = ExpanseConstants.WEAPON_ID_ASSAULT_RIFLE;
	private static final int NUMBER_SHOTS = 5;	
	
	@Override
	public void fireWeapon() {
		boolean fullShot = this.roundsRemaining >= NUMBER_SHOTS;
		int shots = (fullShot? NUMBER_SHOTS: this.roundsRemaining);
		System.out.println("Rounds Remaining: " + this.roundsRemaining);

		for (int i = 0; i < shots; i++) {
			System.out.println("Bang! " + "(" + this.getWeaponName() + ")");
		}
		roundsRemaining -= shots;
		System.out.println("Rounds Remaining: " + this.roundsRemaining);
	}

	@Override
	public void reloadWeapon() {
		System.out.println("Reloading " + this.getWeaponName() + "!");
		System.out.println("Current CLip Size: " + this.roundsRemaining);
		System.out.println("ka-CHUNK");
		this.roundsRemaining = calculateClipSize();
		System.out.println("Current Clip Size: " + this.roundsRemaining);
		
	}

	public int getRoundsRemaining() {
		return roundsRemaining;
	}

	public void setRoundsRemaining(int roundsRemaining) {
		this.roundsRemaining = roundsRemaining;
	}
	
	public AssaultRifle() {
		super();
	}
	
	public AssaultRifle(String name, int clip, int dmg) {
		super(name, clip, dmg);
	}

	public String getWeaponTypeName() {
		return weaponTypeName;
	}

	public int getWeaponId() {
		return weaponId;
	}
}
