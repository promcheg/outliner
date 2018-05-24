package promcheg.outliner.view;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import promcheg.outliner.contoller.OutlinerContextMenuListener;
import promcheg.outliner.contoller.OutlinerMainController;
import promcheg.outliner.contoller.OutlinerMainMenuListener;
import promcheg.outliner.contoller.OutlinerProjectTreeListener;
import promcheg.outliner.contoller.depricated.AppController;
import promcheg.outliner.model.entities.Project;
import promcheg.outliner.view.defines.OutlinerMenu;

/**
 * 
 * @author waldemar
 *
 */
public class OutlinerMainView {
	
	private Shell shell;
	private OutlinerProjectTreeView treeView;
	private DetailView detailView;
	private AppController contoller;
	private boolean isCtrlPressed = false;
	private boolean isAltPressed = false;
	private boolean isShiftPressed = false;
	private OutlinerContextMenuListener contextMenuListener;
	private OutlinerMainMenuListener mainMenuListener;
	private OutlinerProjectTreeListener projectTreeListener;
	private OutlinerMainController mainController;

	
	public OutlinerMainView(Shell mainShell, AppController controller) {
		super();
		this.shell = mainShell;
		this.contoller = controller;
	}

	/**
	 * 
	 * @param shell
	 */
	public void createView() {		
		createDefaultViewComponents();
	}
	
	private void createDefaultViewComponents() {
		this.createMenu(OutlinerMenu.MAIN, null);
		
		SashForm sashForm = new SashForm(shell, SWT.NONE);
		sashForm.setSashWidth(10);
		
		this.treeView = new OutlinerProjectTreeView();
		this.treeView.setProjectTreeListener(this.mainController.getProjectTreeListener());
		this.treeView.setContextMenuListener(this.mainController.getContextMenuListener());		
		this.treeView.createView(sashForm, this.contoller);
		
		this.detailView = new DetailView();		
		this.detailView.createView(sashForm);
		
		sashForm.setWeights(new int[] {1, 3});
		
		sashForm.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent event) {
				if(event.keyCode == SWT.CTRL) {
					OutlinerMainView.this.isCtrlPressed = false;
				}
				
				if(event.keyCode == SWT.ALT) {
					OutlinerMainView.this.isAltPressed = true;
				}
				
				if(event.keyCode == SWT.SHIFT) {
					OutlinerMainView.this.isShiftPressed = false;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent event) {
				if(event.keyCode != SWT.CTRL && event.keyCode != SWT.ALT && event.keyCode != SWT.SHIFT) {
					String keyString = new String(new byte[]{(byte)event.keyCode});
					System.out.println(OutlinerMainView.this.isShiftPressed ? keyString.toUpperCase() : keyString);
					
					OutlinerMainView.this.contoller.onKeyPressed(OutlinerMainView.this.isShiftPressed,
							OutlinerMainView.this.isCtrlPressed, OutlinerMainView.this.isAltPressed, event.keyCode);
				} else {
					if(event.keyCode == SWT.CTRL) {
						OutlinerMainView.this.isCtrlPressed = true;	
					}
					
					if(event.keyCode == SWT.ALT) {
						OutlinerMainView.this.isAltPressed = true;	
					}
					if(event.keyCode == SWT.SHIFT) {
						OutlinerMainView.this.isShiftPressed = true;
					}
				}
			}
		});
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
			} else {
				menuItem.addListener(SWT.Selection, new Listener() {
					
					@Override
					public void handleEvent(Event event) {
						OutlinerMainView.this.contoller.onAction(entry.getAction());
					}
				});
				
			}
		});
	}

	public void openProject(Project project) {
		this.treeView.setProject(project);
	}

	public void setMainController(OutlinerMainController mainController) {
		this.mainController = mainController;		
	}
}
