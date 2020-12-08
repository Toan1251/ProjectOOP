package ProjectOOP.src.Model;

import java.util.Date;
import java.util.Comparator;

public class DataInput{
    /*
    public String Name;
    public Date Date;
    public double Open, High, Low, Close;
    public int Volume ;
    */
    private String Name;
    private Date Date;
    private double Open, High, Low, Close;
    private double Volume;

    public DataInput() {

    }

    public DataInput(String Name, java.util.Date Date ,
                     double Open, double High, double Low,
                     double Close, double Volume) {
        this.Name = Name;
        this.Date = Date;
        this.Open = Open;
        this.High = High;
        this.Low = Low;
        this.Close = Close;
        this.Volume = Volume;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public double getOpen() {
        return Open;
    }

    public void setOpen(double open) {
        Open = open;
    }

    public double getHigh() {
        return High;
    }

    public void setHigh(double high) {
        High = high;
    }

    public double getLow() {
        return Low;
    }

    public void setLow(double low) {
        Low = low;
    }

    public double getClose() {
        return Close;
    }

    public void setClose(double close) {
        Close = close;
    }

    public double getVolume() {
        return Volume;
    }

    public void setVolume(double volume) {
        Volume = volume;
    }

    //Debug
    public void Debug(){
        System.out.println(Name+", "+Date+", "+Open+", "+High+", "+Low+", "+Close+", "+Volume);
    }


}
