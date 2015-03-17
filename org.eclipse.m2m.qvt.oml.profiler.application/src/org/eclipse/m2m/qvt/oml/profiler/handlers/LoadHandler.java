package org.eclipse.m2m.qvt.oml.profiler.handlers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.m2m.qvt.oml.profiler.data.MeasurementList;
import org.eclipse.m2m.qvt.oml.profiler.model.Measurement;
import org.eclipse.m2m.qvt.oml.profiler.model.MeasurementReader;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class LoadHandler {
	@Execute
	public void execute(MeasurementList aData, Shell aShell) {
		FileDialog dialog = new FileDialog(aShell, SWT.OPEN);
		dialog.setFilterExtensions(new String[] { "*.qvtp", "*.*" });
		String selectedFile = dialog.open();
		if (selectedFile != null) {
			try {
				aData.clear();
				if (selectedFile.toLowerCase().endsWith(".qvtp")) {
					loadQvtpFile(aData, selectedFile);
				} else {
					loadTextFile(aData, selectedFile);
				}
			} catch (Exception e) {
				MessageDialog.openError(aShell, "Failed loading file", e.getMessage());
			}
		}
	}

	private void loadQvtpFile(MeasurementList aData, String selectedFile)
			throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createFileURI(selectedFile);
		Resource resource = resourceSet.getResource(fileURI, true);
		aData.addAll(resource.getContents());
	}

	private void loadTextFile(MeasurementList aData, String selectedFile)
			throws FileNotFoundException, IOException, ParseException {
		MeasurementReader reader = new MeasurementReader(selectedFile);
		try {
			Measurement measurement = null;
			while ((measurement = reader.read()) != null) {
				aData.add(measurement);
			}
		} finally {
			reader.close();
		}
	}
}