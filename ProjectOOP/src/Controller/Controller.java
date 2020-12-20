package ProjectOOP.src.Controller;

import ProjectOOP.src.Model.Crawler.ExtractData;
import ProjectOOP.src.Model.Handle.DataFileHandle;
import ProjectOOP.src.Model.Handle.DataFileOutput;
import ProjectOOP.src.Model.Parser.DataFileInput;
import ProjectOOP.src.View.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Controller {
    public static ViewBase viewbase;
    public static DataFileOutput HNX;
    public static DataFileOutput HSX;
    private SimpleDateFormat SDF1 = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat SDF2 = new SimpleDateFormat("dd.MM.yyyy");

    private String filePathTemplate = "ProjectOOP/StockDataEOD/yyyyMMdd/CafeF.HNX.dd.MM.yyyy.csv";


    public Controller() {
        viewbase = new ViewBase();
        ExtractData ex = new ExtractData();
        try {
            ex.run();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        DataFileInput hnx = null;
        DataFileInput hsx = null;
        try {
            hnx = new DataFileInput(filePathTemplate.replace("yyyyMMdd", SDF1.format(ex.lastDay.getTime())).replace("dd.MM.yyyy", SDF2.format(ex.lastDay.getTime())));
            hsx = new DataFileInput(filePathTemplate.replace("yyyyMMdd", SDF1.format(ex.lastDay.getTime())).replace("dd.MM.yyyy", SDF2.format(ex.lastDay.getTime())).replace("HNX", "HSX"));
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
