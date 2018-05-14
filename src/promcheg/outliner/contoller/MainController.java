package promcheg.outliner.contoller;

import promcheg.outliner.model.entities.Chapter;
import promcheg.outliner.model.entities.Project;

/**
 * 
 * @author waldemar
 *
 */
public interface MainController {
	
	void selectProject(Project selectedProject);
	void selectChapter(Chapter chapter);
}
