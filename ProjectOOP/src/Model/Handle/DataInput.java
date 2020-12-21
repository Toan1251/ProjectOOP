package ProjectOOP.src.Model.Handle;

import java.util.Date;

public class DataInput {
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

    public DataInput(String Name, java.util.Date Date,
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

    public double getChange() {
        return getClose() - getOpen();
    }

    public double getVolumeValue() {
        if (getHigh() == getLow()) {
            return getVolume() * getHigh();
        } else {

            return getVolume() * ((getHigh() + getLow()) / 2);
        }
    }

    public double getChangePercent() {
        double cp = getChange() / getOpen();
        if (cp == Double.POSITIVE_INFINITY || cp == Double.NaN) {
            return 0;
        }
        return cp;
    }

    //Debug
    public void Debug() {
        System.out.println(Name + ", " + Date + ", " + Open + ", " + High + ", " + Low + ", " + Close + ", " + Volume);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataInput)) return false;

        DataInput dataInput = (DataInput) o;

        if (getName() != null ? !getName().equals(dataInput.getName()) : dataInput.getName() != null) return false;
        return getDate() != null ? getDate().equals(dataInput.getDate()) : dataInput.getDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        return result;
    }
}