package ProjectOOP.src.Model.Parser;

//class used for reading csv file
//Lớp được dùng cho đọc tệp xê ét vê

import ProjectOOP.src.Model.Handle.DataInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CsvParser {
    private final List<String[]> lines;

    // danh sách bao gồm các thuộc tính
    private List<DataInput> data;

    public CsvParser() {
        this.lines = new LinkedList<String[]>();
        this.data = new LinkedList<DataInput>();
    }

    // đọc file csv
    public CsvParser(String Csv) throws Exception {
        this.lines = new LinkedList<String[]>();
        this.data = new LinkedList<DataInput>();
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
        feed();
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

    public List<DataInput> getData() {
        return data;
    }

    public void setData(List<DataInput> data) {
        this.data = data;
    }

    //Debug
    public void Debug() {
        for (DataInput datum : data) {
            datum.Debug();
        }
    }
}