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

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * Assistent für die Erzeugung von Jgility Produkten
 * 
 * @author Christoph Viebig
 *
 */
public class ProductWizard
    extends Wizard
    implements INewWizard
{

    private ProductWizardPage wizardPage;

    private IStructuredSelection selection;

    /**
     * Initialisiert den Titel des Assistenten mit "New Product Wizard"
     */
    public ProductWizard()
    {
        setWindowTitle( "New Product Wizard" );
    }

    @Override
    public void init( IWorkbench workbench, IStructuredSelection selection )
    {
        this.selection = selection;
    }

    @Override
    public boolean performFinish()
    {
        IFile file = wizardPage.createNewFile();
        if ( file != null )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void addPages()
    {
        wizardPage = new ProductWizardPage( selection );
        addPage( wizardPage );
    }

}
