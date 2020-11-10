package Model;

public class Tag {
    private String tagName;
    private String tagType;

    public Tag() {

    }

    public Tag(String tagName, String tagType) {
        this.tagName = tagName;
        this.tagType = tagType;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;

        Tag tag = (Tag) o;

        return getTagName().equals(tag.getTagName());
    }

    @Override
    public int hashCode() {
        return getTagName().hashCode();
    }
}
