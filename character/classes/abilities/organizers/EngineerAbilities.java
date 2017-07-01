package space.game.rpg.character.classes.abilities.organizers;

import java.util.ArrayList;
import java.util.List;

import space.game.rpg.character.classes.abilities.ClassAbility;
import space.game.rpg.character.classes.abilities.engineer.HackLifeSupport;
import space.game.rpg.character.classes.abilities.engineer.SabotageDefenses;

public class EngineerAbilities extends ClassAbilitySuite {
	List<ClassAbility> engineerAbilities = new ArrayList<>();
	
	private ClassAbility HACK_LIFE = new HackLifeSupport();
	private ClassAbility SABOTAGE = new SabotageDefenses();
	
	@Override
	public List<ClassAbility> seeAllAvailableClassAbilities() {
		return engineerAbilities;
	}

	@Override
	public List<ClassAbility> seeAllUnlockedClassAbilities() {
		List<ClassAbility> unlock = new ArrayList<>();
		for (ClassAbility alpha: engineerAbilities) {
			if (alpha.getAbilityLevel() > 0) {
				unlock.add(alpha);
			}
		}
		return unlock;
	}

	@Override
	public void initialize() {
		engineerAbilities.add(HACK_LIFE);
		engineerAbilities.add(SABOTAGE);
	}

	public EngineerAbilities() {
		super();
		initialize();
	}

}
