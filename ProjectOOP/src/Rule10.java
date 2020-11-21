package Process;

import Model.DataInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

//nhóm top các cổ phiếu họ Vingroup
public class Rule10 extends Rules {


    @Override
    public Map<String, String> PushInMap(ArrayList<DataInput> data) {

        ArrayList<DataInput> array = new ArrayList<>();
        ArrayList<Rules> arr = new ArrayList<>();

        //tìm các đối tượng có tên như dưới và đưa tất cả vào list arr;
        array.add(filterByName(data,"VIC"));
        array.add(filterByName(data,"VHM"));
        array.add(filterByName(data,"VRE"));

        for (int i=0;i<array.size();i++){
            double tmp= array.get(i).getClose()-array.get(i).getOpen();
            arr.add(new Rules(i,tmp,0));
        }

        for(int i=0;i<arr.size();i++) {
            map.put("nameV" +(i+1), array.get(arr.get(i).getIndex()).getName());
            map.put("numV"+(i+1),Double.toString(Math.abs(arr.get(i).getValueChange())*1000));

            if(arr.get(i).getValueChange()>=0){
                map.put("Vlink"+(i+1),"tăng");
                map.put("upV"+(i+1),"lên");
            }

            else if(arr.get(i).getValueChange()<0){
                map.put("Vlink"+(i+1),"giảm");
                map.put("upV"+(i+1),"xuống");
            }
            map.put("level"+(i+1),level(arr.get(i).getValueChange()));
            map.put("openV"+(i+1),Double.toString(array.get(i).getOpen()));
            map.put("closeV"+(i+1),Double.toString(array.get(i).getClose()));
            if(arr.get(0).getValueChange()>=0 && arr.get(1).getValueChange()>=0){ map.put("statement","đang trên đà tăng"); }
            else if(arr.get(0).getValueChange()>=0 && arr.get(1).getValueChange()<0){ map.put("statement","đang biến động"); }
            else if(arr.get(0).getValueChange()<0 && arr.get(1).getValueChange()>=0){ map.put("statement","đang biến động"); }
            else if(arr.get(0).getValueChange()<0 && arr.get(1).getValueChange()<0){ map.put("statement","đang trên đà giảm"); }

        }

        return map;
    }
}
