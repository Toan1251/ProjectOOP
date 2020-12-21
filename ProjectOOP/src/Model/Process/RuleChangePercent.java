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

        for(int i=0;i<sortedList.size();i++) {
            map.put("name"+(i+1), sortedList.get(i).getData().getName());
            double percent = Math.abs(sortedList.get(i).getData().getChangePercent() * 100);
            map.put("percent"+(i+1), Double.toString((double) Math.round(percent * 1000) / 1000));
            map.put("begin"+(i+1), Long.toString((long) (sortedList.get(i).getData().getOpen() * 1000)));
            map.put("end"+(i+1), Long.toString((long) (sortedList.get(i).getData().getClose() * 1000)));
        }

        List<DataOutput> sortedReverseList = sorting.sort(data, 7, sortedList.size(), true);

        for(int j=0;j<sortedReverseList.size();j++) {
            map.put("rname"+(j+1), sortedReverseList.get(j).getData().getName());
            double rpercent = Math.abs(sortedReverseList.get(j).getData().getChangePercent() * 100);
            map.put("rpercent"+(j+1), Double.toString((double) Math.round(rpercent * 1000) / 1000));
            map.put("rbegin"+(j+1), Long.toString((long) (sortedReverseList.get(j).getData().getOpen() * 1000)));
            map.put("rend"+(j+1), Long.toString(((long) sortedReverseList.get(j).getData().getOpen() * 1000)));
        }


        return map;
    }
}

