package promcheg.outliner.contoller;

/**
 * 
 * @author waldemar
 *
 */
public enum OutlinerAction {
	FILE("File", ""),
	OPEN_PROJECT("Open project", ""),
	SAVE_PROJECT("Save project", ""),
	SAVE_PROJECT_AS("Save project as..", ""),
	EXPORT_PROJECT("Export project", ""),
	EXIT("Exit", ""),
	EDIT("Edit", ""),
	COPY("Copy", ""),
	PASTE("Paste", ""),
	HELP("Help", ""),
	ABOUT("About", ""),
	ADD_PROJECT("Add project", ""),
	ADD_CHAPTER("Add chapter", ""),
	ADD_BEAT("Add beat", "");
	
	final String caption;
	final String description;
	
	private OutlinerAction(String caption, String description) {
		this.caption = caption;
		this.description = description;
	}

	public String getCaption() {
		return caption;
	}

	public String getDescription() {
		return description;
	}
}
