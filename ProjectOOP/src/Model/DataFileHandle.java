package Model;

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
        return dFO;
    }

    //Tự động thêm Tag cho từng Input
    public void autoAddTag(DataFileOutput dFO){
        Iterator<DataOutput> itr = dFO.getData().iterator();
        while (itr.hasNext()){
            DataOutput output = itr.next();
            output.autoAddTag();
        }
        // Todo: Thêm các Tag kiểu ranking vào tập input
    }
}
