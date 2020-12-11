package ProjectOOP.src.Model;

import java.util.LinkedList;
import java.util.List;

public class DataOutput extends DataTagging{
    private List<String> sentences;
    // Todo: Thêm các hàm hoặc các lớp cần thiết để tạo, thêm, xóa, trả về câu thích hợp vào LinkedList

    public DataOutput() {
        this.sentences = new LinkedList<String>();
    }

    public DataOutput(DataInput data) {
        super(data);
        this.sentences = new LinkedList<String>();
    }

    public DataOutput(DataInput data, TagManager tags) {
        super(data, tags);
        this.sentences = new LinkedList<String>();
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

    public void addSentences(String sentence){
        this.sentences.add(sentence);
    }

    public void addSentences(List<String> sentences){
        this.sentences.addAll(sentences);
    }

    //Debug
    public void Debug(){
        getData().Debug();
        getTags().Debug();
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }

}
