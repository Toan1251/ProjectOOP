package Model;

import java.util.Map;

//change là số thay đổi, dùng để so sánh độ tăng hay giảm của số liệu.
//index là index của ArrayList trong DataInput
public class Rules extends DataFileInput {
    private Float change;
    private int index;
    protected Map<String,String> map;


    public Rules(){
        //Map dùng để chứa các cặp key,value dùng để thay thế biến cho câu.
        //Map map = new HashMap<String,String>();
    }

    public Rules (Float change, int index){
        setIndex(index);
        setChange(change);
    }

//Map này dùng để chứa các cặp key,value dùng để thay thế biến cho câu.


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Float getChange() {
        return change;
    }

    public void setChange(Float change) {
        this.change = change;
    }



}
