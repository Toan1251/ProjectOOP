package ProjectOOP.src.Process;

import ProjectOOP.src.Model.DataInput;
import java.util.ArrayList;

public class Group13 extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public void begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Ở nhóm hàng không, <nameA1> đang dẫn đầu khi <Alink1> <level1> <numA1> đồng, ngay sau đó là <nameA2> <Alink2> <level2> <numA2> đồng.");
        addGroupSentences("Riêng nhóm hàng không, <nameA1> đang dẫn đầu khi <Alink1> <level1> <numA1> đồng, ngay sau đó là <nameA2> <Alink2> <level2> <numA2> đồng.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new Rule7()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        addSentences(getOutput());


    }
}

//top thay đổi giá ở nhóm Hàng Không.