package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataInput;

import java.util.ArrayList;

public class GroupTopPetrolVol extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Nhóm dầu khí đáng chú ý có mã <PVname1> với lượng cố phiếu bán ra chiếm <timeP>% của <totalP> cổ phiếu được bán ra, kế đến là <PVname2> bán được <PVnum2> cổ phiếu và <PVname3> với <PVnum3> cổ phiếu.");
        addGroupSentences("Bên cạnh đó, nhóm cổ phiếu dầu khí với <totalP> cổ phiếu được bán ra, <PVname1> chiếm <timeP>%, tương đương <PVnum1> cổ phiếu, <PVname2> chiếm <timeP2>%, tương đương <PVnum2> cổ phiếu và <PVname3> chiếm <timeP3>%, tương đương <PVnum3> cổ phiếu.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RulePetrol()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//top 3 lượng cổ phiếu bán ra ở nhóm Dầu khí.