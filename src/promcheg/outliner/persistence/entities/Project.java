package promcheg.outliner.persistence.entities;

import java.util.List;

/**
 * 
 * @author waldemar
 *
 */
public class Project {
	String name;
	String description;
	List<Chapter> chapterList;
	List<Asset> assetList;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Chapter> getChapterList() {
		return chapterList;
	}

	public void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}

	public List<Asset> getAssetList() {
		return assetList;
	}

	public void setAssetList(List<Asset> assetList) {
		this.assetList = assetList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
