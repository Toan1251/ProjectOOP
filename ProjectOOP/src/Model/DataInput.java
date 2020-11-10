package Model;

public class DataInput {
    private String name;
    private String ID;
    /*
    Todo : Thêm các thuộc tính, các hàm get, set thuộc tính, các hàm tính giá trị đặc trưng cho thuộc tính
    Todo : Bổ sung contructor khi đã thêm các thuộc tính
    */
    public DataInput() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataInput)) return false;

        DataInput dataInput = (DataInput) o;

        if (getName() != null ? !getName().equals(dataInput.getName()) : dataInput.getName() != null) return false;
        return getID().equals(dataInput.getID());
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getID().hashCode();
        return result;
    }
}
