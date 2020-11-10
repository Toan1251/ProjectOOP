package Model;

import java.util.ArrayList;

public class DataFileOutput {
    private ArrayList<DataOutput> data;
    private TagManager tagManager;
    // Todo: Thêm các hàm để xử lý chuyển đổi các câu văn thành 1 đoạn văn ngắn
    // Todo: Thêm các hàm phục vụ mục tra cứu, tìm kiểm cho Controller

    public DataFileOutput() {

    }

    public DataFileOutput(ArrayList<DataOutput> data) {
        this.data = data;
    }

    public DataFileOutput(ArrayList<DataOutput> data, TagManager tagManager) {
        this.data = data;
        this.tagManager = tagManager;
    }

    public ArrayList<DataOutput> getData() {
        return data;
    }

    public void setData(ArrayList<DataOutput> data) {
        this.data = data;
    }

    public TagManager getTagManager() {
        return tagManager;
    }

    public void setTagManager(TagManager tagManager) {
        this.tagManager = tagManager;
    }
}
