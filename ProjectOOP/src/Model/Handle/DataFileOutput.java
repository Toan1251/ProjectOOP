package ProjectOOP.src.Model.Handle;

import ProjectOOP.src.Model.Handle.DataInput;
import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.Tag;
import ProjectOOP.src.Model.Handle.TagManager;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class DataFileOutput {
    private List<DataOutput> data;
    private TagManager tagManager;
    // Todo: Thêm các hàm để xử lý chuyển đổi các câu văn thành 1 đoạn văn ngắn
    // Todo: Thêm các hàm phục vụ mục tra cứu, tìm kiểm cho Controller

    public DataFileOutput() {
        data = new LinkedList<DataOutput>();
        tagManager = new TagManager();
    }

    public DataFileOutput(List<DataOutput> data) {
        this.data = data;
        tagManager = new TagManager();
    }

    public DataFileOutput(List<DataOutput> data, TagManager tagManager) {
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
        tagManager.addTag(dO.getTags().getTagSet());
    }

    //Nhận 1 request từ Controler và trả về 1 List Output phù hợp
    public List<DataOutput> find(String request){
        if(!getTagManager().isHaveThisTag(request)){
            return null;
            //respond to View: Không tìm thấy dữ liệu
        }
        List<DataOutput> respond = new LinkedList<DataOutput>();
        for(DataOutput output: data){
            if(output.getTags().isHaveThisTag(request)){
                respond.add(output);
            }
        }
        return respond;
    }
    // trả về đoạn văn phù hợp lên View
    public String respond(String request){
        List<DataOutput> dataOutputs = find(request);
        Tag tag = getTagManager().findTag(request);
        String respondParagrahp="";
        switch (tag.getTagType()) {
            case "name":
                //
                break;
            case "change":
                //
                break;
            case "ranking":
                //
                break;
        }
        return respondParagrahp;
    }


    //Debug
    public void Debug(){
        for (DataOutput datum : data) {
            datum.Debug();
        }
        tagManager.Debug();
    }

    //dựa vào các tag đã chọn, tạo ra các đối tương DataOutput tương ứng
    //và trả về 1 List chứa các DataOutput đã chọn.
    //*** tên các tag dùng làm điều kiện đang là tạm thời
    public List<DataOutput> paragraph(Set<Tag> tags,ArrayList<DataInput>data){
        List<DataOutput> result = new LinkedList<DataOutput>();
        for (Tag tag : tags) {
            DataOutput temp=new DataOutput();
            temp.makeOutput(tag,data);
            result.add(temp);
        }
        return result;  
    }

    //tương tự hàm paragraph riêng cho việc xuất đoạn văn của 1 đối tượng cụ thể
    public List<DataOutput> paragraph(Set<Tag> tags,ArrayList<DataInput>data,String name){
        List<DataOutput> result = new LinkedList<DataOutput>();
        for (Tag tag : tags) {
            DataOutput temp=new DataOutput();
            temp.makeOutputPersonal(tag,data,name);
            result.add(temp);
        }
        return result;
    }





}