package org.eclipse.m2m.qvt.oml.profiler.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

public class ExitHandler
{
    @Execute
    public void execute(IWorkbench aWorkbench)
    {
        aWorkbench.close();
    }
}