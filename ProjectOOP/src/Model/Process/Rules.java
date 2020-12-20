package ProjectOOP.src.Model.Process;
import ProjectOOP.src.Model.Handle.DataInput;
import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class Rules {
    protected Map<String,String> map;
    public Map<String,String> PushInMap(List<DataOutput> data){
        return null;
    };




    public Rules(){
        map = new HashMap<>();

    }

//    public Rules (int index,double valueChange,double PercentChange){
//        setIndex(index);
//        setValueChange(valueChange);
//        setPercentChange(PercentChange);
//
//    }

//    public Rules (int index,double PercentChange){
//        setIndex(index);
//        setPercentChange(PercentChange);
//    }

//    public Rules (int index, double Volume,double volumeValue){
//        setIndex(index);
//        setVolume(Volume);
//        setVolumeValue(volumeValue);
//    }


//Map này dùng để chứa các cặp key,value dùng để thay thế biến cho câu.


//    public int getIndex() {
//        return index;
//    }
//
//    public void setIndex(int index) {
//        this.index = index;
//    }
//
//    public double getValueChange() {
//        return valueChange;
//    }
//
//    public void setValueChange(double valueChange) {
//        this.valueChange = valueChange;
//    }
//    public double getPercentChange() {
//        return PercentChange;
//    }
//
//    public void setPercentChange(double percentChange) {
//        PercentChange = percentChange;
//    }
//
//    public double getVolume() {
//        return Volume;
//    }
//
//    public void setVolume(double volume) {
//        Volume = volume;
//    }
//
//    public double getVolumeValue() {
//        return volumeValue;
//    }
//
//    public void setVolumeValue(double volumeValue) {
//        this.volumeValue = volumeValue;
//    }

    //phương thức nói về mức độ
    public String level(double valueChange) {
        double tmp = Math.abs(valueChange);
        if(tmp >= 1000.0)  {
            return "mạnh";
        }
        else if(tmp >= 500.0 && tmp<1000.0) {
            return "khá mạnh";
        }
        else return "nhẹ";
    }

    public String levelPc(double temp){
        double tmp=100*Math.abs(temp);
        if(tmp>=10.0){
            return "rất mạnh";
        }
        else if(tmp>=5.0 && tmp<10.0){
            return "mạnh";
        }
        else return "nhẹ";
    }


    //phương thức tìm đối tượng trong list data có tên cụ thể
    //trả về 1 đối tượng
    public DataOutput filterByName(List<DataOutput> data,String name){
        return data.stream().filter(x->x.getData().getName().equals(name)).findAny().orElse(null);
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
