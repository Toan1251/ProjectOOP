package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.SortData;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//nhóm top các cổ phiếu cao su
public class RuleRubber extends Rules {


    @Override
    public Map<String, String> PushInMap(List<DataOutput> data) {
        SortData sorting = new SortData();

        //tìm các đối tượng output tương ứng và add vào 1 list chung
        List<DataOutput> myList = new LinkedList<>();
        myList.add(filterByName(data, "DRC"));
        myList.add(filterByName(data, "DPR"));
        myList.add(filterByName(data, "TNC"));
        myList.add(filterByName(data, "HRC"));
        myList.add(filterByName(data, "TRC"));
        myList.add(filterByName(data, "CSM"));
        sorting.removeNull(myList);

        //sắp xếp theo change
        List<DataOutput> sortedListChange = sorting.sort(myList, 6);
        double total = 0.0;
        for (int i = 0; i < sortedListChange.size(); i++) {
            double temp = sortedListChange.get(i).getData().getClose() - sortedListChange.get(i).getData().getOpen();
            total += sortedListChange.get(i).getData().getVolume();
            map.put("nameC" + (i + 1), sortedListChange.get(i).getData().getName());
            if (temp > 0) {
                map.put("Clink" + (i + 1), "tăng");
                map.put("numC" + (i + 1), Long.toString((long) (Math.abs(temp) * 1000)));
                map.put("level" + (i + 1), level(temp));


            }
            if (temp < 0) {
                map.put("Clink" + (i + 1), "giảm");
                map.put("numC" + (i + 1), Long.toString((long) (Math.abs(temp) * 1000)));
                map.put("level" + (i + 1), level(temp));


            } else {
                map.put("Clink" + (i + 1), "đứng giá");
                map.put("numC" + (i + 1), Long.toString((long)sortedListChange.get(i).getData().getOpen()*1000));
                map.put("level" + (i + 1), "");


            }
        }

        //sắp xếp theo volume value
        List<DataOutput> sortedListVolume = sorting.sort(myList, 8);
        for (int i = 0; i < sortedListVolume.size(); i++) {
            map.put("CVname" + (i + 1), sortedListVolume.get(i).getData().getName());
            map.put("CVnum" + (i + 1), Long.toString((long) sortedListVolume.get(i).getData().getVolume()));
        }

        //tổng số cổ phiếu bán ra
        map.put("totalC", Long.toString((long) total));

        //số  lần từng cổ phiếu so với tổng
        for (int i = 0; i < myList.size(); i++) {
            double temp = myList.get(i).getData().getVolume() / total * 100;
            map.put("timeC" + (i + 1), Double.toString((double) Math.round(temp * 1000) / 1000));
        }
        return map;
    }
}