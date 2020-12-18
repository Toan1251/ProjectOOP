package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataInput;
import java.util.ArrayList;
import java.util.Map;

//nhóm top các cổ phiếu hàng không
public class RuleAirline extends Rules {


    @Override
    public Map<String, String> PushInMap(ArrayList<DataInput> data) {

        ArrayList<DataInput> array = new ArrayList<>();
        ArrayList<Rules> arr = new ArrayList<>();

        //tìm các đối tượng có tên như dưới và đưa tất cả vào list arr;
        array.add(filterByName(data,"HVN"));
        array.add(filterByName(data,"VJC"));

        for (int i=0;i<array.size();i++){
            double tmp= array.get(i).getClose()-array.get(i).getOpen();
            arr.add(new Rules(i,tmp,0));
        }

        arr.sort(new SortByChange());
        for(int i=0;i<arr.size();i++) {
            map.put("nameA" +(i+1), array.get(arr.get(i).getIndex()).getName());
            map.put("numA"+(i+1),Double.toString(Math.abs(arr.get(i).getValueChange())*1000));
            if(arr.get(i).getValueChange()>=0){map.put("Alink"+(i+1),"tăng");}
            if(arr.get(i).getValueChange()<0){map.put("Alink"+(i+1),"giảm");}
            map.put("level"+(i+1),level(arr.get(i).getValueChange()));
        }

        array.sort(new DataSortByVolumeValue());
        for(int i=0;i<array.size();i++) {
            map.put("AVname" + (i + 1),array.get(i).getName());
            map.put("AVnum"+(i+1),Double.toString(array.get(i).getVolume()));
        }

        return map;
    }
}
