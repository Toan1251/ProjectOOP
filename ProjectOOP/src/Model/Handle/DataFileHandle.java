package ProjectOOP.src.Model.Handle;

import ProjectOOP.src.Model.Parser.DataFileInput;
import ProjectOOP.src.Model.Process.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    private static final int TOP_DATA = 5;

    public DataFileHandle() {

    }

    //Hàm xử lý dũ liệu đầu vào sang đầu ra
    public DataFileOutput handleFile(DataFileInput dFI) {
        Iterator<DataInput> itr = dFI.getData().getData().iterator();
        DataFileOutput dFO = new DataFileOutput();
        while (itr.hasNext()) {
            DataInput input = itr.next();
            DataOutput output = new DataOutput(input);
            dFO.addData(output);
        }
        autoAddTag(dFO);
        autoAddSentences(dFO);
        return dFO;
    }

    //Tự động thêm Tag cho từng Input
    public void autoAddTag(DataFileOutput dFO) {
        for (DataOutput output : dFO.getData()) {
            output.autoAddTag();
            addGroupTag(dFO, output);
        }
        //Todo: Thêm các tag kiểu ranking cho data
        addRankingTag(dFO);
        for (DataOutput dO : dFO.getData()) {
            dFO.getTagManager().addTag(dO.getTags().getTagSet());
        }
    }

    public void addRankingTag(DataFileOutput dFO) {
        SortData sorting = new SortData();

//        // sorting.sort trả về 1 linkedList gồm TOP_DATA phần tử
//        for(int i = 1; i <= sorting.MAX_FIELD; i++){
//            String tagName = "";
//            String tagType = "ranking";
//            if(i==sorting.VOLUME){
//                tagName = "Volume";
//            }else if(i==sorting.OPEN){
//                tagName = "Open";
//            }else if(i==sorting.CLOSE){
//                tagName = "Close";
//            }else if(i==sorting.HIGH){
//                tagName = "High";
//            }else if(i==sorting.LOW){
//                tagName = "Low";
//            }else if(i==sorting.CHANGE){
//                tagName = "GroupChangeNumber";
//            }else if(i==sorting.CHANGE_PERCENT){
//                tagName = "";
//            }else if(i==sorting.VOLUME_VALUE){
//                tagName = "Volume Value";
//            }
        List<DataOutput> top5Asc = sorting.sort(dFO.getData(), 6, TOP_DATA, false);
        List<DataOutput> top5Desc = sorting.sort(dFO.getData(), 6, TOP_DATA, true);
        List<DataOutput> topAscPc = sorting.sort(dFO.getData(), 7, 1, false);
        List<DataOutput> topDescPc = sorting.sort(dFO.getData(), 7, 1, true);
        List<DataOutput> topVolume = sorting.sort(dFO.getData(), 1, 3, false);

        //top change
        addTagIn(dFO, top5Desc, top5Asc, "GroupDecrease", "GroupIncrease", "ranking");
        //top changePercent
        addTagIn(dFO, topAscPc, topDescPc, "GroupIncreasePercent", "GroupDecreasePercent", "ranking");

        //top volume
        for (DataOutput output : topVolume) {
            int index = dFO.getData().indexOf(output);
            dFO.getData().get(index).getTags().addTag(new Tag("GroupTopVolume", "ranking"));
        }
    }

    //thêm tag dựa theo tên và kiểu group
    public void addGroupTag(DataFileOutput dFO, DataOutput dO) {
        SortData sorting = new SortData();
        switch (dO.getData().getName()) {
            //ngân hàng
            case "BID":
            case "CTG":
            case "HDB":
            case "MBB":
            case "TCB":
            case "VCB":
            case "VPB":
            case "NVB":
            case "SHB":
            case "ACB":
            case "STB":
            case "LPB":
            case "EIB":
            case "TPB":
            case "VIB": {
                List<DataOutput> demo = new LinkedList<>();

                demo.add(filterByName(dFO.getData(), "BID"));
                demo.add(filterByName(dFO.getData(), "CTG"));
                demo.add(filterByName(dFO.getData(), "HDB"));
                demo.add(filterByName(dFO.getData(), "MBB"));
                demo.add(filterByName(dFO.getData(), "TCB"));
                demo.add(filterByName(dFO.getData(), "VCB"));
                demo.add(filterByName(dFO.getData(), "VPB"));
                demo.add(filterByName(dFO.getData(), "NCB"));
                demo.add(filterByName(dFO.getData(), "SHB"));
                demo.add(filterByName(dFO.getData(), "ACB"));
                demo.add(filterByName(dFO.getData(), "STB"));
                demo.add(filterByName(dFO.getData(), "LPB"));
                demo.add(filterByName(dFO.getData(), "EIB"));
                demo.add(filterByName(dFO.getData(), "TPB"));
                demo.add(filterByName(dFO.getData(), "VIB"));
                sorting.removeNull(demo);


                //sắp xếp theo change
                List<DataOutput> topChange = sorting.sort(demo, 6);
                //sắp xếp theo volume value
                List<DataOutput> topValue = sorting.sort(demo, 8);
                addTagIn(dFO, topChange, topValue, "GroupTopBank", "GroupTopBankVol", "group");

                break;
            }
            //dầu khí
            case "ASP":
            case "PGC":
            case "PJT":
            case "PLX":
            case "PVD":
            case "PVT":
            case "PXS":
            case "APP":
            case "PCT":
            case "PGS":
            case "PLC":
            case "PVB":
            case "PVC":
            case "PVG":
            case "PVS":
            case "CNG":
            case "COM": {
                LinkedList<DataOutput> demo = new LinkedList<>();

                demo.add(filterByName(dFO.getData(), "ASP"));
                demo.add(filterByName(dFO.getData(), "PGC"));
                demo.add(filterByName(dFO.getData(), "PJT"));
                demo.add(filterByName(dFO.getData(), "PLX"));
                demo.add(filterByName(dFO.getData(), "PVD"));
                demo.add(filterByName(dFO.getData(), "PVT"));
                demo.add(filterByName(dFO.getData(), "PXS"));
                demo.add(filterByName(dFO.getData(), "APP"));
                demo.add(filterByName(dFO.getData(), "PCT"));
                demo.add(filterByName(dFO.getData(), "PGS"));
                demo.add(filterByName(dFO.getData(), "PLC"));
                demo.add(filterByName(dFO.getData(), "PVB"));
                demo.add(filterByName(dFO.getData(), "PVC"));
                demo.add(filterByName(dFO.getData(), "PVG"));
                demo.add(filterByName(dFO.getData(), "PVS"));
                demo.add(filterByName(dFO.getData(), "CNG"));
                demo.add(filterByName(dFO.getData(), "COM"));
                sorting.removeNull(demo);


                //sắp xếp theo change
                List<DataOutput> topChange = sorting.sort(demo, 6);
                //sắp xếp theo volume value
                List<DataOutput> topValue = sorting.sort(demo, 8);
                addTagIn(dFO, topChange, topValue, "GroupTopPetrol", "GroupTopPetrolVol", "group");
                break;
            }
            //thủy sản
            case "ANV":
            case "IDI":
            case "VHC":
            case "TS4": {
                LinkedList<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random

                demo.add(filterByName(dFO.getData(), "ANV"));
                demo.add(filterByName(dFO.getData(), "IDI"));
                demo.add(filterByName(dFO.getData(), "VHC"));
                demo.add(filterByName(dFO.getData(), "TS4"));
                sorting.removeNull(demo);


                //sắp xếp theo change
                List<DataOutput> topChange = sorting.sort(demo, 6);
                //sắp xếp theo volume value
                List<DataOutput> topValue = sorting.sort(demo, 8);
                addTagIn(dFO, topChange, topValue, "GroupTopFishery", "GroupTopFisheryVol", "group");
                break;
            }
            //hàng không
            case "HVN":
            case "VJC":
            case "ARM":
            case "CIA":
            case "MAS": {
                LinkedList<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random

                demo.add(filterByName(dFO.getData(), "HVN"));
                demo.add(filterByName(dFO.getData(), "VJC"));
                demo.add(filterByName(dFO.getData(), "ARM"));
                demo.add(filterByName(dFO.getData(), "CIA"));
                demo.add(filterByName(dFO.getData(), "MAS"));
                sorting.removeNull(demo);

                //sắp xếp theo change
                List<DataOutput> topChange = sorting.sort(demo, 6);
                //sắp xếp theo volume value
                List<DataOutput> topValue = sorting.sort(demo, 8);
                addTagIn(dFO, topChange, topValue, "GroupTopAirline", "GroupTopAirlineVol", "group");
                break;
            }
            //cao su
            case "DRC":
            case "DPR":
            case "TNC":
            case "HRC":
            case "TRC":
            case "CSM": {
                LinkedList<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random

                demo.add(filterByName(dFO.getData(), "DRC"));
                demo.add(filterByName(dFO.getData(), "DPR"));
                demo.add(filterByName(dFO.getData(), "TNC"));
                demo.add(filterByName(dFO.getData(), "HRC"));
                demo.add(filterByName(dFO.getData(), "TRC"));
                demo.add(filterByName(dFO.getData(), "CSM"));
                sorting.removeNull(demo);


                //sắp xếp theo change
                List<DataOutput> topChange = sorting.sort(demo, 6);
                //sắp xếp theo volume value
                List<DataOutput> topValue = sorting.sort(demo, 8);
                addTagIn(dFO, topChange, topValue, "GroupTopRubber", "GroupTopRubberVol", "group");
                break;
            }
            //thép
            case "NKG":
            case "TLH":
            case "POM":
            case "MWG":
            case "PET":
            case "BVG":
            case "HPG":
            case "HSG":
            case "SMC": {
                LinkedList<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random

                demo.add(filterByName(dFO.getData(), "NKG"));
                demo.add(filterByName(dFO.getData(), "TLH"));
                demo.add(filterByName(dFO.getData(), "POM"));
                demo.add(filterByName(dFO.getData(), "MWG"));
                demo.add(filterByName(dFO.getData(), "PET"));
                demo.add(filterByName(dFO.getData(), "BVG"));
                demo.add(filterByName(dFO.getData(), "HPG"));
                demo.add(filterByName(dFO.getData(), "HSG"));
                demo.add(filterByName(dFO.getData(), "SMC"));
                sorting.removeNull(demo);


                //sắp xếp theo change
                List<DataOutput> topChange = sorting.sort(demo, 6);
                //sắp xếp theo volume value
                List<DataOutput> topValue = sorting.sort(demo, 8);
                addTagIn(dFO, topChange, topValue, "GroupTopSteel", "GroupTopSteelVol", "group");
                break;
            }
            //nhóm Vin
            case "VIC":
            case "VHM":
            case "VRE": {
                LinkedList<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random

                demo.add(filterByName(dFO.getData(), "VIC"));
                demo.add(filterByName(dFO.getData(), "VHM"));
                demo.add(filterByName(dFO.getData(), "VRE"));
//                demo.add(filterByName(dFO.getData(), "C69"));

                sorting.removeNull(demo);


                //sắp xếp theo change
                List<DataOutput> topChange = sorting.sort(demo, 6);
                for (DataOutput output : topChange) {
                    int index = dFO.getData().indexOf(output);
                    dFO.getData().get(index).getTags().addTag(new Tag("GroupVin", "group"));
                }
                break;
            }


        }
    }

    private DataOutput filterByName(List<DataOutput> data, String name) {
        return data.stream().filter(x -> x.getData().getName().equals(name)).findAny().orElse(null);
    }

    //thêm tag tương ứng vào các đối tượng output thuộc 1 list tương ứng
    private void addTagIn(DataFileOutput dFO, List<DataOutput> s1, List<DataOutput> s2, String name1, String name2, String name) {
        for (DataOutput output : s1) {
            int index = dFO.getData().indexOf(output);
            dFO.getData().get(index).getTags().addTag(new Tag(name1, name));
        }
        for (DataOutput output : s2) {
            int index = dFO.getData().indexOf(output);
            dFO.getData().get(index).getTags().addTag(new Tag(name2, name));
        }
    }

