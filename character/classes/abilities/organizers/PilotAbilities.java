package space.game.rpg.character.classes.abilities.organizers;

import java.util.ArrayList;
import java.util.List;

import space.game.rpg.character.classes.abilities.ClassAbility;
import space.game.rpg.character.classes.abilities.pilot.CloseAirSupport;
import space.game.rpg.character.classes.abilities.pilot.DroneStrike;
import space.game.rpg.character.classes.abilities.pilot.SupplyDrop;

public class PilotAbilities extends ClassAbilitySuite {
	List<ClassAbility> pilotAbilities = new ArrayList<>();
	private ClassAbility DRONE_STRIKE = new DroneStrike();
	private ClassAbility SUPPLY_DROP = new SupplyDrop();
	private ClassAbility AIR_SUPPORT = new CloseAirSupport();
	
	@Override
	public List<ClassAbility> seeAllAvailableClassAbilities() {
		return pilotAbilities;
	}

	@Override
	public List<ClassAbility> seeAllUnlockedClassAbilities() {
		List<ClassAbility> unlocked = new ArrayList<>();
		for (ClassAbility alpha: pilotAbilities) {
			if (alpha.getAbilityLevel() > 0) {
				unlocked.add(alpha);
			}
		}
		return unlocked;
	}

	@Override
	public void initialize() {
		pilotAbilities.add(DRONE_STRIKE);
		pilotAbilities.add(SUPPLY_DROP);
		pilotAbilities.add(AIR_SUPPORT);
	}

	public PilotAbilities() {
		super();
		initialize();
	}

}
