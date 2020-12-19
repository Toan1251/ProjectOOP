package ProjectOOP.src.Model.Process;
import ProjectOOP.src.Model.Handle.DataInput;
import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.List;

public class GroupTopAirline extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(List<DataOutput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Ở nhóm hàng không, <nameA1> đang dẫn đầu khi <Alink1> <level1> <numA1> đồng, ngay sau đó là <nameA2> <Alink2> <level2> <numA2> đồng.");
        addGroupSentences("Riêng nhóm hàng không, <nameA1> đang dẫn đầu khi <Alink1> <level1> <numA1> đồng, ngay sau đó là <nameA2> <Alink2> <level2> <numA2> đồng.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleAirline()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//top thay đổi giá ở nhóm Hàng Không.