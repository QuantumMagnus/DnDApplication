package com.quantum_magnus.dnd;

import com.quantum_magnus.views.AbilityScoresView;
import com.quantum_magnus.views.AlignmentView;
import com.quantum_magnus.views.ChooseClassView;
import com.quantum_magnus.views.CreateIntroView;
import com.quantum_magnus.views.DetermineOriginView;
import com.quantum_magnus.views.FillInDetailsView;
import com.quantum_magnus.views.MainView;
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
		this.homeLink.getElement().getStyle().set("width", "100%");
		
		this.createLink = new SideNavItem("Create Character", CreateIntroView.class, 
				VaadinIcon.PLUS_CIRCLE.create());
		this.createLink.addItem(new SideNavItem("1: Choose Class", ChooseClassView.class,
		        VaadinIcon.ACADEMY_CAP.create()));
		this.createLink.addItem(new SideNavItem("2: Determine Origin", DetermineOriginView.class,
		        VaadinIcon.OPEN_BOOK.create()));
		this.createLink.addItem(new SideNavItem("3: Ability Scores", AbilityScoresView.class,
		        VaadinIcon.BAR_CHART_V.create()));
		this.createLink.addItem(new SideNavItem("4: Choose Alignment", AlignmentView.class,
		        VaadinIcon.SCALE.create()));
		this.createLink.addItem(new SideNavItem("5: Fill In Details", FillInDetailsView.class,
		        VaadinIcon.SCALE.create()));
		
        this.add(this.homeLink, this.createLink);
	}
	
	public void setCreateOpen(boolean flag) {
		this.createLink.setExpanded(flag);
	}

}
