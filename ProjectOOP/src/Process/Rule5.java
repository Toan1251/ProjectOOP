package Process;

import Model.DataInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

//nhóm top các cổ phiếu dầu khí
public class Rule5 extends Rules {


    @Override
    public Map<String, String> PushInMap(ArrayList<DataInput> data) {

        ArrayList<DataInput> array = new ArrayList<>();
        ArrayList<Rules> arr = new ArrayList<>();

        //tìm các đối tượng có tên như dưới và đưa tất cả vào list arr;
        array.add(filterByName(data,"ASP"));
        array.add(filterByName(data,"PGC"));
        array.add(filterByName(data,"PJT"));
        array.add(filterByName(data,"PLX"));
        array.add(filterByName(data,"PVD"));
        array.add(filterByName(data,"PVT"));
        array.add(filterByName(data,"PXS"));

        for (int i=0;i<array.size();i++){
            double tmp= array.get(i).getClose()-array.get(i).getOpen();
            arr.add(new Rules(i,tmp,0));
        }

        Collections.sort(arr,new SortByChange());
        for(int i=0;i<arr.size();i++) {
            map.put("namePetro" +(i+1), array.get(arr.get(i).getIndex()).getName());
            map.put("numPetro"+(i+1),Double.toString(Math.abs(arr.get(i).getValueChange())*1000));
            if(arr.get(i).getValueChange()>=0){map.put("Plink"+(i+1),"tăng");}
            if(arr.get(i).getValueChange()<0){map.put("Plink"+(i+1),"giảm");}
            map.put("level"+(i+1),level(arr.get(i).getValueChange()));
        }

        Collections.sort(array,new DataSortByVolumeValue());
        for(int i=0;i<array.size();i++) {
            map.put("PVname" + (i + 1),array.get(i).getName());
            map.put("PVnum"+(i+1),Double.toString(array.get(i).getVolume()));
        }
        map.put("totalP",Integer.toString(filterByName(data,"^DAUKHI").getVolume()));
        for(int i=0;i<array.size();i++) {
            map.put("timeP"+(i+1), Float.toString((float) (array.get(i).getVolume()) / (filterByName(data, "^DAUKHI").getVolume())));
        }

        return map;
    }
}
