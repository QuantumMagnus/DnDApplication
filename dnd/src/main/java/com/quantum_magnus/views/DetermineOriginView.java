package com.quantum_magnus.views;

import com.quantum_magnus.dnd.CharacterData;
import com.quantum_magnus.dnd.DnDOrigins;
import com.quantum_magnus.dnd.NavigationBar;
import com.quantum_magnus.dnd.DnDKeywords.Background;
import com.quantum_magnus.dnd.DnDKeywords.Species;
import com.quantum_magnus.tables.Dragonborn;
import com.quantum_magnus.tables.Elf;
import com.quantum_magnus.tables.Tiefling;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.card.CardVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("create/determine-origin")
@PageTitle("Determine Origin")
public class DetermineOriginView extends AppLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DetermineOriginView() {
		DrawerToggle toggle = new DrawerToggle();
        H1 title = new H1("Create Character");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");
        HorizontalLayout navBarHeader = new HorizontalLayout(toggle, title);
        navBarHeader.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        navBarHeader.setWidthFull();
        navBarHeader.getStyle().set("padding", "var(--lumo-space-m)");

        addToNavbar(true, navBarHeader);

        // === Drawer Menu (Nav Items) ===
		NavigationBar drawerLayout = new NavigationBar();
		drawerLayout.setCreateOpen(true);
        addToDrawer(drawerLayout);
        
        // === Main Content: Three Panels ===
        VerticalLayout leftPanel = new VerticalLayout();
        leftPanel.setPadding(false);
        leftPanel.setWidth("40%");
        leftPanel.setHeightFull();
        leftPanel.getStyle().set("overflow", "auto").set("padding-left", "1em");

        VerticalLayout rightPanel = new VerticalLayout();
        rightPanel.setPadding(false);
        rightPanel.setWidth("60%");
        rightPanel.setHeightFull();
        rightPanel.getStyle().set("overflow", "auto");
        
        Paragraph originBlurb = new Paragraph("A character's origin includes two elements: background and "
        		+ "species. How did the character spend the years leading up to a life of adventure? Who are the "
        		+ "character's ancestors? You can also determine your character's languages.");
        
        NativeLabel backgroundLabel = new NativeLabel("Character Background");
        backgroundLabel.getStyle().set("font-weight", "bold");
        ComboBox<Background> backgroundField = new ComboBox<Background>(); 
        backgroundField.setAllowCustomValue(true);
        backgroundField.setItems(Background.values());
        backgroundField.setTooltipText("Select or type a background");
        HorizontalLayout backgroundSelection = new HorizontalLayout(backgroundLabel, backgroundField);
        backgroundSelection.setAlignItems(FlexComponent.Alignment.BASELINE);
        
        Paragraph characterBackgroundBlurb = new Paragraph("Your character's background is a collection of "
        		+ "characteristics that represent the place and occupation that were most formative before your "
        		+ "character embarked on a life of adventure. Each background includes a brief narrative of "
        		+ "what your character's past might have been like. Alter the details of this narrative however "
        		+ "you like.");
        
        backgroundField.addValueChangeListener(event -> {
            rightPanel.removeAll(); // Clear previous card
            String selected = event.getValue().name();
            if (selected != null) {
                Card card = createBackgroundCard(selected);
                rightPanel.add(card);
            }
        });
        
        NativeLabel speciesLabel = new NativeLabel("Character Species");
        speciesLabel.getStyle().set("font-weight", "bold");
        ComboBox<Species> speciesField = new ComboBox<Species>(); 
        speciesField.setAllowCustomValue(true);
        speciesField.setItems(Species.values());
        speciesField.setTooltipText("Select or type a species");
        HorizontalLayout speciesSelection = new HorizontalLayout(speciesLabel, speciesField);
        speciesSelection.setAlignItems(FlexComponent.Alignment.BASELINE);
        
        Paragraph speciesBlurb = new Paragraph("The peoples of the D&D multiverse hail from different worlds and "
        		+ "include many kinds of sapient life forms. A player character's species is the set of game "
        		+ "traits that an adventurer gains from being one of those life forms. Some species can trace "
        		+ "their origins to a single world, plane of existence, or god, while other species first "
        		+ "appeared in multiple realms at once. Whatever a species' genesis, its members have spread "
        		+ "across the multiverse and contribute to many different cultures.\nMembers of most species live "
        		+ "for about 80 years, with exceptions noted in the text about species in their descriptions. "
        		+ "Regardless of their lifespan, members of all species reach physical maturity at about the same "
        		+ "age. Your character can be any age that isn't beyond their species' normal age range.");
        
        VerticalLayout lowerPanel = new VerticalLayout();
        lowerPanel.setPadding(false);
        lowerPanel.getStyle().set("overflow", "auto");
        lowerPanel.setWidthFull();
        
