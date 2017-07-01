package space.game.rpg.character.classes.weapons;

import space.game.rpg.util.ExpanseConstants;

public class Pistol extends WeaponAbility {
	private int roundsRemaining;
	private String weaponTypeName = "Pistol";
	private int weaponId = ExpanseConstants.WEAPON_ID_PISTOL;
	private static final int NUMBER_SHOTS = 3;
	
	@Override
	public void fireWeapon() {
		boolean fullShot = this.roundsRemaining >= NUMBER_SHOTS;
		int shots = (fullShot? NUMBER_SHOTS: this.roundsRemaining);
		System.out.println("Rounds Remaining: " + this.roundsRemaining);

		for (int i = 0; i < shots; i++) {
			System.out.println("Bang! (" + this.getWeaponName() + ")");
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

	public Pistol() {
		super();
	}
	
	public Pistol(String name, int clip, int dmg) {
		super(name, clip, dmg);
	}

	public String getWeaponTypeName() {
		return weaponTypeName;
	}

	public int getWeaponId() {
		return weaponId;
	}

	public static int getNumberShots() {
		return NUMBER_SHOTS;
	}
	
}
