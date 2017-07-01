package bull.shit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import space.game.rpg.character.PlayerCharacter;
import space.game.rpg.character.attribute.CharacterProfile;
import space.game.rpg.character.classes.CharacterClass;
import space.game.rpg.character.classes.WeaponLoadout;
import space.game.rpg.character.classes.weapons.AssaultRifle;
import space.game.rpg.character.classes.weapons.Pistol;
import space.game.rpg.character.classes.weapons.SpecialWeapon;
import space.game.rpg.character.classes.weapons.SubMachineGun;
import space.game.rpg.character.classes.weapons.WeaponAbility;
import space.game.rpg.util.ExpanseConstants;


public class Whatever {
	public static void main(String[] args) {
		WeaponAbility assaultRifle = new AssaultRifle();
		assaultRifle.setWeaponName("M41 AE Pulse Rifle");
		assaultRifle.setBaseClipSize(100);
		assaultRifle.setBaseDmg(10);
		
		WeaponAbility pistol = new Pistol();
		pistol.setWeaponName("Star Helix Pistol");
		pistol.setBaseClipSize(10);
		pistol.setBaseDmg(20);
		
		WeaponAbility sMG = new SubMachineGun();
		sMG.setWeaponName("Sub-Machine Gun");
		sMG.setBaseClipSize(25);
		sMG.setBaseDmg(5);
		
		WeaponAbility special = new SpecialWeapon();
		special.setWeaponName("Flame Thrower");
		special.setBaseClipSize(5);
		special.setBaseDmg(100);
		
		WeaponAbility assaultRifleTwo = new AssaultRifle();
		assaultRifleTwo.setWeaponName("Belter 9000");
		assaultRifleTwo.setBaseClipSize(50);
		assaultRifleTwo.setBaseDmg(11);
		
		WeaponAbility pistolTwo = new Pistol();
		pistolTwo.setWeaponName("Martian Desert Eagle");
		pistolTwo.setBaseClipSize(25);
		pistolTwo.setBaseDmg(50);
		
		WeaponAbility smgTwo = new SubMachineGun();
		smgTwo.setWeaponName("Uzi 9mm");
		smgTwo.setBaseClipSize(150);
		smgTwo.setBaseDmg(3);
		
		WeaponAbility specialTwo = new SpecialWeapon();
		specialTwo.setWeaponName("Radioactive Grenade Launche");
		specialTwo.setBaseClipSize(1);
		specialTwo.setBaseDmg(500);
		
		WeaponLoadout bunky = new WeaponLoadout();
		bunky.getAvailablePistols().add((Pistol) pistol);
		bunky.getAvailablePistols().add((Pistol) pistolTwo);
		bunky.getAvailableSmgs().add((SubMachineGun) sMG);
		bunky.getAvailableSmgs().add((SubMachineGun) smgTwo);
		bunky.getAvailableARs().add((AssaultRifle) assaultRifle);
		bunky.getAvailableARs().add((AssaultRifle) assaultRifleTwo);
		bunky.getAvailableSpecials().add((SpecialWeapon) special);
		bunky.getAvailableSpecials().add((SpecialWeapon) specialTwo);
		
		Scanner myScan = new Scanner(System.in);
		PlayerCharacter me = null;
		
		
		System.out.println("Please enter your name");
		String name = myScan.nextLine();
		System.out.println("Choose Character");
		System.out.println("1. Pilot");
		System.out.println("2. Captain");
		System.out.println("3. Engineer");
		System.out.println("4. Mechanic");
		System.out.println("5. Botanist");
		int x = myScan.nextInt();
		
		switch(x) {
			case(1):
				me = new PlayerCharacter(name, ExpanseConstants.CLASS_ID_PILOT);
				break;
			case(2):
				me = new PlayerCharacter(name, ExpanseConstants.CLASS_ID_CAPTAIN);
				break;
			case(3):
				me = new PlayerCharacter(name, ExpanseConstants.CLASS_ID_ENGINEER);
				break;
			case(4):
				me = new PlayerCharacter(name, ExpanseConstants.CLASS_ID_MECHANIC);
				break;
			case(5):
				me = new PlayerCharacter(name, ExpanseConstants.CLASS_ID_BOTANIST);
				break;
			default:
				break;
		}
		me.getCharacterClass().getWeaponLoadout().getAvailablePistols().add((Pistol) pistol);
		me.getCharacterClass().getWeaponLoadout().getAvailablePistols().add((Pistol) pistolTwo);
		me.getCharacterClass().getWeaponLoadout().getAvailableSmgs().add((SubMachineGun) sMG);
		me.getCharacterClass().getWeaponLoadout().getAvailableSmgs().add((SubMachineGun) smgTwo);
		me.getCharacterClass().getWeaponLoadout().getAvailableARs().add((AssaultRifle) assaultRifle);
		me.getCharacterClass().getWeaponLoadout().getAvailableARs().add((AssaultRifle) assaultRifleTwo);
		me.getCharacterClass().getWeaponLoadout().getAvailableSpecials().add((SpecialWeapon) special);
		me.getCharacterClass().getWeaponLoadout().getAvailableSpecials().add((SpecialWeapon) specialTwo);
		
		boolean enough = false;
		
		while (!enough) {
			System.out.println("What would you like to do, " + me.getName() + "?");
			
			System.out.println("1. See Basic Character Info");
			System.out.println("2. See Attribute Info");
			System.out.println("3. See Character Class Info" );
			System.out.println("4. See Character Ability Info");
			System.out.println("5. See Character Attribute Info");
			System.out.println("6. See Weapon Info");
			System.out.println("7. Level up");
			System.out.println("8. Exit");
			
			int xx = myScan.nextInt();
			
			switch(xx) {
			case(1):
				me.displayBasicCharacterInfo();
				break;
			case(2):
				attributesInterface(myScan, me.getAttributes());
				break;
			case(3):
				classInterface(myScan, me.getCharacterClass());
				break;
			case(4):
				me.getCharacterClass().getClassAbilities().displayClassAbilities();
				break;
			case(5):
				me.getAttributes().displayAttributeInfo();
				break;
			case(6):
				weaponsInterface(me);
				break;
			case(7):
				me.levelUp();
				break;
			case(8):
				enough = true;
			}
		}
	}
	
