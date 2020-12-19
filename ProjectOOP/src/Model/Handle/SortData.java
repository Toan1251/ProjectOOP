package ProjectOOP.src.Model.Handle;

import ProjectOOP.src.Model.Handle.Sorted.*;

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
        List<DataOutput> sortedList = new LinkedList<>(data);
        //Sort Data theo thứ tự giảm dần dựa trên các thuộc tính
        
        if(attribute==VOLUME){
        	sortedList.sort(new ComparatorByVolume());
        }
        else if(attribute==OPEN){
        	sortedList.sort(new ComparatorByOpen());
        }
        else if(attribute==CLOSE){
        	sortedList.sort(new ComparatorByClose());
        }
        else if(attribute==HIGH){
        	sortedList.sort(new ComparatorByHigh());
        }
        else if(attribute==LOW){
        	sortedList.sort(new ComparatorByLow());
        }
        else if(attribute==CHANGE){
        	sortedList.sort(new ComparatorByChange());
        }
        else if(attribute==CHANGE_PERCENT){
        	sortedList.sort(new ComparatorByChangePercent());
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
