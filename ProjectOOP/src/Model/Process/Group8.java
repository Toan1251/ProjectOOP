package Process;

import Model.DataInput;

import java.util.ArrayList;

public class Group8 extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public void begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
       addGroupSentences("Trong số <totalB> cổ phiếu được bán ra, thì nổi bật nhất chính là <BVname1> với <BVnum1> cổ phiếu, kế tiếp phải kể đến <BVname2> khi đã bán được <BVnum2> cổ phiếu và theo sát ngay sau đó là <BVname3> với <BVnum3> cổ phiếu đã được bán.");
       addGroupSentences("Tại nhóm cổ phiếu ngân hàng, <BVname1> đã bán được <BVnum1> cổ phiếu trên tổng số <totalB> cổ phiếu được thống kê, theo sau là <BVname2> với <BVnum2> cổ phiếu và <BVname3> với <BVnum3> cổ phiếu.");


        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new Rule4()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        addSentences(getOutput());


    }
}

//top 3 số lượng cổ phiếu bán ra được trong nhóm Ngân Hàng