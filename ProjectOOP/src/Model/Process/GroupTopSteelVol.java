package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataInput;

import java.util.ArrayList;

public class GroupTopSteelVol extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(ArrayList<DataInput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Ở nhóm thép, <TVname1> có mức thanh khoản tốt nhất, với <TVnum1> cổ phiếu được bán trên tổng số <totalT> của cả ngành, chiếm tỷ lệ <timeT1>%, sau đó là <TVname2> khi bán được <timeT2>%, tương ứng với <TVnum2> cổ phiếu.");
        addGroupSentences("Riêng nhóm cao su,với tổng <totalT> cổ phiếu được bán, <TVname1> đang dẫn đầu khi bán được <TVnum1> cổ phiếu, ngay sau đó là <TVname2> với <TVnum2> cổ phiếu được bán.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleSteel()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//top lượng cổ phiếu bán ra ở nhóm thép.