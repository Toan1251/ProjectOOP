package inout;

//class used for reading csv file

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvParser {
 private final ArrayList<String[]> lines = new ArrayList<>();

 // a list of objects to contain the initial positions
 private final ArrayList<DataInput> data = new ArrayList<>();

 // reads the csv file
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
             // this adds the currently parsed line to the n-dimensional string array
             lines.add((values));
         }

         inputStream.close();
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     }
 }

 /* distributes tree objects and gatherer objects into
 corresponding arrays of object */
 public void feed() {
     for (String[] line : lines) {
    	 String Name = line[0];
    	 String ID = line[1];
    	 double Open = Double.parseDouble(line[2]);
    	 double High = Double.parseDouble(line[3]);
    	 double Low = Double.parseDouble(line[4]);
    	 double Close = Double.parseDouble(line[5]);
    	 int Volume = Integer.parseInt(line[6]);
         DataInput parsedData = new DataInput(Name, ID, Open, High, Low, Close, Volume);
         data.add(parsedData);
     }
 }

 // returns array of data objects
 public ArrayList<DataInput> getDatas() { return data; }
}
