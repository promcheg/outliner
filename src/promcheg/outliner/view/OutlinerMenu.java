package promcheg.outliner.view;

import java.util.ArrayList;
import java.util.Arrays;

import promcheg.outliner.contoller.OutlinerAction;

/**
 * 
 * @author waldemar
 *
 */
public enum OutlinerMenu {	
	MAIN(null, 	OutlinerAction.FILE, 
				OutlinerAction.EDIT, 
				OutlinerAction.HELP),
	
	
	FILE(MAIN, 	OutlinerAction.OPEN_PROJECT, 
				OutlinerAction.SAVE_PROJECT, 
				OutlinerAction.SAVE_PROJECT_AS, 
				OutlinerAction.EXPORT_PROJECT, 
				OutlinerAction.EXIT),
	TREE_POPUP(null, 
				OutlinerAction.ADD_PROJECT, 
				OutlinerAction.ADD_CHAPTER, 
				OutlinerAction.ADD_BEAT);
	
	final ArrayList<OutlinerAction> actionList;
	
	
	/**
	 * 
	 * @param parent
	 * @param actions
	 */
	OutlinerMenu(OutlinerMenu OutlinerAction... actions){
		this.actionList = new ArrayList<OutlinerAction>();
		this.actionList.addAll(Arrays.asList(actions));
	}

	public ArrayList<OutlinerAction> getActionList() {
		return actionList;
	}
}
