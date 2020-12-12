package ProjectOOP.src.Process;

import ProjectOOP.src.Model.DataInput;

import java.util.ArrayList;

public class GroupDecrease extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Trong khi đó,top các cổ phiếu giảm giá mạnh nhất sàn phiên này có <rname1> (giảm <rnum1> đồng), <rname2> (giảm <rnum2> đồng), <rname3> (giảm <rnum3> đồng), <rname4> (giảm <rnum4> đồng) và <rname5> (giảm <rnum5> đồng).");
        addGroupSentences("Ở chiều ngược lại, <rname1>, <rname2>, <rname3>, <rname4> và <rname5> giảm nhiều nhất, lần lượt là <rnum1>, <rnum2>, <rnum3>, <rnum4> và <rnum5> đồng.");
        addGroupSentences("Giảm nhiều nhất là các mã: <rname1>, <rname2>, <rname3>, <rname4>, và <rname5> lần lượt rớt: <rnum1>, <rnum2>, <rnum3>, <rnum4> và <rnum5> đồng.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleChange()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

// top 5 giảm giá