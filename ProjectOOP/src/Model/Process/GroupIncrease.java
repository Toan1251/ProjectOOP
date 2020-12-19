package ProjectOOP.src.Model.Process;
import ProjectOOP.src.Model.Handle.DataInput;
import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.List;

public class GroupIncrease extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(List<DataOutput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Top 5 cổ phiếu tăng giá nhiều nhất gồm <name1>, <name2>, <name3>, <name4> và <name5>.");
        addGroupSentences("Các cổ phiếu tăng giá mạnh nhất là <name1> (tăng <num1> đồng), <name2> (tăng <num2> đồng), <name3> (tăng <num3> đồng), <name4> (tăng <num4> đồng), <name5> (tăng <num5> đồng).");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleChange()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//top 5 tăng giá