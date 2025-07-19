package com.quantum_magnus.views;

import java.util.List;

import com.quantum_magnus.dnd.AbilityPointTracker;
import com.quantum_magnus.dnd.CharacterData;
import com.quantum_magnus.dnd.NavigationBar;
import com.quantum_magnus.dnd.DnDKeywords.Abilities;
import com.quantum_magnus.dnd.DnDKeywords.AbilityScoreGenerationMethod;
import com.quantum_magnus.tables.PointCost;
import com.quantum_magnus.tables.StandardArray;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.IntegerField.IntegerFieldI18n;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("create/determine-ability-scores")
@PageTitle("Determine Ability Scores")
public class AbilityScoresView extends AppLayout{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static IntegerField strengthField;
	private static IntegerField dexterityField;
	private static IntegerField constitutionField;
	private static IntegerField intelligenceField;
	private static IntegerField wisdomField;
	private static IntegerField charismaField;
	
	public AbilityScoresView() {
		DrawerToggle toggle = new DrawerToggle();
        H1 title = new H1("Create Character");
        title.getStyle()
	        	.set("font-size", "var(--lumo-font-size-l)")
	        	.set("margin", "0");
        HorizontalLayout navBarHeader = new HorizontalLayout(toggle, title);
        navBarHeader.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        navBarHeader.setWidthFull();
        navBarHeader.getStyle().set("padding", "var(--lumo-space-m)");

        addToNavbar(true, navBarHeader);
        
        // === Drawer Menu (Nav Items) ===
        NavigationBar drawerLayout = new NavigationBar();
        drawerLayout.setCreateOpen(false);
        addToDrawer(drawerLayout);		
        
        // === Main Content: Left and Right Panels ===
        VerticalLayout leftPanel = new VerticalLayout();
        leftPanel.setPadding(false);
        leftPanel.setWidth("50%");
        leftPanel.setHeightFull();
        leftPanel.getStyle().set("overflow", "auto").set("padding-left", "1em");

        VerticalLayout rightPanel = new VerticalLayout();
        rightPanel.setPadding(false);
        rightPanel.setWidth("50%");
        rightPanel.setHeightFull();
        rightPanel.getStyle().set("overflow", "hidden");
        
        Paragraph abilityScoreBlurb = new Paragraph("Much of what your character can do in game depends on your six "
        		+ "abilities. To determine your character's ability scores, you first generate a set of six numbers using the "
        		+ "instructions below and then assign them to your six abilities. Select a method to see how your scores can be "
        		+ "generated.");
        
        NativeLabel abilityScoreLabel = new NativeLabel("Generate Your Scores");
        abilityScoreLabel.getStyle().set("font-weight", "bold");
        ComboBox<AbilityScoreGenerationMethod> abilityScoreField = new ComboBox<AbilityScoreGenerationMethod>(); 
        abilityScoreField.setAllowCustomValue(true);
        abilityScoreField.setItems(AbilityScoreGenerationMethod.values());
        abilityScoreField.setItemLabelGenerator(AbilityScoreGenerationMethod::getDisplayName);
        abilityScoreField.setTooltipText("Select or type a generation method");
        abilityScoreField.setWidth("13em");
        abilityScoreField.setValue(AbilityScoreGenerationMethod.StandardArray);
        HorizontalLayout abilityScoreSelection = new HorizontalLayout(abilityScoreLabel, abilityScoreField);
        abilityScoreSelection.setAlignItems(FlexComponent.Alignment.BASELINE);
        abilityScoreField.addValueChangeListener(event -> {
            rightPanel.removeAll(); // Clear previous panel
            String selected = event.getValue().name();
            if (selected != null) {
            		H3 tableTitle = null;
            		if (selected.equals(AbilityScoreGenerationMethod.StandardArray.name())) {
            			createStandardArray(rightPanel, tableTitle);
            		} else if (selected.equals(AbilityScoreGenerationMethod.PointCost.name())) {
            			tableTitle = new H3("Ability Score Point Costs");
            			
            			Grid<PointCost> pointCostTableFirstHalf = new Grid<PointCost>(PointCost.class, false);
            			pointCostTableFirstHalf.addColumn(PointCost::getScore).setHeader("Score")
            				.setFlexGrow(1).setTextAlign(ColumnTextAlign.CENTER);
            			pointCostTableFirstHalf.addColumn(PointCost::getCost).setHeader("Cost")
            				.setFlexGrow(1).setTextAlign(ColumnTextAlign.CENTER);
            			pointCostTableFirstHalf.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
    	                pointCostTableFirstHalf.getStyle().set("overflow", "hidden");
    	                pointCostTableFirstHalf.setWidthFull();
    	                
    	                PointCost[] pointCostFirstHalf = PointCost.getPointCostFirstHalf();
    	                pointCostTableFirstHalf.setItems(pointCostFirstHalf);
    	                pointCostTableFirstHalf.setAllRowsVisible(true);
            			
            			Grid<PointCost> pointCostTableSecondHalf = new Grid<PointCost>(PointCost.class, false);
            			pointCostTableSecondHalf.addColumn(PointCost::getScore).setHeader("Score")
            				.setFlexGrow(1).setTextAlign(ColumnTextAlign.CENTER);
            			pointCostTableSecondHalf.addColumn(PointCost::getCost).setHeader("Cost")
            				.setFlexGrow(1).setTextAlign(ColumnTextAlign.CENTER);
            			pointCostTableSecondHalf.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
            			pointCostTableSecondHalf.getStyle().set("overflow", "hidden");
    	                pointCostTableSecondHalf.setWidthFull();
    	                
    	                PointCost[] pointCostSecondHalf = PointCost.getPointCostSecondHalf();
    	                pointCostTableSecondHalf.setItems(pointCostSecondHalf);
    	                pointCostTableSecondHalf.setAllRowsVisible(true);
            			
            			HorizontalLayout pointCostTablePanel = 
            					new HorizontalLayout(pointCostTableFirstHalf, pointCostTableSecondHalf);
            			
            			Paragraph pointCostBlurb = new Paragraph("You have 27 points to spend on your ability scores. "
            					+ "The cost of each score is shown on the Ability Scores Point Costs table seen above. "
            					+ "For example, a score of 14 costs 7 of your 27 points.");
    	                
            			List.of(strengthField, dexterityField, constitutionField, 
            	        		intelligenceField, wisdomField, charismaField).forEach(field -> {
            	            field.setMin(8);
            	            field.setMax(15);
            	            field.setStepButtonsVisible(true);
            	        });
            			
            			strengthField.setI18n(new IntegerFieldI18n()
        		            .setRequiredErrorMessage(Abilities.Strength + " Score is required")
        		            .setBadInputErrorMessage("Invalid number format")
        		            .setMinErrorMessage(Abilities.Strength + " must be at least 8")
        		            .setMaxErrorMessage(Abilities.Strength + " cannot exceed 15"));
            			
            			dexterityField.setI18n(new IntegerFieldI18n()
            	        		.setRequiredErrorMessage(Abilities.Dexterity + " Score is required")
            	            .setBadInputErrorMessage("Invalid number format")
            	            .setMinErrorMessage(Abilities.Dexterity + " must be at least 8")
            	            .setMaxErrorMessage(Abilities.Dexterity + " cannot exceed 15"));
            			
            			constitutionField.setI18n(new IntegerFieldI18n()
            	        		.setRequiredErrorMessage(Abilities.Constitution + " Score is required")
            	            .setBadInputErrorMessage("Invalid number format")
            	            .setMinErrorMessage(Abilities.Constitution + " must be at least 8")
            	            .setMaxErrorMessage(Abilities.Constitution + " cannot exceed 15"));
            			
            			intelligenceField.setI18n(new IntegerFieldI18n()
            	        		.setRequiredErrorMessage(Abilities.Intelligence + " Score is required")
            	            .setBadInputErrorMessage("Invalid number format")
            	            .setMinErrorMessage(Abilities.Intelligence + " must be at least 8")
            	            .setMaxErrorMessage(Abilities.Intelligence + " cannot exceed 15"));
            			
            			wisdomField.setI18n(new IntegerFieldI18n()
            	        		.setRequiredErrorMessage(Abilities.Wisdom + " Score is required")
            	            .setBadInputErrorMessage("Invalid number format")
            	            .setMinErrorMessage(Abilities.Wisdom + " must be at least 8")
            	            .setMaxErrorMessage(Abilities.Wisdom + " cannot exceed 15"));
            			
            			charismaField.setI18n(new IntegerFieldI18n()
            	        		.setRequiredErrorMessage(Abilities.Charisma + " Score is required")
            	            .setBadInputErrorMessage("Invalid number format")
            	            .setMinErrorMessage(Abilities.Charisma + " must be at least 8")
            	            .setMaxErrorMessage(Abilities.Charisma + " cannot exceed 15"));

            	        AbilityPointTracker tracker = new AbilityPointTracker(27, 
            	        		List.of(strengthField, dexterityField, constitutionField, 
            	        				intelligenceField, wisdomField, charismaField));
            			
    	                rightPanel.add(tableTitle, pointCostTablePanel, pointCostBlurb, tracker);
            		} else { // if selected == RandomGeneration
            			tableTitle = new H3("Generate Random Scores");
            			List<IntegerField> abilities = List.of(strengthField, dexterityField, constitutionField, 
    	        				intelligenceField, wisdomField, charismaField);
            			
            			AbilityPointTracker tracker = new AbilityPointTracker(abilities);
            			
            			abilities.forEach(field -> {
            	            field.setMin(3);
            	            field.setMax(18);
            	            field.setValue(3);
            	            field.setStepButtonsVisible(true);
            	        });
            			resetMinMax();
            			
            			rightPanel.add(tracker);
            		}
            }
        });
        
        strengthField = new IntegerField();
        strengthField.setLabel(Abilities.Strength.name());
        strengthField.setRequiredIndicatorVisible(true);
        strengthField.setMin(3);
        strengthField.setMax(18);
        strengthField.setStepButtonsVisible(true);
        
        dexterityField = new IntegerField();
        dexterityField.setLabel(Abilities.Dexterity.name());
        dexterityField.setRequiredIndicatorVisible(true);
        dexterityField.setMin(3);
        dexterityField.setMax(18);
        dexterityField.setStepButtonsVisible(true);
        
        constitutionField = new IntegerField();
        constitutionField.setLabel(Abilities.Constitution.name());
        constitutionField.setRequiredIndicatorVisible(true);
        constitutionField.setMin(3);
        constitutionField.setMax(18);
        constitutionField.setStepButtonsVisible(true);
        
        intelligenceField = new IntegerField();
        intelligenceField.setLabel(Abilities.Intelligence.name());
        intelligenceField.setRequiredIndicatorVisible(true);
        intelligenceField.setMin(3);
        intelligenceField.setMax(18);
        intelligenceField.setStepButtonsVisible(true);
        
        wisdomField = new IntegerField();
        wisdomField.setLabel(Abilities.Wisdom.name());
        wisdomField.setRequiredIndicatorVisible(true);
        wisdomField.setMin(3);
        wisdomField.setMax(18);
        wisdomField.setStepButtonsVisible(true);
        
        charismaField = new IntegerField();
        charismaField.setLabel(Abilities.Charisma.name());
        charismaField.setRequiredIndicatorVisible(true);
        charismaField.setMin(3);
        charismaField.setMax(18);
        charismaField.setStepButtonsVisible(true);
        
        resetMinMax();
        
        H3 initTableTitle = new H3("Standard Array by Class");
        createStandardArray(rightPanel, initTableTitle);
        
        VerticalLayout physicalAbilities = new VerticalLayout(strengthField, dexterityField, constitutionField);
        physicalAbilities.getStyle().set("overflow", "hidden");
        physicalAbilities.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        VerticalLayout mentalAbilities = new VerticalLayout(intelligenceField, wisdomField, charismaField);
        mentalAbilities.getStyle().set("overflow", "hidden");
        mentalAbilities.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        
        HorizontalLayout abilityPanel = new HorizontalLayout(physicalAbilities, mentalAbilities);
        abilityPanel.setPadding(false);
        abilityPanel.getStyle().set("overflow", "hidden");
        abilityPanel.setWidthFull();
        
        //lowerPanel.getStyle().set("background-color", "#f0f0f0");
        
        leftPanel.add(abilityScoreBlurb, abilityScoreLabel, abilityScoreField, abilityScoreSelection, abilityPanel);
        rightPanel.add();
        //lowerPanel.add();
        
        HorizontalLayout header = new HorizontalLayout();
        
        H1 heading = new H1("Step 3: Determine Ability Scores");
        
        Button nextButton = new Button("Next Step");
        nextButton.addClickListener(click -> {
        		int[] abilityScores = {strengthField.getValue(), dexterityField.getValue(), constitutionField.getValue(),
        				intelligenceField.getValue(), wisdomField.getValue(), charismaField.getValue()};
        	
        		CharacterData formData = getCharacterData();
        		formData.setAbilityScores(abilityScores);

    			VaadinSession.getCurrent().setAttribute(CharacterData.class, formData);
        	
	    		UI.getCurrent().navigate(TestView.class);
	    });
        nextButton.getStyle().set("left", "41.75rem").set("top", "0.5rem");
        header.add(heading, nextButton);
        
        VerticalLayout bottomPanel = new VerticalLayout(header);
        bottomPanel.getStyle().set("overflow", "auto");
        HorizontalLayout mainContent = new HorizontalLayout(leftPanel, rightPanel);
        mainContent.setHeight("78vh");
        mainContent.getStyle().set("overflow", "auto");
        bottomPanel.add(mainContent/*, lowerPanel*/);
        setContent(bottomPanel);
	}
	
