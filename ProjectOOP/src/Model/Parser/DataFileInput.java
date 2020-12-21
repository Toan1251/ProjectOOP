package ProjectOOP.src.Model.Parser;

public class DataFileInput {
    private CsvParser data;

    public DataFileInput() {
        this.data = new CsvParser();
    }

    public DataFileInput(String filename) throws Exception {
        this.data = new CsvParser(filename);
    }

    public CsvParser getData() {
        return data;
    }

    public void setData(CsvParser data) {
        this.data = data;
    }

    //Debug
    public void Debug() {
        data.Debug();
    }
}

