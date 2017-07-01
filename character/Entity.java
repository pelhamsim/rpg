package space.game.rpg.character;

import space.game.rpg.character.attribute.CharacterProfile;
import space.game.rpg.character.classes.CharacterClass;
import space.game.rpg.item.CharacterInventory;
import space.game.rpg.item.logic.Equippable;
import space.game.rpg.logic.state.StateManager;

public abstract class Entity {
	protected CharacterProfile attributes;
	protected CharacterClass characterClass;
	protected CharacterInventory characterInventory;
	protected StateManager stateManager;
//	protected AnimationManager animationManager;
//	protected PhysicsManager physicsManager;
	
	protected String name;
	protected int level;
	
	public abstract void levelUp();
	
	public abstract void walk();
	
	public abstract void run();
	
	public abstract void speak();
	
	public abstract void jump();
	
	public abstract void die();
	
	public abstract void equip(Equippable item);
	
	public abstract void unequip(Equippable item);
	
	public abstract void initializeAtLevel(int level);
	
	public abstract void initializeCharacter(int characterClassChoice, int startingLevel);
	
	public Entity() {
		super();
	}
	
	public Entity(String name, int characterClassID) {
		this.name = name;
		initializeCharacter(characterClassID, 1);
	}
	
	public CharacterClass getCharacterClass() {
		return characterClass;
	}

	public CharacterProfile getAttributes() {
		return attributes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}
	
	public void displayCharacterInfo() {
		System.out.println(this.name + "\nLevel: " + this.level);
		attributes.displayAttributeInfo();
		characterClass.displayClassInfo();
	}
}
