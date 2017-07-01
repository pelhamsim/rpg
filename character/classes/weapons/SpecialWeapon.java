package space.game.rpg.character.classes.weapons;

import space.game.rpg.util.ExpanseConstants;

public class SpecialWeapon extends WeaponAbility {
	private int roundsRemaining;
	private String weaponTypeName = "Special Ordnance Delivery Vector";
	private int weaponId = ExpanseConstants.WEAPON_ID_SPECIAL;
	
	@Override
	public void fireWeapon() {
		int shots = roundsRemaining;
		System.out.println("Rounds Remaining: " + this.roundsRemaining);

		if (shots > 0) {
			System.out.println("Bang! (" + this.getWeaponName() + ")");
		}
		
		roundsRemaining -= 1;
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

	public SpecialWeapon() {
		super();
	}
	
	public SpecialWeapon(String name, int clip, int dmg) {
		super(name, clip, dmg);
	}

	public int getRoundsRemaining() {
		return roundsRemaining;
	}

	public String getWeaponTypeName() {
		return weaponTypeName;
	}

	public int getWeaponId() {
		return weaponId;
	}

}
