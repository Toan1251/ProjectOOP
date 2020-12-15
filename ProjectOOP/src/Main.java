package ProjectOOP.src;

import ProjectOOP.src.Model.DataOutput;
import ProjectOOP.src.crawler.ExtractData;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {
        //Cập nhật dữ liệu chứng khoán mới nhất
        ExtractData ed = new ExtractData();
        ed.run();
        //todo: Xây dựng luồng hđ cho dữ liệu
    }
}
