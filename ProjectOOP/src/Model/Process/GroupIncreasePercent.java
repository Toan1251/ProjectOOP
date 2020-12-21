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
        addGroupSentences("Được biết, trong tổng số <tong> mã thì dẫn đầu là là cổ phiếu <name1> với mức tăng <percent1>%, tương ứng tăng từ <begin1> đồng lên <end1> đồng, ngay sau đó là <name2> với mức tăng <percent2>% ( <begin2> lên <end2> (đồng) ),xếp thứ 3 là <name3> tăng từ <begin3> đồng lên <end3> đồng, tương ứng <percent3>%. Hai mã xếp cuối là trong top5 là <name4> và <name5>, tăng lần lượt <percent4>% và <percent5>%. ");
        addGroupSentences("Giữ vị trí quán quân về tăng giá trong số <tong> mã là <name1> với mức tăng <percent1>%, tương ứng tăng từ <begin1> lên <end1> đồng. Á quân là <name2> với mức tăng <percent2>% ( <begin2> lên <end2> (đồng) ),xếp thứ 3 là <name3> tăng từ <begin3> đồng lên <end3> đồng, tương ứng <percent3>%. Hai mã xếp cuối là trong top5 là <name4> và <name5>, tăng lần lượt <percent4>% và <percent5>%. ");
        addGroupSentences("Đứng đầu danh sách tăng giá là mã <name1>, tăng từ <begin1> đồng lên <end1> đồng, tương ứng với mức tăng <percent1>%, ngay sau đó là <name2> với mức tăng <percent2>% ( <begin2> lên <rend2> (đồng) ),xếp thứ 3 là <name3> tăng từ <begin3> đồng lên <end3> đồng, tương ứng <percent3>%. Hai mã xếp cuối là trong top5 là <name4> và <name5>, tăng lần lượt <percent4>% và <rpercent5>%. ");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleChangePercent()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//mức tăng cao nhất(về %)