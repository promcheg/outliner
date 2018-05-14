package promcheg.outliner.view.defines;

import java.util.ArrayList;
import java.util.Arrays;

import promcheg.outliner.contoller.types.ActionType;

/**
 * 
 * @author waldemar
 *
 */
public enum OutlinerMenu {
	OPEN("Open", "Open a project file", ActionType.OPEN_FILE), 
	SAVE("Save", "Save current project", ActionType.SAVE_FILE),
	
	
	COPY("Copy", "Copy", ActionType.NONE),
	PASTE("Paste", "Paste", ActionType.NONE),
	ABOUT("About", "About", ActionType.NONE),
	ADD_NEW_PROJECT("Add new project", "", ActionType.NONE),
	ADD_NEW_CHAPTER("Add new chapter", "", ActionType.NONE),
	ADD_NEW_BIT("Add new bit", "", ActionType.NONE),
	OPTIONS("Settings", "Application settings", ActionType.NONE),
	EXPORT_TO_PDF("Export to pdf", "", ActionType.NONE),
	EXPORT_TO_HTML("Export to html", "", ActionType.NONE),
	EXPORT("Export", "Export current project", EXPORT_TO_PDF, EXPORT_TO_HTML),
	EXIT("Exit", "Close application", ActionType.EXIT_APPLICATION),
	FILE("File", "", OPEN, SAVE, EXPORT, EXIT),
	EDIT("Edit", "Edit", COPY, PASTE, OPTIONS),
	HELP("Help", "", ABOUT),
	
	MAIN("", "", FILE, EDIT, HELP),
	TREE_CONTEXT("", "", ADD_NEW_PROJECT, ADD_NEW_CHAPTER, ADD_NEW_BIT)
	;
	
	final private ArrayList<OutlinerMenu> children;
	final private String tooltip;
	final private String caption;
	private ActionType actionType;

	/**
	 * 
	 * @param children
	 */
	OutlinerMenu(String caption, String tooltip, ActionType action) {
		this(caption, tooltip);
		this.actionType = action;
	}
	
	OutlinerMenu(String caption, String tooltip) {
		this.caption = caption;
		this.tooltip = tooltip;
		this.actionType = ActionType.NONE;
		this.children = new ArrayList<OutlinerMenu>();
	}
	
	OutlinerMenu(String caption, String tooltip, OutlinerMenu... children) {
		this(caption, tooltip);
		if(children!= null) {
			this.children.addAll(new ArrayList<OutlinerMenu>(Arrays.asList(children)));	
		}
	}
		
	/**
	 * 
	 * @return
	 */
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}

	public ArrayList<OutlinerMenu> getChildren() {
		return children;
	}

	public String getTooltip() {
		return tooltip;
	}

	public String getCaption() {
		return caption;
	}

	public ActionType getAction() {
		return this.actionType;
	}
}
