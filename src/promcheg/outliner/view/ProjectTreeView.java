package promcheg.outliner.view;

import java.util.ArrayList;

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

import promcheg.outliner.contoller.MainController;
import promcheg.outliner.contoller.handler.ProjectTreeController;
import promcheg.outliner.contoller.types.EntityType;
import promcheg.outliner.model.entities.Chapter;
import promcheg.outliner.model.entities.Project;
import promcheg.outliner.view.defines.OutlinerMenu;

/**
 * 
 * @author waldemar
 *
 */
public class ProjectTreeView implements ProjectTreeController {
	private Tree projectTree;
	
	/**
	 * 
	 * @param sashForm
	 */
	public void createView(SashForm sashForm, final MainController controller) {
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
							controller.selectProject((Project) treeNode.getData());	
						} else {
							controller.selectChapter((Chapter) treeNode.getData());
						}
						
					} else if(event.button == 3) {
						treeContextMenu.setVisible(true);	
					}
				}
			}
		});
		
		OutlinerMenu.TREE_CONTEXT.getChildren().stream().forEach(entry->{
			MenuItem menuItem = new MenuItem(treeContextMenu, SWT.NONE);
			menuItem.setText(entry.getCaption());
			menuItem.setToolTipText(entry.getTooltip());
			menuItem.addListener(SWT.Selection, new Listener() {
				
				@Override
				public void handleEvent(Event event) {
				}
			});
		});
	}

	@Override
	public void setData(ArrayList<Project> projectList) {
		
		
		projectList.stream().forEach(project->{
			addProject(project);
		});
	}

	public void addProject(Project project) {
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
