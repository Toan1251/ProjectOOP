package ProjectOOP.src.Controller;

import ProjectOOP.src.Model.Crawler.ExtractData;
import ProjectOOP.src.Model.Handle.DataFileHandle;
import ProjectOOP.src.Model.Handle.DataFileOutput;
import ProjectOOP.src.Model.Parser.DataFileInput;
import ProjectOOP.src.View.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Controller {
    public static ViewBase viewbase;
    public static DataFileOutput HNX;
    public static DataFileOutput HSX;
    private SimpleDateFormat SDF1 = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat SDF2 = new SimpleDateFormat("dd.MM.yyyy");

    private String filePath = "ProjectOOP/StockDataEOD/20201218/CafeF.HNX.18.12.2020.csv";


    public Controller() {
        viewbase = new ViewBase();
        ExtractData ex = new ExtractData();
        ex.run();
        DataFileInput hnx = null;
        DataFileInput hsx = null;
        try {
            hnx = new DataFileInput("ProjectOOP/StockDataEOD/20201218/CafeF.HNX.18.12.2020.csv");
            hsx = new DataFileInput("ProjectOOP/StockDataEOD/20201218/CafeF.HNX.18.12.2020.csv");
        }catch (Exception e){
            e.printStackTrace();
        }
        DataFileHandle h = new DataFileHandle();
        HNX = h.handleFile(hnx);
        HSX = h.handleFile(hsx);
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
