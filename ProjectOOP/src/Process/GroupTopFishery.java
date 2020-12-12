package ProjectOOP.src.Process;

import ProjectOOP.src.Model.DataInput;

import java.util.ArrayList;

public class GroupTopFishery extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Riêng nhóm thủy sản, <nameF1> đang dẫn đầu khi <Flink1> <level1> <numF1> đồng, ngay sau đó là <nameF2> <Flink2> <level2> <numF2> đồng.");
        addGroupSentences(" Bên cạnh đó, với việc tham gia các hiệp định thương mại thì nhóm ngành xuất khẩu như thủy sản cũng được đánh giá cao, nổi bật trong đó là <nameF1> đang dẫn đầu khi <Flink1> <level1> <numF1> đồng, ngay sau đó là <nameF2> <Flink2> <level2> <numBank2> đồng.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleFischery()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//top 3 thay đổi giá ở nhóm Thủy sản.