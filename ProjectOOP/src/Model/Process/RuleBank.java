package ProjectOOP.src.Model.Process;
import ProjectOOP.src.Model.Handle.DataInput;
import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.SortData;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//nhóm top
// các ngân hàng
public class RuleBank extends Rules {


    @Override
    public Map<String, String> PushInMap(List<DataOutput> data) {
        SortData sorting = new SortData();

        //tìm các đối tượng output tương ứng và add vào 1 list chung
        List<DataOutput> myList = new LinkedList<>();
        myList.add(filterByName(data,"BID"));
        myList.add(filterByName(data,"CTG"));
        myList.add(filterByName(data,"HDB"));
        myList.add(filterByName(data,"MBB"));
        myList.add(filterByName(data,"TCB"));
        myList.add(filterByName(data,"VCB"));
        myList.add(filterByName(data,"VPB"));

        //sắp xếp theo change
        List<DataOutput> sortedListChange = sorting.sort(myList, 6);
        for(int i=0;i<sortedListChange.size();i++) {
            double temp = sortedListChange.get(i).getData().getClose()-sortedListChange.get(i).getData().getOpen();

            map.put("nameBank" +(i+1), sortedListChange.get(i).getData().getName());
            map.put("numBank"+(i+1),Double.toString(Math.abs(temp)*1000));
            if(temp>=0){map.put("Blink"+(i+1),"tăng");}
            if(temp<0){map.put("Blink"+(i+1),"giảm");}
            map.put("level"+(i+1),level(temp));

        }

        //sắp xếp theo volume value
        List<DataOutput> sortedListVolume = sorting.sort(myList, 8);
        for (int i=0;i<sortedListVolume.size();i++){
            map.put("BVname"+(i+1),sortedListVolume.get(i).getData().getName());
            map.put("BVnum"+(i+1),Double.toString(sortedListVolume.get(i).getData().getVolume()));
        }

        //tổng số cổ phiếu bán ra
        map.put("totalB",Double.toString(filterByName(data,"^NGANHANG").getData().getVolume()));


        return map;

    }
}








//        ArrayList<DataInput> array = new ArrayList<>();
//        ArrayList<Rules> arr = new ArrayList<>();
//
//        //tìm các đối tượng có tên như dưới và đưa tất cả vào list arr;
//        array.add(filterByName(data,"BID"));
//        array.add(filterByName(data,"CTG"));
//        array.add(filterByName(data,"HDB"));
//        array.add(filterByName(data,"MBB"));
//        array.add(filterByName(data,"TCB"));
//        array.add(filterByName(data,"VCB"));
//        array.add(filterByName(data,"VPB"));
//
//        for (int i=0;i<array.size();i++){
//            double tmp= array.get(i).getClose()-array.get(i).getOpen();
//            arr.add(new Rules(i,tmp,0));
//        }
//
//        arr.sort(new SortByChange());
//        for(int i=0;i<arr.size();i++) {
//            map.put("nameBank" +(i+1), array.get(arr.get(i).getIndex()).getName());
//            map.put("numBank"+(i+1),Double.toString(Math.abs(arr.get(i).getValueChange())*1000));
//            if(arr.get(i).getValueChange()>=0){map.put("Blink"+(i+1),"tăng");}
//            if(arr.get(i).getValueChange()<0){map.put("Blink"+(i+1),"giảm");}
//            map.put("level"+(i+1),level(arr.get(i).getValueChange()));
//
//        }
//        array.sort(new DataSortByVolumeValue());
//        for (int i=0;i<array.size();i++){
//            map.put("BVname"+(i+1),array.get(i).getName());
//            map.put("BVnum"+(i+1),Double.toString(array.get(i).getVolume()));
//        }
//
//        map.put("totalB",Double.toString(filterByName(data,"^NGANHANG").getVolume()));
//
//
//        return map;
//    }

