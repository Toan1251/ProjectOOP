package Model;

public class DataFileInput {
    private CsvParser data;
    public DataFileInput() {
        this.data = new CsvParser();
    }
    public DataFileInput(String filename) throws Exception{
        this.data = new CsvParser(filename);
    }
    public void setData(CsvParser data) throws Exception {
        this.data = data;
    }

    public CsvParser getData() {
        return data;
    }

    //Debug
    public void Debug(){
        data.Debug();
    }
}

