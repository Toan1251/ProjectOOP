package inout;
import java.util.Date;

public class DataInput {
	public String Name;
	public Date Date;
	public double Open, High, Low, Close;
	public double Volume ;
	
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
}
