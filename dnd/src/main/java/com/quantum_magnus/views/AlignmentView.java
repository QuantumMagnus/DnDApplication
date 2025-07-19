package com.quantum_magnus.views;

import com.quantum_magnus.dnd.CharacterData;
import com.quantum_magnus.dnd.NavigationBar;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
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
        
        Paragraph alignmentBlurb = new Paragraph("Alignment is a shorthand for your character's moral compass. Choose "
        		+ "your character's alignment from the following options. Note that D&D assumes that okayer characters aren't "
        		+ "of an evil alignment. Check with your DM before making an evil character");
        
        
        
        
        
        leftPanel.add(alignmentBlurb);
        rightPanel.add();
        
        HorizontalLayout header = new HorizontalLayout();
        
        H1 heading = new H1("Step 4: Choose an Alignment");
        
        Button nextButton = new Button("Next Step");
        nextButton.addClickListener(click -> {
        		CharacterData formData = getCharacterData();
        		//formData.setAlignment(alignmentField);

    			VaadinSession.getCurrent().setAttribute(CharacterData.class, formData);
        	
	    		UI.getCurrent().navigate(TestView.class);
	    });
        nextButton.getStyle().set("left", "45.25rem").set("top", "0.5rem");
        header.add(heading, nextButton);
        
        VerticalLayout bottomPanel = new VerticalLayout(header);
        bottomPanel.getStyle().set("overflow", "auto");
        HorizontalLayout mainContent = new HorizontalLayout(leftPanel, rightPanel);
        mainContent.setHeight("78vh");
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