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
        myList.add(filterByName(data, "BID"));
        myList.add(filterByName(data, "CTG"));
        myList.add(filterByName(data, "HDB"));
        myList.add(filterByName(data, "MBB"));
        myList.add(filterByName(data, "TCB"));
        myList.add(filterByName(data, "VCB"));
        myList.add(filterByName(data, "VPB"));
        myList.add(filterByName(data, "NVB"));
        myList.add(filterByName(data, "SHB"));
        myList.add(filterByName(data, "ACB"));
        myList.add(filterByName(data, "STB"));
        myList.add(filterByName(data, "LPB"));
        myList.add(filterByName(data, "EIB"));
        myList.add(filterByName(data, "TPB"));
        myList.add(filterByName(data, "VIB"));

        sorting.removeNull(myList);


        //sắp xếp theo change
        List<DataOutput> sortedListChange = sorting.sort(myList, 6);
        double total = 0.0;
        for (int i = 0; i < sortedListChange.size(); i++) {
            double temp = sortedListChange.get(i).getData().getClose() - sortedListChange.get(i).getData().getOpen();
            total += sortedListChange.get(i).getData().getVolume();

            map.put("nameBank" + (i + 1), sortedListChange.get(i).getData().getName());
            if (temp > 0) {
                map.put("Blink" + (i + 1), "tăng");
                map.put("numBank" + (i + 1), Long.toString((long) (Math.abs(temp) * 1000)));
                map.put("level" + (i + 1), level(temp));


            }
            if (temp < 0) {
                map.put("Blink" + (i + 1), "giảm");
                map.put("numBank" + (i + 1), Long.toString((long) (Math.abs(temp) * 1000)));
                map.put("level" + (i + 1), level(temp));


            } else {
                map.put("Blink" + (i + 1), "đứng giá");
                map.put("numBank" + (i + 1), Long.toString((long) (sortedListChange.get(i).getData().getOpen()*1000)));
                map.put("level" + (i + 1), "");
            }
        }

        //sắp xếp theo volume value
        List<DataOutput> sortedListVolume = sorting.sort(myList, 8);
        for (int i = 0; i < sortedListVolume.size(); i++) {
            map.put("BVname" + (i + 1), sortedListVolume.get(i).getData().getName());
            map.put("BVnum" + (i + 1), Long.toString((long) sortedListVolume.get(i).getData().getVolume()));
        }

        //tổng số cổ phiếu bán ra
        map.put("totalB", Long.toString((long) (total)));


        return map;

    }
}
