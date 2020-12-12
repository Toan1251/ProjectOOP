package ProjectOOP.src.Process;

import ProjectOOP.src.Model.DataInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

//nhóm top các cổ phiếu cao su
public class RuleRubber extends Rules {


    @Override
    public Map<String, String> PushInMap(ArrayList<DataInput> data) {

        ArrayList<DataInput> array = new ArrayList<>();
        ArrayList<Rules> arr = new ArrayList<>();

        //tìm các đối tượng có tên như dưới và đưa tất cả vào list arr;
        array.add(filterByName(data,"DRC"));
        array.add(filterByName(data,"DPR"));
        array.add(filterByName(data,"TNC"));
        array.add(filterByName(data,"HRC"));
        array.add(filterByName(data,"TRC"));
        array.add(filterByName(data,"CSM"));



        for (int i=0;i<array.size();i++){
            double tmp= array.get(i).getClose()-array.get(i).getOpen();
            arr.add(new Rules(i,tmp,0));
        }

        arr.sort(new SortByChange());
        for(int i=0;i<arr.size();i++) {
            map.put("nameC" +(i+1), array.get(arr.get(i).getIndex()).getName());
            map.put("numC"+(i+1),Double.toString(Math.abs(arr.get(i).getValueChange())*1000));
            if(arr.get(i).getValueChange()>=0){map.put("Clink"+(i+1),"tăng");}
            if(arr.get(i).getValueChange()<0){map.put("Clink"+(i+1),"giảm");}
            map.put("level"+(i+1),level(arr.get(i).getValueChange()));
        }

        array.sort(new DataSortByVolumeValue());
        for(int i=0;i<array.size();i++) {
            map.put("CVname" + (i + 1),array.get(i).getName());
            map.put("CVnum"+(i+1),Double.toString(array.get(i).getVolume()));
        }
        map.put("totalC",Double.toString(filterByName(data,"^CAOSU").getVolume()));
        for(int i=0;i<array.size();i++) {
            map.put("timeC"+(i+1), Float.toString((float) ((array.get(i).getVolume()) / (filterByName(data, "^CAOSU").getVolume()))));
        }

        return map;
    }
}
