package org.eclipse.m2m.qvt.oml.profiler.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;


/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

@SuppressWarnings("restriction")
public class QVToProfilerPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	
	public QVToProfilerPreferencePage() {
		super(GRID);
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		// FIXME The defaults are set here since the preference initializer is not called.
		store.setDefault(QVToProfilerPreferenceConstants.P_PATH, System.getProperty("user.home"));
		
		setPreferenceStore(store);
		setDescription("QVTo Profiler preferences");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		addField(new DirectoryFieldEditor(QVToProfilerPreferenceConstants.P_PATH, "&Results:", 
				getFieldEditorParent()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
}