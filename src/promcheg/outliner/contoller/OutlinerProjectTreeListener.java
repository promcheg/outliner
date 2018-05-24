package promcheg.outliner.contoller;

import promcheg.outliner.model.entities.Chapter;
import promcheg.outliner.model.entities.Project;

/**
 * 
 * @author waldemar
 *
 */
public interface OutlinerProjectTreeListener {
	/**
	 * 
	 * @param project
	 */
	void onProjectSelected(Project project);

	/**
	 * 
	 * @param chapter
	 */
	void onChapterSelected(Chapter chapter);
	
	/**
	 * 
	 * @param projectTreeHandler
	 */
	void setProjectTreeHandler(OutlinerProjectTreeHandler projectTreeHandler);
}
