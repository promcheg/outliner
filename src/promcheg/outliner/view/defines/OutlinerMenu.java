package promcheg.outliner.view.defines;

import java.util.ArrayList;
import java.util.Arrays;

import promcheg.outliner.contoller.desc.ActionTypeDesc;

/**
 * 
 * @author waldemar
 *
 */
public enum OutlinerMenu {
	OPEN("Open", "Open a project file", ActionTypeDesc.OPEN_FILE), 
	SAVE("Save", "Save current project", ActionTypeDesc.SAVE_FILE),
	
	
	COPY("Copy", "Copy", ActionTypeDesc.NONE),
	PASTE("Paste", "Paste", ActionTypeDesc.NONE),
	ABOUT("About", "About", ActionTypeDesc.NONE),
	ADD_NEW_PROJECT("Add new project", "", ActionTypeDesc.NONE),
	ADD_NEW_CHAPTER("Add new chapter", "", ActionTypeDesc.NONE),
	ADD_NEW_BIT("Add new bit", "", ActionTypeDesc.NONE),
	OPTIONS("Settings", "Application settings", ActionTypeDesc.NONE),
	EXPORT_TO_PDF("Export to pdf", "", ActionTypeDesc.NONE),
	EXPORT_TO_HTML("Export to html", "", ActionTypeDesc.NONE),
	EXPORT("Export", "Export current project", EXPORT_TO_PDF, EXPORT_TO_HTML),
	EXIT("Exit", "Close application", ActionTypeDesc.EXIT_APPLICATION),
	FILE("File", "", OPEN, SAVE, EXPORT, EXIT),
	EDIT("Edit", "Edit", COPY, PASTE, OPTIONS),
	HELP("Help", "", ABOUT),
	
	MAIN("", "", FILE, EDIT, HELP),
	TREE_CONTEXT("", "", ADD_NEW_PROJECT, ADD_NEW_CHAPTER, ADD_NEW_BIT)
	;
	
	final private ArrayList<OutlinerMenu> children;
	final private String tooltip;
	final private String caption;
	private ActionTypeDesc actionType;

	/**
	 * 
	 * @param children
	 */
	OutlinerMenu(String caption, String tooltip, ActionTypeDesc action) {
		this(caption, tooltip);
		this.actionType = action;
	}
	
	OutlinerMenu(String caption, String tooltip) {
		this.caption = caption;
		this.tooltip = tooltip;
		this.actionType = ActionTypeDesc.NONE;
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

	public ActionTypeDesc getAction() {
		return this.actionType;
	}
}
