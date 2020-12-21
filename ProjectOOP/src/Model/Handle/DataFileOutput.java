package ProjectOOP.src.Model.Handle;

import ProjectOOP.src.View.SpawmError;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    public void addData(DataOutput dO) {
        data.add(dO);
    }

    //Nhận 1 request từ Controler và trả về 1 List Output phù hợp
    //ví dụ: nhận vào GroupVin thì nếu có thì trả về 1 list DataOutput có tag GroupVin
    public List<DataOutput> find(String request) {
        if (!getTagManager().isHaveThisTag(request)) {
            return null;
            //respond to View: Không tìm thấy dữ liệu
        }
        List<DataOutput> respond = new LinkedList<>();
        for (DataOutput output : data) {
            if (output.getTags().isHaveThisTag(request)) {
                respond.add(output);
            }
        }
        return respond;
    }

    // trả về đoạn văn phù hợp lên View
    //ví dụ: request là groupVin thì trả về 1 list dataoutput có tagname là groupVin
    //nếu đưa vào là 1 tên thì trả về tất cả các output với tag kiểu name
    public String respond(String request) {
        List<DataOutput> dataOutputs = find(request);
        Tag tag = getTagManager().findTag(request);
        if (tag == null) {
            new SpawmError("Không tìm thấy dữ liệu chứng khoán", "Error");
            return null;
        }
        String respondParagraph = "";
        DataOutput temp = dataOutputs.get(0);
        switch (tag.getTagType()) {
            case "name":
                //check lai
                for (DataOutput op : dataOutputs) {
                    if (op.getData().getName().equals(request)) {
                        List<String> tmp = op.getSentence_name();
                        for (String s : tmp) {
                            respondParagraph += s;
                        }
                    }
                }
                break;
            case "group":
//                DataOutput temp = dataOutputs.get(0);
                if (request.equals("GroupTopAirline")||request.equals("GroupTopAirlineVol")) {
                    respondParagraph = addS(temp.getSentence_nganh());
                }
                if (request.equals("GroupTopBank")||request.equals("GroupTopBankVol")) {
                    respondParagraph = addS(temp.getSentence_nganh());
                }
                if (request.equals("GroupTopFishery")||request.equals("GroupTopFisheryVol")) {
                    respondParagraph = addS(temp.getSentence_nganh());
                }
                if (request.equals("GroupTopPetrol")||request.equals("GroupTopPetrolVol")) {
                    respondParagraph = addS(temp.getSentence_nganh());
                }
                if (request.equals("GroupTopRubber")||request.equals("GroupTopRubberVol")) {
                    respondParagraph = addS(temp.getSentence_nganh());
                }
                if (request.equals("GroupTopSteel")||request.equals("GroupTopSteelVol")) {
                    respondParagraph = addS(temp.getSentence_nganh());
                }
                if (request.equals("GroupVin")) {
                    respondParagraph = temp.getSentence_nganh().get(1);
                }
                break;
            case "ranking":
//                DataOutput temp = dataOutputs.get(0);
                if (request.equals("GroupDecrease")||request.equals("GroupDecreasePercent")) {
                    respondParagraph += temp.getSentence_ranking().get(1);
                    respondParagraph += temp.getSentence_ranking().get(2);
                }
                if (request.equals("GroupIncrease")||request.equals("GroupIncreasePercent")) {
                    respondParagraph += temp.getSentence_ranking().get(3);
                    respondParagraph += temp.getSentence_ranking().get(4);
                }
                if (request.equals("GroupTopVolume")) {
                    respondParagraph = temp.getSentence_ranking().get(5);
                }
                break;
            case "count":
                //do tất cả chỉ có 1 câu thuộc kiểu count
                respondParagraph = temp.getSentence_count().get(0);
                break;
                // thử thêm change
            //case "change":
              //  for(DataOutput output: dataOutputs){
                //    respondParagraph += output.getSentence_name();
                //}
        }
        return respondParagraph;
    }

    private String addS(Map<Integer,String> tmp){
        String result="";
        for(int i=1;i<=tmp.size();i++){
            result+=tmp.get(i);
        }
        return result;
    }


    //Debug
    public void Debug() {
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