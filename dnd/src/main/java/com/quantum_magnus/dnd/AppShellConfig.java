package com.quantum_magnus.dnd;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Theme(variant = Lumo.DARK)
@PWA(name = "D&D Character Builder", shortName = "DnD Builder")
public class AppShellConfig implements AppShellConfigurator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    // No methods needed unless you want custom config
}