package ProjectOOP.src.Model.Process;
import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.SortData;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//nhóm top các cổ phiếu họ Vingroup
public class RuleVin extends Rules {


    @Override
    public Map<String, String> PushInMap(List<DataOutput> data) {
        SortData sorting = new SortData();

        //tìm các đối tượng output tương ứng và add vào 1 list chung
        List<DataOutput> myList = new LinkedList<>();
        myList.add(filterByName(data,"VIC"));
        myList.add(filterByName(data,"VHM"));
        myList.add(filterByName(data,"VRE"));
        //test
        myList.add(filterByName(data,"C69"));

        sorting.removeNull(myList);

        for (int i=0;i<myList.size();i++){
            double temp= myList.get(i).getData().getClose()-myList.get(i).getData().getOpen();
            double temp1=myList.get(i+1).getData().getClose()-myList.get(i+1).getData().getOpen();
            map.put("nameV" +(i+1), myList.get(i).getData().getName());
            if(temp>0){
                map.put("Vlink"+(i+1),"tăng");
                map.put("upV"+(i+1),"lên");
                map.put("levelV"+(i+1),level(temp));
                map.put("openV"+(i+1),Integer.toString((int)myList.get(i).getData().getOpen()*1000000));
                map.put("closeV"+(i+1),Integer.toString((int)myList.get(i).getData().getClose()*1000000));
                map.put("numV"+(i+1),Integer.toString((int)Math.abs(temp)*1000000));}


            else if(temp<0){
                map.put("Vlink"+(i+1),"giảm");
                map.put("upV"+(i+1),"xuống");
                map.put("levelV"+(i+1),level(temp));
                map.put("openV"+(i+1),Integer.toString((int)myList.get(i).getData().getOpen()*1000));
                map.put("closeV"+(i+1),Integer.toString((int)myList.get(i).getData().getClose()*1000));
                map.put("numV"+(i+1),Integer.toString((int)Math.abs(temp)*1000000));}
            else {
                map.put("Vlink"+(i+1),"đứng giá");
                map.put("upV"+(i+1),"");
                map.put("levelV"+(i+1),"");
                map.put("openV"+(i+1),"");
                map.put("closeV"+(i+1),"");
                map.put("numV"+(i+1),"");
            }




            if(temp>=0 && temp1>=0){ map.put("statement","đang trên đà tăng"); }
            else if(temp>=0 && temp1<0){ map.put("statement","đang biến động"); }
            else if(temp<0 && temp1>=0){ map.put("statement","đang biến động"); }
            else if(temp<0 && temp1<0){ map.put("statement","đang trên đà giảm"); }
        }

        //sắp xếp theo change
        List<DataOutput> sortedListChange = sorting.sort(myList, 6);
        for(int i=0;i<sortedListChange.size();i++) {
            double temp = sortedListChange.get(i).getData().getClose()-sortedListChange.get(i).getData().getOpen();
            map.put("name" +(i+1), sortedListChange.get(i).getData().getName());
            if(temp>0){
                map.put("link"+(i+1),"tăng");
                map.put("up"+(i+1),"lên");
                map.put("num"+(i+1),Integer.toString((int)Math.abs(temp)*1000000));
                map.put("level"+(i+1),level(temp));
                map.put("open"+(i+1),Integer.toString((int)sortedListChange.get(i).getData().getOpen()));
                map.put("close"+(i+1),Integer.toString((int)sortedListChange.get(i).getData().getClose()));
            }
            else if(temp<0){
                map.put("link"+(i+1),"giảm");
                map.put("up"+(i+1),"xuống");
                map.put("num"+(i+1),Integer.toString((int)Math.abs(temp)*1000000));
                map.put("level"+(i+1),level(temp));
                map.put("open"+(i+1),Integer.toString((int)sortedListChange.get(i).getData().getOpen()));
                map.put("close"+(i+1),Integer.toString((int)sortedListChange.get(i).getData().getClose()));

            }else{
                map.put("link"+(i+1),"đứng giá");
                map.put("up"+(i+1),"");
                map.put("num"+(i+1),"");
                map.put("level"+(i+1),"");
                map.put("open"+(i+1),"");
                map.put("close"+(i+1),"");
            }
        }
        return map;
    }
}

//        ArrayList<DataInput> array = new ArrayList<>();
//        ArrayList<Rules> arr = new ArrayList<>();
//
//        //tìm các đối tượng có tên như dưới và đưa tất cả vào list arr;
//        array.add(filterByName(data,"VIC"));
//        array.add(filterByName(data,"VHM"));
//        array.add(filterByName(data,"VRE"));
//
//        for (int i=0;i<array.size();i++){
//            double tmp= array.get(i).getClose()-array.get(i).getOpen();
//            arr.add(new Rules(i,tmp,0));
//        }
//
//        for(int i=0;i<arr.size();i++) {
//            map.put("nameV" +(i+1), array.get(arr.get(i).getIndex()).getName());
//            map.put("numV"+(i+1),Double.toString(Math.abs(arr.get(i).getValueChange())*1000));
//
//            if(arr.get(i).getValueChange()>=0){
//                map.put("Vlink"+(i+1),"tăng");
//                map.put("upV"+(i+1),"lên");
//            }
//
//            else if(arr.get(i).getValueChange()<0){
//                map.put("Vlink"+(i+1),"giảm");
//                map.put("upV"+(i+1),"xuống");
//            }
//            map.put("level"+(i+1),level(arr.get(i).getValueChange()));
//            map.put("openV"+(i+1),Double.toString(array.get(i).getOpen()));
//            map.put("closeV"+(i+1),Double.toString(array.get(i).getClose()));
//            if(arr.get(0).getValueChange()>=0 && arr.get(1).getValueChange()>=0){ map.put("statement","đang trên đà tăng"); }
//            else if(arr.get(0).getValueChange()>=0 && arr.get(1).getValueChange()<0){ map.put("statement","đang biến động"); }
//            else if(arr.get(0).getValueChange()<0 && arr.get(1).getValueChange()>=0){ map.put("statement","đang biến động"); }
//            else if(arr.get(0).getValueChange()<0 && arr.get(1).getValueChange()<0){ map.put("statement","đang trên đà giảm"); }
//
//        }
//
//        return map;
//    }
//}
