package Model;

import java.util.Set;

public class TagManager {

    private Set<Tag> tagSet;


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


    public void addTag(Tag tag) {
        tagSet.add(tag);
    }


    public void removeTag(Tag tag) {
        tagSet.remove(tag);
    }

    public Tag findTag(String tag ) {
        if(isHaveThisTag(tag)){
            for (Tag temp : tagSet) {
                if (temp.getTagName().equals(tag)){
                    return temp;
                }
            }
        }
        return null;
    }

    public boolean isHaveThisTag(String tag) {
        Tag temp = new Tag(tag);
        return tagSet.contains(temp);
    }
}
