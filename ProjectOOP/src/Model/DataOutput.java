package Model;

import java.util.ArrayList;

public class DataOutput extends DataTagging{
    private ArrayList<String> sentences;
    // Todo: Thêm các hàm hoặc các lớp cần thiết để tạo, thêm, xóa, trả về câu thích hợp vào arraylist
    public DataOutput() {
        super();
    }

    public DataOutput(DataInput data) {
        super(data);
    }

    public DataOutput(DataInput data, TagManager tags) {
        super(data, tags);
    }

    public DataOutput(DataInput data, ArrayList<String> sentences) {
        super(data);
        this.sentences = sentences;
    }

    public DataOutput(DataInput data, TagManager tags, ArrayList<String> sentences) {
        super(data, tags);
        this.sentences = sentences;
    }

    public ArrayList<String> getSentences() {
        return sentences;
    }

    public void setSentences(ArrayList<String> sentences) {
        this.sentences = sentences;
    }
}
