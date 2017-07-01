package space.game.rpg;

import java.util.List;

import space.game.rpg.character.Entity;
import space.game.rpg.character.PlayerCharacter;
import space.game.rpg.logic.animation.GlobalAnimationHandler;
import space.game.rpg.logic.state.game.GameState;
import space.game.rpg.util.save.SaveFileManager;

public class GameWorld {
	private String areaName;
	private Long areaId;
	private List<Entity> npcs;
	private PlayerCharacter playerCharacter;
	
	private GlobalAnimationHandler animationHandler;
	private SaveFileManager saveFileManager;	//<-- To enable auto-saves
	
	private List<GameState> globalState;	//<-- TODO remove?

}


