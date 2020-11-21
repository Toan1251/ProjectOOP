package Process;

import Model.CsvParser;
import Model.DataInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Rule2 extends Rules {

    @Override
    public Map<String, String> PushInMap(ArrayList<DataInput> data) {
        //dùng để truyền giá trị cho thuộc tính của đối tượng và đưa đối tượng vào list.
        ArrayList<Rules> arr = new ArrayList<>();
        for (int i=0;i<(data.size());++i){
            double temp=(double) Math.round(((data.get(i).getClose())/(data.get(i).getOpen())-1)*10000)/100;
            arr.add(new Rules(i,temp));
        }

        Collections.sort(arr,new SortByPercent());
        map.put("tong",Integer.toString(arr.size()));
        map.put("name",data.get(arr.get(0).getIndex()).getName());
        map.put("percent",Double.toString(arr.get(0).getPercentChange()));
        map.put("begin",Double.toString(data.get(0).getOpen()));
        map.put("end",Double.toString(data.get(0).getClose()));

        Collections.sort(arr,new SortByReversePercent());
        map.put("rname",data.get(arr.get(0).getIndex()).getName());
        map.put("rpercent",Double.toString(Math.abs(arr.get(0).getPercentChange())));
        map.put("rbegin",Double.toString(data.get(0).getOpen()*1000));
        map.put("rend",Double.toString(data.get(0).getClose()*1000));


        return map;

    }
}