	private static void classInterface(Scanner myScan, CharacterClass characterClass) {
		boolean nope = false;
		
		while (!nope) {
			System.out.println("1. Class Information");
			System.out.println("2. Class Abilities");
			System.out.println("3. Weapon Proficiencies");
			System.out.println("4. Back");
			
			int xx = myScan.nextInt();
			
			switch(xx){
				case(1):
					characterClass.displayClassDescription();
					break;
				case(2):
					characterClass.getClassAbilities().displayClassAbilities();
					break;
				case(3):
					System.out.println("\n" + characterClass.getCharacterClass().getClassName() + " can use ");
					for (WeaponAbility alpha: characterClass.getWeaponLoadout().getCurrentLoadout().values()) {
						System.out.println(alpha.getWeaponTypeName());
					}
					System.out.println(" ");
					break;
				case(4):default:
					nope = true;
					break;
			}
		}
	}

	private static void attributesInterface(Scanner myScan, CharacterProfile attributes) {
		boolean up = false;
		
		while (!up) {
			System.out.println("1. Core Stats");
			System.out.println("2. Base Attributes");
			System.out.println("3. Skills");
			System.out.println("4. Back");
			
			int xx = myScan.nextInt();
			
			switch(xx){
				case(1):
					attributes.displayCoreAttributes();
					break;
				case(2):
					attributes.displayBaseAttributes();
					break;
				case(3):
					attributes.displayDerivedAttributes();
					break;
				case(4):default:
					up = true;
					break;
			}
		}
	}

	private static void weaponsInterface(PlayerCharacter me) {
		Scanner myScan = new Scanner(System.in);
		
		boolean yes = false;
		
		while (!yes) {
			showStatusOrWhatever(me.getCharacterClass().getWeaponLoadout());
			System.out.println("What would you like to see?");
			System.out.println("1. Current Loadout");
			System.out.println("2. Current Inventory");
			System.out.println("3. Equip new weapon");
			System.out.println("4. Unequip Weapon");
			System.out.println("5. Find random weapon!");
			System.out.println("6. Back");
			
			int xx = myScan.nextInt();
			
			switch(xx){
				case(1):
					showLoadoutForTest(myScan, me.getCharacterClass().getWeaponLoadout());
					break;
				case(2):
					showInventoryForTest(myScan, me.getCharacterClass().getWeaponLoadout());
					break;
				case(3):
					equipWeaponInterface(myScan, me.getCharacterClass().getWeaponLoadout());
					break;
				case(4):
					unequipWeaponInterface(myScan, me.getCharacterClass().getWeaponLoadout());
					break;
				case(5):
					me.getCharacterClass().getWeaponLoadout().acquireNewWeapon(gimmeARando());
				
				default:
					yes = true;
			}
		}
	}
	
	private static void equipWeaponInterface(Scanner myScan, WeaponLoadout weaponLoadout) {
		int i = 1;
		Map<Integer, WeaponAbility> choices = new HashMap<>();
		
		for (WeaponAbility alpha: weaponLoadout.getInventory()) {
			System.out.println(i + ". " + alpha.getWeaponName());
			choices.put(Integer.valueOf(i), alpha);
			i++;
		}
		
		System.out.println("\nPlease Select Weapon You'd Like To Equip"); 
		int xx = myScan.nextInt();
		
		weaponLoadout.equipWeapon(choices.get(Integer.valueOf(xx)));
	}

