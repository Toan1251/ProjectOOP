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

    //tự động điền các tag kiểu change và name vào bộ quản lý tag
    public void autoAddTagChange() {
        // thêm change Tag
        String name;
        if(data.Close - data.Open > 0) {
            name = "up";
        }
        else if(data.Close - data.Open < 0) {
            name = "down";
        }
        else {
            name = "stand";
        }
        Tag tagChange = new Tag(name, "change");
        tags.addTag(tagChange);
        // thêm name Tag
        Tag tagName = new Tag(data.getName(),"name");
        tags.addTag(tagName);
    }


}
