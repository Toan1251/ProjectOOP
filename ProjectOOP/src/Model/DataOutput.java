package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataOutput extends DataTagging{
    private List<String> sentences;
    // Todo: Thêm các hàm hoặc các lớp cần thiết để tạo, thêm, xóa, trả về câu thích hợp vào arraylist

    public DataOutput() {
        this.sentences = new ArrayList<String>();
    }

    public DataOutput(DataInput data) {
        super(data);
        this.sentences = new ArrayList<String>();
    }

    public DataOutput(DataInput data, TagManager tags) {
        super(data, tags);
        this.sentences = new ArrayList<String>();
    }

    public DataOutput(DataInput data, List<String> sentences) {
        super(data);
        this.sentences = sentences;
    }

    public DataOutput(DataInput data, TagManager tags, List<String> sentences) {
        super(data, tags);
        this.sentences = sentences;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

    //Debug
    public void Debug(){
        getData().Debug();
        getTags().Debug();
        Iterator<String> itr = sentences.listIterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
