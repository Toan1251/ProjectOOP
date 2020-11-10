package Model;
import java.util.Set;

public class TagManager {
    private Set<Tag> tagSet;
    /*
    Todo : Bổ sung các hàm thêm, xóa, sửa, tìm 1 tag vào tagset
    */
    public TagManager() {

    }

    public TagManager(Set<Tag> tagSet) {
        this.tagSet = tagSet;
    }

    public Set<Tag> getTagSet() {
        return tagSet;
    }

    public void setTagSet(Set<Tag> tagSet) {
        this.tagSet = tagSet;
    }

}
