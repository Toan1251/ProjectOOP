package ProjectOOP.src.Model.Handle;

import ProjectOOP.src.Model.Parser.DataFileInput;

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
    }
}