	private static void resetMinMax() {
		strengthField.setI18n(new IntegerFieldI18n()
            .setRequiredErrorMessage(Abilities.Strength + " Score is required")
            .setBadInputErrorMessage("Invalid number format")
            .setMinErrorMessage(Abilities.Strength + " must be at least 3")
            .setMaxErrorMessage(Abilities.Strength + " cannot exceed 18"));
		
		dexterityField.setI18n(new IntegerFieldI18n()
        		.setRequiredErrorMessage(Abilities.Dexterity + " Score is required")
            .setBadInputErrorMessage("Invalid number format")
            .setMinErrorMessage(Abilities.Dexterity + " must be at least 3")
            .setMaxErrorMessage(Abilities.Dexterity + " cannot exceed 18"));
		
		constitutionField.setI18n(new IntegerFieldI18n()
        		.setRequiredErrorMessage(Abilities.Constitution + " Score is required")
            .setBadInputErrorMessage("Invalid number format")
            .setMinErrorMessage(Abilities.Constitution + " must be at least 3")
            .setMaxErrorMessage(Abilities.Constitution + " cannot exceed 18"));
		
		intelligenceField.setI18n(new IntegerFieldI18n()
        		.setRequiredErrorMessage(Abilities.Intelligence + " Score is required")
            .setBadInputErrorMessage("Invalid number format")
            .setMinErrorMessage(Abilities.Intelligence + " must be at least 3")
            .setMaxErrorMessage(Abilities.Intelligence + " cannot exceed 18"));
		
		wisdomField.setI18n(new IntegerFieldI18n()
        		.setRequiredErrorMessage(Abilities.Wisdom + " Score is required")
            .setBadInputErrorMessage("Invalid number format")
            .setMinErrorMessage(Abilities.Wisdom + " must be at least 3")
            .setMaxErrorMessage(Abilities.Wisdom + " cannot exceed 18"));
		
		charismaField.setI18n(new IntegerFieldI18n()
        		.setRequiredErrorMessage(Abilities.Charisma + " Score is required")
            .setBadInputErrorMessage("Invalid number format")
            .setMinErrorMessage(Abilities.Charisma + " must be at least 3")
            .setMaxErrorMessage(Abilities.Charisma + " cannot exceed 18"));
	}
	
