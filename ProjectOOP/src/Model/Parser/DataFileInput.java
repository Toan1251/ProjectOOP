package ProjectOOP.src.Model.Parser;

import ProjectOOP.src.Model.Parser.CsvParser;

public class DataFileInput {
    private CsvParser data;
    public DataFileInput() {
        this.data = new CsvParser();
    }
    public DataFileInput(String filename) throws Exception{
        this.data = new CsvParser(filename);
    }
    public void setData(CsvParser data){
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

