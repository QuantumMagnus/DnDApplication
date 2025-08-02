package com.quantum_magnus.views;

import com.quantum_magnus.dnd.CharacterData;
import com.quantum_magnus.dnd.DnDKeywords.Alignments;
import com.quantum_magnus.dnd.NavigationBar;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("create/choose-alignment")
@PageTitle("Choose an Alignment")
public class AlignmentView extends AppLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AlignmentView() {
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
        
        Paragraph alignmentBlurb = new Paragraph("Alignment is a shorthand for your character's moral compass. Choose your "
        		+ "character's alignment from the following options. Note that D&D assumes that okayer characters aren't of an "
        		+ "evil alignment. Check with your DM before making an evil character.");
        
        NativeLabel alignmentLabel = new NativeLabel("Alignment");
        alignmentLabel.getStyle().set("font-weight", "bold");
        ComboBox<Alignments> alignmentField = new ComboBox<Alignments>();
        alignmentField.setAllowCustomValue(true);
        alignmentField.setItems(Alignments.values());
        alignmentField.setTooltipText("Select or type an alignment");
        HorizontalLayout alignmentSelection = new HorizontalLayout(alignmentLabel, alignmentField);
        alignmentSelection.setAlignItems(FlexComponent.Alignment.BASELINE);
        
        H3 personalityTitle = new H3("Alignment and Personality");
        
        Paragraph personalityBlurb = new Paragraph("Alignment can shape a character's personality, goals, and core beliefs. "
        		+ "Looking at the two elements of an alignment, you cn use the lists below to inspire details of your "
        		+ "character's personality.");
        
        H4 lawfulTitle = new H4("Lawful");
        
        UnorderedList lawfulTraits = new UnorderedList();
        lawfulTraits.add(new ListItem("Cooperative"));
        lawfulTraits.add(new ListItem("Loyal"));
        lawfulTraits.add(new ListItem("Judgmental"));
        lawfulTraits.add(new ListItem("Methodical"));
        
        VerticalLayout lawfulPanel = new VerticalLayout(lawfulTitle, lawfulTraits);
        lawfulPanel.setSpacing(false);
        
        H4 neutralTitle = new H4("Neutral");
        
        UnorderedList neutralTraits = new UnorderedList();
        neutralTraits.add(new ListItem("Selfish"));
        neutralTraits.add(new ListItem("Disinterested"));
        neutralTraits.add(new ListItem("Laconic"));
        neutralTraits.add(new ListItem("Pragmatic"));
        
        VerticalLayout neutralPanel = new VerticalLayout(neutralTitle, neutralTraits);
        neutralPanel.setSpacing(false);
        
        H4 chaoticTitle = new H4("Chaotic");
        
        UnorderedList chaoticTraits = new UnorderedList();
        chaoticTraits.add(new ListItem("Boastful"));
        chaoticTraits.add(new ListItem("Impulsive"));
        chaoticTraits.add(new ListItem("Rebellious"));
        chaoticTraits.add(new ListItem("Self-Absorbed"));
        
        VerticalLayout chaoticPanel = new VerticalLayout(chaoticTitle, chaoticTraits);
        chaoticPanel.setSpacing(false);
        
        H4 goodTitle = new H4("Good");
        
        UnorderedList goodTraits = new UnorderedList();
        goodTraits.add(new ListItem("Compassionate"));
        goodTraits.add(new ListItem("Helpful"));
        goodTraits.add(new ListItem("Honest"));
        goodTraits.add(new ListItem("Kind"));
        
        VerticalLayout goodPanel = new VerticalLayout(goodTitle, goodTraits);
        goodPanel.setSpacing(false);
        
        H4 evilTitle = new H4("Evil");
        
        UnorderedList evilTraits = new UnorderedList();
        evilTraits.add(new ListItem("Dishonest"));
        evilTraits.add(new ListItem("Vengeful"));
        evilTraits.add(new ListItem("Cruel"));
        evilTraits.add(new ListItem("Greedy"));
        
        VerticalLayout evilPanel = new VerticalLayout(evilTitle, evilTraits);
        evilPanel.setSpacing(false);
        
        HorizontalLayout topTraitPanel = new HorizontalLayout(lawfulPanel, neutralPanel, chaoticPanel);
        topTraitPanel.getStyle().set("margin-left", "auto").set("margin-right", "auto");
        topTraitPanel.setWidthFull();
        topTraitPanel.setSpacing(false);
        HorizontalLayout bottomTraitPanel = new HorizontalLayout(goodPanel, evilPanel);
        bottomTraitPanel.getStyle().set("margin-left", "auto").set("margin-right", "auto");
        bottomTraitPanel.setSpacing(false);
        VerticalLayout personalityTraitsPanel = new VerticalLayout(personalityTitle, 
        		personalityBlurb, topTraitPanel, bottomTraitPanel);
        personalityTraitsPanel.setSpacing(false);
        
        Image alignmentChart = new Image("misc/alignments.jpg", "Alignment Chart");
        alignmentChart.getStyle().set("width", "80%").set("display", "block")
        		.set("margin-left", "auto").set("margin-right", "auto");
        
        leftPanel.add(alignmentBlurb, alignmentSelection, personalityTraitsPanel);
        rightPanel.add(alignmentChart);
        
        HorizontalLayout header = new HorizontalLayout();
        
        H1 heading = new H1("Step 4: Choose an Alignment");
        
        Button nextButton = new Button("Next Step");
        nextButton.addClickListener(click -> {
        		CharacterData formData = getCharacterData();
        		formData.setAlignment(alignmentField.getValue().getDisplayName());

    			VaadinSession.getCurrent().setAttribute(CharacterData.class, formData);
        	
	    		UI.getCurrent().navigate(FillInDetailsView.class);
	    });
        nextButton.getStyle().set("left", "45.25rem").set("top", "0.5rem");
        header.add(heading, nextButton);
        
        VerticalLayout bottomPanel = new VerticalLayout(header);
        bottomPanel.getStyle().set("overflow", "auto");
        HorizontalLayout mainContent = new HorizontalLayout(leftPanel, rightPanel);
        mainContent.setHeightFull();
        mainContent.getStyle().set("overflow", "auto");
        bottomPanel.add(mainContent);
        setContent(bottomPanel);
	}

	private CharacterData getCharacterData() {
        CharacterData data = VaadinSession.getCurrent().getAttribute(CharacterData.class);
        if (data == null) {
            throw new IllegalStateException("No data from previous step.");
        }
        return data;
    }
	
}