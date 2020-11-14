package inout;

public class DataFileInput {
	public DataFileInput(String filename){
		CsvParser lines = new CsvParser(filename);
		lines.feed();
	}    
}

