package space.game.rpg.character.classes.abilities.organizers;

import java.util.ArrayList;
import java.util.List;

import space.game.rpg.character.classes.abilities.ClassAbility;
import space.game.rpg.character.classes.abilities.mechanic.BeatWithChickenTin;
import space.game.rpg.character.classes.abilities.mechanic.SprayAndPray;

public class MechanicAbilities extends ClassAbilitySuite {
	List<ClassAbility> mechanicAbilities = new ArrayList<>();
	
	private ClassAbility BEAT_WITH = new BeatWithChickenTin();
	private ClassAbility SPRAY = new SprayAndPray();
	
	@Override
	public List<ClassAbility> seeAllAvailableClassAbilities() {
		return mechanicAbilities;
	}

	@Override
	public List<ClassAbility> seeAllUnlockedClassAbilities() {
		List<ClassAbility> unlocked = new ArrayList<>();
		for (ClassAbility alpha: mechanicAbilities) {
			if (alpha.getAbilityLevel() > 0) {
				unlocked.add(alpha);
			}
		}
		return unlocked;
	}

	@Override
	public void initialize() {
		mechanicAbilities.add(BEAT_WITH);
		mechanicAbilities.add(SPRAY);
	}

	public MechanicAbilities() {
		super();
		initialize();
	}
}
