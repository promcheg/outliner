package promcheg.outliner.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import promcheg.outliner.contoller.OutlinerAction;
import swing2swt.layout.BorderLayout;

/**
 * 
 * @author waldemar
 *
 */
public class OutlinerMainView {
	
	private Shell mainShell;

	/**
	 * 
	 * @param mainShell
	 */
	public void open(Shell mainShell) {
		this.mainShell = mainShell;
		
		Display display = Display.getDefault();
		createDefaultViewComponents();
		mainShell.open();
		mainShell.layout();
		
		while(!mainShell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private void createDefaultViewComponents() {
		this.mainShell = new Shell();
		this.mainShell.setSize(1980, 1050);
		this.mainShell.setText("Outliner");
		this.mainShell.setLayout(new BorderLayout(0, 0));
		
		this.createMainMenu();
	}
	
	private void createMainMenu() {
		Menu menu = new Menu(mainShell, SWT.BAR);
		mainShell.setMenuBar(menu);	
	}
	
	private void createMenuItem(Menu parent, OutlinerAction action) {
		MenuItem item = new MenuItem(parent, SWT.NONE);
		item.setText(action.getCaption());
		item.setToolTipText(action.getDescription());
	}
	
	public void createPopupMenu() {
		
	}
}
