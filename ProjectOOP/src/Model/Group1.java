package Model;


public class Group1 extends Group {
    //override lại hàm để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public void begin() {
        //thêm câu vào list sentences chung chờ xử lí
        addGroupSentences("Tại thời điểm đóng cửa, toàn thị trường có <soLuongTang> mã tăng giá, <soLuongGiam> mã giảm giá và <soLuongKhongDoi> mã đứng giá");
        addGroupSentences("Trong phiên hôm nay,số mã <code1> hiện lên tới <231> mã, bằng <solan> lần số mã tăng điểm với mã<code2>.");

        // hàm dùng để tạo 1 map chứa các giá trị cần thay và tên biến tương ứng.
        this.eachMap = (new Rule1()).PushInMap();

        //hàm xử lí và đưa câu đã lựa chọn vào list chung để phục vụ việc tạo đoạn văn sau này
        addSentences(getOutput());


    }
}