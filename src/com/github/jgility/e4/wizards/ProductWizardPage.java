/*
 * 
 * Copyright (c) 2011 by Jgility Development Group
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Viebig
 *
 */

package com.github.jgility.e4.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * Seite für den Assistenten für die Erzeugung eines Jgility Produktes
 * 
 * @author Christoph Viebig
 *
 */
public class ProductWizardPage extends WizardNewFileCreationPage {
	
    /**
     * Erzeugt Seite für den Assistenten für die Erzeugung eines Jgility Produktes
     * 
     * Name: Product Wizard
     * Title: New Product
     * Description: Create a new Product
     * File Extension: xml
     * @param selection
     */
	public ProductWizardPage(IStructuredSelection selection) {
		super("Product Wizard", selection);
		setTitle("New Product");
		setDescription("Create a new Product");
		setFileExtension("xml");
	}
}
