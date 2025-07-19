package com.quantum_magnus.views;

import com.quantum_magnus.dnd.NavigationBar;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")
@PageTitle("DND Player's Handbook")
public class MainView extends AppLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainView() {
		DrawerToggle toggle = new DrawerToggle();
        H1 title = new H1("Home");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");
        HorizontalLayout navBarHeader = new HorizontalLayout(toggle, title);
        navBarHeader.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        navBarHeader.setWidthFull();
        navBarHeader.getStyle().set("padding", "var(--lumo-space-m)");

        addToNavbar(true, navBarHeader);

        NavigationBar drawerLayout = new NavigationBar();
        drawerLayout.setCreateOpen(false);
        addToDrawer(drawerLayout);
	}

}