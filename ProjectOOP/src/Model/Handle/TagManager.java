package ProjectOOP.src.Model.Handle;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TagManager {

    private Set<Tag> tagSet;


    public TagManager() {
        tagSet = new HashSet<Tag>();
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

    //Thêm 1 tag vào Set
    public void addTag(Tag tag) {
        tagSet.add(tag);
    }

    //Thêm 1 collection Tag vào Set
    public void addTag(Collection<Tag> tags) {
        tagSet.addAll(tags);
    }

    //Xóa 1 tag khỏi Set
    public void removeTag(Tag tag) {
        tagSet.remove(tag);
    }

    //Xóa 1 Collection khỏi Set
    public void removeTag(Collection<Tag> tags) {
        tagSet.removeAll(tags);
    }

    //Tìm 1 Tag dựa vào tên
    public Tag findTag(String tag) {
        if (isHaveThisTag(tag)) {
            Iterator<Tag> itr = this.tagSet.iterator();
            while (itr.hasNext()) {
                Tag nowTag = itr.next();
                if (nowTag.getTagName().equals(tag)) {
                    return nowTag;
                }
            }
        }
        return null;
    }

    //Kiểm tra Tag có tồn tại trong set không
    //ví dụ: truyền vào
    public boolean isHaveThisTag(String tag) {
        for (Tag temp : tagSet) {
            if (temp.getTagName().equals(tag)) {
                return true;
            }
        }
        return false;
    }

    //Debug
    public void Debug() {
        for (Tag tag : this.tagSet) {
            tag.Debug();
            Iterator<Tag> itr = this.tagSet.iterator();
            while (itr.hasNext()) {
                itr.next().Debug();
            }
        }
    }
}