package ProjectOOP.src.Model.Handle;

public class DataTagging{
    private DataInput data;
    private TagManager tags;
    /*
    Todo: Thêm các hàm hoặc các lớp cần thiết tự động bổ sung các tag cần thiết cho 1 đơn vị dữ liệu
    */
    public DataTagging() {
        this.data = new DataInput();
        this.tags = new TagManager();
    }

    public DataTagging(DataInput data) {
        this.data = data;
        this.tags = new TagManager();
    }

    public DataTagging(DataInput data, TagManager tags) {
        this.data = data;
        this.tags = tags;
    }

    public DataInput getData() {
        return data;
    }

    public void setData(DataInput data) {
        this.data = data;
    }

    public TagManager getTags() {
        return tags;
    }

    public void setTags(TagManager tags) {
        this.tags = tags;
    }

    //tự động điền các tag kiểu change và name vào bộ quản lý tag
    public void autoAddTag() {
        // thêm change Tag
        String name;
        if(data.getClose() - data.getOpen() > 0) {
            name = "up";
        }
        else if(data.getClose() - data.getOpen() < 0) {
            name = "down";
        }
        else {
            name = "stand";
        }
        Tag tagChange = new Tag(name, "change");
        this.tags.addTag(tagChange);
        // thêm name Tag
        Tag tagName = new Tag(data.getName(),"name");
        this.tags.addTag(tagName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataTagging)) return false;

        DataTagging that = (DataTagging) o;

        return getData() != null ? getData().equals(that.getData()) : that.getData() == null;
    }

    @Override
    public int hashCode() {
        return getData() != null ? getData().hashCode() : 0;
    }

    //Debug
    public void Debug(){
        data.Debug();
        tags.Debug();
    }

}
