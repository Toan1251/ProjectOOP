package Process;

import Model.DataInput;

import java.util.ArrayList;

public class Group2 extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public void begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Top 5 cổ phiếu tăng giá nhiều nhất gồm <name1>, <name2>, <name3>, <name4> và <name5>.");
        addGroupSentences("Các cổ phiếu tăng giá mạnh nhất là <name1> (tăng <num1> đồng), <name2> (tăng <num2> đồng), <name3> (tăng <num3> đồng), <name4> (tăng <num4> đồng), <name5> (tăng <num5> đồng).");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new Rule1()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        addSentences(getOutput());


    }
}

//top 5 tăng giá