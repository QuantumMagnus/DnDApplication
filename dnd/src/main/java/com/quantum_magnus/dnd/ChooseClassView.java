package com.quantum_magnus.dnd;

import com.quantum_magnus.dnd.DnDKeywords.Class;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("create/choose-a-class")
@PageTitle("Choose a Class")
public class ChooseClassView extends AppLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Accordion[] accordions = new Accordion[12];

	public ChooseClassView() {
				
		DrawerToggle toggle = new DrawerToggle();
        H1 title = new H1("Create Character");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");
        HorizontalLayout navBarHeader = new HorizontalLayout(toggle, title);
        navBarHeader.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        navBarHeader.setWidthFull();
        navBarHeader.getStyle().set("padding", "var(--lumo-space-m)");

        addToNavbar(true, navBarHeader);

        NavigationBar drawerLayout = new NavigationBar();
        drawerLayout.setCreateOpen(true);
        addToDrawer(drawerLayout);
		
        // === Main Content: Two Panels Side-by-Side ===
        VerticalLayout leftPanel = new VerticalLayout();
        leftPanel.setPadding(false);
        leftPanel.setWidth("45%");
        leftPanel.setHeightFull();
        leftPanel.getStyle().set("overflow", "hidden").set("padding-left", "1em");

        VerticalLayout rightPanel = new VerticalLayout();
        rightPanel.setPadding(false);
        rightPanel.setWidth("55%");
        rightPanel.setHeightFull();
        rightPanel.getStyle().set("overflow", "auto").set("padding-left", "1em");
        
        Paragraph classBlurb = new Paragraph("Every adventurer is a member of a class. A class broadly describes "
        		+ "a character's vocation, special talent, and favored tactics. The Class Overview table below "
        		+ "summarizes the classes. Read more about each class using the arrows on the right.");
        
        NativeLabel classLabel = new NativeLabel("Class");
        classLabel.getStyle().set("font-weight", "bold");
        ComboBox<Class> classField = new ComboBox<Class>();
        classField.setAllowCustomValue(true);
        classField.setItems(Class.values());
        classField.setTooltipText("Select or type a class");
        HorizontalLayout classSelection = new HorizontalLayout(classLabel, classField);
        classSelection.setAlignItems(FlexComponent.Alignment.BASELINE);
        
        H3 tableTitle = new H3("Class Overview");
        
        Grid<DnDClasses> classesTable = new Grid<DnDClasses>(DnDClasses.class, false);
        classesTable.addColumn(DnDClasses::getClassName).setHeader("Class");
        classesTable.addColumn(DnDClasses::getClassLikes).setHeader("Likes...").setAutoWidth(true);
        classesTable.addColumn(DnDClasses::getPrimaryAbility).setHeader("Primary Ability").setAutoWidth(true);
        classesTable.addColumn(DnDClasses::getComplexity).setHeader("Complexity");

        DnDClasses[] classes = DnDClasses.getDnDClasses();
        classesTable.setItems(classes);
        classesTable.setAllRowsVisible(true);
        
        // Barbarian
        Accordion barbarian = new Accordion();
        String barbarianHtml = DnDClasses.getClassText(Class.Barbarian);
        Html barbarianContent = new Html(barbarianHtml);
        VerticalLayout barbarianInfo = new VerticalLayout(barbarianContent);
        barbarianInfo.setPadding(false);
        barbarianInfo.setSpacing(false);
        barbarian.add("Barbarian", barbarianInfo);
        accordions[0] = barbarian;
        barbarian.close();
        
        // Bard
        Accordion bard = new Accordion();
        String bardHtml = DnDClasses.getClassText(Class.Bard);
        Html bardContent = new Html(bardHtml);
        VerticalLayout bardInfo = new VerticalLayout(bardContent);
        bardInfo.setPadding(false);
        bardInfo.setSpacing(false);
        bard.add("Bard", bardInfo);
        accordions[1] = bard;
        bard.close();

        // Cleric
        Accordion cleric = new Accordion();
        String clericHtml = DnDClasses.getClassText(Class.Cleric);
        Html clericContent = new Html(clericHtml);
        VerticalLayout clericInfo = new VerticalLayout(clericContent);
        clericInfo.setPadding(false);
        clericInfo.setSpacing(false);
        cleric.add("Cleric", clericInfo);
        accordions[2] = cleric;
        cleric.close();
        
        // Druid
        Accordion druid = new Accordion();
        String druidHtml = DnDClasses.getClassText(Class.Druid);
        Html druidContent = new Html(druidHtml);
        VerticalLayout druidInfo = new VerticalLayout(druidContent);
        druidInfo.setPadding(false);
        druidInfo.setSpacing(false);
        druid.add("Druid", druidInfo);
        accordions[3] = druid;
        druid.close();
        
        // Fighter
        Accordion fighter = new Accordion();
        String fighterHtml = DnDClasses.getClassText(Class.Fighter);
        Html fighterContent = new Html(fighterHtml);
        VerticalLayout fighterInfo = new VerticalLayout(fighterContent);
        fighterInfo.setPadding(false);
        fighterInfo.setSpacing(false);
        fighter.add("Fighter", fighterInfo);
        accordions[4] = fighter;
        fighter.close();
        
        // Monk
        Accordion monk = new Accordion();
        String monkHtml = DnDClasses.getClassText(Class.Monk);
        Html monkContent = new Html(monkHtml);
        VerticalLayout monkInfo = new VerticalLayout(monkContent);
        monkInfo.setPadding(false);
        monkInfo.setSpacing(false);
        monk.add("Monk", monkInfo);
        accordions[5] = monk;
        monk.close();
        
        // Paladin
        Accordion paladin = new Accordion();
        String paladinHtml = DnDClasses.getClassText(Class.Paladin);
        Html paladinContent = new Html(paladinHtml);
        VerticalLayout paladinInfo = new VerticalLayout(paladinContent);
        paladinInfo.setPadding(false);
        paladinInfo.setSpacing(false);
        paladin.add("Paladin", paladinInfo);
        accordions[6] = paladin;
        paladin.close();
        
        // Ranger
        Accordion ranger = new Accordion();
        String rangerHtml = DnDClasses.getClassText(Class.Ranger);
        Html rangerContent = new Html(rangerHtml);
        VerticalLayout rangerInfo = new VerticalLayout(rangerContent);
        rangerInfo.setPadding(false);
        rangerInfo.setSpacing(false);
        rangerInfo.setHeight("28em");
        ranger.add("Ranger", rangerInfo);
        accordions[7] = ranger;
        ranger.close();
        
        // Rogue
        Accordion rogue = new Accordion();
        String rogueHtml = DnDClasses.getClassText(Class.Rogue);
        Html rogueContent = new Html(rogueHtml);
        VerticalLayout rogueInfo = new VerticalLayout(rogueContent);
        rogueInfo.setPadding(false);
        rogueInfo.setSpacing(false);
        rogueInfo.setHeight("32em");
        rogue.add("Rogue", rogueInfo);
        accordions[8] = rogue;
        rogue.close();
        
        
        // Sorcerer
        Accordion sorcerer = new Accordion();
        String sorcererHtml = DnDClasses.getClassText(Class.Sorcerer);
        Html sorcererContent = new Html(sorcererHtml);
        VerticalLayout sorcererInfo = new VerticalLayout(sorcererContent);
        sorcererInfo.setPadding(false);
        sorcererInfo.setSpacing(false);
        sorcererInfo.setHeight("36em");
        sorcerer.add("Sorcerer", sorcererInfo);
        accordions[9] = sorcerer;
        sorcerer.close();
        
        // Warlock
        Accordion warlock = new Accordion();
        String warlockHtml = DnDClasses.getClassText(Class.Warlock);
        Html warlockContent = new Html(warlockHtml);
        VerticalLayout warlockInfo = new VerticalLayout(warlockContent);
        warlockInfo.setPadding(false);
        warlockInfo.setSpacing(false);
        warlockInfo.setHeight("40em");
        warlock.add("Warlock", warlockInfo);
        accordions[10] = warlock;
        warlock.close();
        
        // Wizard
        Accordion wizard = new Accordion();
        String wizardHtml = DnDClasses.getClassText(Class.Wizard);
        Html wizardContent = new Html(wizardHtml);
        VerticalLayout wizardInfo = new VerticalLayout(wizardContent);
        wizardInfo.setPadding(false);
        wizardInfo.setSpacing(false);
        wizardInfo.setHeight("44em");
        wizard.add("Wizard", wizardInfo);
        accordions[11] = wizard;
        wizard.close();
        
        classField.addValueChangeListener(event -> {
            for (int idx = 0; idx < 12; idx++) {
            		accordions[idx].close();
            }
            String selected = event.getValue().name();
            if (selected != null) {
                switch (selected) {
                case "Barbarian":
	                	accordions[0].open(0);
	                	accordions[0].getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
                	break;
                case "Bard":
	                	accordions[1].open(0);
	                	accordions[1].getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
                	break;
                case "Cleric":
	                	accordions[2].open(0);
	                	accordions[2].getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
                	break;
                case "Druid":
	                	accordions[3].open(0);
	                	accordions[3].getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
                	break;
                case "Fighter":
	                	accordions[4].open(0);
	                	accordions[4].getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
                	break;
                case "Monk":
	                	accordions[5].open(0);
	                	accordions[5].getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
                	break;
                case "Paladin":
	                	accordions[6].open(0);
	                	accordions[6].getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
                	break;
                case "Ranger":
	                	accordions[7].open(0);
	                	accordions[7].getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
                	break;
                case "Rogue":
	                	accordions[8].open(0);
	                	accordions[8].getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
                	break;
                case "Sorcerer":
	                	accordions[9].open(0);
	                	accordions[9].getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
                	break;
                case "Warlock":
	                	accordions[10].open(0);
	                	accordions[10].getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
                	break;
                case "Wizard":
	                	accordions[11].open(0);
	                	accordions[11].getElement().executeJs("this.scrollIntoView({ behavior: 'smooth', block: 'start' })");
                	break;
                default: 
	                	for (int idx = 0; idx < 12; idx++) {
	                    	accordions[idx].close();
                    }
                }
            }
        });
        
        leftPanel.add(classBlurb, classSelection, tableTitle, classesTable);
        rightPanel.add(barbarian, bard, cleric, druid, fighter, monk, 
        		paladin, ranger, rogue, sorcerer, warlock, wizard);
        
        HorizontalLayout header = new HorizontalLayout();
        
        H1 heading = new H1("Step 1: Choose a Class");
        
        Button nextButton = new Button("Next Step");
        nextButton.addClickListener(click -> {
        		UI.getCurrent().navigate(DetermineOriginView.class);
        });
        nextButton.getStyle().set("left", "53.33rem").set("top", "0.5rem");
        header.add(heading, nextButton);
        
        VerticalLayout bottomPanel = new VerticalLayout(header);
        bottomPanel.setSizeFull();
        HorizontalLayout mainContent = new HorizontalLayout(leftPanel, rightPanel);
        mainContent.setHeightFull();
        mainContent.getStyle().set("overflow", "auto");
        bottomPanel.add(mainContent);
        setContent(bottomPanel);
    }

}