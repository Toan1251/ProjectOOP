package Process;

import Model.DataInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

//nhóm top
// các ngân hàng
public class Rule4 extends Rules {


    @Override
    public Map<String, String> PushInMap(ArrayList<DataInput> data) {

        ArrayList<DataInput> array = new ArrayList<>();
        ArrayList<Rules> arr = new ArrayList<>();

        //tìm các đối tượng có tên như dưới và đưa tất cả vào list arr;
        array.add(filterByName(data,"BID"));
        array.add(filterByName(data,"CTG"));
        array.add(filterByName(data,"HDB"));
        array.add(filterByName(data,"MBB"));
        array.add(filterByName(data,"TCB"));
        array.add(filterByName(data,"VCB"));
        array.add(filterByName(data,"VPB"));

        for (int i=0;i<array.size();i++){
            double tmp= array.get(i).getClose()-array.get(i).getOpen();
            arr.add(new Rules(i,tmp,0));
        }

        Collections.sort(arr,new SortByChange());
        for(int i=0;i<arr.size();i++) {
            map.put("nameBank" +(i+1), array.get(arr.get(i).getIndex()).getName());
            map.put("numBank"+(i+1),Double.toString(Math.abs(arr.get(i).getValueChange())*1000));
            if(arr.get(i).getValueChange()>=0){map.put("Blink"+(i+1),"tăng");}
            if(arr.get(i).getValueChange()<0){map.put("Blink"+(i+1),"giảm");}
            map.put("level"+(i+1),level(arr.get(i).getValueChange()));

        }
        Collections.sort(array,new DataSortByVolumeValue());
        for (int i=0;i<array.size();i++){
            map.put("BVname"+(i+1),array.get(i).getName());
            map.put("BVnum"+(i+1),Double.toString(array.get(i).getVolume()));
        }

        map.put("totalB",Integer.toString(filterByName(data,"^NGANHANG").getVolume()));


        return map;
    }
}
