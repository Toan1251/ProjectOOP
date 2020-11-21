package Process;

import Model.DataInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
//
public class Rule1 extends Rules {
    @Override
    public Map<String, String> PushInMap(ArrayList<DataInput> data) {
        //ArrayList này để chứa các đối tương Rules được tạo ra
        ArrayList<Rules> arr = new ArrayList<>();

        //hàm này dùng để tạo ra các đối tượng Rules và thêm nó vào trong ArrayList của lớp Rules

            //phương thức dùng để truyền giá trị cho thuộc tính của đối tượng và đưa đối tượng vào list.
            for (int i=0;i<(data.size());i++){
                double tmp = data.get(i).getClose()-data.get(i).getOpen();
                double temp=(double) Math.round(((data.get(i).getClose())/(data.get(i).getOpen())-1)*10000)/100;
                arr.add(new Rules(i,tmp,temp));
            }
    //Hàm này dùng để sắp xếp lại list và sau đó truyền các thông số vào map

        int Tang=0;
        int Giam=0;
        int KhongDoi=0;
        int TangTran=0;
        int GiamSan=0;
        //sắp xếp các đối tượng trong String arr theo thứ tự giảm dần về change
        Collections.sort(arr,new SortByChange());
        //Cứ mỗi vòng lặp thì sẽ đếm được số tăng, giảm,không đổi.
        for (int j=0;j< arr.size();j++){
            if (arr.get(j).getValueChange()>0){
                Tang++;
            }
            else if(arr.get(j).getValueChange()<0){
                Giam++;
            }
            else {
                KhongDoi++;
            }

            if (Math.round(arr.get(j).getPercentChange()) ==7 ){ TangTran++;}
            else if (Math.round(arr.get(j).getPercentChange()) ==-7){GiamSan++;}


        }

        if((Tang/Giam)>1){
            map.put("code1","tăng");
            map.put("code2","giảm");
            map.put("solan",Integer.toString(Tang/Giam));
            map.put("soLuong1",Integer.toString(Tang));
            map.put("soLuong2",Integer.toString(Giam));
        }
        else if ((Tang/Giam)<1){
            map.put("code1","giảm");
            map.put("code2","tăng");
            map.put("solan",Integer.toString(Giam/Tang));
            map.put("soLuong1",Integer.toString(Giam));
            map.put("soLuong2",Integer.toString(Tang));
        }

        //truyền key và value tương ứng vào map.
        map.put("soLuongTang",Integer.toString(Tang));
        map.put("soLuongGiam",Integer.toString(Giam));
        map.put("soLuongKhongDoi",Integer.toString(KhongDoi));
        map.put("tangtran",Integer.toString(TangTran));
        map.put("giamsan",Integer.toString(GiamSan));


        //phần tử đầu tiên của arr chứa index của phần tử tương ứng của data.
        map.put("tenCaoNhat",data.get(arr.get(0).getIndex()).getName());
        map.put("tenThapNhat",data.get(arr.get(arr.size()-1).getIndex()).getName());
        map.put("tong",Integer.toString(arr.size()));

        //điền tên và lượng thay đổi trong top tăng 5
        for(int i=0;i<arr.size();i++) {
            map.put("name"+(i+1), data.get(arr.get(i).getIndex()).getName());
            map.put("num"+(i+1), Double.toString(arr.get(0).getValueChange() * 1000));
        }

        Collections.sort(arr,new SortByReverseChange());
        //điền tên và lượng thay đổi trong top giảm 5
        for(int i=0;i<arr.size();i++) {
            map.put("rname"+(i+1), data.get(arr.get(i).getIndex()).getName());
            map.put("rnum1", Double.toString((Math.abs(arr.get(i).getValueChange())) * 1000));

        }


        return map;
    }

}
