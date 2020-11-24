package Process;

import Model.DataInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

//nhóm top các cổ phiếu thủy sản
public class Rule6 extends Rules {


    @Override
    public Map<String, String> PushInMap(ArrayList<DataInput> data) {

        ArrayList<DataInput> array = new ArrayList<>();
        ArrayList<Rules> arr = new ArrayList<>();

        //tìm các đối tượng có tên như dưới và đưa tất cả vào list arr;
        array.add(filterByName(data,"ANV"));
        array.add(filterByName(data,"IDI"));
        array.add(filterByName(data,"VHC"));
        array.add(filterByName(data,"TS4"));

        for (int i=0;i<array.size();i++){
            double tmp= array.get(i).getClose()-array.get(i).getOpen();
            arr.add(new Rules(i,tmp,0));
        }

        Collections.sort(arr,new SortByChange());
        for(int i=0;i<arr.size();i++) {
            map.put("nameF" +(i+1), array.get(arr.get(i).getIndex()).getName());
            map.put("numF"+(i+1),Double.toString(Math.abs(arr.get(i).getValueChange())*1000));
            if(arr.get(i).getValueChange()>=0){map.put("Flink"+(i+1),"tăng");}
            if(arr.get(i).getValueChange()<0){map.put("Flink"+(i+1),"giảm");}
            map.put("level"+(i+1),level(arr.get(i).getValueChange()));
        }

        Collections.sort(array,new DataSortByVolumeValue());
        for(int i=0;i<array.size();i++) {
            map.put("FVname" + (i + 1),array.get(i).getName());
            map.put("FVnum"+(i+1),Double.toString(array.get(i).getVolume()));
        }
        map.put("totalF",Integer.toString(filterByName(data,"^THUYSAN").getVolume()));
        for(int i=0;i<array.size();i++) {
            map.put("timeF"+(i+1), Float.toString((float) (array.get(i).getVolume()) / (filterByName(data, "^THUYSAN").getVolume())));
        }

        return map;
    }
}
