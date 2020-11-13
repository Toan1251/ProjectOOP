package Model;

import java.util.Set;
import java.util.ArrayList;

public class TagManager {
    
    private Set<Tag> tagSet;
	
	ArrayList<Tag> tagList = new ArrayList<Tag>();
	
	public TagManager() {
		
	}
	public TagManager(Set<Tag> tagSet) {
		this.tagSet= tagSet;
	}
	
	public Set<Tag> getTagSet(){
		return tagSet;
	}
	
	public void setTagSet(Set<Tag> tagSet) {
		this.tagSet = tagSet;
	}
	
//Thêm tag vào tagList 
	public void addTag(Tag Tag) {
	tagList.add((Tag) tagSet);
	}
	
//Xoá tag khỏi tagList 
	public void removeTag(Tag Tag) {
	tagList.remove((Tag) tagSet);
	}
//Tìm Kiếm xem có tag trong tagList không, nếu có trả về true và hiện ra tag 
	public Tag findTag(Tag String) {
	tagList.contains((Tag) tagSet);
	return (Tag) tagSet;
	}
//Ktra xem có tag đó trong tagList hay không 
	public boolean isHaveThisTag(Tag String) {
	return tagList.contains((Tag) tagSet);
	}

}
