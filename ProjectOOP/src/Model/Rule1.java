package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
//
public class Rule1 extends Rules {

    //ArrayList này để chứa các đối tương Rules được tạo ra
    ArrayList<Rules> arr = new ArrayList<>();

    //hàm này dùng để tạo ra các đối tượng Rules và thêm nó vào trong ArrayList của lớp Rules
    public void  PushInArray(){
        //hiện tại tôi đang xem công thức nên cứ để tạm là A và B nhé.
        for (int i=0;i<(super.getData().size());++i){
            float tmp = super.getData().get(i).getA()-super.getData().get(i).getB();
            arr.add(new Rules(tmp,i));
        }
    }

    //Hàm này dùng để sắp xếp lại list và sau đó truyền các thông số vào map
    public Map<String,String> PushInMap(){
        PushInArray();
        int Tang=0;
        int Giam=0;
        int KhongDoi=0;
    //sắp xếp các đối tượng trong String arr theo thứ tự giảm dần về change
        Collections.sort(arr,new SortbyChange());
    //Cứ mỗi vòng lặp thì sẽ đếm được số tăng, giảm,không đổi.
        for (int j=0;j< arr.size();++j){
            if (arr.get(j).getChange()>0){
                Tang++;
            }
            else if(arr.get(j).getChange()<0){
                Giam++;
            }
            else {
                KhongDoi++;
            }
        }

        if((Tang/Giam)>1){
            map.put("code1","tăng");
            map.put("code2","giảm");
            map.put("solan",Integer.toString(Tang/Giam));
        }
        else if ((Tang/Giam)<1){
            map.put("code1","giảm");
            map.put("code2","tăng");
            map.put("solan",Integer.toString(Giam/Tang));
        }

    //truyền key và value tương ứng vào map.
        map.put("soLuongTang",Integer.toString(Tang));
        map.put("soLuongGiam",Integer.toString(Giam));
        map.put("soLuongKhongDoi",Integer.toString(KhongDoi));

        //phần tử đầu tiên của arr chứa index của phần tử tương ứng của data.
        map.put("tenCaoNhat",getData().get(arr.get(0).getIndex()).getName());
        map.put("tenThapNhat",getData().get(arr.get(arr.size()-1).getIndex()).getName());
        map.put("tong",Integer.toString(arr.size()));

        //điền tên và lượng thay đổi trong top tăng 5
        map.put("name1",getData().get(arr.get(0).getIndex()).getName());
        map.put("name2",getData().get(arr.get(1).getIndex()).getName());
        map.put("name3",getData().get(arr.get(2).getIndex()).getName());
        map.put("name4",getData().get(arr.get(3).getIndex()).getName());
        map.put("name5",getData().get(arr.get(4).getIndex()).getName());
        map.put("num1",Float.toString(arr.get(0).getChange()));
        map.put("num2",Float.toString(arr.get(1).getChange()));
        map.put("num3",Float.toString(arr.get(2).getChange()));
        map.put("num4",Float.toString(arr.get(3).getChange()));
        map.put("num5",Float.toString(arr.get(4).getChange()));

        //điền tên và lượng thay đổi trong top giảm 5
        map.put("rname1",getData().get(arr.get(arr.size()-1).getIndex()).getName());
        map.put("rname2",getData().get(arr.get(arr.size()-2).getIndex()).getName());
        map.put("rname3",getData().get(arr.get(arr.size()-3).getIndex()).getName());
        map.put("rname4",getData().get(arr.get(arr.size()-4).getIndex()).getName());
        map.put("rname5",getData().get(arr.get(arr.size()-5).getIndex()).getName());
        map.put("rnum1",Float.toString(arr.get(arr.size()-1).getChange()));
        map.put("rnum2",Float.toString(arr.get(arr.size()-2).getChange()));
        map.put("rnum3",Float.toString(arr.get(arr.size()-3).getChange()));
        map.put("rnum4",Float.toString(arr.get(arr.size()-4).getChange()));
        map.put("rnum5",Float.toString(arr.get(arr.size()-5).getChange()));


        return map;
    }

}
