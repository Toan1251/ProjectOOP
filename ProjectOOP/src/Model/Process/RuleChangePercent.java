package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.SortData;

import java.util.List;
import java.util.Map;

public class RuleChangePercent extends Rules {

    @Override
    public Map<String, String> PushInMap(List<DataOutput> data) {
        SortData sorting = new SortData();
        List<DataOutput> sortedList = sorting.sort(data, 7);
        map.put("tong", Integer.toString(sortedList.size()));
        map.put("name", sortedList.get(0).getData().getName());
        double percent = Math.abs(sortedList.get(0).getData().getChangePercent() * 100);
        map.put("percent", Double.toString((double) Math.round(percent * 1000) / 1000));
        map.put("begin", Long.toString((long) (sortedList.get(0).getData().getOpen() * 1000)));
        map.put("end", Long.toString((long) (sortedList.get(0).getData().getClose() * 1000)));

        List<DataOutput> sortedReverseList = sorting.sort(data, 7, sortedList.size(), true);
        map.put("rname", sortedReverseList.get(0).getData().getName());
        double rpercent = Math.abs(sortedReverseList.get(0).getData().getChangePercent() * 100);
        map.put("rpercent", Double.toString((double) Math.round(rpercent * 1000) / 1000));
        map.put("rbegin", Long.toString((long) (sortedReverseList.get(0).getData().getOpen() * 1000)));
        map.put("rend", Long.toString(((long) sortedReverseList.get(0).getData().getOpen() * 1000)));


        return map;
    }
}

