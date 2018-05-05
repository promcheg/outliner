package promcheg.outliner;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Tree;

import swing2swt.layout.BorderLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class OutlinerMain {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			OutlinerMain window = new OutlinerMain();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1980, 1050);
		shell.setText("SWT Application");
		shell.setLayout(new BorderLayout(0, 0));
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);	
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmOpen = new MenuItem(menu_1, SWT.NONE);
		mntmOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				FileDialog dialog = new FileDialog(shell, SWT.OPEN);
				String fileName = dialog.open();
				System.out.println(fileName);
			}
		});
		mntmOpen.setText("Open");
		
		MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		mntmSave.setText("Save");
		mntmSave.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
			}
		});
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.setText("Exit");
		mntmExit.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				System.exit(0);
			}
			
		});
		
		MenuItem mntmEdit = new MenuItem(menu, SWT.CASCADE);
		mntmEdit.setText("Edit");
		
		Menu menu_2 = new Menu(mntmEdit);
		mntmEdit.setMenu(menu_2);
		
		MenuItem mntmCopy = new MenuItem(menu_2, SWT.NONE);
		mntmCopy.setText("Copy");
		
		MenuItem mntmPaste = new MenuItem(menu_2, SWT.NONE);
		mntmPaste.setText("Paste");
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText("Help");
		
		Menu menu_3 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_3);
		
		MenuItem mntmAbout = new MenuItem(menu_3, SWT.NONE);
		mntmAbout.setText("About");
		
		SashForm sashForm = new SashForm(shell, SWT.NONE);
		sashForm.setSashWidth(10);
		
		ScrolledComposite projectTreeContainer = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		projectTreeContainer.setExpandHorizontal(true);
		projectTreeContainer.setExpandVertical(true);
		
		Tree projectTree = new Tree(projectTreeContainer, SWT.BORDER);
		projectTreeContainer.setContent(projectTree);
		projectTreeContainer.setMinSize(projectTree.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		ScrolledComposite detailContainer = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		detailContainer.setExpandHorizontal(true);
		detailContainer.setExpandVertical(true);
		
		TabFolder detailTabFolder = new TabFolder(detailContainer, SWT.NONE);
		
		TabItem tabItemWelcome = new TabItem(detailTabFolder, SWT.NONE);
		tabItemWelcome.setText("Welcome");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(detailTabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tabItemWelcome.setControl(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		detailContainer.setContent(detailTabFolder);
		detailContainer.setMinSize(detailTabFolder.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		sashForm.setWeights(new int[] {1, 3});

	}
}
