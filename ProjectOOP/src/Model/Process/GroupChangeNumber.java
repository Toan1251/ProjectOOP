package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.List;


public class GroupChangeNumber extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String begin(List<DataOutput> data) {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Tại thời điểm đóng cửa, toàn thị trường có <soLuongTang> mã tăng giá, <soLuongGiam> mã giảm giá và <soLuongKhongDoi> mã đứng giá,trong đó có <tangtran> mã tăng trần và <giamsan> mã giảm sàn. ");
        addGroupSentences("Trong phiên hôm nay,số mã <code1> hiện lên tới <soLuong1> mã, bằng <solan> lần số mã <code2> với <soLuong2> mã.");
        addGroupSentences("Theo thống kê, kết thúc phiên đã có <giam> trên tổng số <tong> mã giảm với <giamSan> mã giảm sàn, <tang> mã tăng giá trong đó có <tangTran> mã tăng trần, <dung> mã đứng giá.");


        // phương thức dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new RuleChange()).PushInMap(data);

        //phương thức xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
//        addSentences(getOutput());
        return getOutput();


    }
}

//tổng quan về số mã tăng, giảm, đứng giá