//    private Map<Integer,String> replaceMap(int num,String str){
//        Map<Integer,String> temp=new HashMap<>();
//        temp.put(num,str);
//        return temp;
//    }


    //Tự động thêm câu cho từng Input
    public void autoAddSentences(DataFileOutput dF0) {
        //Todo: Thêm các mẫu câu cho tập input
        for (DataOutput output : dF0.getData()) {
            Set<Tag> obj;
            obj = output.getTags().getTagSet();
            Iterator<Tag> itr = obj.iterator();
            while (itr.hasNext()) {
                Tag value = itr.next();
                processSentences(value, dF0.getData(), output);
            }
        }
    }


    //Dựa theo các tag của đối tượng Output, thêm câu vào
    //***name ở đây là tên của đối tượng cần in ra đoạn văn riêng
    public void processSentences(Tag tag, List<DataOutput> data, DataOutput op) {
        //List<Group> choosenGroupList = new ArrayList<>();
        //for (Tag tag : Tags) {
//        DataOutput temp =new DataOutput();
        if (tag.getTagName().equals("GroupChangeNumber") && tag.getTagType().equals("count")) {
            op.addSentence_count(new GroupChangeNumber().begin(data));
        }
        if (tag.getTagName().equals("GroupDecrease") && tag.getTagType().equals("ranking")) {
//             Map<Integer,String> temp =new HashMap<>();
//             temp.put(1,new GroupDecrease().begin(data));
            op.addSentence_ranking(1, new GroupDecrease().begin(data));
        }
        if (tag.getTagName().equals("GroupDecreasePercent") && tag.getTagType().equals("ranking")) {
//            Map<Integer,String> temp=new HashMap<>();
//            temp.put(2,new GroupDecreasePercent().begin(data));
            op.addSentence_ranking(2, new GroupDecreasePercent().begin(data));
        }
        if (tag.getTagName().equals("GroupIncrease") && tag.getTagType().equals("ranking")) {
//            Map<Integer,String> temp=new HashMap<>();
//            temp.put(3,new GroupIncrease().begin(data));
            op.addSentence_ranking(3, new GroupIncrease().begin(data));
        }
        if (tag.getTagName().equals("GroupIncreasePercent") && tag.getTagType().equals("ranking")) {
//            Map<Integer,String> temp= new HashMap<>();
//            temp.put(4,new GroupIncreasePercent().begin(data));
            op.addSentence_ranking(4, new GroupIncreasePercent().begin(data));
        }
        if (tag.getTagName().equals("GroupTopVolume") && tag.getTagType().equals("ranking")) {
//            Map<Integer,String> temp= new HashMap<>();
//            temp.put(5,new GroupTopVolume().begin(data));
            op.addSentence_ranking(5, new GroupTopVolume().begin(data));
        }
        if (tag.getTagName().equals("GroupTopAirline") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(1, new GroupTopAirline().begin(data));
        }
        if (tag.getTagName().equals("GroupTopAirlineVol") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(2, new GroupTopAirline().begin(data));
        }
        if (tag.getTagName().equals("GroupTopBank") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(1, new GroupTopBank().begin(data));
        }
        if (tag.getTagName().equals("GroupTopBankVol") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(2, new GroupTopBankVol().begin(data));
        }
        if (tag.getTagName().equals("GroupTopFishery") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(1, new GroupTopFishery().begin(data));
        }
        if (tag.getTagName().equals("GroupTopFisheryVol") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(2, new GroupTopFisheryVol().begin(data));
        }
        if (tag.getTagName().equals("GroupTopPetrol") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(1, new GroupTopPetrol().begin(data));
        }
        if (tag.getTagName().equals("GroupTopPetrolVol") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(2, new GroupTopPetrolVol().begin(data));
        }
        if (tag.getTagName().equals("GroupTopRubber") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(1, new GroupTopRubber().begin(data));
        }
        if (tag.getTagName().equals("GroupTopRubberVol") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(2, new GroupTopRubberVol().begin(data));
        }
        if (tag.getTagName().equals("GroupTopSteel") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(1, new GroupTopSteel().begin(data));
        }
        if (tag.getTagName().equals("GroupTopSteelVol") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(2, new GroupTopSteelVol().begin(data));
        }
        if (tag.getTagName().equals("GroupVin") && tag.getTagType().equals("group")) {
            op.addSentence_nganh(1, new GroupVin().begin(data));
        }
        if (tag.getTagType().equals("name")) {

            op.addSentences_name(new GroupPersonal().Process(data, tag.getTagName()));
        }
    }

}



