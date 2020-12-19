package ProjectOOP.src.Model.Process;
import ProjectOOP.src.Model.Handle.DataInput;
import java.util.List;
import java.util.Map;

public class RuleTopVol extends Rules {

    @Override
    public Map<String, String> PushInMap(List<DataOutput> data) {
        SortData sorting = new SortData();
        List<DataOutput> sortedListVol = sorting.sort(data, 1);
        for(int i=0;i<3;i++) {
            map.put("vol" + (i + 1), sortedListVol.get(i).getData().getName());
            map.put("v"+(i+1), Double.toString(sortedListVol.get(i).getData().getVolume()));
        }

        List<DataOutput> sortedListVolValue = sorting.sort(data, 8);
        map.put("rvol",sortedListVolValue.get(0).getData().getName());
        map.put("rv",Double.toString(sortedListVolValue.get(0).getData().getVolumeValue()));
        return map;
    }
}








//        //ArrayList này để chứa các đối tương Rules được tạo ra
//        ArrayList<Rules> arr = new ArrayList<>();
//
//        //phương thức này dùng để tạo ra các đối tượng Rules và thêm nó vào trong ArrayList của lớp Rules
//        for (int i=0;i<(data.size());i++){
//            double tmp= data.get(i).getVolume();
//            double temp=data.get(i).getVolume()*((data.get(i).getHigh())-(data.get(i).getLow()))/2*1000;
//            Rules obj= new Rules();
//            obj.setIndex(i);
//            obj.setVolume(tmp);
//            obj.setVolumeValue(temp);
//            arr.add(obj);
//        }
//
//        //sắp xếp theo Volume và đưa các cặp key-value cần thiết vào map
//        arr.sort(new SortByVolume());
//        for(int i=0;i<3;i++) {
//            map.put("vol" + (i + 1), data.get(arr.get(i).getIndex()).getName());
//            map.put("v"+(i+1), Double.toString(arr.get(i).getVolume()));
//        }
//
//        //sắp xếp theo VolumeValue và đưa các cặp key-value cần thiết vào map
//        arr.sort(new SortByVolumeValue());
//        map.put("rvol",data.get(arr.get(0).getIndex()).getName());
//        map.put("rv",Double.toString(arr.get(0).getVolumeValue()));
//
//
//        return map;
//
//
//    }
//
//}
