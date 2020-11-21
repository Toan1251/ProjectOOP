package Process;

import Model.DataInput;

import java.util.ArrayList;

public class Group6 extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public void begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Về khối lượng khớp lệnh của từng mã trong phiên này, <vol1> vươn lên dẫn đầu với hơn <v1> cổ phiếu, <vol2> tiếp tục giao dịch sôi động với gần <v2> cổ phiếu được khớp lệnh và không còn dư bán, <vol3> cũng có giao dịch cao là hơn <v3> cổ phiếu.");
        addGroupSentences("Tính cho đến thời điểm này, <vol1> vẫn là cổ phiếu thanh khoản nhất thị trường với khối lượng giao dịch lớn và diễn biến rất sôi động, cụ thể là <v1> cổ phiếu được khớp lệnh, tiếp đến là <vol2> với <v2> đơn vị/mã và ngay sau đó là <vol3> với <v3> cổ phiếu được khớp.");
        addGroupSentences("Phiên này, <vol1>, <vol2> và <vol3> dẫn đầu thị trường về lượng khớp lệnh, trong đó phải kể đến <vol1> với <v1> đơn vị được chuyển nhượng. ");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new Rule3()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        addSentences(getOutput());


    }
}

//top 3 khối lượng giao dịch/khớp lệnh.