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
        myList.add(filterByName(data, "VIC"));
        myList.add(filterByName(data, "VHM"));
        myList.add(filterByName(data, "VRE"));
//        //test
//        myList.add(filterByName(data,"C69"));

        sorting.removeNull(myList);

        //xử lí riêng câu 1
        for (int i = 0; i < myList.size(); i++) {
            double temp = myList.get(i).getData().getClose() - myList.get(i).getData().getOpen();
            map.put("nameV" + (i + 1), myList.get(i).getData().getName());

            if (temp > 0) {
                map.put("Vlink" + (i + 1), "tăng");
                map.put("upV" + (i + 1), "lên");
                map.put("levelV" + (i + 1), level(temp));
                map.put("openV" + (i + 1), Long.toString((long) (myList.get(i).getData().getOpen() * 1000)));
                map.put("closeV" + (i + 1), Long.toString((long) (myList.get(i).getData().getClose() * 1000)));
                map.put("numV" + (i + 1), Long.toString((long) (Math.abs(temp) * 1000)));
            } else if (temp < 0) {
                map.put("Vlink" + (i + 1), "giảm");
                map.put("upV" + (i + 1), "xuống");
                map.put("levelV" + (i + 1), level(temp));
                map.put("openV" + (i + 1), Long.toString((long) (myList.get(i).getData().getOpen() * 1000)));
                map.put("closeV" + (i + 1), Long.toString((long) (myList.get(i).getData().getClose() * 1000)));
                map.put("numV" + (i + 1), Long.toString((long) (Math.abs(temp) * 1000)));
            } else {
                map.put("Vlink" + (i + 1), "đứng giá");
                map.put("upV" + (i + 1), "");
                map.put("levelV" + (i + 1), "");
                map.put("openV" + (i + 1), "");
                map.put("closeV" + (i + 1), "");
                map.put("numV" + (i + 1), "");
            }
        }
        double temp1 = myList.get(0).getData().getClose() - myList.get(0).getData().getOpen();
        double temp2 = myList.get(1).getData().getClose() - myList.get(1).getData().getOpen();
        if (temp1 > 0 && temp2 > 0) {
            map.put("statement", "đang trên đà tăng");
        } else if (temp1 >= 0 && temp2 < 0) {
            map.put("statement", "đang biến động");
        } else if (temp1 < 0 && temp2 >= 0) {
            map.put("statement", "đang biến động");
        } else if (temp1 < 0 && temp2 < 0) {
            map.put("statement", "đang trên đà giảm");
        } else if (temp1 == 0 && temp2 == 0) {
            map.put("statement", "đang đứng giá");
        }

        //xử lí câu 2,3
        //sắp xếp theo change
        List<DataOutput> sortedListChange = sorting.sort(myList, 6);
        for (int i = 0; i < sortedListChange.size(); i++) {
            double temp = sortedListChange.get(i).getData().getClose() - sortedListChange.get(i).getData().getOpen();
            map.put("name" + (i + 1), sortedListChange.get(i).getData().getName());
            if (temp > 0) {
                map.put("link" + (i + 1), "tăng");
                map.put("up" + (i + 1), "lên");
                map.put("num" + (i + 1), Long.toString((long) (Math.abs(temp) * 1000)));
                map.put("level" + (i + 1), level(temp));
                map.put("open" + (i + 1), Long.toString((long) (sortedListChange.get(i).getData().getOpen() * 1000)));
                map.put("close" + (i + 1), Long.toString((long) (sortedListChange.get(i).getData().getClose() * 1000)));
            } else if (temp < 0) {
                map.put("link" + (i + 1), "giảm");
                map.put("up" + (i + 1), "xuống");
                map.put("num" + (i + 1), Long.toString((long) (Math.abs(temp) * 1000)));
                map.put("level" + (i + 1), level(temp));
                map.put("open" + (i + 1), Long.toString((long) (sortedListChange.get(i).getData().getOpen() * 1000)));
                map.put("close" + (i + 1), Long.toString((long) (sortedListChange.get(i).getData().getClose() * 1000)));

            } else {
                map.put("link" + (i + 1), "đứng giá");
                map.put("up" + (i + 1), "");
                map.put("num" + (i + 1), "");
                map.put("level" + (i + 1), "");
                map.put("open" + (i + 1), "");
                map.put("close" + (i + 1), "");
            }
        }
        return map;
    }
}