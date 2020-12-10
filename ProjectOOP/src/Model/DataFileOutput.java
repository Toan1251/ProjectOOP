package ProjectOOP.src.Model;

import java.util.ArrayList;
import java.util.List;

public class DataFileOutput {
    private List<DataOutput> data;
    private TagManager tagManager;
    // Todo: Thêm các hàm để xử lý chuyển đổi các câu văn thành 1 đoạn văn ngắn
    // Todo: Thêm các hàm phục vụ mục tra cứu, tìm kiểm cho Controller

    public DataFileOutput() {
        data = new ArrayList<DataOutput>();
        tagManager = new TagManager();
    }

    public DataFileOutput(List<DataOutput> data) {
        this.data = data;
        tagManager = new TagManager();
    }

    public DataFileOutput(ArrayList<DataOutput> data, TagManager tagManager) {
        this.data = data;
        this.tagManager = tagManager;
    }

    public List<DataOutput> getData() {
        return data;
    }

    public void setData(List<DataOutput> data) {
        this.data = data;
    }

    public TagManager getTagManager() {
        return tagManager;
    }

    public void setTagManager(TagManager tagManager) {
        this.tagManager = tagManager;
    }

    //Thêm 1 Output vào List
    public void addData(DataOutput dO){
        data.add(dO);
    }

    //Debug
    public void Debug(){
        for (DataOutput datum : data) {
            datum.Debug();
        }
        tagManager.Debug();
    }

}
