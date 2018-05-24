package promcheg.outliner.contoller;

import promcheg.outliner.model.entities.Chapter;
import promcheg.outliner.model.entities.Project;
import promcheg.outliner.view.defines.OutlinerMenu;
import promcheg.utils.Utils;

/**
 * 
 * @author waldemar
 *
 */
public class OutlinerMainController {
	private OutlinerMainMenuListener mainMenuListener;
	private OutlinerContextMenuListener contextMenuListener;
	private OutlinerProjectTreeListener projectTreeListener;
	protected OutlinerProjectTreeHandler projectTreeNandler;
	private Project currentProject;

	public OutlinerMainController() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public OutlinerMainMenuListener getMainMenuListener() {
		if(this.mainMenuListener == null) {
			this.mainMenuListener = new OutlinerMainMenuListener() {
				
			};
		}
		return mainMenuListener;
	}

	/**
	 * 
	 * @param mainMenuListener
	 */
	public void setMainMenuListener(OutlinerMainMenuListener mainMenuListener) {
		this.mainMenuListener = mainMenuListener;
	}

	/**
	 * 
	 * @return
	 */
	public OutlinerContextMenuListener getContextMenuListener() {
		if(this.contextMenuListener == null) {
			this.contextMenuListener = new OutlinerContextMenuListener() {

				@Override
				public void onMenuAction(OutlinerMenu menuItem) {
					System.out.println(menuItem);
					switch(menuItem) {
					case ABOUT:
						break;
					case ADD_NEW_BIT:
						break;
					case ADD_NEW_CHAPTER:
						break;
					case ADD_NEW_PROJECT:
						currentProject = new Project();
						break;
					case COPY:
						break;
					case EDIT:
						break;
					case EXIT:
						break;
					case EXPORT:
						break;
					case EXPORT_TO_HTML:
						break;
					case EXPORT_TO_PDF:
						break;
					case FILE:
						break;
					case HELP:
						break;
					case MAIN:
						break;
					case OPEN:
						break;
					case OPTIONS:
						break;
					case PASTE:
						break;
					case SAVE:
						break;
					case TREE_CONTEXT:
						break;
					default:
						break;
					
					}
				}
				
			};
		}
		return contextMenuListener;
	}

	/**
	 * 
	 * @param contextMenuListener
	 */
	public void setContextMenuListener(OutlinerContextMenuListener contextMenuListener) {
		this.contextMenuListener = contextMenuListener;
	}

	/**
	 * 
	 * @return
	 */
	public OutlinerProjectTreeListener getProjectTreeListener() {
		if(this.projectTreeListener == null) {
			this.projectTreeListener = new OutlinerProjectTreeListener() {

				@Override
				public void onProjectSelected(Project project) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onChapterSelected(Chapter chapter) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void setProjectTreeHandler(OutlinerProjectTreeHandler projectTreeHandler) {
					OutlinerMainController.this.projectTreeNandler = projectTreeHandler;
				}
			};
		}
		return projectTreeListener;
	}

	/**
	 * 
	 * @param projectTreeListener
	 */
	public void setProjectTreeListener(OutlinerProjectTreeListener projectTreeListener) {
		this.projectTreeListener = projectTreeListener;
	}

	public void openProject(String filename) {
		Project project = Utils.readEntity(filename, Project.class);
		this.currentProject = project;
	}

	public void closeApplication() {
		System.exit(1);
	}

	public void saveProject(String filename) {
		Utils.writeEntity(filename, this.currentProject, Project.class);
	}
}
