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

package com.github.jgility.e4.natures;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

/**
 * Eclipse Project Nature für Projekte im Jgility Kontext
 * 
 * @author Christoph Viebig
 */
public class JgilityNature
    implements IProjectNature
{

    /**
     * Identifikator der Eclipse Project Nature
     */
    public static final String NATURE_ID = "com.github.jgility.e4.natures.JgilityNature";

    private IProject project;

    @Override
    public void configure()
        throws CoreException
    {
        // empty
    }

    @Override
    public void deconfigure()
        throws CoreException
    {
        // empty
    }

    @Override
    public IProject getProject()
    {
        return this.project;
    }

    @Override
    public void setProject( IProject project )
    {
        this.project = project;
    }

}
