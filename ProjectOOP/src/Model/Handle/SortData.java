package ProjectOOP.src.Model.Handle;

import ProjectOOP.src.Model.Handle.Sorted.*;

import java.util.*;

public class SortData {

    public static final int VOLUME=1;
    public static final int OPEN=2;
    public static final int CLOSE=3;
    public static final int HIGH=4;
    public static final int LOW=5;
    public static final int CHANGE=6;
    public static final int CHANGE_PERCENT=7;
    public static final int VOLUME_VALUE=8;
    public static final int MAX_FIELD = 8;

    public SortData() {

    }

    //isAscending: Thứ tự tăng dần
    //Loại bỏ mọi phần tử null trong danh sách đã được sắp xếp

    public List<DataOutput> sort(List<DataOutput> data, int attribute){
        List<DataOutput> sortedList = new LinkedList<>(data);
        List<DataOutput> nullList = new LinkedList<>();

        nullList.add(null);
        sortedList.removeAll(nullList);

        //Sort Data theo thứ tự giảm dần dựa trên các thuộc tính
        if(attribute==VOLUME){
            //sortedList.sort(new ComparatorByVolume());
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
        else if(attribute==VOLUME_VALUE){
            sortedList.sort(new ComparatorByVolumeValue());
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

    public void removeNull(List l){
        List<Object> nullList = new LinkedList<>();
        nullList.add(null);
        l.removeAll(nullList);
    }
}