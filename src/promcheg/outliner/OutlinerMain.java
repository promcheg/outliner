package promcheg.outliner;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import promcheg.outliner.view.defines.OutlinerMenu;
import swing2swt.layout.BorderLayout;

public class OutlinerMain {

	protected Shell shell;
	private Text textDescription;
	private Text textContent;

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
		
		this.createMenu(OutlinerMenu.MAIN, null);
		
		
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

		projectTree.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseUp(MouseEvent event) {
				Point point = new Point(event.x, event.y);
				TreeItem treeNode = projectTree.getItem(point);				
				if(treeNode != null && event.button == 3) {
					treeContextMenu.setVisible(true);
				}
			}
		});
		
		OutlinerMenu.TREE_CONTEXT.getChildren().stream().forEach(entry->{
			MenuItem menuItem = new MenuItem(treeContextMenu, SWT.NONE);
			menuItem.setText(entry.getCaption());
			menuItem.setToolTipText(entry.getTooltip());
		});
		
		TreeItem treeItemProject_1 = new TreeItem(projectTree, SWT.NONE);
		treeItemProject_1.setText("Project 1");
		
		
		TreeItem treeItemProject_2 = new TreeItem(projectTree, SWT.NONE);
		treeItemProject_2.setText("Project 2");
		TreeItem treeItemProject_3 = new TreeItem(projectTree, SWT.NONE);
		treeItemProject_3.setText("Project 3");
		TreeItem treeItemProject_4 = new TreeItem(projectTree, SWT.NONE);
		treeItemProject_4.setText("Project 4");
		TreeItem treeItemProject_5 = new TreeItem(projectTree, SWT.NONE);
		treeItemProject_5.setText("Project 5");
		TreeItem treeItemProject_6 = new TreeItem(projectTree, SWT.NONE);
		treeItemProject_6.setText("Project 6");
		
		
		projectTreeContainer.setContent(projectTree);
		projectTreeContainer.setMinSize(projectTree.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		ScrolledComposite detailContainer = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		detailContainer.setExpandHorizontal(true);
		detailContainer.setExpandVertical(true);
		
		TabFolder detailTabFolder = new TabFolder(detailContainer, SWT.NONE);
		
		createWelcomeTabContent(detailTabFolder);
		
		TabItem projectTab = new TabItem(detailTabFolder, SWT.NONE);
		projectTab.setText("Project");
		
		Composite projectComposite = new Composite(detailTabFolder, SWT.NONE);
		projectTab.setControl(projectComposite);
		
		detailContainer.setContent(detailTabFolder);
		detailContainer.setMinSize(detailTabFolder.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		sashForm.setWeights(new int[] {1, 3});
	}

	/**
	 * @param detailTabFolder
	 */
	private void createWelcomeTabContent(TabFolder detailTabFolder) {
		TabItem tabItemWelcome = new TabItem(detailTabFolder, SWT.NONE);
		tabItemWelcome.setText("Welcome");
		
		Composite composite = new Composite(detailTabFolder, SWT.NONE);		
		tabItemWelcome.setControl(composite);
		
		GridLayout gridLayout = new GridLayout(4, false);
	    gridLayout.verticalSpacing = 8;	    
		composite.setLayout(gridLayout);
		
		Label labelDescription = new Label(composite, SWT.NULL);
		labelDescription.setText("Description");
		
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 3;
		
		textDescription = new Text(composite, SWT.SINGLE | SWT.BORDER);
		textDescription.setLayoutData(gridData);
		
		Label labelContent = new Label(composite, SWT.NULL);
		labelContent.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		labelContent.setText("New Label");
		
		textContent = new Text(composite, SWT.WRAP | SWT.MULTI | SWT.BORDER | SWT.H_SCROLL
		        | SWT.V_SCROLL);
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
	    gridData.horizontalSpan = 3;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.grabExcessHorizontalSpace = true;
		textContent.setLayoutData(gridData);
	}

	/**
	 * 
	 * @param menu
	 * @param parent
	 */
	private void createMenu(OutlinerMenu menu, final Menu parent) {
		AtomicReference<Menu> atomicParent = new AtomicReference<Menu>(parent);
		
		Menu mainMenu;
		if(parent == null) {
			mainMenu = new Menu(shell, SWT.BAR);
			shell.setMenuBar(mainMenu);
			atomicParent.set(mainMenu);
		}
		
		menu.getChildren().stream().forEach(entry->{
			MenuItem menuItem = entry.hasChildren() ? new MenuItem(atomicParent.get(), SWT.CASCADE) : new MenuItem(atomicParent.get(), SWT.NONE);
			menuItem.setText(entry.getCaption());
			
			if(entry.hasChildren()) {
				Menu cascade = new Menu(atomicParent.get());
				menuItem.setMenu(cascade);				
				createMenu(entry, cascade);
			}
		});
	}	
}
