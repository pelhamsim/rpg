package space.game.rpg.character.classes.abilities;

public abstract class ClassAbility {
	protected String abilityName;
	protected String abilityDescription;
	protected int level;
	
	//Sandbox methods
	public abstract void useLevelOne();
	public abstract void useLevelTwo();
	public abstract void useLevelThree();
	public abstract void useLevelFour();
	
	public abstract void coolDown();
	
	public String getAbilityName() {
		return abilityName;
	}
	
	public int getAbilityLevel() {
		return level;
	}
	
	public void upgradeAbility() {
		this.level++;
	}
	
	public void useAbility() {
		switch(this.level){
			case(1):
				useLevelOne();
				break;
			case(2):
				useLevelTwo();
				break;
			case(3):
				useLevelThree();
				break;
			case(4):
				useLevelFour();
				break;
			default: case(0):
				System.out.println("Nope!");
				break;
		}
	}
	
	public ClassAbility() {
		super();
	}
	public String getAbilityDescription() {
		return abilityDescription;
	}
	public int getLevel() {
		return level;
	}
}
