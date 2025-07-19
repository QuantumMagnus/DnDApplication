package com.quantum_magnus.views;

import com.quantum_magnus.dnd.CharacterData;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("create/test")
@PageTitle("Test")
public class TestView extends VerticalLayout {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public TestView() {
		CharacterData data = VaadinSession.getCurrent().getAttribute(CharacterData.class);
	
		if (data != null) {
			add(new H2("Review Your Character"));
			add(new Paragraph("Class: " + data.getClassIn()));
			add(new Paragraph("Background: " + data.getBackground()));
			add(new Paragraph("Race: " + data.getSpecies()));
			add(new Paragraph("Ability Scores:"));
			add(new ListItem("Strength: " + data.getAbilityScores()[0]));
			add(new ListItem("Dexterity: " + data.getAbilityScores()[1]));
			add(new ListItem("Constitution: " + data.getAbilityScores()[2]));
			add(new ListItem("Intelligence: " + data.getAbilityScores()[3]));
			add(new ListItem("Wisdom: " + data.getAbilityScores()[4]));
			add(new ListItem("Charisma: " + data.getAbilityScores()[5]));
	
			Button submitButton = new Button("Submit", e -> {
				saveCharacter(data); // e.g. save to DB
				VaadinSession.getCurrent().setAttribute(CharacterData.class, null);
				Notification.show("Character Created!");
				UI.getCurrent().navigate("");
			});
	
			add(submitButton);
		} else {
			add(new Paragraph("No character data found."));
		}
	}

	private void saveCharacter(CharacterData data) {
		// Persist data somewhere
		System.out.println("Saving character: " + data);
	}
	
}