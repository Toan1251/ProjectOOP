package Model;

public class DataTagging {
    private DataInput data;
    private TagManager tags;
    /*
    Todo: Thêm các hàm hoặc các lớp cần thiết tự động bổ sung các tag cần thiết cho 1 đơn vị dữ liệu
    */
    public DataTagging() {

    }

    public DataTagging(DataInput data) {
        this.data = data;
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
}
