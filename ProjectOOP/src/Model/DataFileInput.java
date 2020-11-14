package Model;

import java.util.ArrayList;

public class DataFileInput {
    private ArrayList<DataInput> data;
    // Todo: Thêm các hàm hoặc các lớp cần thiết để đọc dữ liệu từ file CSV
    public DataFileInput() {

    }

    public DataFileInput(ArrayList<DataInput> data) {
        this.data = data;
    }

    public ArrayList<DataInput> getData() {
        return data;
    }

    public void setData(ArrayList<DataInput> data) {
        this.data = data;
    }
}
