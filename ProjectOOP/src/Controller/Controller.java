package ProjectOOP.src.Controller;

import ProjectOOP.src.Model.Handle.DataFileOutput;
import ProjectOOP.src.View.*;

public class Controller {

    // Khởi chạy Controller
    public void start() {
        ViewBase viewbase = new ViewBase();
        //viewbase.showFrame();
    }

    // Gửi Request về DataFileOutPut
    // request là String mà người dùng nhập ở Search, hoặc String ở TagView
    /*
    public String sentRequest(DataFileOutput dfo, int id) {
        String request;
        if (id == 1) {
            request = ViewBase.userInputString;
        } else if (id == 2) {
            request = TagView.tagString;
        }
        return request;
    }

    // Gửi trả dữ liệu về View
    public String sentData(ViewBase viewbase, DataFileOutput dfo) {
        //chua truyen request
        String outputData = dfo.respond(request);
        return outputData;
    }
    */
    // Hiện kết quả lên Label Result
    public void show(ViewBase viewbase) {
        DataFileOutput dfo = new DataFileOutput();
        //viewbase.showData(sentData(viewbase, dfo));

    }

}




    //Todo: Đợi cho Model và View Hoàn thành khung cơ bản để xác định các lớp hoặc phương thức cần thiết
