package space.game.rpg.character.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import space.game.rpg.character.classes.weapons.AssaultRifle;
import space.game.rpg.character.classes.weapons.Pistol;
import space.game.rpg.character.classes.weapons.SpecialWeapon;
import space.game.rpg.character.classes.weapons.SubMachineGun;
import space.game.rpg.character.classes.weapons.WeaponAbility;
import space.game.rpg.util.ExpanseConstants;

public class WeaponLoadout {
	private Map<Integer, WeaponAbility> currentLoadout = new HashMap<>();
	private List<Pistol> availablePistols = new ArrayList<>();
	private List<SubMachineGun> availableSmgs = new ArrayList<>();
	private List<AssaultRifle> availableARs = new ArrayList<>();
	private List<SpecialWeapon> availableSpecials = new ArrayList<>();

	public void acquireNewWeapon(WeaponAbility alpha) {
		int weaponId = alpha.getWeaponId();
		if (weaponId == ExpanseConstants.WEAPON_ID_ASSAULT_RIFLE) {
			availableARs.add((AssaultRifle) alpha);
		} else if (weaponId == ExpanseConstants.WEAPON_ID_PISTOL) {
			availablePistols.add((Pistol) alpha);
		} else if (weaponId == ExpanseConstants.WEAPON_ID_SMG) {
			availableSmgs.add((SubMachineGun) alpha);
		} else if (weaponId == ExpanseConstants.WEAPON_ID_SPECIAL) {
			availableSpecials.add((SpecialWeapon) alpha);
		} else {
			return;
		}

	}

	public void equipWeapon(WeaponAbility alpha) {
		if (currentLoadout.get(Integer.valueOf(alpha.getWeaponId())) != null) {
			System.out.println("Replacing " + currentLoadout.get(Integer.valueOf(alpha.getWeaponId())).getWeaponName()
					+ " with " + alpha.getWeaponName());
			removeFromInventory(alpha);
		}
		addToLoadout(alpha);
	}

	public void unequipWeapon(WeaponAbility alpha) {
		removeFromLoadout(alpha);
		addToInventory(alpha);
	}

	private void removeFromInventory(WeaponAbility alpha) {
		if (!isInInventory(alpha)) {
			return;
		} else {
			int weaponId = alpha.getWeaponId();
			if (weaponId == ExpanseConstants.WEAPON_ID_ASSAULT_RIFLE) {
				if (isInInventory(alpha)) {
					availableARs.remove(availableARs.indexOf(alpha));
				}
			} else if (weaponId == ExpanseConstants.WEAPON_ID_PISTOL) {
				availablePistols.remove(availablePistols.indexOf(alpha));
			} else if (weaponId == ExpanseConstants.WEAPON_ID_SMG) {
				availableSmgs.remove(availableSmgs.indexOf(alpha));
			} else if (weaponId == ExpanseConstants.WEAPON_ID_SPECIAL) {
				availableSpecials.remove(availableSpecials.indexOf(alpha));
			} else {
				return;
			}
		}
	}

	private boolean isInInventory(WeaponAbility alpha) {
		return getInventory().indexOf(alpha) >= 0;
	}

	private void removeFromLoadout(WeaponAbility alpha) {
		this.currentLoadout.remove(alpha);
	}

	private void addToInventory(WeaponAbility alpha) {
		int weaponId = alpha.getWeaponId();
		if (weaponId == ExpanseConstants.WEAPON_ID_ASSAULT_RIFLE) {
			availableARs.add((AssaultRifle) alpha);
		} else if (weaponId == ExpanseConstants.WEAPON_ID_PISTOL) {
			availablePistols.add((Pistol) alpha);
		} else if (weaponId == ExpanseConstants.WEAPON_ID_SMG) {
			availableSmgs.add((SubMachineGun) alpha);
		} else if (weaponId == ExpanseConstants.WEAPON_ID_SPECIAL) {
			availableSpecials.add((SpecialWeapon) alpha);
		} else {
			return;
		}
	}

	private void addToLoadout(WeaponAbility alpha) {
		currentLoadout.remove(Integer.valueOf(alpha.getWeaponId()));
		currentLoadout.put(Integer.valueOf(alpha.getWeaponId()), alpha);
	}

	private boolean checkConfirm() {
		Scanner myScan = new Scanner(System.in);
		if (myScan.nextLine().equalsIgnoreCase("Y")) {
			return true;
		} else {
			return false;
		}
	}

	public Map<Integer, WeaponAbility> getCurrentLoadout() {
		return currentLoadout;
	}

	public List<WeaponAbility> getInventory() {
		List<WeaponAbility> inventory = new ArrayList<>();
		inventory.addAll(availablePistols);
		inventory.addAll(availableSmgs);
		inventory.addAll(availableARs);
		inventory.addAll(availableSpecials);
		return inventory;
	}

	public List<Pistol> getAvailablePistols() {
		return availablePistols;
	}

	public List<SubMachineGun> getAvailableSmgs() {
		return availableSmgs;
	}

	public List<AssaultRifle> getAvailableARs() {
		return availableARs;
	}

	public List<SpecialWeapon> getAvailableSpecials() {
		return availableSpecials;
	}

	public WeaponLoadout() {
		super();
	}

	public void displayWeaponInfo() {
		displayWeaponLoadout();
		System.out.println("");
		displayInventory();
	}

	public void displayWeaponLoadout() {
		System.out.println("Currently Equipped: ");

		for (WeaponAbility alpha : currentLoadout.values()) {
			System.out.println(alpha.getWeaponTypeName() + ": " + alpha.getWeaponName() + "\nCLip Size: "
					+ alpha.getBaseClipSize() + "\nBase DMG: " + alpha.getBaseDmg());
		}
	}

	public void displayInventory() {
		System.out.println("Currently in Inventory: ");

		for (WeaponAbility alpha : getInventory()) {
			System.out.println(alpha.getWeaponTypeName() + ": " + alpha.getWeaponName() + "\nCLip Size: "
					+ alpha.getBaseClipSize() + "\nBase DMG: " + alpha.getBaseDmg());
		}
	}
}
