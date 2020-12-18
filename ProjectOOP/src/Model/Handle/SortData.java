package ProjectOOP.src.Model.Handle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortData {

    public static final int VOLUME=1;
    public static final int OPEN=2;
    public static final int CLOSE=3;
    public static final int HIGH=4;
    public static final int LOW=5;
    public static final int CHANGE=6;
    public static final int CHANGE_PERCENT=7;
    public static final int MAX_FIELD = 7;

    public SortData() {

    }

    //isAscending: Thứ tự giảm dần

    public List<DataOutput> sort(List<DataOutput> data, int attribute){
        List<DataOutput> sortedList = new ArrayList<>(data);
        //Sort Data theo thứ tự giảm dần dựa trên các thuộc tính
        if(attribute==VOLUME){
            sortedList.sort((d1, d2) -> d1.getData().getVolume() < d2.getData().getVolume() ? 1 : -1);
        }
        else if(attribute==OPEN){
            sortedList.sort((d1, d2) -> d1.getData().getOpen() < d2.getData().getOpen() ? 1 : -1);
        }
        else if(attribute==CLOSE){
            sortedList.sort((d1, d2) -> d1.getData().getClose() < d2.getData().getClose() ? 1 : -1);
        }
        else if(attribute==HIGH){
            sortedList.sort((d1, d2) -> d1.getData().getHigh() < d2.getData().getHigh() ? 1 : -1);
        }
        else if(attribute==LOW){
            sortedList.sort((d1, d2) -> d1.getData().getLow() < d2.getData().getLow() ? 1 : -1);
        }
        else if(attribute==CHANGE){
            sortedList.sort((d1, d2) -> d1.getData().getChange() < d2.getData().getChange() ? 1 : -1);
        }
        else if(attribute==CHANGE_PERCENT){
            sortedList.sort((d1, d2) -> d1.getData().getChangePercent() < d2.getData().getChangePercent() ? 1 : -1);
        }
        return sortedList;
    }

    public List<DataOutput> sort(List<DataOutput> data, int attribute ,int numOfElement, boolean isAscending){
        List<DataOutput> sortedList = sort(data, attribute);
        if(isAscending){
            Collections.reverse(sortedList);
        }
        List<DataOutput> finalList = new LinkedList<DataOutput>();
        for(int i = 0; i < numOfElement; i++){
            finalList.add(sortedList.get(i));
        }
        return finalList;
    }
}
