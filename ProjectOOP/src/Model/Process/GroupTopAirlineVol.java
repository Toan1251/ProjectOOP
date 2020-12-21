package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.List;

public class GroupTopAirlineVol extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(List<DataOutput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Ở nhóm hàng không, <AVname1> có mức thanh khoản tốt nhất, với <AVnum1> cổ phiếu được bán, đạt giá trị giao dịch lớn nhất, sau đó là <AVname2> khi bán được <AVnum2> cổ phiếu và đạt giá trị giao dịch đứng thứ nhì.");
        addGroupSentences("Riêng nhóm hàng không, <AVname1> đang dẫn đầu về mức thanh khoản khi bán được <AVnum1> cổ phiếu với giá trị giao dịch cao nhất , ngay sau đó là <AVname2> với <AVnum2> cổ phiếu được bán ứng với mức giá trị giao dịch đứng thứ hai.");

        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleAirline()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        return getOutput();


    }
}

//top lượng cổ phiếu bán ra ở nhóm Hàng Không.