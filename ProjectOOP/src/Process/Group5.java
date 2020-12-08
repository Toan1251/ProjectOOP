package ProjectOOP.src.Process;

import ProjectOOP.src.Model.DataInput;
import java.util.ArrayList;

public class Group5 extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public void begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
       addGroupSentences("Ngược lại,<rname> là mã cổ phiếu có mức giảm mạnh nhất sàn là <rpercent>%, tương ứng giảm từ <rbegin> đồng xuống <rend> đồng.  ");
       addGroupSentences("Trong khi đó dẫn đầu danh sách giảm giá sàn HOSE là <rname> của <corp> với mức giảm <rpercent>%, tương ứng giảm từ <rbegin> đồng/CP xuống còn <rend> đồng/CP.");
       addGroupSentences("Dẫn đầu nhóm giảm giá trong ngày là <rname> với mức giảm <rpercent>%, tương ứng giảm <rbegin> đồng xuống còn <rend> đồng/CP.");

       // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new Rule2()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        addSentences(getOutput());


    }
}

// mức giảm mạnh nhất (%)