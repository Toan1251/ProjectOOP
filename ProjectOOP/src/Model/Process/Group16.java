package Process;

import Model.DataInput;

import java.util.ArrayList;

public class Group16 extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public void begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Ở nhóm cao su, <CVname1> có mức thanh khoản tốt nhất, với <CVnum1> cổ phiếu được bán trên tổng số <totalC> của cả ngành, chiếm tỷ lệ <timeC1>%, sau đó là <CVname2> khi bán được <timeC2>%, tương ứng với <CVnum2> cổ phiếu.");
        addGroupSentences("Riêng nhóm cao su,với tổng <totalC> cổ phiếu được bán, <CVname1> đang dẫn đầu khi bán được <CVnum1> cổ phiếu, ngay sau đó là <CVname2> với <CVnum2> cổ phiếu được bán.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new Rule8()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        addSentences(getOutput());


    }
}

//top lượng cổ phiếu bán ra ở nhóm cao su.