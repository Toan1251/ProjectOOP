package ProjectOOP.src.Model.Process;
import ProjectOOP.src.Model.Handle.DataInput;
import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.SortData;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//nhóm top các cổ phiếu thép
public class RuleSteel extends Rules {


    @Override
    public Map<String, String> PushInMap(List<DataOutput> data) {
        SortData sorting = new SortData();

        //tìm các đối tượng output tương ứng và add vào 1 list chung
        List<DataOutput> myList = new LinkedList<>();
        myList.add(filterByName(data,"NKG"));
        myList.add(filterByName(data,"TLH"));
        myList.add(filterByName(data,"POM"));
        myList.add(filterByName(data,"MWG"));
        myList.add(filterByName(data,"PET"));
        myList.add(filterByName(data,"BVG"));
        myList.add(filterByName(data,"HPG"));
        myList.add(filterByName(data,"HSG"));
        myList.add(filterByName(data,"SMC"));

        //sắp xếp theo change
        List<DataOutput> sortedListChange = sorting.sort(myList, 6);
        for(int i=0;i<sortedListChange.size();i++) {
            double temp=sortedListChange.get(i).getData().getClose()-sortedListChange.get(i).getData().getOpen();

            map.put("nameT" +(i+1), sortedListChange.get(i).getData().getName());
            if(temp>0){
                map.put("Tlink"+(i+1),"tăng");
                map.put("numT"+(i+1),Integer.toString((int)Math.abs(temp)*1000000));
                map.put("level"+(i+1),level(temp));
            }
            if(temp<0){
                map.put("Tlink"+(i+1),"giảm");
                map.put("numT"+(i+1),Integer.toString((int)Math.abs(temp)*1000000));
                map.put("level"+(i+1),level(temp));
            }else{
                map.put("Tlink"+(i+1),"đứng giá");
                map.put("numT"+(i+1),"");
                map.put("level"+(i+1),"");

            }
        }

        //sắp xếp theo volume value
        List<DataOutput> sortedListVolume = sorting.sort(myList, 8);
        for(int i=0;i<sortedListVolume.size();i++) {
            map.put("TVname" + (i + 1),sortedListVolume.get(i).getData().getName());
            map.put("TVnum"+(i+1),Double.toString(sortedListVolume.get(i).getData().getVolume()));
        }

        //tổng số cổ phiếu bán ra
        map.put("totalT",Double.toString(filterByName(data,"^THEP").getData().getVolume()));

        //số  lần từng cổ phiếu so với tổng
        for(int i=0;i<myList.size();i++) {
            map.put("timeT"+(i+1), Float.toString((float) ((myList.get(i).getData().getVolume()) / (filterByName(data, "^THEP").getData().getVolume()))));
        }
        return map;





    }
}

//        ArrayList<DataInput> array = new ArrayList<>();
//        ArrayList<Rules> arr = new ArrayList<>();
//
//        //tìm các đối tượng có tên như dưới và đưa tất cả vào list arr;
//        array.add(filterByName(data,"NKG"));
//        array.add(filterByName(data,"TLH"));
//        array.add(filterByName(data,"POM"));
//        array.add(filterByName(data,"MWG"));
//        array.add(filterByName(data,"PET"));
//        array.add(filterByName(data,"BVG"));
//        array.add(filterByName(data,"HPG"));
//        array.add(filterByName(data,"HSG"));
//        array.add(filterByName(data,"SMC"));
//
//
//
//        for (int i=0;i<array.size();i++){
//            double tmp= array.get(i).getClose()-array.get(i).getOpen();
//            arr.add(new Rules(i,tmp,0));
//        }
//
//        arr.sort(new SortByChange());
//        for(int i=0;i<arr.size();i++) {
//            map.put("nameT" +(i+1), array.get(arr.get(i).getIndex()).getName());
//            map.put("numT"+(i+1),Double.toString(Math.abs(arr.get(i).getValueChange())*1000));
//            if(arr.get(i).getValueChange()>=0){map.put("Tlink"+(i+1),"tăng");}
//            if(arr.get(i).getValueChange()<0){map.put("Tlink"+(i+1),"giảm");}
//            map.put("level"+(i+1),level(arr.get(i).getValueChange()));
//        }
//
//        array.sort(new DataSortByVolumeValue());
//        for(int i=0;i<array.size();i++) {
//            map.put("TVname" + (i + 1),array.get(i).getName());
//            map.put("TVnum"+(i+1),Double.toString(array.get(i).getVolume()));
//        }
//        map.put("totalT",Double.toString(filterByName(data,"^THEP").getVolume()));
//        for(int i=0;i<array.size();i++) {
//            map.put("timeT"+(i+1), Float.toString((float) ((array.get(i).getVolume()) / (filterByName(data, "^THEP").getVolume()))));
//        }
//
//        return map;
//    }
//}
