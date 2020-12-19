package ProjectOOP.src;

import ProjectOOP.src.Model.Crawler.ExtractData;
import ProjectOOP.src.Model.Handle.DataFileHandle;
import ProjectOOP.src.Model.Handle.DataFileOutput;
import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.SortData;
import ProjectOOP.src.Model.Parser.DataFileInput;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Cập nhật dữ liệu chứng khoán mới nhất
        ExtractData ed = new ExtractData();
        ed.run();
        DataFileInput dfi = new DataFileInput();
        try {
            dfi = new DataFileInput("ProjectOOP/StockDataEOD/20201218/CafeF.HNX.18.12.2020.csv");
        }catch (Exception e){
            e.printStackTrace();
        }
        DataFileOutput dfo = new DataFileHandle().handleFile(dfi);
        dfo.getData().get(1).Debug();

        //todo: Xây dựng luồng hđ cho dữ liệu
    }
}
