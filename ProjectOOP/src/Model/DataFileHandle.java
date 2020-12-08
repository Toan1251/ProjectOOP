package ProjectOOP.src.Model;

import java.util.Iterator;

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
        //Thực hiện các hàm thêm các tag kiểu ranking cho data
    }

    //Tự động thêm câu cho từng Input
    public void autoAddSentences(DataFileOutput dF0){
        //Todo: Thêm các mẫu câu cho tập input
    }
}
