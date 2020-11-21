package Process;

import Model.DataInput;

import java.util.ArrayList;

public class Group9 extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public void begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Bên cạnh đó, chính sách cũng ảnh hưởng đến dầu khí, nổi bật nhất ở <namePetro1> khi <Plink1> <level1> <numPetro1> đồng, kế tiếp phải kể đến <namePetro2> với việc <Plink2> <level2> <numPetro2> đồng và cuối cùng là <namePetro3> khi <Plink3> <level3> <numPetro3> đồng.");
        addGroupSentences("Còn với nhóm dầu khí, <namePetro1> <Plink1> <level1> <numPetro1> đồng, <namePetro2> <Plink2> <level2> <numPetro2> đồng và <namePetro3> <Plink3> <level3> <numPetro3> đồng ");


        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new Rule5()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        addSentences(getOutput());


    }
}

//top 3 thay đổi giá ở nhóm Dầu khí.