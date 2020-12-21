package ProjectOOP.src.Controller;

import ProjectOOP.src.Model.Crawler.ExtractData;
import ProjectOOP.src.Model.Handle.DataFileHandle;
import ProjectOOP.src.Model.Handle.DataFileOutput;
import ProjectOOP.src.Model.Parser.DataFileInput;
import ProjectOOP.src.View.SpawmError;
import ProjectOOP.src.View.ViewBase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

public class Controller {
    //    public static ViewBase viewbase;
    public static DataFileOutput HNX;
    public static DataFileOutput HSX;
    public SpawmError error;
    private SimpleDateFormat SDF1 = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat SDF2 = new SimpleDateFormat("dd.MM.yyyy");

    private String filePathTemplate = "ProjectOOP/StockDataEOD/yyyyMMdd/CafeF.HNX.dd.MM.yyyy.csv";


    public Controller() {
        ViewBase.ShowFrame();
        ExtractData ex = new ExtractData();
        try {
            ex.run();
        } catch (UnknownHostException e) {
            error = new SpawmError("Khong co mang", "Error");
        } catch (FileNotFoundException e) {
            error = new SpawmError("Khong tim thay file", "Error");
        } catch (IOException e) {
            error = new SpawmError("Khong dung dinh dang ma co phieu", "Error");
        } catch (Exception e) {
            error = new SpawmError("Xay ra loi", "Error");
        }
        DataFileInput hnx = null;
        DataFileInput hsx = null;
        try {
            hnx = new DataFileInput(filePathTemplate.replace("yyyyMMdd", SDF1.format(ex.lastDay.getTime())).replace("dd.MM.yyyy", SDF2.format(ex.lastDay.getTime())));
            hsx = new DataFileInput(filePathTemplate.replace("yyyyMMdd", SDF1.format(ex.lastDay.getTime())).replace("dd.MM.yyyy", SDF2.format(ex.lastDay.getTime())).replace("HNX", "HSX"));
        } catch (FileNotFoundException e) {
            error = new SpawmError("Khong tim thay file", "Error");
        } catch (Exception e) {
            error = new SpawmError("Xay ra loi", "Error");
        }
        DataFileHandle h = new DataFileHandle();
        HNX = h.handleFile(hnx);
        HSX = h.handleFile(hsx);
    }


    public static void request() {
        System.out.println(ViewBase.userInputString);
        String request = ViewBase.userInputString;
        DataFileOutput dfo;
        if (ViewBase.sanChungKhoanHienTai == 0) {
            dfo = HNX;
        } else {
            dfo = HSX;
        }
        String respond = dfo.respond(request);
        ViewBase.ShowData(respond);
    }

}