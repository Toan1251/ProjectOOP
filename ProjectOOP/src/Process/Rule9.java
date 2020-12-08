package ProjectOOP.src.Process;

import ProjectOOP.src.Model.DataInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

//nhóm top các cổ phiếu thép
public class Rule9 extends Rules {


    @Override
    public Map<String, String> PushInMap(ArrayList<DataInput> data) {

        ArrayList<DataInput> array = new ArrayList<>();
        ArrayList<Rules> arr = new ArrayList<>();

        //tìm các đối tượng có tên như dưới và đưa tất cả vào list arr;
        array.add(filterByName(data,"NKG"));
        array.add(filterByName(data,"TLH"));
        array.add(filterByName(data,"POM"));
        array.add(filterByName(data,"MWG"));
        array.add(filterByName(data,"PET"));
        array.add(filterByName(data,"BVG"));
        array.add(filterByName(data,"HPG"));
        array.add(filterByName(data,"HSG"));
        array.add(filterByName(data,"SMC"));



        for (int i=0;i<array.size();i++){
            double tmp= array.get(i).getClose()-array.get(i).getOpen();
            arr.add(new Rules(i,tmp,0));
        }

        arr.sort(new SortByChange());
        for(int i=0;i<arr.size();i++) {
            map.put("nameT" +(i+1), array.get(arr.get(i).getIndex()).getName());
            map.put("numT"+(i+1),Double.toString(Math.abs(arr.get(i).getValueChange())*1000));
            if(arr.get(i).getValueChange()>=0){map.put("Tlink"+(i+1),"tăng");}
            if(arr.get(i).getValueChange()<0){map.put("Tlink"+(i+1),"giảm");}
            map.put("level"+(i+1),level(arr.get(i).getValueChange()));
        }

        array.sort(new DataSortByVolumeValue());
        for(int i=0;i<array.size();i++) {
            map.put("TVname" + (i + 1),array.get(i).getName());
            map.put("TVnum"+(i+1),Double.toString(array.get(i).getVolume()));
        }
        map.put("totalT",Integer.toString(filterByName(data,"^THEP").getVolume()));
        for(int i=0;i<array.size();i++) {
            map.put("timeT"+(i+1), Float.toString((float) (array.get(i).getVolume()) / (filterByName(data, "^THEP").getVolume())));
        }

        return map;
    }
}
