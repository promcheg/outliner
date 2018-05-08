package promcheg.outliner.model;

/**
 * 
 * @author waldemar
 *
 */
public enum AssetType {
	PERSON("[PERSON]", "An asset which is used to define a character in the book"),
	ITEM("[ITEM]", "An asset used which is used to define an object, for example car/ship/building etc.");
	
	private final String placeholder;	
	private final String description;
	
	private AssetType(String placeholder, String description) {
		this.placeholder= placeholder;
		this.description = description;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public String getDescription() {
		return description;
	}
}
