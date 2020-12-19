package ProjectOOP.src.Model.Handle;

import ProjectOOP.src.Model.Parser.DataFileInput;
import jdk.jfr.Unsigned;
import ProjectOOP.src.Model.Process.*;
import java.util.*;
public class DataFileHandle {
    /*
    Todo: Thêm các hàm hoặc các lớp phù hợp để bổ sung 1 số tag đặc biệt vào trong bộ dữ liệu
    Todo: Xây dựng các Comparator Hỗ trợ sorting để so sánh dữ liệu
    vd: Top10 Mua vào, Top10 bán ra, Top10 giá trị, Top10 tăng điểm,...
    Todo: Thêm các hàm hoặc các lớp phù hợp để bổ sung cho các mẫu câu trong bộ dữ liệu
    vd: kết thúc phiên giao dịch hôm nay, cổ phiếu DWG tăng 31 điểm, trở thành cổ phiếu có điểm tăng mạnh nhất,
    ...
    Todo: Thêm hàm để xử lý DataFileInput -> DataFileOutput
    */
    private static final int TOP_DATA = 10;

    public DataFileHandle() {

    }
    //Hàm xử lý dũ liệu đầu vào sang đầu ra
    public DataFileOutput handleFile(DataFileInput dFI){
        Iterator<DataInput> itr = dFI.getData().getData().iterator();
        DataFileOutput dFO = new DataFileOutput();
        while (itr.hasNext()){
            DataInput input = itr.next();
            DataOutput output = new DataOutput(input);
            dFO.addData(output);
        }
        autoAddTag(dFO);
        autoAddSentences(dFO);
        return dFO;
    }

    //Tự động thêm Tag cho từng Input
    public void autoAddTag(DataFileOutput dFO){
        for (DataOutput output : dFO.getData()) {
            output.autoAddTag();
        }
        //Todo: Thêm các tag kiểu ranking cho data
        addRankingTag(dFO);
    }

    public void addRankingTag(DataFileOutput dFO){
        SortData sorting = new SortData();

        // sorting.sort trả về 1 linkedList gồm TOP_DATA phần tử
        for(int i = 1; i <= sorting.MAX_FIELD; i++){
            String tagName = "Top 10 ";
            String tagType = "ranking";
            if(i==sorting.VOLUME){
                tagName += "Volume";
            }else if(i==sorting.OPEN){
                tagName += "Open";
            }else if(i==sorting.CLOSE){
                tagName += "Close";
            }else if(i==sorting.HIGH){
                tagName += "High";
            }else if(i==sorting.LOW){
                tagName += "Low";
            }else if(i==sorting.CHANGE){
                tagName += "Change";
            }else if(i==sorting.CHANGE_PERCENT){
                tagName += "Up Speed";
            }else if(i==sorting.VOLUME_VALUE){
                tagName += "Volume Value";
            }
            List<DataOutput> top10Desc = sorting.sort(dFO.getData(), i, TOP_DATA, false);
            List<DataOutput> top10Asc = sorting.sort(dFO.getData(), i, TOP_DATA, true);
            for(DataOutput output: top10Desc){
                int index = dFO.getData().indexOf(output);
                dFO.getData().get(index).getTags().addTag(new Tag(tagName+" Desc", tagType));
            }
            for(DataOutput output: top10Asc){
                int index = dFO.getData().indexOf(output);
                dFO.getData().get(index).getTags().addTag(new Tag(tagName+" Asc", tagType));
            }
        }
        //Sapxep Dataoutput theo Volume giam dan va add 10phan tu dau vao top10Valume

    }
    //Tự động thêm câu cho từng Input
    public void autoAddSentences(DataFileOutput dF0){
        //Todo: Thêm các mẫu câu cho tập input
        for (DataOutput output : dF0.getData()) {
            Set<Tag> obj;
            obj=output.getTags().getTagSet();
            Iterator<Tag> itr = obj.iterator();
            while (itr.hasNext()){
                Tag value= itr.next();
                processSentences(value, dF0.getData(), output);
            }
        }
    }



    //Dựa theo các tag của đối tượng Output, thêm câu vào
    //***name ở đây là tên của đối tượng cần in ra đoạn văn riêng
    public void processSentences(Tag tag,List<DataOutput> data,DataOutput op) {
        //List<Group> choosenGroupList = new ArrayList<>();
        //for (Tag tag : Tags) {
//        DataOutput temp =new DataOutput();
        if (tag.getTagName().equals("GroupChangeNumber") && tag.getTagType().equals("ranking")) {
            op.addSentence_ranking(new GroupChangeNumber().begin(data));
        }
        if (tag.getTagName().equals("GroupDecrease") && tag.getTagType().equals("ranking")) {
            op.addSentence_ranking(new GroupDecrease().begin(data));
        }
        if (tag.getTagName().equals("GroupDecreasePercent") && tag.getTagType().equals("ranking")) {
            op.addSentence_ranking(new GroupDecreasePercent().begin(data));
        }
        if (tag.getTagName().equals("GroupIncrease") && tag.getTagType().equals("ranking")) {
            op.addSentence_ranking(new GroupIncrease().begin(data));
        }
        if (tag.getTagName().equals("GroupIncreasePercent") && tag.getTagType().equals("ranking")) {
            op.addSentence_ranking(new GroupIncreasePercent().begin(data));
        }
        if (tag.getTagName().equals("GroupTopAirline") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopAirline().begin(data));
        }
        if (tag.getTagName().equals("GroupTopAirlineVol") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopAirlineVol().begin(data));
        }
        if (tag.getTagName().equals("GroupTopBank") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopBank().begin(data));
        }
        if (tag.getTagName().equals("GroupTopBankVol") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopBankVol().begin(data));
        }
        if (tag.getTagName().equals("GroupTopFishery") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopFishery().begin(data));
        }
        if (tag.getTagName().equals("GroupTopFisheryVol") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopFisheryVol().begin(data));
        }
        if (tag.getTagName().equals("GroupTopPetrol") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopPetrol().begin(data));
        }
        if (tag.getTagName().equals("GroupTopPetrolVol") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopPetrolVol().begin(data));
        }
        if (tag.getTagName().equals("GroupTopRubber") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopRubber().begin(data));
        }
        if (tag.getTagName().equals("GroupTopRubberVol") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopRubberVol().begin(data));
        }
        if (tag.getTagName().equals("GroupTopSteel") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopSteel().begin(data));
        }
        if (tag.getTagName().equals("GroupTopSteelVol") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopSteelVol().begin(data));
        }
        if (tag.getTagName().equals("GroupTopVolume") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupTopVolume().begin(data));
        }
        if (tag.getTagName().equals("GroupVin") && tag.getTagType().equals("nhom nganh")) {
            op.addSentence_nganh(new GroupVin().begin(data));
        }
        if (tag.getTagType().equals("name")) {

            op.addSentences_name(new GroupPersonal().Process(data, tag.getTagName()));
        }
    }

}



