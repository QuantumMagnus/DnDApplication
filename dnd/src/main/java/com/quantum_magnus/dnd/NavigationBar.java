package com.quantum_magnus.dnd;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNavItem;

public class NavigationBar extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SideNavItem homeLink;
	private SideNavItem createLink;
	
	public NavigationBar() {
        // === Drawer Menu (Nav Items) ===
		this.homeLink = new SideNavItem("Home",
		        MainView.class, VaadinIcon.HOME.create());
		
		this.createLink = new SideNavItem("Create Character", CreateIntroView.class, 
				VaadinIcon.PLUS_CIRCLE.create());
		this.createLink.addItem(new SideNavItem("1: Choose Class", ChooseClassView.class,
		        VaadinIcon.ACADEMY_CAP.create()));
		this.createLink.addItem(new SideNavItem("2: Determine Origin", DetermineOriginView.class,
		        VaadinIcon.OPEN_BOOK.create()));
		this.createLink.addItem(new SideNavItem("3: Ability Scores", AbilityScoresView.class,
		        VaadinIcon.BAR_CHART_V.create()));
		
        this.add(this.homeLink, this.createLink);
	}
	
	public void setCreateOpen(boolean flag) {
		this.createLink.setExpanded(flag);
	}

}
