package org.eclipse.m2m.qvt.oml.profiler.parts;

import javax.annotation.PostConstruct;

import org.eclipse.m2m.qvt.oml.profiler.data.HighlightedText;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class HighlightToolItem
{
    private Text itsText;
    
    @PostConstruct
    public void createControls(Composite aParent, HighlightedText aHighlightedText)
    {
        Composite comp = new Composite(aParent, SWT.NONE);
        GridLayout gl_comp = new GridLayout(1, false);
        gl_comp.horizontalSpacing = 0;
        gl_comp.verticalSpacing = 0;
        gl_comp.marginWidth = 0;
        gl_comp.marginHeight = 0;
        comp.setLayout(gl_comp);

        itsText = new Text(comp, SWT.BORDER | SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
        itsText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        itsText.setMessage("Highlight");
        itsText.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent aE)
            {
                System.out.println("focusGained");
                ((Text)aE.widget).setText("");
            }
        });
        GridDataFactory.fillDefaults().hint(580, SWT.DEFAULT).applyTo(itsText);
        
        IObservableValue target = WidgetProperties.text(SWT.Modify).observe(itsText);
        IObservableValue myModel = BeanProperties.value(HighlightedText.FIELD_SELECTION).observe(aHighlightedText);
        DataBindingContext ctx = new DataBindingContext();
        ctx.bindValue(target, myModel);
    }
}
