package ProjectOOP.src.Model.Process;
import ProjectOOP.src.Model.Handle.DataInput;
import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.List;

public class GroupTopFisheryVol extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(List<DataOutput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Nhóm dầu khí đáng chú ý có mã <FVname1> với lượng cố phiếu bán ra chiếm <timeF>% của <totalF> cổ phiếu được bán ra, kế đến là <FVname2> bán được <FVnum2> cổ phiếu và <FVname3> với <FVnum3> cổ phiếu.");
        addGroupSentences("Bên cạnh đó, nhóm cổ phiếu dầu khí với <totalF> cổ phiếu được bán ra, <FVname1> chiếm <timeF>%, tương đương <FVnum1> cổ phiếu, <FVname2> chiếm <timeF2>%, tương đương <FVnum2> cổ phiếu và <FVname3> chiếm <timeF3>%, tương đương <FVnum3> cổ phiếu.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleFischery()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//top 3 lượng cổ phiếu bán ra ở nhóm Thủy Sản.