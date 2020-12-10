package ProjectOOP.src;

import ProjectOOP.src.crawler.ExtractData;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {
        ExtractData now;
        try{
            now = new ExtractData();
        }catch (UnknownHostException e){
            e.printStackTrace();
            System.out.println("No internet Connection");
            //todo: View cần hiển thị 1 thông báo không có kết nối Internet
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("No file in the Directory");
            //todo: View hiển thị missing file cho người dùng
        }


        //todo: Xây dựng luồng hđ cho dữ liệu
    }
}
