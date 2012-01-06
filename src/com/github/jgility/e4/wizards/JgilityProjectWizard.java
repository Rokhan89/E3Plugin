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
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import com.github.jgility.e4.natures.JgilityNature;
import com.github.jgility.e4.projects.ProjectFactory;

/**
 * Implementiert einen Assistenten für die Erstellung von Jgility Eclipse Projekten
 * 
 * @author Christoph Viebig
 */
public class JgilityProjectWizard
    extends Wizard
    implements INewWizard
{

    private WizardNewProjectCreationPage wizardPage;

    /**
     * Initialisiert den Titel des Assistenten mit "New Jgility Project"
     */
    public JgilityProjectWizard()
    {
        setWindowTitle( "New Jgility Project" );
    }

    @Override
    public void init( IWorkbench workbench, IStructuredSelection selection )
    {
        // unmodified
    }

    @Override
    public boolean performFinish()
    {
        boolean success;
        if ( !wizardPage.useDefaults() )
        {
            success =
                ProjectFactory.createProjectWithNature( wizardPage.getProjectName(), wizardPage.getLocationURI(),
                                                        JgilityNature.NATURE_ID );
        }
        else
        {
            success =
                ProjectFactory.createProjectWithNature( wizardPage.getProjectName(), null, JgilityNature.NATURE_ID );
        }
        return success;
    }

    /**
     * Fügt dem Assistenten eine @WizardNewProjectCreationPage hinzu und konfiguriert diese
     */
    @Override
    public void addPages()
    {
        super.addPages();

        wizardPage = new WizardNewProjectCreationPage("Jgility New Project Wizard");
        wizardPage.setTitle("New Jgility Project");
        wizardPage.setDescription("Creates a new Jgility project");

        addPage( wizardPage );
    }

}
