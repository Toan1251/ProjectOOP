package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.List;

public class GroupVin extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(List<DataOutput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Đáng lưu ý, hai mã cổ phiếu có giá trị vốn hóa dẫn đầu thị trường chứng khoán Việt Nam là VIC của Tập đoàn Vingroup và VHM của Vinhomes <statement>. Cụ thể, mã <nameV1> <Vlink1> <levelV1> <numV1> <openV1>  <upV1> <closeV1> ; Mã <nameV2> <Vlink2> <levelV2> <openV2>  <upV2> <closeV2> . Ngoài ra, mã cùng họ nhà Vin khác là VRE cũng <Vlink3> <levelV3> <openV3>  <upV3> <closeV3> . ");
        addGroupSentences("Cùng họ Vingroup thì <name1> đang dẫn đầu khi <link1> <level1> <num1> , từ <open1>  <up1> <close1> ;<name2> <link2> <level2> <num2> , từ <open2>  <up2> <close2>  và Mã <name3> <link3> <level3> <open3>  <up3> <close3> . ");
        addGroupSentences("top 3 cổ phiếu dẫn đầu trong cùng họ Vingroup là <name1> khi <link1> <level1> <num1> , <name2> <link2> <level2> <num2>  và <name3> <link3> <level3> <num3>  ");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleVin()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//nhóm họ Vingroup.