	private static void unequipWeaponInterface(Scanner myScan, WeaponLoadout weaponLoadout) {
		int i = 1;
		Map<Integer, WeaponAbility> choices = new HashMap<>();
		
		for (WeaponAbility alpha: weaponLoadout.getCurrentLoadout().values()) {
			System.out.println(i + ". " + alpha.getWeaponName());
			choices.put(Integer.valueOf(i), alpha);
			i++;
		}
		
		System.out.println("\nPlease Select Weapon You'd Like to Unequip");
		int xx = myScan.nextInt();
		
		weaponLoadout.unequipWeapon(choices.get(Integer.valueOf(xx)));
	}

	private static void showStatusOrWhatever(WeaponLoadout bunky) {
		System.out.println("Current Inventory: ");
		System.out.println("++++++++++");
		System.out.println("Equipped: ");
		int i = 1;
		for (WeaponAbility bravo: bunky.getCurrentLoadout().values()) {
			System.out.println(i + ": " + bravo.toString());
			i++;
		}
		System.out.println();
		System.out.println("++++++++++");
		System.out.println("In Inventory: ");
		i = 1;
		for (WeaponAbility bravo: bunky.getInventory()) {
			System.out.println(i + ": " + bravo.toString());
			i++;
		}
	}

	private static WeaponAbility gimmeARando() {
		int i = (int)(Math.random() * 10); 
			if (i < 4) {
				Pistol p = new Pistol();
				p.setWeaponName("Pelham's Pistol");
				p.setBaseClipSize(999);
				p.setBaseDmg(10000);
				return p;
			} else if (i >= 4 && i < 7) {
				AssaultRifle r = new AssaultRifle();
				r.setWeaponName("Chewie's Bowcaster");
				r.setBaseClipSize(50);
				r.setBaseDmg(1000);
				return r;
			} else {
				SpecialWeapon s = new SpecialWeapon();
				s.setWeaponName("Motorized Hacksaw");
				s.setBaseClipSize(9999);
				s.setBaseDmg(5000);
				return s;
			}
	}
	

	private static void showInventoryForTest(Scanner myScan, WeaponLoadout bunky) {
		System.out.println("\nCurrent Inventory: ");
		
		for (WeaponAbility alpha: bunky.getInventory()) {
			System.out.println("\n" + alpha.getWeaponTypeName() +": " + alpha.toString());
		}
	}
	
	private static void showLoadoutForTest(Scanner myScan, WeaponLoadout bunky) {
		System.out.println("\nCurrent Loadout: ");
		int i = 1;
		Map<Integer, WeaponAbility> choices = new HashMap<>();
		for (WeaponAbility alpha: bunky.getCurrentLoadout().values()) {
			System.out.println("\n" + i + ": (" + alpha.getWeaponTypeName() + ") " + alpha.toString());
			choices.put(Integer.valueOf(i), alpha);
			i++;
		}
		System.out.println(i + " - Back");
		System.out.println("Please Choose");
		
		
		int w = myScan.nextInt();
		boolean enough = w >= 5;
		while (!enough) {
			interactWithWeapon(myScan, choices.get(Integer.valueOf(w)));	
			enough = true;
		}
		return;
	}

	private static void interactWithWeapon(Scanner myScan, WeaponAbility weaponAbility) {
		boolean enough = false;
		while (!enough) {
			System.out.println("1 - Fire\n2 - Reload\n3 - Back");
			int w = myScan.nextInt();
			switch(w){
				case(1):
					weaponAbility.fireWeapon();
					break;
				case(2):
					weaponAbility.reloadWeapon();
					break;
				case(3):
				case(99):
					enough = true;
				default:
					break;
			}
		}
	}

	private static void equipWeaponsForTest(Scanner myScan, WeaponLoadout bunky) {
		int i = 1;
		for (WeaponAbility beany: bunky.getInventory()) { 
			System.out.println(i + ": " + beany.toString());
			i++;
		}
		
		System.out.println("Please Choose");
		int w = myScan.nextInt() - 1;
		
		bunky.equipWeapon(bunky.getInventory().get(w));
	}

	private static void unequipWeaponsForTest(Scanner myScan, WeaponLoadout bunky) {
		int i = 1;
		for (WeaponAbility alpha: bunky.getCurrentLoadout().values()) {
			System.out.println(alpha.toString());
			i++;
		}
		
		System.out.println("Please Choose");
		int w = myScan.nextInt() - 1;
		bunky.unequipWeapon(bunky.getCurrentLoadout().get(w));
	}
}
