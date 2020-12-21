package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.SortData;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//nhóm top các cổ phiếu dầu khí
public class RulePetrol extends Rules {


    @Override
    public Map<String, String> PushInMap(List<DataOutput> data) {
        SortData sorting = new SortData();

        //tìm các đối tượng output tương ứng và add vào 1 list chung
        List<DataOutput> myList = new LinkedList<>();
        myList.add(filterByName(data, "ASP"));
        myList.add(filterByName(data, "PGC"));
        myList.add(filterByName(data, "PJT"));
        myList.add(filterByName(data, "PLX"));
        myList.add(filterByName(data, "PVD"));
        myList.add(filterByName(data, "PVT"));
        myList.add(filterByName(data, "PXS"));
        myList.add(filterByName(data, "APP"));
        myList.add(filterByName(data, "PCT"));
        myList.add(filterByName(data, "PGS"));
        myList.add(filterByName(data, "PLC"));
        myList.add(filterByName(data, "PVB"));
        myList.add(filterByName(data, "PVC"));
        myList.add(filterByName(data, "PVG"));
        myList.add(filterByName(data, "PVS"));
        myList.add(filterByName(data, "CNG"));
        myList.add(filterByName(data, "COM"));

        sorting.removeNull(myList);


        //sắp xếp theo change
        List<DataOutput> sortedListChange = sorting.sort(myList, 6);
        double total = 0.0;
        for (int i = 0; i < sortedListChange.size(); i++) {
            double temp = sortedListChange.get(i).getData().getClose() - sortedListChange.get(i).getData().getOpen();
            total += sortedListChange.get(i).getData().getVolume();
            map.put("namePetro" + (i + 1), sortedListChange.get(i).getData().getName());
            if (temp > 0) {
                map.put("Plink" + (i + 1), "tăng");
                map.put("numPetro" + (i + 1), Long.toString((long) (Math.abs(temp) * 1000)));
                map.put("level" + (i + 1), level(temp));

            }
            if (temp < 0) {
                map.put("Plink" + (i + 1), "giảm");
                map.put("numPetro" + (i + 1), Long.toString(((long) Math.abs(temp) * 1000)));
                map.put("level" + (i + 1), level(temp));

            } else {
                map.put("Plink" + (i + 1), "đứng giá");
                map.put("numPetro" + (i + 1), Long.toString((long)sortedListChange.get(i).getData().getOpen()*1000));
                map.put("level" + (i + 1), "");

            }
        }

        //sắp xếp theo volume value
        List<DataOutput> sortedListVolume = sorting.sort(myList, 8);
        for (int i = 0; i < sortedListVolume.size(); i++) {
            map.put("PVname" + (i + 1), sortedListVolume.get(i).getData().getName());
            map.put("PVnum" + (i + 1), Long.toString((long) sortedListVolume.get(i).getData().getVolume()));
        }

        //tổng số cổ phiếu bán ra
        map.put("totalP", Long.toString((long) total));

        //số  lần từng cổ phiếu so với tổng
        for (int i = 0; i < sortedListVolume.size(); i++) {
            double tmp = sortedListVolume.get(i).getData().getVolume() / total * 100;
            map.put("timeP" + (i + 1), Double.toString((double) Math.round(tmp * 1000) / 1000));
        }
        return map;

    }
}

