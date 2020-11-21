package Process;

import Model.DataInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Rule3 extends Rules {

    @Override
    public Map<String, String> PushInMap(ArrayList<DataInput> data) {
        //ArrayList này để chứa các đối tương Rules được tạo ra
        ArrayList<Rules> arr = new ArrayList<>();

        //phương thức này dùng để tạo ra các đối tượng Rules và thêm nó vào trong ArrayList của lớp Rules
        for (int i=0;i<(data.size());i++){
            int tmp= data.get(i).getVolume();
            double temp=data.get(i).getVolume()*((data.get(i).getHigh())-(data.get(i).getLow()))/2*1000;
            arr.add(new Rules(i,tmp,temp));
        }

        //sắp xếp theo Volume và đưa các cặp key-value cần thiết vào map
        Collections.sort(arr,new SortByVolume());
        for(int i=0;i<3;i++) {
            map.put("vol" + (i + 1), data.get(arr.get(i).getIndex()).getName());
            map.put("v"+(i+1), Integer.toString(arr.get(i).getVolume()));
        }

        //sắp xếp theo VolumeValue và đưa các cặp key-value cần thiết vào map
        Collections.sort(arr,new SortByVolumeValue());
        map.put("rvol",data.get(arr.get(0).getIndex()).getName());
        map.put("rv",Double.toString(arr.get(0).getVolumeValue()));


        return map;


    }

}
