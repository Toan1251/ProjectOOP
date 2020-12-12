package ProjectOOP.src.Process;

import java.util.ArrayList;
import java.util.Map;
import ProjectOOP.src.Model.*;
import java.util.stream.*;

//change là số thay đổi, dùng để so sánh độ tăng hay giảm của số liệu.
//index là index của ArrayList trong DataInput
public class Rules {
    private double valueChange;
    private double PercentChange;
    private int index;
    protected Map<String,String> map;
    private double Volume;
    private double volumeValue;

    //.//
    public Map<String,String> PushInMap(ArrayList<DataInput> data){
        return null;
    };




    public Rules(){
        //Map dùng để chứa các cặp key,value dùng để thay thế biến cho câu.
        //Map map = new HashMap<String,String>();
    }

    public Rules (int index,double valueChange,double PercentChange){
        setIndex(index);
        setValueChange(valueChange);
        setPercentChange(PercentChange);

    }

    public Rules (int index,double PercentChange){
        setIndex(index);
        setPercentChange(PercentChange);
    }

//    public Rules (int index, double Volume,double volumeValue){
//        setIndex(index);
//        setVolume(Volume);
//        setVolumeValue(volumeValue);
//    }


//Map này dùng để chứa các cặp key,value dùng để thay thế biến cho câu.


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getValueChange() {
        return valueChange;
    }

    public void setValueChange(double valueChange) {
        this.valueChange = valueChange;
    }
    public double getPercentChange() {
        return PercentChange;
    }

    public void setPercentChange(double percentChange) {
        PercentChange = percentChange;
    }

    public double getVolume() {
        return Volume;
    }

    public void setVolume(double volume) {
        Volume = volume;
    }

    public double getVolumeValue() {
        return volumeValue;
    }

    public void setVolumeValue(double volumeValue) {
        this.volumeValue = volumeValue;
    }

    //phương thức nói về mức độ
    public String level(double valueChange) {
        double tmp = Math.abs(valueChange);
        if(tmp >= 1000)  {
            return "mạnh";
        }
        else if(tmp >= 500) {
            return "khá mạnh";
        }
        else return "nhẹ";
    }


    //phương thức tìm đối tượng trong list data có tên cụ thể
    //trả về 1 đối tượng
    public DataInput filterByName(ArrayList<DataInput> data,String name){
        return data.stream().filter(x->x.getName().equals(name)).findAny().orElse(null);
    }

    //phương thức tìm đối tượng trong list data có tên cụ thể
//trả về 1 đối tượng
//    public DataInput filterByDay(ArrayList<DataInput> data,int Day) {
//        return data.stream().filter(x -> x.getDate().get==).findAny().orElse(null);
//    }

    //phương thức tìm đối tượng trong list data có tên cụ thể
//trả về 1 đối tượng
//    public DataInput filterByNameAndDate(String name,Date date) {
//        return getData().stream().filter(x -> x.getDate() == date && x.getName().equals(name)).findAny().orElse(null);
//
//    }


}