        speciesField.addValueChangeListener(event -> {
            lowerPanel.removeAll(); // Clear previous card
            String selected = event.getValue().name();
            if (selected != null) {
            		String[] speciesHtml = DnDOrigins.speciesDetails(selected);
                Card card = createSpeciesCard(selected, speciesHtml[0]);
                lowerPanel.add(card);
                
                Html leftHtml = new Html(speciesHtml[1]);
                Html rightHtml = new Html(speciesHtml[2]);
                
                VerticalLayout speciesLeftPanel = new VerticalLayout();
                speciesLeftPanel.setPadding(false);
                speciesLeftPanel.setWidth("50%");
                speciesLeftPanel.setHeightFull();
                speciesLeftPanel.getStyle().set("overflow", "hidden").set("padding-left", "1em");
                
                if (selected.equals(Species.Dragonborn.name())) {
	                H3 tableTitle = new H3("Draconic Ancestors");
	                
	                Grid<Dragonborn> dragonbornFirstHalfTable = new Grid<Dragonborn>(Dragonborn.class, false);
	                dragonbornFirstHalfTable.addColumn(Dragonborn::getAncestor).setHeader("Dragon");
	                dragonbornFirstHalfTable.addColumn(Dragonborn::getElement).setHeader("Damage Type");
	                dragonbornFirstHalfTable.getStyle().set("overflow", "hidden");
	                dragonbornFirstHalfTable.setWidthFull();
	
	                Dragonborn[] dragonbornFirstHalfSubspecies = Dragonborn.getDragonbornFirstHalf();
	                dragonbornFirstHalfTable.setItems(dragonbornFirstHalfSubspecies);
	                
	                Grid<Dragonborn> dragonbornSecondHalfTable = new Grid<Dragonborn>(Dragonborn.class, false);
	                dragonbornSecondHalfTable.addColumn(Dragonborn::getAncestor).setHeader("Dragon");
	                dragonbornSecondHalfTable.addColumn(Dragonborn::getElement).setHeader("Damage Type");
	                dragonbornSecondHalfTable.getStyle().set("overflow", "hidden");
	                dragonbornSecondHalfTable.setWidthFull();
	
	                Dragonborn[] dragonbornSecondHalfSubspecies = Dragonborn.getDragonbornSecondHalf();
	                dragonbornSecondHalfTable.setItems(dragonbornSecondHalfSubspecies);
	                
	                HorizontalLayout dragonbornAncestorsPanel = 
	                		new HorizontalLayout(dragonbornFirstHalfTable, dragonbornSecondHalfTable);
	                dragonbornAncestorsPanel.setWidthFull();
	                dragonbornAncestorsPanel.setFlexGrow(1, dragonbornFirstHalfTable);
	                dragonbornAncestorsPanel.setFlexGrow(1, dragonbornSecondHalfTable);
	                dragonbornAncestorsPanel.getStyle().set("overflow", "hidden");
	                
	                dragonbornFirstHalfTable.setAllRowsVisible(true);
	                dragonbornSecondHalfTable.setAllRowsVisible(true);
	                
	                speciesLeftPanel.add(leftHtml, tableTitle, dragonbornAncestorsPanel);
                } else {
                		speciesLeftPanel.add(leftHtml);
                }

                VerticalLayout speciesRightPanel = new VerticalLayout();
                speciesRightPanel.setPadding(false);
                speciesRightPanel.setWidth("50%");
                speciesRightPanel.setHeightFull();
                speciesRightPanel.getStyle().set("overflow", "hidden").set("padding-right", "1em");
                speciesRightPanel.add(rightHtml);
                
                HorizontalLayout details = new HorizontalLayout(speciesLeftPanel, speciesRightPanel);
                lowerPanel.getStyle().set("overflow", "auto");
                lowerPanel.setHeight(speciesHtml[3]);
                
                if (selected.equals(Species.Elf.name())) {
	                H3 tableTitle = new H3("Elven Lineages");
	                
	                Grid<Elf> elfLineageTable = new Grid<Elf>(Elf.class, false);
	                elfLineageTable.addColumn(Elf::getLineage).setHeader("Lineage").setFlexGrow(0);
	                elfLineageTable.addColumn(Elf::getLevelOne).setHeader("Level 1").setWidth("45rem").setFlexGrow(0);
	                elfLineageTable.addColumn(Elf::getLevelThree).setHeader("Level 3").setWidth("17rem").setFlexGrow(0);
	                elfLineageTable.addColumn(Elf::getLevelFive).setHeader("Level 5").setWidth("17rem").setFlexGrow(0);
	                elfLineageTable.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
	                elfLineageTable.getStyle().set("overflow", "hidden");
	                elfLineageTable.setWidthFull();
	
	                Elf[] elvenSubspecies = Elf.getElvenLineages();
	                elfLineageTable.setItems(elvenSubspecies);
	                elfLineageTable.setAllRowsVisible(true);
	                lowerPanel.add(details, tableTitle, elfLineageTable);
                } else if (selected.equals(Species.Tiefling.name())) {
                		H3 tableTitle = new H3("Fiendish Legacies");
	                
	                Grid<Tiefling> tieflingLegacyTable = new Grid<Tiefling>(Tiefling.class, false);
	                tieflingLegacyTable.addColumn(Tiefling::getLegacy).setHeader("Lineage").setFlexGrow(0);
	                tieflingLegacyTable.addColumn(Tiefling::getLevelOne).setHeader("Level 1")
	                		.setWidth("45rem").setFlexGrow(0);
	                tieflingLegacyTable.addColumn(Tiefling::getLevelThree).setHeader("Level 3")
	                		.setWidth("17rem").setFlexGrow(0);
	                tieflingLegacyTable.addColumn(Tiefling::getLevelFive).setHeader("Level 5")
	                		.setWidth("17rem").setFlexGrow(0);
	                tieflingLegacyTable.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
	                tieflingLegacyTable.getStyle().set("overflow", "hidden");
	                tieflingLegacyTable.setWidthFull();
	
	                Tiefling[] tieflingSubspecies = Tiefling.getTieflingLegacies();
	                tieflingLegacyTable.setItems(tieflingSubspecies);
	                tieflingLegacyTable.setAllRowsVisible(true);
	                lowerPanel.add(details, tableTitle, tieflingLegacyTable);
                } else {
                		lowerPanel.add(details);
                }
            }
            lowerPanel.getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
        });
        
