package com.quantum_magnus.dnd;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;

public class AbilityPointTracker extends Composite<VerticalLayout> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String HTML_TEMPLATE_1 = """
		<div>	
			<div style="display: grid; grid-template-columns: 1fr 1fr;">
		        <div style='text-align: center; font-size: 2rem; margin: 0.5em 0.5em 0em 1em;'>%d</div>
		        <div style='text-align: center; font-size: 2rem; margin: 0.5em 0.5em 0em 0.5em;'>%d</div>
		        <div style='text-align: center; font-size: 2rem; margin: 0.25em 0.5em 0em 1em;'>%d</div>
		        <div style='text-align: center; font-size: 2rem; margin: 0.25em 0.5em 0em 0.5em;'>%d</div>
		    </div>
		    <div style='text-align: center; font-size: 2.5rem; margin: 0em 0em 0em 0.25em; border: 1px solid black;'>%d</div>
		</div>
	"""; 
	private static final String HTML_TEMPLATE_2 = """
		<div>
			<div style="display: grid; grid-template-columns: 1fr 1fr;">
		        <div style='text-align: center; font-size: 2rem; margin: 0.5em 0.5em 0em 0.5em;'>%d</div>
		        <div style='text-align: center; font-size: 2rem; margin: 0.5em 0.5em 0em 0.5em;'>%d</div>
		        <div style='text-align: center; font-size: 2rem; margin: 0.25em 0.5em 0em 0.5em;'>%d</div>
		        <div style='text-align: center; font-size: 2rem; margin: 0.25em 0.5em 0em 0.5em;'>%d</div>
		    </div>
			<div style='text-align: center; font-size: 2.5rem; margin: 0em 0em 0em 0.25em; border: 1px solid black;'>%d</div>
		</div>
	""";
	private static int strNumbers[], dexNumbers[], conNumbers[], intNumbers[], wisNumbers[], chaNumbers[];
	private int totalAvailablePoints;
	private static Html strGen, dexGen, conGen, intGen, wisGen, chaGen;
    private Paragraph pointsRemainingText = new Paragraph("");
    private HorizontalLayout randomGenerationPanel = new HorizontalLayout();
    private VerticalLayout strButtonPanel, dexButtonPanel, conButtonPanel, intButtonPanel, wisButtonPanel, chaButtonPanel;
    private List<IntegerField> abilityFields;

    public AbilityPointTracker(int totalAvailablePoints, List<IntegerField> abilityFields) {
        this.totalAvailablePoints = totalAvailablePoints;
        this.abilityFields = abilityFields;

        getContent().add(pointsRemainingText);

        // Add listeners and initialize
        abilityFields.forEach(field -> {
            field.setValue(8); // default base score
            field.addValueChangeListener(e -> updatePointsRemaining());
        });

        updatePointsRemaining(); // initial display
    }

    public AbilityPointTracker(List<IntegerField> abilityFields) {
    		this.abilityFields = abilityFields;
		
    		// Strength
    		strGen = new Html(String.format(HTML_TEMPLATE_1, 4, 3, 2, 1, 0));
    		
    		Button generateStrButton = new Button("Roll Stat", click -> {
    			strNumbers = rollStat();
    			
    			String updatedHtml = String.format(
		        HTML_TEMPLATE_1,
		        strNumbers[0], strNumbers[1], strNumbers[2], strNumbers[3], getStatTotal(strNumbers)
		    );
    			Html updatedStr = new Html(updatedHtml);
    			
    			strButtonPanel.replace(strGen, updatedStr);
    			strGen = updatedStr;
        });
    		generateStrButton.getStyle().set("margin-left", "0.5em");
    		
    		strButtonPanel = new VerticalLayout(strGen, generateStrButton);
    		strButtonPanel.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    		
    		// Dexterity
    		dexGen = new Html(String.format(HTML_TEMPLATE_1, 4, 3, 2, 1, 0));
    		
    		Button generateDexButton = new Button("Roll Stat", click -> {
    			dexNumbers = rollStat();
    			
    			String updatedHtml = String.format(
		        HTML_TEMPLATE_1,
		        dexNumbers[0], dexNumbers[1], dexNumbers[2], dexNumbers[3], getStatTotal(dexNumbers)
		    );
    			Html updatedDex = new Html(updatedHtml);
    			
    			dexButtonPanel.replace(dexGen, updatedDex);
    			dexGen = updatedDex;
        });
    		generateDexButton.getStyle().set("margin-left", "0.5em");
    		
    		dexButtonPanel = new VerticalLayout(dexGen, generateDexButton);
    		dexButtonPanel.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    		
    		// Constitution
    		conGen = new Html(String.format(HTML_TEMPLATE_2, 4, 3, 2, 1, 0));
    		
    		Button generateConButton = new Button("Roll Stat", click -> {
    			conNumbers = rollStat();
    			
    			String updatedHtml = String.format(
		        HTML_TEMPLATE_2,
		        conNumbers[0], conNumbers[1], conNumbers[2], conNumbers[3], getStatTotal(conNumbers)
		    );
    			Html updatedCon = new Html(updatedHtml);
    			
    			conButtonPanel.replace(conGen, updatedCon);
    			conGen = updatedCon;
        });
    		
    		conButtonPanel = new VerticalLayout(conGen, generateConButton);
    		conButtonPanel.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    		
    		// Intelligence
    		intGen = new Html(String.format(HTML_TEMPLATE_1, 4, 3, 2, 1, 0));
    		
    		Button generateIntButton = new Button("Roll Stat", click -> {
    			intNumbers = rollStat();
    			
    			String updatedHtml = String.format(
		        HTML_TEMPLATE_1,
		        intNumbers[0], intNumbers[1], intNumbers[2], intNumbers[3], getStatTotal(intNumbers)
		    );
    			Html updatedInt = new Html(updatedHtml);
    			
    			intButtonPanel.replace(intGen, updatedInt);
    			intGen = updatedInt;
        });
    		generateIntButton.getStyle().set("margin-left", "0.5em");
    		
    		intButtonPanel = new VerticalLayout(intGen, generateIntButton);
    		intButtonPanel.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    		
    		// Wisdom
    		wisGen = new Html(String.format(HTML_TEMPLATE_1, 4, 3, 2, 1, 0));
    		
    		Button generateWisButton = new Button("Roll Stat", click -> {
    			wisNumbers = rollStat();
    			
    			String updatedHtml = String.format(
		        HTML_TEMPLATE_1,
		        wisNumbers[0], wisNumbers[1], wisNumbers[2], wisNumbers[3], getStatTotal(wisNumbers)
		    );
    			Html updatedWis = new Html(updatedHtml);
    			
    			wisButtonPanel.replace(wisGen, updatedWis);
    			wisGen = updatedWis;
        });
    		generateWisButton.getStyle().set("margin-left", "0.5em");
    		
    		wisButtonPanel = new VerticalLayout(wisGen, generateWisButton);
    		wisButtonPanel.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    		
    		// Charisma
    		chaGen = new Html(String.format(HTML_TEMPLATE_2, 4, 3, 2, 1, 0));
    		
    		Button generateChaButton = new Button("Roll Stat", click -> {
    			chaNumbers = rollStat();
    			
    			String updatedHtml = String.format(
		        HTML_TEMPLATE_2,
		        chaNumbers[0], chaNumbers[1], chaNumbers[2], chaNumbers[3], getStatTotal(chaNumbers)
		    );
    			Html updatedCha = new Html(updatedHtml);
    			
    			chaButtonPanel.replace(chaGen, updatedCha);
    			chaGen = updatedCha;
        });
    		
    		chaButtonPanel = new VerticalLayout(chaGen, generateChaButton);
    		chaButtonPanel.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    		
    		VerticalLayout leftPanel = new VerticalLayout(strButtonPanel, intButtonPanel);
    		VerticalLayout middlePanel = new VerticalLayout(dexButtonPanel, wisButtonPanel);
    		VerticalLayout rightPanel = new VerticalLayout(conButtonPanel, chaButtonPanel);
    		randomGenerationPanel.add(leftPanel, middlePanel, rightPanel);
    		randomGenerationPanel.setWidthFull();
    		
    		getContent().add(randomGenerationPanel);
    }
    
    private void updatePointsRemaining() {
        int totalSpent = abilityFields.stream()
                .map(IntegerField::getValue)
                .mapToInt(v -> getPointCost(v == null ? 8 : v))
                .sum();

        int remaining = totalAvailablePoints - totalSpent;
        pointsRemainingText.setText("Points remaining: " + remaining);
        pointsRemainingText.getStyle().set("font-size", "2.5rem");
        
        for (IntegerField field : abilityFields) {
            int value = field.getValue() == null ? 8 : field.getValue();

            // Disable incrementing if maxed out or no points left
            if (value >= 15 || remaining <= 0) {
                field.setMax(value);
            } else {
                field.setMax(15);
            }

            field.setMin(8);
        }
    }
    
    private int getPointCost(int score) {
        switch (score) {
            case 8:  return 0;
            case 9:  return 1;
            case 10: return 2;
            case 11: return 3;
            case 12: return 4;
            case 13: return 5;
            case 14: return 7;
            case 15: return 9;
            default: return 0; // fallback (shouldn't happen)
        }
    }

    private static int[] rollStat() {
	    Random random = new Random();
	    int[] rolls = new int[4];

	    for (int idx = 0; idx < 4; idx++) {
	        rolls[idx] = random.nextInt(6) + 1; // 1 to 6 inclusive
	    }
	    
	    return rolls;
	}
    
    private static int getStatTotal(int[] roll) {
    		int result;
    		
    		Arrays.sort(roll);
    		result = roll[1] + roll[2] + roll[3];
    		
    		return result;
    }
    
}