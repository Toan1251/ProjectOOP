package inout;

public class DataFileInput {
	public CsvParser data;
	public DataFileInput() {
		
	}
	public DataFileInput(String filename) throws Exception{
		data = new CsvParser(filename);
		data.feed();
	} 
	public void setData(CsvParser data) throws Exception {
		data.feed();
        this.data = data;
    }
}

