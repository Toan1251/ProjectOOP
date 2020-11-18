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
        if(getTagSet().equals(tag) == true) {
            Tag t = new Tag();
            t.setTagName(tag);
            return t;
        }
        else {
            return null;
        }
    }

    public boolean isHaveThisTag(String tag) {
        return tagSet.equals(tag);
    }
}
