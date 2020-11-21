package Process;

import Model.DataInput;

import java.util.ArrayList;

public class Group14 extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public void begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Ở nhóm hàng không, <AVname1> có mức thanh khoản tốt nhất, với <AVnum1> cổ phiếu được bán, sau đó là <AVname2> khi bán được <AVnum2> cổ phiếu.");
        addGroupSentences("Riêng nhóm hàng không, <AVname1> đang dẫn đầu khi bán được <AVnum1> cổ phiếu, ngay sau đó là <AVname2> với <AVnum2> cổ phiếu được bán.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new Rule7()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        addSentences(getOutput());


    }
}

//top lượng cổ phiếu bán ra ở nhóm Hàng Không.