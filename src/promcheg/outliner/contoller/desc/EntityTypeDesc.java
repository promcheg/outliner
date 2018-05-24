package promcheg.outliner.contoller.desc;

/**
 * 
 * @author waldemar
 *
 */
public enum EntityTypeDesc {
	PROJECT("project"),
	CHAPTER("chapter");
	
	final String key;
	
	EntityTypeDesc(String key) {
		this.key = key;
	}
	
	public static EntityTypeDesc getType(String key) {
		for(EntityTypeDesc entry : EntityTypeDesc.values()) {
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
