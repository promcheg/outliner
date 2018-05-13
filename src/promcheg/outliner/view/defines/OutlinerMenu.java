package promcheg.outliner.view.defines;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author waldemar
 *
 */
public enum OutlinerMenu {
	OPEN("Open", "Open a project file"), 
	SAVE("Save", "Save current project"),
	
	
	COPY("Copy", "Copy"),
	PASTE("Paste", "Paste"),
	ABOUT("About", "About"),
	ADD_NEW_PROJECT("Add new project", ""),
	ADD_NEW_CHAPTER("Add new chapter", ""),
	ADD_NEW_BIT("Add new bit", ""),
	OPTIONS("Settings", "Application settings"),
	EXPORT_TO_PDF("Export to pdf", ""),
	EXPORT_TO_HTML("Export to html", ""),
	EXPORT("Export", "Export current project", EXPORT_TO_PDF, EXPORT_TO_HTML),
	EXIT("Exit", "Close application"),
	FILE("File", "", OPEN, SAVE, EXPORT, EXIT),
	EDIT("Edit", "Edit", COPY, PASTE, OPTIONS),
	HELP("Help", "", ABOUT),
	
	MAIN("", "", FILE, EDIT, HELP),
	TREE_CONTEXT("", "", ADD_NEW_PROJECT, ADD_NEW_CHAPTER, ADD_NEW_BIT)
	;
	
	final private ArrayList<OutlinerMenu> children;
	final private String tooltip;
	final private String caption;

	/**
	 * 
	 * @param children
	 */
	OutlinerMenu(String caption, String tooltip, OutlinerMenu... children) {
		this.caption = caption;
		this.tooltip = tooltip;
		if(children!= null) {
			this.children = new ArrayList<OutlinerMenu>(Arrays.asList(children));	
		} else {
			this.children = new ArrayList<OutlinerMenu>();
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
}
