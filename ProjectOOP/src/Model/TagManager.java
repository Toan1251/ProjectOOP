package Model;

import java.util.Set;

public class TagManager {

    private Set<Tag> tagSet; // Danh sách hỗ trợ quản lý Tag(Đảm bảo không có tag nào trùng nhau trong Set)


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

    // Thêm 1 Tag vào danh sách các Tag
    public void addTag(Tag tag) {
        tagSet.add(tag);
    }

    // Xóa 1 Tag khỏi danh sách các Tag
    public void removeTag(Tag tag) {
        tagSet.remove(tag);
    }
    
    // Tìm kiếm Tag cần thiết trong danh sách Tag
    public Tag findTag(String tag ) {
        if(isHaveThisTag(tag)){
            for (Tag temp : tagSet) {
                if (temp.getTagName().equals(tag)){
                    return temp;
                }
            }
        }
        // Nếu không có Tag cần thiết trả về null
        return null;
    }

    // Nếu Tag cần thiết có trong danh sách Tag trả về True
    public boolean isHaveThisTag(String tag) {
        Tag temp = new Tag(tag);
        return tagSet.contains(temp);
    }
}
