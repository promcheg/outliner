package promcheg.outliner.model.entities;

import java.util.ArrayList;

/**
 * 
 * @author waldemar
 *
 */
public class Project {
	String name;
	String description;
	ArrayList<Chapter> chapterList;
	ArrayList<Asset> assetList;

	public Project() {
		super();
	}

	public Project(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Chapter> getChapterList() {
		return chapterList;
	}

	public void setChapterList(ArrayList<Chapter> chapterList) {
		this.chapterList = chapterList;
	}

	public ArrayList<Asset> getAssetList() {
		return assetList;
	}

	public void setAssetList(ArrayList<Asset> assetList) {
		this.assetList = assetList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void add(Chapter chapter) {
		chapterList.add(chapter);
	}
	
	public void add(Asset asset) {
		assetList.add(asset);
	}
	
	public boolean hasChapters() {
		return chapterList != null && !chapterList.isEmpty();
	}

	public void addChapter(Chapter chapter) {
		if(this.chapterList == null) {
			this.chapterList = new ArrayList<>();
		}
		
		this.chapterList.add(chapter);
	}
}
