package ProjectOOP.src.Model.Process;
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
        myList.add(filterByName(data,"NVB"));
        myList.add(filterByName(data,"SHB"));
        myList.add(filterByName(data,"ACB"));
        myList.add(filterByName(data,"STB"));
        myList.add(filterByName(data,"LPB"));
        myList.add(filterByName(data,"EIB"));
        myList.add(filterByName(data,"TPB"));
        myList.add(filterByName(data,"VIB"));

        sorting.removeNull(myList);



        //sắp xếp theo change
        List<DataOutput> sortedListChange = sorting.sort(myList, 6);
        double total=0.0;
        for(int i=0;i<sortedListChange.size();i++) {
            double temp = sortedListChange.get(i).getData().getClose()-sortedListChange.get(i).getData().getOpen();
            total +=sortedListChange.get(i).getData().getVolume();

            map.put("nameBank" +(i+1), sortedListChange.get(i).getData().getName());
            if(temp>0){
                map.put("Blink"+(i+1),"tăng");
                map.put("numBank"+(i+1),Long.toString((long)(Math.abs(temp)*1000)));
                map.put("level"+(i+1),level(temp));


            }
            if(temp<0){
                map.put("Blink"+(i+1),"giảm");
                map.put("numBank"+(i+1),Long.toString((long)(Math.abs(temp)*1000000)));
                map.put("level"+(i+1),level(temp));


            }else{
                map.put("Blink"+(i+1),"đứng giá");
                map.put("numBank"+(i+1),"");
                map.put("level"+(i+1),"");
            }
        }

        //sắp xếp theo volume value
        List<DataOutput> sortedListVolume = sorting.sort(myList, 8);
        for (int i=0;i<sortedListVolume.size();i++){
            map.put("BVname"+(i+1),sortedListVolume.get(i).getData().getName());
            map.put("BVnum"+(i+1),Long.toString((long)sortedListVolume.get(i).getData().getVolume()));
        }

        //tổng số cổ phiếu bán ra
        map.put("totalB",Long.toString((long)(total)));


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

