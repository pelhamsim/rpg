package space.game.rpg.character;

import space.game.rpg.character.classes.CharacterClass;
import space.game.rpg.item.logic.Equippable;
import space.game.rpg.logic.decision.DecisionHandler;

public class NPC extends Entity {
	private DecisionHandler decisionHandler;
	
	public NPC(String name, int classId) {
		super(name, classId);
	}
	
	@Override
	public void levelUp() {
		level += 1;
		attributes.levelUp();
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
	public void initializeCharacter(int characterClass, int startingLevel) {
		// TODO Auto-generated method stub
		
	}
}




//TODO - Note here: PlayerCharacter will handle inputs and call methods on "Entity" based on those inputs (including state changes)
//TODO - NPC class will have ai decide which Entity methods to call.  Either way, Entity handles everything at that level