        leftPanel.add(originBlurb, backgroundSelection, characterBackgroundBlurb, speciesSelection, speciesBlurb);
        rightPanel.add();
        lowerPanel.add();
		
        HorizontalLayout header = new HorizontalLayout();
        
        H1 heading = new H1("Step 2: Determine Origin");
        
        Button nextButton = new Button("Next Step");
        nextButton.addClickListener(click -> {
        		CharacterData formData = getCharacterData();
			formData.setBackground(backgroundField.getValue().name());
			formData.setSpecies(speciesField.getValue().name());

			VaadinSession.getCurrent().setAttribute(CharacterData.class, formData);
        	
        		UI.getCurrent().navigate(AbilityScoresView.class);
        });
        nextButton.getStyle().set("left", "50rem").set("top", "0.5rem");
        header.add(heading, nextButton);
        
        VerticalLayout bottomPanel = new VerticalLayout(header);
        bottomPanel.getStyle().set("overflow", "auto");
        HorizontalLayout mainContent = new HorizontalLayout(leftPanel, rightPanel);
        mainContent.setHeightFull();
        mainContent.getStyle().set("overflow", "auto");
        bottomPanel.add(mainContent, lowerPanel);
        setContent(bottomPanel);
	}

	// Helper method to create a Background card component
	private Card createBackgroundCard(String background) {
		Card backgroundCard = new Card();
        Image image = DnDOrigins.getBackgroundImage(background);
        backgroundCard.setWidthFull();
        backgroundCard.setMedia(image);
        backgroundCard.addThemeVariants(CardVariant.LUMO_COVER_MEDIA);
        
        VerticalLayout leftPanel = new VerticalLayout();
        leftPanel.setPadding(false);
        leftPanel.setWidth("50%");
        leftPanel.setHeightFull();
        leftPanel.getStyle().set("overflow", "hidden");

        VerticalLayout rightPanel = new VerticalLayout();
        rightPanel.setPadding(false);
        rightPanel.setWidth("50%");
        rightPanel.setHeightFull();
        rightPanel.getStyle().set("overflow", "hidden");
        
        HorizontalLayout details = new HorizontalLayout(leftPanel, rightPanel);
        String[] backgroundHtml = DnDOrigins.backgroundDetails(background);
        Html components = new Html(backgroundHtml[0]);
        Html description = new Html(backgroundHtml[1]);
        
        leftPanel.add(components);
        rightPanel.add(description);
        
        backgroundCard.add(details);
        
	    return backgroundCard;
	}
	
	// Helper method to create a Background card component
	private Card createSpeciesCard(String species, String descriptionIn) {
		Card speciesCard = new Card();
        Image image = DnDOrigins.getSpeciesImage(species);
        image.setWidth("55em");
        speciesCard.setWidthFull();
        speciesCard.setMedia(image);
        speciesCard.addThemeVariants(CardVariant.LUMO_COVER_MEDIA, CardVariant.LUMO_HORIZONTAL);
        speciesCard.setTitle(new Div(species));
        
        Html description = new Html(descriptionIn);
        speciesCard.add(description);
        
	    return speciesCard;
	}
	
	private CharacterData getCharacterData() {
        CharacterData data = VaadinSession.getCurrent().getAttribute(CharacterData.class);
        if (data == null) {
            throw new IllegalStateException("No data from previous step.");
        }
        return data;
    }
	
}