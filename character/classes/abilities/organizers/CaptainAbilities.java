package space.game.rpg.character.classes.abilities.organizers;

import java.util.ArrayList;
import java.util.List;

import space.game.rpg.character.classes.abilities.ClassAbility;
import space.game.rpg.character.classes.abilities.captain.BolsterDefenses;
import space.game.rpg.character.classes.abilities.captain.RallyTroops;

public class CaptainAbilities extends ClassAbilitySuite {
	List<ClassAbility> captainAbilities = new ArrayList<>();
	
	//TODO - this is a perfect place to write some fucking JSON!
	private ClassAbility BOLSTER_DEFENSES = new BolsterDefenses();
	private ClassAbility RALLY_TROOPS = new RallyTroops();
	
	@Override
	public List<ClassAbility> seeAllAvailableClassAbilities() {
		return captainAbilities;
	}

	@Override
	public List<ClassAbility> seeAllUnlockedClassAbilities() {
		List<ClassAbility> unlock = new ArrayList<>();
		for (ClassAbility alpha: captainAbilities) {
			if (alpha.getAbilityLevel() > 0) {
				unlock.add(alpha);
			}
		}
		return unlock;
	}

	@Override
	public void initialize() {
		captainAbilities.add(BOLSTER_DEFENSES);
		captainAbilities.add(RALLY_TROOPS);
	}

	public CaptainAbilities() {
		super();
		initialize();
	}
}
