package com.quantum_magnus.dnd;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("create")
@PageTitle("Create a Character")
public class CreateIntroView extends AppLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateIntroView() {
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
        
        VerticalLayout leftPanel = new VerticalLayout();
        leftPanel.setPadding(false);
        leftPanel.setWidth("50%");
        leftPanel.setHeightFull();
        leftPanel.getStyle().set("overflow", "hidden");

        VerticalLayout rightPanel = new VerticalLayout();
        rightPanel.setPadding(false);
        rightPanel.setWidth("50%");
        rightPanel.setHeightFull();
        rightPanel.getStyle().set("overflow", "auto");
        
        Image art = new Image("misc/charactercreate.jpg", "Create Intro Art");
        art.getStyle().set("width", "44em");
        
        Paragraph createIntro = new Paragraph("You can make a character for Dungeons & Dragons using the building "
        		+ "blocks on this website. Your character is a combination of game statistics, roleplaying hooks "
        		+ "and your imagination. You choose a class (such as Fighter or Wizard), a background (such as "
        		+ "Sailer or Acolyte), and a species (such as Human and Elf). You also invent the personality "
        		+ "and appearance of your character. Once completed, your character serves as your avatar in the "
        		+ "D&D multiverse.");
        
        H3 getReady = new H3("Get Ready");
        
        Paragraph notes = new Paragraph("Before you dive into character creation, there are a few things to do to "
        		+ "get ready, as explained on the right.");
        
        H4 noteHeader1 = new H4("Talk with your DM");
        
        Paragraph note1 = new Paragraph("Start by talking with your Dungeon Master about the type of D&D game "
        		+ "they plan to run. If the DM draws inspiration from Greek myth, for example, you might choose a "
        		+ "different direction for your character than if the DM is planning for swashbuckling on the "
        		+ "high seas. Think about the kind of adventurer you want to play in this game. If you don't know "
        		+ "where to begin, look at some character illustrations on this site or Google for inspiration.");
        
        H4 noteHeader2 = new H4("Session Zero");
        
        Paragraph note2 = new Paragraph("Some Dungeon Masters start a campaign with a \"session zero,\" an "
        		+ "initial gathering focused on creating characters and setting expectations, including topics "
        		+ "to avoid as well as those to embrace. A session zero provides a great opportunity to talk "
        		+ "to the other players and the DM and decide whether your characters know one another, how they "
        		+ "met, and what sorts of quests the group might undertake together.");
        
        leftPanel.add(art, createIntro, getReady, notes);
        rightPanel.add(noteHeader1, note1, noteHeader2, note2);
        
        HorizontalLayout header = new HorizontalLayout();
        
        H1 heading = new H1("Creating a Character");
        
        Button nextButton = new Button("Let's Begin");
        nextButton.addClickListener(click -> {
        		UI.getCurrent().navigate(ChooseClassView.class);
        });
        nextButton.getStyle().set("left", "51.5rem").set("top", "0.5rem");
        header.add(heading, nextButton);
        
        VerticalLayout bottomPanel = new VerticalLayout(header);
        bottomPanel.setSizeFull();
        HorizontalLayout mainContent = new HorizontalLayout();
        mainContent.add(leftPanel, rightPanel);
        mainContent.setHeightFull();
        mainContent.getStyle().set("overflow", "auto");
        bottomPanel.add(mainContent);
        setContent(bottomPanel);
	}
}