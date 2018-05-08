package promcheg.outliner;

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import promcheg.outliner.model.entities.Project;
import swing2swt.layout.BorderLayout;

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
		
		final Tree projectTree = new Tree(projectTreeContainer, SWT.BORDER);
		
		final Menu treeContextMenu = new Menu(projectTree);
		treeContextMenu.addMenuListener(new MenuAdapter() {

			@Override
			public void menuShown(MenuEvent e) {
				TreeItem[] selection = projectTree.getSelection();
				
				Arrays.stream(selection).forEach(entry->{
					System.out.println(entry.getText());
				});
				super.menuShown(e);
			}
			
		});
		
		projectTree.setMenu(treeContextMenu);
		
		MenuItem addNewProject = new MenuItem(treeContextMenu, SWT.NONE);
		addNewProject.setText("Add New Project");
		
		MenuItem addNewChapter = new MenuItem(treeContextMenu, SWT.NONE);
		addNewChapter.setText("Add New Chapter");
		
		ProjectTreeItem<Project> treeItemProject_1 = new ProjectTreeItem<Project>(new Project("Project one", "description one"), projectTree, SWT.NONE);
		treeItemProject_1.setText("Project 1");
		ProjectTreeItem<Project> treeItemProject_2 = new ProjectTreeItem<Project>(new Project("Project two", "description two"), projectTree, SWT.NONE);
		treeItemProject_2.setText("Project 2");
		ProjectTreeItem<Project> treeItemProject_3 = new ProjectTreeItem<Project>(new Project("Project three", "description three"), projectTree, SWT.NONE);
		treeItemProject_3.setText("Project 3");
		ProjectTreeItem<Project> treeItemProject_4 = new ProjectTreeItem<Project>(new Project("Project four", "description four"), projectTree, SWT.NONE);
		treeItemProject_4.setText("Project 4");
		ProjectTreeItem<Project> treeItemProject_5 = new ProjectTreeItem<Project>(new Project("Project five", "description five"), projectTree, SWT.NONE);
		treeItemProject_5.setText("Project 5");
		ProjectTreeItem<Project> treeItemProject_6 = new ProjectTreeItem<Project>(new Project("Project six", "description six"), projectTree, SWT.NONE);
		treeItemProject_6.setText("Project 6");
		
		
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
	
	/**
	 * 
	 * @author waldemar
	 *
	 * @param <T>
	 */
	class ProjectTreeItem<T> extends TreeItem {
		T uObject;
		
		/**
		 * 
		 * @param uObject
		 * @param parent
		 * @param style
		 */
		public ProjectTreeItem(T uObject, Tree parent, int style) {
			this(parent, style);
		}

		/**
		 * 
		 * @param parent
		 * @param style
		 */
		public ProjectTreeItem(Tree parent, int style) {
			super(parent, style);
		}

		public T getuObject() {
			return uObject;
		}

		public void setuObject(T uObject) {
			this.uObject = uObject;
		}
	}
}
