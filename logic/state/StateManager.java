package space.game.rpg.logic.state;

import java.util.ArrayList;
import java.util.List;

import space.game.rpg.logic.state.character.BaseCharacterState;
import space.game.rpg.logic.state.character.CharacterState;
import space.game.rpg.logic.state.game.GameState;
import space.game.rpg.logic.state.weapon.BaseWeaponState;
import space.game.rpg.logic.state.weapon.WeaponState;

public class StateManager {
	private List<CharacterState> characterStateQueue;
	private List<WeaponState> weaponStateQueue;
	
	public StateManager(List<GameState> gameStateQueue, List<CharacterState> characterStateQueue,
			List<WeaponState> weaponStateQueue) {
		super();
		gameStateQueue = null;
		characterStateQueue = new ArrayList<>();
		weaponStateQueue = new ArrayList<>();
		initializeStates();
	}
	
	private void initializeStates() {
		characterStateQueue.add(new BaseCharacterState());
		weaponStateQueue.add(new BaseWeaponState());
	}
}


//TODO Pulling "GameState" out of here, to get its own home on the Game Object