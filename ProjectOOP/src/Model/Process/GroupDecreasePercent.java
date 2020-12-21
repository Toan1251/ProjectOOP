package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.List;

public class GroupDecreasePercent extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(List<DataOutput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Ngược lại,<rname1> là mã cổ phiếu có mức giảm mạnh nhất sàn là <rpercent1>%, tương ứng giảm từ <rbegin1> đồng xuống <rend1> đồng, ngay sau đó là <rname2> với mức giảm <rpercent2>% ( <rbegin2> xuống <rend2> (đồng) ),xếp thứ 3 là <rname3> giảm từ <rbegin3> đồng xuống <rend3> đồng, tương ứng <rpercent3>%. Hai mã xếp cuối là trong top5 là <rname4> và <rname5>, giảm lần lượt <rpercent4>% và <rpercent5>%. ");
        addGroupSentences("Trong khi đó dẫn đầu danh sách giảm giá là <rname1> với mức giảm <rpercent1>%, tương ứng giảm từ <rbegin1> đồng/CP xuống còn <rend1> đồng/CP, ngay sau đó là <rname2> với mức giảm <rpercent2>% ( <rbegin2> xuống <rend2> (đồng/CP) ),xếp thứ 3 là <rname3> giảm từ <rbegin3> đồng xuống <rend3> đồng/CP, tương ứng <rpercent3>%. Hai mã xếp cuối là trong top5 là <rname4> và <rname5>, giảm lần lượt <rpercent4>% và <rpercent5>%. ");
        addGroupSentences("Dẫn đầu nhóm giảm giá trong ngày là <rname1> với mức giảm <rpercent1>%, tương ứng giảm <rbegin1> đồng/CP xuống còn <rend1> đồng/CP, ngay sau đó là <rname2> với mức giảm <rpercent2>% ( <rbegin2> xuống <rend2> (đồng/CP) ),xếp thứ 3 là <rname3> giảm từ <rbegin3> đồng xuống <rend3> đồng/CP, tương ứng <rpercent3>%. Hai mã xếp cuối là trong top5 là <rname4> và <rname5>, giảm lần lượt <rpercent5>% và <rpercent6>%. ");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleChangePercent()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

// mức giảm mạnh nhất (%)