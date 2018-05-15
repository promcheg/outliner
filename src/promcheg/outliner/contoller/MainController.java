package promcheg.outliner.contoller;

import promcheg.outliner.contoller.types.ActionType;
import promcheg.outliner.model.entities.Chapter;
import promcheg.outliner.model.entities.Project;

/**
 * 
 * @author waldemar
 *
 */
public interface MainController {
	
	void onProjectSelection(Project selectedProject);
	void onChapterSelection(Chapter chapter);
	void onAction(ActionType actionType);
	void onKeyPressed(boolean shift, boolean ctrl, boolean alt, int key);
}
