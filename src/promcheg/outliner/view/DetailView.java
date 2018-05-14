package promcheg.outliner.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.TabFolder;

/**
 * 
 * @author waldemar
 *
 */
public class DetailView {
	
	private TabFolder detailTabFolder;

	public void createView(SashForm sashForm) {
		ScrolledComposite viewContainer = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		viewContainer.setExpandHorizontal(true);
		viewContainer.setExpandVertical(true);

		this.detailTabFolder = new TabFolder(viewContainer, SWT.NONE);
		viewContainer.setContent(detailTabFolder);
		viewContainer.setMinSize(detailTabFolder.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
}
