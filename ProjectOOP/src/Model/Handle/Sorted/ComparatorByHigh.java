package ProjectOOP.src.Model.Handle.Sorted;

import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.Comparator;

public class ComparatorByHigh implements Comparator<DataOutput> {

    @Override
    public int compare(DataOutput d1, DataOutput d2) {

        return Double.compare(d2.getData().getHigh(), d1.getData().getHigh());
    }
}
