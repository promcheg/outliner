package promcheg.outliner.contoller.types;

/**
 * 
 * @author waldemar
 *
 */
public enum EntityType {
	PROJECT("project"),
	CHAPTER("chapter");
	
	final String key;
	
	EntityType(String key) {
		this.key = key;
	}
	
	public static EntityType getType(String key) {
		for(EntityType entry : EntityType.values()) {
			if(entry.getKey().equalsIgnoreCase(key)) {
				return entry;
			}
		}
		
		return null;
	}

	public String getKey() {
		return key;
	}
}
