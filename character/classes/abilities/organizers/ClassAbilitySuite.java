package space.game.rpg.character.classes.abilities.organizers;

import java.util.List;

import space.game.rpg.character.classes.abilities.ClassAbility;

public abstract class ClassAbilitySuite {
	public abstract List<ClassAbility> seeAllAvailableClassAbilities();
	public abstract List<ClassAbility> seeAllUnlockedClassAbilities();
	
	public abstract void initialize();
	
	public void displayClassAbilities() {
		System.out.println("Class Abilities:"); 
		int i = 1;
		
		for (ClassAbility alpha: seeAllAvailableClassAbilities()) {
			System.out.println(i + ": " + alpha.getAbilityName() + 
					"\nDescription: " + alpha.getAbilityDescription() +
					"Level: " + alpha.getAbilityLevel() + "\n");
		}
	}
}
