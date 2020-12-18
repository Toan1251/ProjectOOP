package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataInput;

import java.util.ArrayList;

public class GroupVin extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Đáng lưu ý, hai mã cổ phiếu có giá trị vốn hóa dẫn đầu thị trường chứng khoán Việt Nam là VIC của Tập đoàn Vingroup và VHM của Vinhomes <statement>. Cụ thể, mã <nameV1> <Vlink1> <level1> <numV1> đồng, từ <openV1> đồng <upV1> <closeV1> đồng; Mã <nameV2> <Vlink2> <level2> từ <openV2> đồng <upV2> <closeV2> đồng. Ngoài ra, mã cùng họ nhà Vin khác là VRE cũng <Vlink3> <level3> từ <openV3> đồng <upV3> <closeV3> đồng. ");
        addGroupSentences("Cùng họ Vingroup thì <nameV1> <Vlink1> <level1> <numV> đồng, từ <openV1> đồng <upV1> <closeV1> đồng;<nameV2> <Vlink2> <level2> <numV2> đồng, từ <openV2> đồng <upV2> <closeV2> đồng và Mã <nameV2> <Vlink2> <level2> từ <openV2> đồng <upV2> <closeV2> đồng. ");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleVin()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//nhóm họ Vingroup.