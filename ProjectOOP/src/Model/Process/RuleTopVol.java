package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataOutput;
import ProjectOOP.src.Model.Handle.SortData;

import java.util.List;
import java.util.Map;

public class RuleTopVol extends Rules {

    @Override
    public Map<String, String> PushInMap(List<DataOutput> data) {
        SortData sorting = new SortData();
        List<DataOutput> sortedListVol = sorting.sort(data, 1);
        for (int i = 0; i < 3; i++) {
            map.put("vol" + (i + 1), sortedListVol.get(i).getData().getName());
            map.put("v" + (i + 1), Long.toString((long) sortedListVol.get(i).getData().getVolume()));
        }

        List<DataOutput> sortedListVolValue = sorting.sort(data, 8);
        map.put("rvol", sortedListVolValue.get(0).getData().getName());
        map.put("rv", Long.toString((long) sortedListVolValue.get(0).getData().getVolumeValue()));
        return map;
    }
}
