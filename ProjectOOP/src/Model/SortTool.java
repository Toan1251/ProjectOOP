package Model;

import java.util.Comparator;

//hàm để so sánh các đối tượng theo mức thay đổi.
class SortbyChange implements Comparator<Rules> {
    @Override
    public int compare(Rules o1, Rules o2) {
        return (o1.getChange()).compareTo(o2.getChange());
    }
}


