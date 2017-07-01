package space.game.rpg;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class RPG extends BasicGame{
	private TiledMap desertMap;
	
	
	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new RPG("Unlicensed Expanse Game!"));
			app.setDisplayMode(app.getScreenWidth(), app.getScreenHeight(), false);
			app.setShowFPS(false);
			app.start();
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public RPG(String name) {
		super(name);
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		desertMap.render(0, 0);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		desertMap = new TiledMap("Maps/pelhamMap.tmx");
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

}
