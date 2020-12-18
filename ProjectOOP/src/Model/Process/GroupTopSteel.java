package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataInput;

import java.util.ArrayList;

public class GroupTopSteel extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Ở nhóm ngành thép, <nameT1> đang dẫn đầu với việc <Tlink1> <level1> <numT1> đồng, ngay sau đó là <nameT2> khi <Tlink2> <level2> <numT2> đồng.");
        addGroupSentences("Về nhóm thép thì <nameT1> đang dẫn đầu khi <Tlink1> <level1> <numT1> đồng, ngay sau đó là <nameT2> <Tlink2> <level2> <numT2> đồng.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleSteel()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//top thay đổi giá ở nhóm thép.