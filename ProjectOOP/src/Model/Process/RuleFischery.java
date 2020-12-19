package ProjectOOP.src.Model.Process;
import ProjectOOP.src.Model.Handle.DataInput;
import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.SortData;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//nhóm top các cổ phiếu thủy sản
public class RuleFischery extends Rules {


    @Override
    public Map<String, String> PushInMap(List<DataOutput> data) {
        SortData sorting = new SortData();

        //tìm các đối tượng output tương ứng và add vào 1 list chung
        List<DataOutput> myList = new LinkedList<>();
        myList.add(filterByName(data,"ANV"));
        myList.add(filterByName(data,"IDI"));
        myList.add(filterByName(data,"VHC"));
        myList.add(filterByName(data,"TS4"));

        //sắp xếp theo change
        List<DataOutput> sortedListChange = sorting.sort(myList, 6);
        for(int i=0;i<sortedListChange.size();i++) {
            double temp=sortedListChange.get(i).getData().getClose()-sortedListChange.get(i).getData().getOpen();

            map.put("nameF" +(i+1),sortedListChange.get(i).getData().getName());
            map.put("numF"+(i+1),Double.toString(Math.abs(temp)*1000));
            if(temp>=0){map.put("Flink"+(i+1),"tăng");}
            if(temp<0){map.put("Flink"+(i+1),"giảm");}
            map.put("level"+(i+1),level(temp));
        }

        //sắp xếp theo volume value
        List<DataOutput> sortedListVolume = sorting.sort(myList, 8);
        for(int i=0;i<sortedListVolume.size();i++) {
            map.put("FVname" + (i + 1),sortedListVolume.get(i).getData().getName());
            map.put("FVnum"+(i+1),Double.toString(sortedListVolume.get(i).getData().getVolume()));
        }

        //tổng số cổ phiếu bán ra
        map.put("totalF",Double.toString(filterByName(data,"^THUYSAN").getData().getVolume()));

        //số  lần từng cổ phiếu so với tổng
        for(int i=0;i<myList.size();i++) {
            map.put("timeF"+(i+1), Float.toString((float) ((myList.get(i).getData().getVolume()) / (filterByName(data, "^THUYSAN").getData().getVolume()))));
        }

        return map;

    }
}







//        ArrayList<DataInput> array = new ArrayList<>();
//        ArrayList<Rules> arr = new ArrayList<>();
//
//        //tìm các đối tượng có tên như dưới và đưa tất cả vào list arr;
//        array.add(filterByName(data,"ANV"));
//        array.add(filterByName(data,"IDI"));
//        array.add(filterByName(data,"VHC"));
//        array.add(filterByName(data,"TS4"));
//
//        for (int i=0;i<array.size();i++){
//            double tmp= array.get(i).getClose()-array.get(i).getOpen();
//            arr.add(new Rules(i,tmp,0));
//        }
//
//        arr.sort(new SortByChange());
//        for(int i=0;i<arr.size();i++) {
//            map.put("nameF" +(i+1), array.get(arr.get(i).getIndex()).getName());
//            map.put("numF"+(i+1),Double.toString(Math.abs(arr.get(i).getValueChange())*1000));
//            if(arr.get(i).getValueChange()>=0){map.put("Flink"+(i+1),"tăng");}
//            if(arr.get(i).getValueChange()<0){map.put("Flink"+(i+1),"giảm");}
//            map.put("level"+(i+1),level(arr.get(i).getValueChange()));
//        }
//
//        array.sort(new DataSortByVolumeValue());
//        for(int i=0;i<array.size();i++) {
//            map.put("FVname" + (i + 1),array.get(i).getName());
//            map.put("FVnum"+(i+1),Double.toString(array.get(i).getVolume()));
//        }
//        map.put("totalF",Double.toString(filterByName(data,"^THUYSAN").getVolume()));
//        for(int i=0;i<array.size();i++) {
//            map.put("timeF"+(i+1), Float.toString((float) ((array.get(i).getVolume()) / (filterByName(data, "^THUYSAN").getVolume()))));
//        }
//
//        return map;
//    }
//}
