package ProjectOOP.src.Model.Handle;

public class Tag {
    private String tagName;
    private String tagType;

    public Tag() {

    }

    public Tag(String tagName) {
        this.tagName = tagName;
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

    //Hàm so sánh hỗ trợ tìm kiếm tag bằng 1 string
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;

        Tag tag = (Tag) o;

        return getTagName() != null ? getTagName().equals(tag.getTagName()) : tag.getTagName() == null;
    }

    @Override
    public int hashCode() {
        return getTagName() != null ? getTagName().hashCode() : 0;
    }


    //Debug
    public void Debug() {
        System.out.println(tagName + " : " + tagType);
    }
}
