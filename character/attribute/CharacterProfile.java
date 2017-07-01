package space.game.rpg.character.attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import space.game.rpg.character.attribute.core.CoreAttribute;
import space.game.rpg.character.attribute.core.Health;
import space.game.rpg.character.attribute.core.Mana;
import space.game.rpg.character.attribute.core.Stamina;
import space.game.rpg.character.attribute.logic.Attribute;
import space.game.rpg.character.attribute.logic.BaseAttribute;
import space.game.rpg.character.attribute.logic.DependantAttribute;
import space.game.rpg.util.ExpanseConstants;

public class CharacterProfile {
	private Map<String, Attribute> baseAttributes = new HashMap<String, Attribute>();
	private Map<String, DependantAttribute> derivedAttributes = new HashMap<String, DependantAttribute>();
	private Map<String, CoreAttribute> coreAttributes = new HashMap<String, CoreAttribute>();

	public CharacterProfile() {
		super();
		this.baseAttributes = BaseAttribute.initializeBaseAttributes();
		this.derivedAttributes = BaseAttribute.initializeDependantAttributes();
		for (CoreAttribute alpha: CoreAttribute.initializeCoreAttributes()) {
			coreAttributes.put(alpha.getAttributeName(), alpha);
		}
	}
	
	private List<String> getBaseAttributeKeys() {
		List<String> baseKeys = new ArrayList<>();
		for (String str: Arrays.asList(ExpanseConstants.BASE_ABILITY_KEYS)) {
			baseKeys.add(str);
		}
		return baseKeys;
	}
	
	private List<String> getDerivedAbilityKeys() {
		List<String> abilityKeys = new ArrayList<>();
		for (String str: Arrays.asList(ExpanseConstants.SKILL_KEYS)) {
			abilityKeys.add(str);
		}
		return abilityKeys;
	}
	
	public void applyLevel(int level) {
		for (String str: getBaseAttributeKeys()) {
			baseAttributes.get(str).applyLevelModifier(level);
		}
		
		for (String str: getDerivedAbilityKeys()) {
			derivedAttributes.get(str).applyLevelModifier(level);
		}
	}

	public Map<String, Attribute> getBaseAttributes() {
		return baseAttributes;
	}

	public void setBaseAttributes(Map<String, Attribute> baseAttributes) {
		this.baseAttributes = baseAttributes;
	}

	public Map<String, DependantAttribute> getDerivedAttributes() {
		return derivedAttributes;
	}

	public void setDerivedAttributes(Map<String, DependantAttribute> derivedAttributes) {
		this.derivedAttributes = derivedAttributes;
	}
	
	public void levelUp() {
		for (BaseAttribute alpha: baseAttributes.values()) {
			alpha.setBaseValue(alpha.getBaseValue() + 7);
		}
		
		for (DependantAttribute bravo: derivedAttributes.values()) {
			bravo.setBaseValue(bravo.getBaseValue() + 3);
		}
		
		for (CoreAttribute charlie: coreAttributes.values()) {
			charlie.setBaseValue(charlie.getBaseValue() + 14);
		}
	}
	
	public void displayAttributeInfo() {
		displayCoreAttributes();
		displayBaseAttributes();
		displayDerivedAttributes();
	}
	
	public void displayCoreAttributes() {
		System.out.println("Core Attributes:");
		for (CoreAttribute alpha: coreAttributes.values()) {
			System.out.println(alpha.getAttributeName() + ": " + alpha.getBaseValue());
		}
		System.out.println(" ");
	}
	
	public void displayBaseAttributes() {
		System.out.println("Base Attributes:");
		for (String str: getBaseAttributeKeys()) {
			System.out.println(str + ": " + baseAttributes.get(str).calculateValue());
		}
		System.out.println(" ");
	}
	
	public void displayDerivedAttributes() {
		System.out.println("Skills: ");
		for (String str: getDerivedAbilityKeys()) {
			System.out.println(str + ": " + derivedAttributes.get(str).calculateValue());
		}
		System.out.println(" ");
	}
}
