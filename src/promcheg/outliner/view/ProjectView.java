package promcheg.outliner.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import promcheg.outliner.model.entities.Project;

public class ProjectView {

	/**
	 * 
	 */
	public ProjectView() {
		super();
	}
	

	public Composite getCompiste(Project project, Composite parent, int style) {
		Composite composite = new Composite(parent, style);
		GridLayout gridLayout = new GridLayout(4, false);
	    gridLayout.verticalSpacing = 8;	    
		composite.setLayout(gridLayout);
		
		Label labelDescription = new Label(composite, SWT.NULL);
		labelDescription.setText("Description");
		
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 3;
		
		Text textName = new Text(composite, SWT.SINGLE | SWT.BORDER);
		textName.setLayoutData(gridData);
		if(project.getName() != null) {
			textName.setText(project.getDescription());
		}
		
		Label labelContent = new Label(composite, SWT.NULL);
		labelContent.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		labelContent.setText("New Label");
		
		Text textContent = new Text(composite, SWT.WRAP | SWT.MULTI | SWT.BORDER | SWT.H_SCROLL
		        | SWT.V_SCROLL);
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
	    gridData.horizontalSpan = 3;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.grabExcessHorizontalSpace = true;
		textContent.setLayoutData(gridData);

		return composite;
	}
}
