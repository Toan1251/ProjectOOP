package Process;

import Model.DataInput;

import java.util.ArrayList;

public class Group7 extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public void begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Trong số các cổ phiếu ngân hàng, đáng chú ý nhất là <nameBank1> <Blink1> <level1> <numBank1> đồng, <nameBank2> <Blink2> <level2> <numBank1> đồng và <nameBank3> <Blink3> <level3> <numBank3> đồng.");
        addGroupSentences("Về phía các ngân hàng thì <nameBank1> gây chú ý nhất với việc <Blink1> <level1> <numBank1> đồng, kế đến là <nameBank2> <Blink2> <level2> <numBank2> đồng và cuối cùng là <nameBank3> <Blink3> <level3> <numBank3> đồng ");
        addGroupSentences("Với sự thay đổi về chính sách thì cổ phiếu của các ngân hàng có sự thay đổi rõ nét với tâm điểm là 3 ngân hàng: <nameBank1> <Blink1> <level1> <numBank1> đồng, <nameBank2> <Blink2> <level2> <numBank2> đồng và <nameBank3> <Blink3> <level3> <numBank3> đồng.");


        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new Rule4()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        addSentences(getOutput());


    }
}

//top 3 thay đổi giá ở Nhóm Ngân Hàng