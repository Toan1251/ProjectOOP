package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.SortData;

import java.util.List;
import java.util.Map;

//
public class RuleChange extends Rules {
    @Override
    public Map<String, String> PushInMap(List<DataOutput> data) {
        SortData sorting = new SortData();
        List<DataOutput> sortedList = sorting.sort(data, 6);
        int tang = 0;
        int giam = 0;
        int dunggia = 0;
        int tangtran = 0;
        int giamsan = 0;
        for (DataOutput dataOutput : sortedList) {
            double temp = dataOutput.getData().getClose() - dataOutput.getData().getOpen();
            if (temp > 0) {
                tang++;
            } else if (temp < 0) {
                giam++;
            } else {
                dunggia++;
            }

            if (dataOutput.getData().getChangePercent() >= 7) {
                tangtran++;
            }
            if (dataOutput.getData().getChangePercent() <= -7) {
                giamsan++;
            }

        }

        if ((tang / giam) > 1) {
            map.put("code1", "tăng");
            map.put("code2", "giảm");
            map.put("solan", Integer.toString(tang / giam));
            map.put("soLuong1", Integer.toString(tang));
            map.put("soLuong2", Integer.toString(giam));
        } else if ((tang / giam) < 1) {
            map.put("code1", "giảm");
            map.put("code2", "tăng");
            map.put("solan", Integer.toString(giam / tang));
            map.put("soLuong1", Integer.toString(giam));
            map.put("soLuong2", Integer.toString(tang));
        }

        map.put("soLuongTang", Integer.toString(tang));
        map.put("soLuongGiam", Integer.toString(giam));
        map.put("soLuongKhongDoi", Integer.toString(dunggia));
        map.put("tangtran", Integer.toString(tangtran));
        map.put("giamsan", Integer.toString(giamsan));

        //phần tử đầu tiên của arr chứa index của phần tử tương ứng của data.
        map.put("tenCaoNhat", sortedList.get(0).getData().getName());
        map.put("tenThapNhat", sortedList.get(sortedList.size() - 1).getData().getName());
        map.put("tong", Integer.toString(sortedList.size()));

        //điền tên và lượng thay đổi trong top tăng 5
        for (int i = 0; i < sortedList.size(); i++) {
            double temp = sortedList.get(i).getData().getClose() - sortedList.get(i).getData().getOpen();
            map.put("name" + (i + 1), sortedList.get(i).getData().getName());
            map.put("num" + (i + 1), Long.toString((long) (Math.abs(temp) * 1000)));
        }

        List<DataOutput> sortedReverseList = sorting.sort(data, 6, sortedList.size(), true);
        for (int i = 0; i < sortedReverseList.size(); i++) {
            double temp = sortedReverseList.get(i).getData().getClose() - sortedReverseList.get(i).getData().getOpen();
            map.put("rname" + (i + 1), sortedReverseList.get(i).getData().getName());
            map.put("rnum1", Long.toString((long) ((Math.abs(temp)) * 1000)));

        }

        return map;
    }
}
