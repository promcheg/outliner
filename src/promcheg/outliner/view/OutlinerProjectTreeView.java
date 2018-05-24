package promcheg.outliner.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import promcheg.outliner.contoller.OutlinerContextMenuListener;
import promcheg.outliner.contoller.OutlinerProjectTreeHandler;
import promcheg.outliner.contoller.OutlinerProjectTreeListener;
import promcheg.outliner.contoller.depricated.AppController;
import promcheg.outliner.model.entities.Chapter;
import promcheg.outliner.model.entities.Project;
import promcheg.outliner.view.defines.OutlinerMenu;

/**
 * 
 * @author waldemar
 *
 */
public class OutlinerProjectTreeView {
	private Tree projectTree;
	private OutlinerProjectTreeHandler projectTreeHandler;
	private OutlinerProjectTreeListener projectTreeListener;
	private OutlinerContextMenuListener contextMenuListener;
	
	public OutlinerProjectTreeView() {
		super();
		
		this.projectTreeHandler = new OutlinerProjectTreeHandler() {
			
			@Override
			public void onProjectOpen(Project project) {
				setProject(project);
			}
		};
	}
	
	public OutlinerProjectTreeHandler getProjectTreeHandler() {
		return projectTreeHandler;
	}

	public void setProjectTreeListener(OutlinerProjectTreeListener projectTreeListener) {
		this.projectTreeListener = projectTreeListener;
		this.projectTreeListener.setProjectTreeHandler(this.projectTreeHandler);
	}

	public void setContextMenuListener(OutlinerContextMenuListener contextMenuListener) {
		this.contextMenuListener = contextMenuListener;
	}

	/**
	 * 
	 * @param sashForm
	 */
	public void createView(SashForm sashForm, final AppController controller) {
		ScrolledComposite viewContainer = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		viewContainer.setExpandHorizontal(true);
		viewContainer.setExpandVertical(true);

		this.projectTree = new Tree(viewContainer, SWT.BORDER);
		viewContainer.setContent(projectTree);
		viewContainer.setMinSize(projectTree.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		final Menu treeContextMenu = new Menu(projectTree);
		this.projectTree.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseUp(MouseEvent event) {
				Point point = new Point(event.x, event.y);
				TreeItem treeNode = projectTree.getItem(point);
				
				if(treeNode != null) {
					if(event.button == 1) {
						if(treeNode.getData() instanceof Project) {
							controller.onProjectSelection((Project) treeNode.getData());	
						} else {
							controller.onChapterSelection((Chapter) treeNode.getData());
						}
					}
				}
				
				if(event.button == 3) {
					treeContextMenu.setVisible(true);
				}
			}
		});
		
		OutlinerMenu.TREE_CONTEXT.getChildren().stream().forEach(entry->{
			MenuItem menuItem = new MenuItem(treeContextMenu, SWT.NONE);
			menuItem.setText(entry.getCaption());
			menuItem.setToolTipText(entry.getTooltip());
			menuItem.setData(entry);
			
			menuItem.addListener(SWT.Selection, new Listener() {
				
				@Override
				public void handleEvent(Event event) {
					contextMenuListener.onMenuAction(entry);
				}
			});
		});
	}

	public void setProject(Project project) {
		projectTree.clear(0, true);
		
		final TreeItem projectItem = new TreeItem(projectTree, SWT.NONE);
		projectItem.setText(project.getName());
		projectItem.setData(project);
		
		if(project.hasChapters()) {
			project.getChapterList().stream().forEach(chapter-> {
				TreeItem chapterItem = new TreeItem(projectItem, SWT.NONE);
				chapterItem.setText(chapter.getDescription());
				chapterItem.setData(chapter);
			});
		}
	}
}
