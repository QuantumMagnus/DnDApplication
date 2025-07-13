package com.quantum_magnus.dnd;

import com.quantum_magnus.dnd.DnDKeywords.AbilityScoreGenerationMethod;
import com.quantum_magnus.grid_contents.StandardArray;
import com.quantum_magnus.dnd.DnDKeywords.Abilities;
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

@Route("create/determine-ability-scores")
@PageTitle("Determine Ability Scores")
public class AbilityScoresView extends AppLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
        
        // === Main Content: Three Panels ===
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
        
        Paragraph abilityScoreBlurb = new Paragraph("To determine your character's ability scores, you first generate a "
        		+ "set of six numbers using the instructions below and then assign them to your six abilities. Select a "
        		+ "generation method to see how your scores can be generated.");
        
        NativeLabel abilityScoreLabel = new NativeLabel("Generate Your Scores");
        abilityScoreLabel.getStyle().set("font-weight", "bold");
        ComboBox<AbilityScoreGenerationMethod> abilityScoreField = new ComboBox<AbilityScoreGenerationMethod>(); 
        abilityScoreField.setAllowCustomValue(true);
        abilityScoreField.setItems(AbilityScoreGenerationMethod.values());
        abilityScoreField.setItemLabelGenerator(AbilityScoreGenerationMethod::getDisplayName);
        abilityScoreField.setTooltipText("Select or type a generation method");
        abilityScoreField.setWidth("13em");
        HorizontalLayout abilityScoreSelection = new HorizontalLayout(abilityScoreLabel, abilityScoreField);
        abilityScoreSelection.setAlignItems(FlexComponent.Alignment.BASELINE);
        abilityScoreField.addValueChangeListener(event -> {
            rightPanel.removeAll(); // Clear previous card
            String selected = event.getValue().name();
            if (selected != null) {
            		if (selected.equals(AbilityScoreGenerationMethod.StandardArray.name())) {
            			H3 tableTitle = new H3("Standard Array by Class");
    	                
    	                Grid<StandardArray> standardArrayTable = 
    	                		new Grid<StandardArray>(StandardArray.class, false);
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
    	                
    	                rightPanel.add(tableTitle, standardArrayTable, standardArrayBlurb);
            		} else if (selected.equals(AbilityScoreGenerationMethod.StandardArray.name())) {
            			
            		} else { // if selected == RandomGeneration
            			
            		}
            }
        });
        
        IntegerField strengthField = new IntegerField();
        strengthField.setLabel(Abilities.Strength.name());
        strengthField.setRequiredIndicatorVisible(true);
        strengthField.setMin(3);
        strengthField.setMax(18);
        strengthField.setStepButtonsVisible(true);
        strengthField.setI18n(new IntegerFieldI18n()
            .setRequiredErrorMessage(Abilities.Strength + " Score is required")
            .setBadInputErrorMessage("Invalid number format")
            .setMinErrorMessage(Abilities.Strength + " must be at least 3")
            .setMaxErrorMessage(Abilities.Strength + " cannot exceed 18"));
        
        IntegerField dexterityField = new IntegerField();
        dexterityField.setLabel(Abilities.Dexterity.name());
        dexterityField.setRequiredIndicatorVisible(true);
        dexterityField.setMin(3);
        dexterityField.setMax(18);
        dexterityField.setStepButtonsVisible(true);
        dexterityField.setI18n(new IntegerFieldI18n()
        		.setRequiredErrorMessage(Abilities.Dexterity + " Score is required")
            .setBadInputErrorMessage("Invalid number format")
            .setMinErrorMessage(Abilities.Dexterity + " must be at least 3")
            .setMaxErrorMessage(Abilities.Dexterity + " cannot exceed 18"));
        
        IntegerField constitutionField = new IntegerField();
        constitutionField.setLabel(Abilities.Constitution.name());
        constitutionField.setRequiredIndicatorVisible(true);
        constitutionField.setMin(3);
        constitutionField.setMax(18);
        constitutionField.setStepButtonsVisible(true);
        constitutionField.setI18n(new IntegerFieldI18n()
        		.setRequiredErrorMessage(Abilities.Constitution + " Score is required")
            .setBadInputErrorMessage("Invalid number format")
            .setMinErrorMessage(Abilities.Constitution + " must be at least 3")
            .setMaxErrorMessage(Abilities.Constitution + " cannot exceed 18"));
        
        IntegerField intelligenceField = new IntegerField();
        intelligenceField.setLabel(Abilities.Intelligence.name());
        intelligenceField.setRequiredIndicatorVisible(true);
        intelligenceField.setMin(3);
        intelligenceField.setMax(18);
        intelligenceField.setStepButtonsVisible(true);
        intelligenceField.setI18n(new IntegerFieldI18n()
        		.setRequiredErrorMessage(Abilities.Intelligence + " Score is required")
            .setBadInputErrorMessage("Invalid number format")
            .setMinErrorMessage(Abilities.Intelligence + " must be at least 3")
            .setMaxErrorMessage(Abilities.Intelligence + " cannot exceed 18"));
        
        IntegerField wisdomField = new IntegerField();
        wisdomField.setLabel(Abilities.Wisdom.name());
        wisdomField.setRequiredIndicatorVisible(true);
        wisdomField.setMin(3);
        wisdomField.setMax(18);
        wisdomField.setStepButtonsVisible(true);
        wisdomField.setI18n(new IntegerFieldI18n()
        		.setRequiredErrorMessage(Abilities.Wisdom + " Score is required")
            .setBadInputErrorMessage("Invalid number format")
            .setMinErrorMessage(Abilities.Wisdom + " must be at least 3")
            .setMaxErrorMessage(Abilities.Wisdom + " cannot exceed 18"));
        
        IntegerField charismaField = new IntegerField();
        charismaField.setLabel(Abilities.Charisma.name());
        charismaField.setRequiredIndicatorVisible(true);
        charismaField.setMin(3);
        charismaField.setMax(18);
        charismaField.setStepButtonsVisible(true);
        charismaField.setI18n(new IntegerFieldI18n()
        		.setRequiredErrorMessage(Abilities.Charisma + " Score is required")
            .setBadInputErrorMessage("Invalid number format")
            .setMinErrorMessage(Abilities.Charisma + " must be at least 3")
            .setMaxErrorMessage(Abilities.Charisma + " cannot exceed 18"));
        
        VerticalLayout physicalAbilities = new VerticalLayout(strengthField, dexterityField, constitutionField);
        physicalAbilities.getStyle().set("overflow", "hidden");
        VerticalLayout mentalAbilities = new VerticalLayout(intelligenceField, wisdomField, charismaField);
        mentalAbilities.getStyle().set("overflow", "hidden");
        
        HorizontalLayout abilityPanel = new HorizontalLayout(physicalAbilities, mentalAbilities);
        abilityPanel.setPadding(false);
        abilityPanel.getStyle().set("overflow", "hidden");
        abilityPanel.setWidthFull();
        
        

//        lowerPanel.getStyle().set("background-color", "#f0f0f0");
        
        
        
        
        
        
        
        
        
        leftPanel.add(abilityScoreBlurb, abilityScoreLabel, abilityScoreField, abilityScoreSelection, abilityPanel);
        rightPanel.add();
        
        HorizontalLayout header = new HorizontalLayout();
        
        H1 heading = new H1("Step 3: Determine Ability Scores");
        
        Button nextButton = new Button("Next Step");
        nextButton.addClickListener(click -> {
	    		UI.getCurrent().navigate(AbilityScoresView.class);
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
	
}