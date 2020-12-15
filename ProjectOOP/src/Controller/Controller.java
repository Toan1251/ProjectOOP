package ProjectOOP.src.Controller;

import ProjectOOP.src.Model.DataFileOutput;
import ProjectOOP.src.View.*;

public class Controller {
    // Khởi chạy Controller
    public void start() {
        ViewBase viewbase = new ViewBase();
        viewbase.showFrame();
    }

    // Gửi Request về DataFileOutPut
    // request là String mà người dùng nhập ở Search
    public String sentRequest(DataFileOutput dfo) {
        String request = ViewBase.userInputString;

        //Còn trường hợp nhấn vào các Button Tag, quy ra thanh String

    }

    // Gửi trả dữ liệu về View
    public String sentData(ViewBase viewbase, DataFileOutput dfo) {
        String outputData = dfo.respond(request);
        return outputData;
    }
    // Hiện kết quả lên Label Result
    public void show(ViewBase viewbase) {
        DataFileOutput dfo = new DataFileOutput();
        viewbase.showData(sentData(viewbase,dfo));


    }




    //Todo: Đợi cho Model và View Hoàn thành khung cơ bản để xác định các lớp hoặc phương thức cần thiết
}
