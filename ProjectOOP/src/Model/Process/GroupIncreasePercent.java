package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.List;

public class GroupIncreasePercent extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(List<DataOutput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Được biết, trong tổng số <tong> mã thì dẫn đầu là là cổ phiếu <name> với mức tăng <percent>%, tương ứng tăng từ <begin> đồng lên <end> đồng. .");
        addGroupSentences("Giữ vị trí quán quân về tăng giá tại HoSE là <name> với mức tăng <percent>%, tương ứng tăng từ <begin> lên <end> đồng.");
        addGroupSentences("Đứng đầu danh sách tăng giá là mã <name>, tăng từ <begin> đồng lên <end> đồng, tương ứng với mức tăng <percent>%.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleChangePercent()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//mức tăng cao nhất(về %)