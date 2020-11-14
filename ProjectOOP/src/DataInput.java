package inout;

public class DataInput {
	String Name;
	String ID;
	double Open, High, Low, Close;
	int Volume ;
	
	public DataInput(String Name, String ID, 
					double Open, double High, double Low, 
					double Close, int Volume) {
		this.Name = Name;
		this.ID = ID;
		this.Open = Open;
		this.High = High;
		this.Low = Low;
		this.Close = Close;
		this.Volume = Volume;
	}
}
