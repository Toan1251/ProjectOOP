package ProjectOOP.src;

import ProjectOOP.src.Model.DataOutput;
import ProjectOOP.src.crawler.ExtractData;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {
        //Cập nhật dữ liệu chứng khoán mới nhất
        try{
            new ExtractData();
        }catch (UnknownHostException e){
            //todo: No internet cconnection
            e.printStackTrace();
        }catch (IOException e){
            //todo: Missing file
            e.printStackTrace();
        }


        //todo: Xây dựng luồng hđ cho dữ liệu
    }
}
