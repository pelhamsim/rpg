package space.game.rpg.character.classes.logic;

import java.util.ArrayList;
import java.util.List;

import space.game.rpg.character.classes.abilities.ClassAbility;
import space.game.rpg.util.ExpanseConstants;

public abstract class ProtoClass {
	private String className;
	private String classDescription;
	private List<ClassAbility> classAbilities;
	private int classId;
	
	public abstract void applyClassBonus();
	public abstract void aquireNewAbility();
	public abstract void levelUp();
	
	public String getClassName(){
		return className;
	}
	
	public String getClassDescription() {
		return classDescription;
	}

	public ProtoClass(int classId) {
		super();
		switch(classId) {
		case(ExpanseConstants.CLASS_ID_PILOT):
			this.className = "Pilot";
			this.classDescription = "Sure, he's not a \" family man\", per se, but he'll get you back in one piece";
			break;
		case(ExpanseConstants.CLASS_ID_MECHANIC):
			this.className = "Mechanic";
			this.classDescription = "He...fixes things.";
			break;
		case(ExpanseConstants.CLASS_ID_ENGINEER):
			this.className = "Engineer";
			this.classDescription = "A mechanical genius who can make that rickety old rock hopper sing";
			break;
		case(ExpanseConstants.CLASS_ID_BOTANIST):
			this.className = "Botanist";
			this.classDescription = "He came here to study plants and kick ass...and we're all out of plants";
			break;
		case(ExpanseConstants.CLASS_ID_CAPTAIN):
			this.className = "Captain";
			this.classDescription = "Great with his people.  Keeping secrets?  Not so much...";
			break;
		default:
			break;
		}
		addClassAbilities(classId);
	}
	
	private void addClassAbilities(int classId2) {
		classAbilities = new ArrayList<>();
		
	}
	
	public void addNewAbility(ClassAbility alpha) {
		
	}
	
	public List<ClassAbility> getClassAbilities() {
		return classAbilities;
	}
	
	public int getClassId() {
		return classId;
	}
}
