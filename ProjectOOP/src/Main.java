package ProjectOOP.src;

import ProjectOOP.src.Model.Crawler.ExtractData;

public class Main {

    public static void main(String[] args) {
        //Cập nhật dữ liệu chứng khoán mới nhất
        ExtractData ed = new ExtractData();
        ed.run();

        //todo: Xây dựng luồng hđ cho dữ liệu
    }
}
