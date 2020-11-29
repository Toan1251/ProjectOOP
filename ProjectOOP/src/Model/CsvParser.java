package Model;

//class used for reading csv file
//Lớp được dùng cho đọc tệp xê ét vê

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CsvParser {
    private List<String[]> lines = new ArrayList<>();

    // danh sách bao gồm các thuộc tính
    private List<DataInput> data = new ArrayList<>();

    public CsvParser() {
        this.lines = new ArrayList<String[]>();
        this.data = new ArrayList<DataInput>();
    }

    // đọc file csv
    public CsvParser(String Csv) {
        this.lines = new ArrayList<String[]>();
        this.data = new ArrayList<DataInput>();
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
        try{
            feed();
        }catch (Exception e){
            System.out.println(e);
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

    public List<DataInput> getData() {
        return data;
    }

    public void setData(List<DataInput> data) {
        this.data = data;
    }

    //Debug
    public void Debug(){
        Iterator<DataInput> itr = data.listIterator();
        while (itr.hasNext()){
            itr.next().Debug();
        }
    }
}