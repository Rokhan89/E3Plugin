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

package com.github.jgility.e4.projects;

import java.net.URI;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;

/**
 * Eclipse Project Factory stellt statische Methoden für das Erstellen und Bearbeiten von Eclipse Projects zur Verfügung
 * 
 * @author Christoph Viebig
 */
public final class ProjectFactory
{

    /**
     * Erzeugt ein Eclipse Project
     * 
     * @param name Projektname
     * @param location Projektverzeichnis
     * @return IProject Erzeugtes Eclipse Project
     */
    public static IProject createProject( String name, URI location )
        throws CoreException
    {
        Assert.isNotNull( name );
        Assert.isTrue( name.trim().length() > 0 );

        IWorkspace workspace = ResourcesPlugin.getWorkspace();

        IProject project = workspace.getRoot().getProject( name );

        if ( !project.exists() )
        {
            IProjectDescription description = workspace.newProjectDescription( project.getName() );
            if ( location != null && workspace.getRoot().getLocationURI().equals( location ) )
            {
                location = null;
            }
            description.setLocationURI( location );

            project.create( description, null );
            if ( !project.isOpen() )
            {
                project.open( null );
            }
        }

        return project;
    }

    /**
     * Erweitert ein Eclipse Project um eine Eclipse Project Nature. Eine Project Nature ist eine Art Projekttyp. Ein
     * Eclipse Project kann mehrere davon besitzen und wird beim Hinzufügen einer Nature durch diese neu konfiguriert.
     * 
     * @param project Eclipse Project
     * @param natureId Id der Eclipse Project Nature
     * @throws CoreException
     */
    public static void addNature( IProject project, String natureId )
        throws CoreException
    {
        if ( !project.hasNature( natureId ) )
        {
            IProjectDescription description = project.getDescription();
            String[] natures = description.getNatureIds();
            String[] newNatures = new String[natures.length + 1];
            System.arraycopy( natures, 0, newNatures, 0, natures.length );
            newNatures[natures.length] = natureId;
            description.setNatureIds( newNatures );

            // TODO IResource.AVOID_NATURE_CONFIG entfernen
            project.setDescription( description, IResource.AVOID_NATURE_CONFIG, null );
        }
    }

    public static boolean createProjectWithNature( String name, URI location, String natureId )
    {
        boolean success = true;
        try
        {
            IProject project = createProject( name, location );
            addNature( project, natureId );
        }
        catch ( CoreException e )
        {
            e.printStackTrace();
            success = false;
        }
        return success;
    }
}
