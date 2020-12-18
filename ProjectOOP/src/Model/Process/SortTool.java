package ProjectOOP.src.Model.Process;

import ProjectOOP.src.Model.Handle.DataInput;

import java.util.Comparator;

//hàm để so sánh các đối tượng theo mức thay đổi.
class SortByChange implements Comparator<Rules> {
    @Override
    public int compare(Rules o1, Rules o2) {
        return ((Double)o1.getValueChange()).compareTo(o2.getValueChange());
    }
}

class SortByReverseChange implements Comparator<Rules> {
    @Override
    public int compare(Rules o1, Rules o2) {
        return ((Double)o2.getValueChange()).compareTo(o1.getValueChange());
    }
}

class SortByPercent implements Comparator<Rules> {
    @Override
    public int compare(Rules o1, Rules o2) {
        return ((Double)o1.getPercentChange()).compareTo(o2.getPercentChange());
    }
}

class SortByReversePercent implements Comparator<Rules> {
    @Override
    public int compare(Rules o1, Rules o2) {
        return ((Double)o2.getPercentChange()).compareTo(o1.getPercentChange());
    }
}

class SortByVolume implements Comparator<Rules> {
    @Override
    public int compare(Rules o1, Rules o2) {
        return ((Double)o1.getVolume()).compareTo(o2.getVolume());
    }
}

class SortByVolumeValue implements Comparator<Rules> {
    @Override
    public int compare(Rules o1, Rules o2) {
        return ((Double)o1.getVolumeValue()).compareTo(o2.getVolumeValue());
    }
}

class DataSortByVolumeValue implements Comparator<DataInput> {
    @Override
    public int compare(DataInput o1, DataInput o2) {
        return ((Double)o1.getVolume()).compareTo(o2.getVolume());
    }
}













