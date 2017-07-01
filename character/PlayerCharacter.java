package space.game.rpg.character;

import space.game.rpg.character.attribute.CharacterProfile;
import space.game.rpg.character.classes.CharacterClass;
import space.game.rpg.item.CharacterInventory;
import space.game.rpg.item.logic.Equippable;
import space.game.rpg.logic.input.InputHandler;

public class PlayerCharacter extends Entity {	
	private InputHandler inputHandler;
	
	public PlayerCharacter(String name, int characterClassID) {
		super(name, characterClassID);
	}
	
	@Override
	public void walk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void levelUp() {
		this.level++;
		this.characterClass.levelUp(this.level);
		this.attributes.levelUp();
	}

	@Override
	public void initializeAtLevel(int level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void equip(Equippable item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unequip(Equippable item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeCharacter(int characterClassChoice, int startingLevel) {
		this.characterClass = new CharacterClass(characterClassChoice);
		this.attributes = new CharacterProfile();
		this.characterInventory = new CharacterInventory();
		this.level = startingLevel;
	}

	public void displayBasicCharacterInfo() {
		System.out.println(this.name + "\nLevel " + this.level + " " + this.characterClass.getCharacterClass().getClassName() +
				"\nDescription: " + this.characterClass.getCharacterClass().getClassDescription());
	}	
}















//TODO - Note here: PlayerCharacter will handle inputs and call methods on "Entity" based on those inputs (including state changes)
//TODO - NPC class will have ai decide which Entity methods to call.  Either way, Entity handles everything at that level