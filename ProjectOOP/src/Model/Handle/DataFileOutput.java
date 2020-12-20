package ProjectOOP.src.Model.Handle;

import ProjectOOP.src.Model.Handle.DataInput;
import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.Tag;
import ProjectOOP.src.Model.Handle.TagManager;
import ProjectOOP.src.View.SpawmError;

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
    }

    //Nhận 1 request từ Controler và trả về 1 List Output phù hợp
    //ví dụ: nhận vào GroupVin thì nếu có thì trả về 1 list DataOutput có tag GroupVin
    public List<DataOutput> find(String request){
        if(!getTagManager().isHaveThisTag(request)){
            return null;
            //respond to View: Không tìm thấy dữ liệu
        }
        List<DataOutput> respond = new LinkedList<>();
        for(DataOutput output: data){
            if(output.getTags().isHaveThisTag(request)){
                respond.add(output);
            }
        }
        return respond;
    }
    // trả về đoạn văn phù hợp lên View
    //ví dụ: request là groupVin thì trả về 1 list dataoutput có tagname là groupVin
    //nếu đưa vào là 1 tên thì trả về tất cả các output với tag kiểu name
    public String respond(String request){
        List<DataOutput> dataOutputs = find(request);
        Tag tag = getTagManager().findTag(request);
        if(tag==null){
            new SpawmError("Không tìm thấy dữ liệu chứng khoán", "Error");
            return null;
        }
        String respondParagraph="";
        DataOutput temp=dataOutputs.get(0);
        switch (tag.getTagType()) {
            case "name":
                //check lai
                for(DataOutput op:dataOutputs){
                    if(op.getData().getName().equals(request)){
                        List<String> tmp= op.getSentence_name();
                        for (String s : tmp) {
                            respondParagraph += s;
                        }
                    }
                }
                break;
            case "group":
//                DataOutput temp = dataOutputs.get(0);
                if(request.equals("GroupTopAirline")) {
                    respondParagraph=temp.getSentence_nganh().get(1);
                }
                    if(request.equals("GroupTopAirlineVol")){
                    respondParagraph=temp.getSentence_nganh().get(2);
                }
                if(request.equals("GroupTopBank")) {
                    respondParagraph=temp.getSentence_nganh().get(1);
                }
                if(request.equals("GroupTopBankVol")) {
                    respondParagraph=temp.getSentence_nganh().get(2);
                }
                if(request.equals("GroupTopFishery")) {
                    respondParagraph=temp.getSentence_nganh().get(1);
                }
                if(request.equals("GroupTopFisheryVol")) {
                    respondParagraph=temp.getSentence_nganh().get(2);
                }
                if(request.equals("GroupTopPetrol")) {
                    respondParagraph=temp.getSentence_nganh().get(1);
                }
                if(request.equals("GroupTopPetrolVol")) {
                    respondParagraph=temp.getSentence_nganh().get(2);
                }
                if(request.equals("GroupTopRubber")) {
                    respondParagraph=temp.getSentence_nganh().get(1);
                }
                if(request.equals("GroupTopRubberVol")) {
                    respondParagraph=temp.getSentence_nganh().get(2);
                }
                if(request.equals("GroupTopSteel")) {
                    respondParagraph=temp.getSentence_nganh().get(1);
                }
                if(request.equals("GroupTopSteelVol")) {
                    respondParagraph=temp.getSentence_nganh().get(2);
                }
                if(request.equals("GroupVin")) {
                    respondParagraph=temp.getSentence_nganh().get(1);
                }
                break;
            case "ranking":
//                DataOutput temp = dataOutputs.get(0);
                if(request.equals("GroupDecrease")) {
                    respondParagraph=temp.getSentence_nganh().get(1);
                }
                if(request.equals("GroupDecreasePercent")) {
                    respondParagraph=temp.getSentence_nganh().get(2);
                }
                if(request.equals("GroupIncrease")) {
                    respondParagraph=temp.getSentence_nganh().get(3);
                }
                if(request.equals("GroupIncreasePercent")) {
                    respondParagraph=temp.getSentence_nganh().get(4);
                }
                if(request.equals("GroupTopVolume")){
                    respondParagraph=temp.getSentence_nganh().get(5);
                }
                break;
            case "count":
                //do tất cả chỉ có 1 câu thuộc kiểu count
                respondParagraph=temp.getSentence_count().get(0);
                break;
        }
        return respondParagraph;
    }


    //Debug
    public void Debug(){
        for (DataOutput datum : data) {
            datum.Debug();
        }
        tagManager.Debug();
    }

//    //dựa vào các tag đã chọn, tạo ra các đối tương DataOutput tương ứng
//    //và trả về 1 List chứa các DataOutput đã chọn.
//    //*** tên các tag dùng làm điều kiện đang là tạm thời
//    public List<DataOutput> paragraph(Tag tag,ArrayList<DataInput>data){
//
//        List<DataOutput> result = new LinkedList<DataOutput>();
//
//            DataOutput temp=new DataOutput();
//            temp.makeOutput(tag,data);
//            result.add(temp);
//
//        return result;
//    }
//
//    //tương tự hàm paragraph riêng cho việc xuất đoạn văn của 1 đối tượng cụ thể
//    public List<DataOutput> paragraph(Set<Tag> tags,ArrayList<DataInput>data,String name){
//        List<DataOutput> result = new LinkedList<DataOutput>();
//        for (Tag tag : tags) {
//            DataOutput temp=new DataOutput();
//            temp.makeOutputPersonal(tag,data,name);
//            result.add(temp);
//        }
//        return result;
//    }





}