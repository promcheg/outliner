package promcheg.outliner.contoller.depricated;

import promcheg.outliner.contoller.desc.ActionTypeDesc;
import promcheg.outliner.model.entities.Chapter;
import promcheg.outliner.model.entities.Project;

/**
 * 
 * @author waldemar
 *
 */
public interface AppController {
	
	void onProjectSelection(Project selectedProject);
	void onChapterSelection(Chapter chapter);
	void onAction(ActionTypeDesc actionType);
	void onKeyPressed(boolean shift, boolean ctrl, boolean alt, int key);
}