	private static void createStandardArray(VerticalLayout rightPanel, H3 tableTitle) {
		tableTitle = new H3("Standard Array by Class");
        
        Grid<StandardArray> standardArrayTable = new Grid<StandardArray>(StandardArray.class, false);
        standardArrayTable.addColumn(StandardArray::getClassIn).setHeader("Class")
        		.setAutoWidth(false).setWidth("9rem").setFlexGrow(0).setResizable(true);
        standardArrayTable.addColumn(StandardArray::getStrength).setHeader("Str.")
        		.setAutoWidth(false).setWidth("2em").setFlexGrow(1).setTextAlign(ColumnTextAlign.CENTER);
        standardArrayTable.addColumn(StandardArray::getDexterity).setHeader("Dex.")
        		.setAutoWidth(false).setWidth("2em").setFlexGrow(1).setTextAlign(ColumnTextAlign.CENTER);
        standardArrayTable.addColumn(StandardArray::getConstitution).setHeader("Con.")
        		.setAutoWidth(false).setWidth("2em").setFlexGrow(1).setTextAlign(ColumnTextAlign.CENTER);
        standardArrayTable.addColumn(StandardArray::getIntelligence).setHeader("Int.")
        		.setAutoWidth(false).setWidth("2em").setFlexGrow(1).setTextAlign(ColumnTextAlign.CENTER);
        standardArrayTable.addColumn(StandardArray::getWisdom).setHeader("Wis.")
        		.setAutoWidth(false).setWidth("2em").setFlexGrow(1).setTextAlign(ColumnTextAlign.CENTER);
        standardArrayTable.addColumn(StandardArray::getCharisma).setHeader("Cha.")
        		.setAutoWidth(false).setWidth("2em").setFlexGrow(1).setTextAlign(ColumnTextAlign.CENTER);
        standardArrayTable.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
        standardArrayTable.getStyle().set("overflow", "hidden");
        standardArrayTable.setWidthFull();

        StandardArray[] standardArray = StandardArray.getStandardArrayChart();
        standardArrayTable.setItems(standardArray);
        standardArrayTable.setAllRowsVisible(true);
        
        Paragraph standardArrayBlurb = new Paragraph("Use the following six scores for your abilites: "
        		+ "15, 14, 13, 12, 10, 8.");
        
        List.of(strengthField, dexterityField, constitutionField, 
        		intelligenceField, wisdomField, charismaField).forEach(field -> {
            field.setMin(3);
            field.setMax(18);
            field.setValue(3);
            field.setStepButtonsVisible(true);
        });
        resetMinMax();
        
        rightPanel.add(tableTitle, standardArrayTable, standardArrayBlurb);
	}
	
	private CharacterData getCharacterData() {
        CharacterData data = VaadinSession.getCurrent().getAttribute(CharacterData.class);
        if (data == null) {
            throw new IllegalStateException("No data from previous step.");
        }
        return data;
    }
	
}