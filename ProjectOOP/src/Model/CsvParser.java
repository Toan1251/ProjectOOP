package inout;

//class used for reading csv file
//Lớp được dùng cho đọc tệp xê ét vê

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CsvParser {
 public final ArrayList<String[]> lines = new ArrayList<>();

 // danh sách bao gồm các thuộc tính
 public final ArrayList<DataInput> data = new ArrayList<>();

 // đọc file csv
 public CsvParser(String Csv) {
     final String fileName;
     final File file;
     Scanner inputStream;
     fileName = Csv;
     file = new File(fileName);
     try {
         inputStream = new Scanner(file);

         while (inputStream.hasNext()) {
             String line = inputStream.next();
             String[] values = line.split(",");
             // thêm 1 dòng vào 1 phần tử của mảng String n chiều (n là số cột của file csv)
             lines.add((values));
         }

         inputStream.close();
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     }
 }

 // đưa Strings vào thuộc tính tương ứng 
 public void feed() throws Exception {
     for (int i = 1; i < lines.size(); i++) {
    	 String Name = lines.get(i)[0];
    	 String strDate = lines.get(i)[1];
    	 Date date = new SimpleDateFormat("yyyyMMdd").parse(strDate);
    	 double Open = Double.parseDouble(lines.get(i)[2]);
    	 double High = Double.parseDouble(lines.get(i)[3]);
    	 double Low = Double.parseDouble(lines.get(i)[4]);
    	 double Close = Double.parseDouble(lines.get(i)[5]);
    	 double Volume = Double.parseDouble(lines.get(i)[6]);
         DataInput parsedData = new DataInput(Name, date, Open, High, Low, Close, Volume);
         data.add(parsedData);
     }
 }

 // returns array of data objects
 public ArrayList<DataInput> getDatas() { return data; }
}
