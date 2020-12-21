package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.List;

public class GroupTopVolume extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(List<DataOutput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Về khối lượng khớp lệnh của từng mã trong phiên này, <vol1> vươn lên dẫn đầu với hơn <v1> cổ phiếu, <vol2> tiếp tục giao dịch sôi động với gần <v2> cổ phiếu được khớp lệnh và không còn dư bán, <vol3> cũng có giao dịch là hơn <v3> cổ phiếu. Hai mã cổ phiếu <vol4> và <vol5> theo sau với lần lượt là <v4> và <v5> cổ phiếu được khớp. ");
        addGroupSentences("Tính cho đến thời điểm này, <vol1> vẫn là cổ phiếu thanh khoản nhất thị trường với khối lượng giao dịch lớn và diễn biến rất sôi động, cụ thể là <v1> cổ phiếu được khớp lệnh, tiếp đến là <vol2> với <v2> đơn vị/mã, <vol3> với <v3> đơn vị/mã. Ngay sau đó là <vol4> và <vol5> với lần lượt <v4> và <v5> cổ phiếu được khớp. ");
        addGroupSentences("Phiên này, <vol1>, <vol2> và <vol3> dẫn đầu thị trường về lượng khớp lệnh, trong đó phải kể đến <vol1> với <v1> đơn vị được chuyển nhượng, kế đến là <vol2> với <v2> đơn vị và <vol3> với <v3> đơn vị. Tuy không bằng các mã trên nhưng <vol4> với <v4> đơn vị/mã và <vol5> với <v5> đơn vị/ mã cũng đáng được nói đến. ");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleTopVol()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//top 3 khối lượng giao dịch/khớp lệnh.