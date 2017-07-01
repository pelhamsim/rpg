package space.game.rpg.character.classes.abilities.organizers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import space.game.rpg.character.classes.abilities.ClassAbility;
import space.game.rpg.character.classes.abilities.botanist.Infect;
import space.game.rpg.character.classes.abilities.botanist.Poison;

public class BotanistAbilities extends ClassAbilitySuite {
	List<ClassAbility> botanistAbilities = new ArrayList<>();
	
	private ClassAbility INFECT = new Infect();
	private ClassAbility POISON = new Poison();
	
	@Override
	public List<ClassAbility> seeAllAvailableClassAbilities() {
		return botanistAbilities;
	}
	
	@Override
	public List<ClassAbility> seeAllUnlockedClassAbilities() {
		List<ClassAbility> unlocked = new ArrayList<>();
		for (ClassAbility alpha: botanistAbilities) {
			if (alpha.getAbilityLevel() > 0) {
				unlocked.add(alpha);
			}
		}
		return unlocked;
	}
	
	@Override
	public void initialize() {
		this.botanistAbilities.add(INFECT);
		this.botanistAbilities.add(POISON);
	}

	public BotanistAbilities() {
		super();
		initialize();
	}
}
