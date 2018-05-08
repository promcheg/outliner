package promcheg.outliner.model.entities;

import java.util.ArrayList;
import java.util.List;

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

	public List<Chapter> getChapterList() {
		return chapterList;
	}

	public void setChapterList(ArrayList<Chapter> chapterList) {
		this.chapterList = chapterList;
	}

	public List<Asset> getAssetList() {
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
}
