package space.game.rpg.character.classes;

import space.game.rpg.character.classes.abilities.ClassAbility;
import space.game.rpg.character.classes.abilities.organizers.BotanistAbilities;
import space.game.rpg.character.classes.abilities.organizers.CaptainAbilities;
import space.game.rpg.character.classes.abilities.organizers.ClassAbilitySuite;
import space.game.rpg.character.classes.abilities.organizers.EngineerAbilities;
import space.game.rpg.character.classes.abilities.organizers.MechanicAbilities;
import space.game.rpg.character.classes.abilities.organizers.PilotAbilities;
import space.game.rpg.character.classes.concrete.Botanist;
import space.game.rpg.character.classes.concrete.Captain;
import space.game.rpg.character.classes.concrete.Engineer;
import space.game.rpg.character.classes.concrete.Mechanic;
import space.game.rpg.character.classes.concrete.Pilot;
import space.game.rpg.character.classes.logic.ProtoClass;
import space.game.rpg.character.classes.weapons.AssaultRifle;
import space.game.rpg.character.classes.weapons.Pistol;
import space.game.rpg.character.classes.weapons.SpecialWeapon;
import space.game.rpg.character.classes.weapons.SubMachineGun;
import space.game.rpg.util.ExpanseConstants;

public class CharacterClass {
	private ProtoClass characterClass;
	private ClassAbilitySuite classAbilities;
	private WeaponLoadout weaponLoadout;
	
	public CharacterClass(int characterClassID) {
		super();
		
		weaponLoadout = new WeaponLoadout();
		
		switch(characterClassID) {
			case(ExpanseConstants.CLASS_ID_BOTANIST):
				initializeBotanist();
				break;
			case(ExpanseConstants.CLASS_ID_CAPTAIN):
				initializeCaptain();
				break;
			case(ExpanseConstants.CLASS_ID_ENGINEER):
				initializeEngineer();
				break;
			case(ExpanseConstants.CLASS_ID_MECHANIC):
				initializeMechanic();
				break;
			case(ExpanseConstants.CLASS_ID_PILOT):
				initializePilot();
				break;
			default:
				break;
		}
		initializeWeaponLoadout(characterClassID);
	}
	
	public ProtoClass getCharacterClass() {
		return this.characterClass;
	}
	
	public void displayClassDescription() {
		System.out.println("\nClass: " + this.getCharacterClass().getClassName());
		System.out.println("Description: " + this.getCharacterClass().getClassDescription() + "\n");
	}
	
	private void initializeWeaponLoadout(int classId) {
		weaponLoadout = new WeaponLoadout();
		SubMachineGun basic = new SubMachineGun("Snub-Nosed OPA Klacker", 25, 5);
		Pistol basicPistol = new Pistol("Star Helix Standard Sidearm", 10, 10);
		AssaultRifle basicAR = new AssaultRifle("Standard-Issue Martian Marine Assault Rifle", 50, 15);
		SpecialWeapon basicSpecial = new SpecialWeapon("Acetylene Torch", 999, 35);
		
		switch(classId) {
			case(ExpanseConstants.CLASS_ID_MECHANIC):
				addSmg(basic);
				addAR(basicAR);
				addPistol(basicPistol);
				addSpecial(basicSpecial);
				break;
			case(ExpanseConstants.CLASS_ID_CAPTAIN):
				addSmg(basic);
				addAR(basicAR);
				addPistol(basicPistol);
				break;
			case(ExpanseConstants.CLASS_ID_ENGINEER):
				addSmg(basic);
				addPistol(basicPistol);
				break;
			case(ExpanseConstants.CLASS_ID_BOTANIST): case(ExpanseConstants.CLASS_ID_PILOT):
				addPistol(basicPistol);
			default:
				break;
		}
	}
	
	private void addSmg(SubMachineGun smg) {
		weaponLoadout.equipWeapon(smg);
	}
	
	private void addAR(AssaultRifle ar) {
		weaponLoadout.equipWeapon(ar);
	}
	
	private void addPistol(Pistol pistol) {
		weaponLoadout.equipWeapon(pistol);
	}
	
	private void addSpecial(SpecialWeapon special) {
		weaponLoadout.equipWeapon(special);
	}

	public WeaponLoadout getWeaponLoadout() {
		return weaponLoadout;
	}
	
	private void initializeCaptain() {
		this.characterClass = new Captain();
		this.classAbilities = new CaptainAbilities();
	}
	
	private void initializePilot() {
		this.characterClass = new Pilot();
		this.classAbilities = new PilotAbilities();
	}
	
	private void initializeEngineer() {
		this.characterClass = new Engineer();
		this.classAbilities = new EngineerAbilities();
	}
	
	private void initializeMechanic() {
		this.characterClass = new Mechanic();
		this.classAbilities = new MechanicAbilities();
	}
	
	private void initializeBotanist() {
		this.characterClass = new Botanist();
		this.classAbilities = new BotanistAbilities();
	}

	public ClassAbilitySuite getClassAbilities() {
		return classAbilities;
	}
	
	public void displayClassInfo() {
		System.out.println(this.characterClass.getClassName() + "\nDescription: " + 
				this.characterClass.getClassDescription());
		System.out.println("");
		this.classAbilities.displayClassAbilities();
		this.weaponLoadout.displayWeaponLoadout();
		this.weaponLoadout.displayInventory();
	}

	public void levelUp(int level) {
		for (ClassAbility johnson: classAbilities.seeAllAvailableClassAbilities()) {
			johnson.upgradeAbility();
		}
	}
}
