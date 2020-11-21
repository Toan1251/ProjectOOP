package Process;

import Model.DataInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Random;

public class RulePersonal extends Rules {

    //phương thức dùng để tìm ra đối tượng ngẫu nhiên sẽ dùng để so sánh.
    private Random random = new Random();

    private DataInput randomOBJ(ArrayList<DataInput> data){
        int index = random.nextInt(data.size());
        return data.get(index);
    }

    private double dauhieu(DataInput obj ){
        double result = (double) (obj.getHigh()+obj.getLow())/2*(obj.getVolume()); //đã chia 1000
        return result;
    }

    //thay thế cho compare (so sánh)
    private void sosanh(DataInput a,DataInput b){

        if(dauhieu(a)>dauhieu(b)){
            map.put("compare","nhiều hơn");}
        else if (dauhieu(a)<dauhieu(b)){
            map.put("compare","ít hơn");
        }
        else {
            map.put("compare","bằng nhau");
        }
    }

    //thay thế cho levelSS (nói về mức độ chênh lệch)
    private void level(DataInput a,DataInput b){

        if(dauhieu(a)-dauhieu(b)<=1000000){
            map.put("levelSS","một chút");}
        else if ((dauhieu(a)-dauhieu(b))>1000000 && (dauhieu(a)-dauhieu(b))<5000000){
            map.put("levelSS","khá nhiều");
        }
        else {
            map.put("levelSS","rất nhiều");
        }
    }


    public Map<String, String> PushInMap(ArrayList<DataInput> data,String name) {

        //tìm kiếm đối tượng có tên muốn tìm và trả về đối tượng đó.
        //tạo tmp y hệt đối tượng tìm được.
        DataInput tmp = data.stream().filter(x->x.getName().equals(name)).findAny().orElse(null);

        //tạo kiểu hiển thị ngày tháng năm (pattern)
        //như ở dưới là day/month/year.
        String pattern ="dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        //change có giá trị bằng độ chênh lệch của giá trị cổ phiếu.
        double change=tmp.getClose()-tmp.getOpen();
        double percent=Math.abs ((double) Math.round((((tmp.getClose())*1000)/((tmp.getOpen())*1000)-1)*10000)/100);

        //lấy tỉ lệ % tăng hoặc giảm


        //truyền vào các cặp key và value tương ứng.
        map.put("name",tmp.getName());
        map.put("date",dateFormat.format(tmp.getDate()));
        map.put("numOpen",Double.toString(tmp.getOpen()*1000));
        map.put("numHigh",Double.toString(tmp.getHigh()*1000));
        map.put("numClose",Double.toString(tmp.getClose()*1000));
        map.put("percent",Double.toString(percent));
        map.put("volume1",Integer.toString(tmp.getVolume()));
        map.put("gtgd",Double.toString(dauhieu(tmp)/1000000));//tỉ đồng

        //thay thế chỗ dấu hiệu dựa vào lượng gtgd.
        if(dauhieu(tmp)>=8000000){map.put("dau hieu","rất khả quan");}// đã chia 1000, giá trị thực phải *1000;
        else if(5000000<dauhieu(tmp) &&dauhieu(tmp)<8000000){map.put("dau hieu","khá khả quan");}
        else {map.put("dau hieu","không mấy khả quan");}


        //nói về tình trạng cổ phiếu
        if (change>0){map.put("link","tăng");}
        else if(change<0){map.put("link","giảm");}
        else if(change ==0 && (tmp.getOpen()==tmp.getHigh() || tmp.getOpen()==tmp.getLow())){map.put("link","đứng giá");}
        else map.put("link","biến động");

        //nói về mức độ
        map.put("level",level(change));

        //nếu obj cần tìm thuộc nhóm ngân hàng
        if (name.equals("BID") || name.equals("CTG") || name.equals("HDB") || name.equals("MBB") || name.equals("TCB")
            || name.equals("VCB") || name.equals("VPB")){
            ArrayList<DataInput> demo=new ArrayList<DataInput>();//list chứa các đối tượng để random
            demo.add(filterByName(data,"BID"));
            demo.add(filterByName(data,"CTG"));
            demo.add(filterByName(data,"HDB"));
            demo.add(filterByName(data,"MBB"));
            demo.add(filterByName(data,"TCB"));
            demo.add(filterByName(data,"VCB"));
            demo.add(filterByName(data,"VPB"));
            DataInput obj= randomOBJ(demo);
            map.put("nameSS",obj.getName()+"thuộc cùng nhóm ngân hàng");
            map.put("volume2",Integer.toString(obj.getVolume()));
            sosanh(tmp,obj);
            level(tmp,obj);

        }

        else if (name.equals("ASP") || name.equals("PGC") || name.equals("PJT") || name.equals("PLX") || name.equals("PVD")
                || name.equals("PVT") || name.equals("PXS")){
            ArrayList<DataInput> demo=new ArrayList<DataInput>();//list chứa các đối tượng để random
            demo.add(filterByName(data,"ASP"));
            demo.add(filterByName(data,"PGC"));
            demo.add(filterByName(data,"PJT"));
            demo.add(filterByName(data,"PLX"));
            demo.add(filterByName(data,"PVD"));
            demo.add(filterByName(data,"PVT"));
            demo.add(filterByName(data,"PXS"));
            DataInput obj= randomOBJ(demo);
            map.put("nameSS",obj.getName()+"thuộc cùng nhóm dầu khí");
            map.put("volume2",Integer.toString(obj.getVolume()));
            sosanh(tmp,obj);
            level(tmp,obj);

        }

        else if (name.equals("ANV") || name.equals("IDI") || name.equals("VHC") || name.equals("TS4")){
            ArrayList<DataInput> demo=new ArrayList<DataInput>();//list chứa các đối tượng để random
            demo.add(filterByName(data,"ANV"));
            demo.add(filterByName(data,"IDI"));
            demo.add(filterByName(data,"VHC"));
            demo.add(filterByName(data,"TS4"));
            DataInput obj= randomOBJ(demo);
            map.put("nameSS",obj.getName()+"thuộc cùng nhóm thuỷ sản");
            map.put("volume2",Integer.toString(obj.getVolume()));
            sosanh(tmp,obj);
            level(tmp,obj);

        }

        else if (name.equals("HVN") || name.equals("VJC")){
            ArrayList<DataInput> demo=new ArrayList<DataInput>();//list chứa các đối tượng để random
            demo.add(filterByName(data,"HVN"));
            demo.add(filterByName(data,"VJC"));
            DataInput obj= randomOBJ(demo);
            map.put("nameSS",obj.getName()+"thuộc cùng nhóm hàng không");
            map.put("volume2",Integer.toString(obj.getVolume()));
            sosanh(tmp,obj);
            level(tmp,obj);

        }

        else if (name.equals("DRC") || name.equals("DPR") || name.equals("TNC") || name.equals("HRC") || name.equals("TRC")
                || name.equals("CSM")){
            ArrayList<DataInput> demo=new ArrayList<DataInput>();//list chứa các đối tượng để random
            demo.add(filterByName(data,"DRC"));
            demo.add(filterByName(data,"DPR"));
            demo.add(filterByName(data,"TNC"));
            demo.add(filterByName(data,"HRC"));
            demo.add(filterByName(data,"TRC"));
            demo.add(filterByName(data,"CSM"));
            DataInput obj= randomOBJ(demo);
            map.put("nameSS",obj.getName()+"thuộc cùng nhóm cao su");
            map.put("volume2",Integer.toString(obj.getVolume()));
            sosanh(tmp,obj);
            level(tmp,obj);

        }

        else if (name.equals("NKG") || name.equals("TLH") || name.equals("POM") || name.equals("MWG") || name.equals("PET")
                || name.equals("BVG") || name.equals("HPG")|| name.equals("HSG") || name.equals("SMC")){
            ArrayList<DataInput> demo=new ArrayList<DataInput>();//list chứa các đối tượng để random
            demo.add(filterByName(data,"NKG"));
            demo.add(filterByName(data,"TLH"));
            demo.add(filterByName(data,"POM"));
            demo.add(filterByName(data,"MWG"));
            demo.add(filterByName(data,"PET"));
            demo.add(filterByName(data,"BVG"));
            demo.add(filterByName(data,"HPG"));
            demo.add(filterByName(data,"HSG"));
            demo.add(filterByName(data,"SMC"));
            DataInput obj= randomOBJ(demo);
            map.put("nameSS",obj.getName()+"thuộc cùng nhóm thép");
            map.put("volume2",Integer.toString(obj.getVolume()));
            sosanh(tmp,obj);
            level(tmp,obj);

        }

        else if (name.equals("VIC") || name.equals("VHM") || name.equals("VRE")){
            ArrayList<DataInput> demo=new ArrayList<DataInput>();//list chứa các đối tượng để random
            demo.add(filterByName(data,"VIC"));
            demo.add(filterByName(data,"VHM"));
            demo.add(filterByName(data,"VRE"));
            DataInput obj= randomOBJ(demo);
            map.put("nameSS",obj.getName()+"thuộc cùng nhóm họ Vin ");
            map.put("volume2",Integer.toString(obj.getVolume()));
            sosanh(tmp,obj);
            level(tmp,obj);

        }
        else {
            DataInput obj= filterByName(data,name);
            map.put("nameSS",obj.getName());
            map.put("volume2",Integer.toString(obj.getVolume()));
            sosanh(tmp,obj);
            level(tmp,obj);

        }
        return map;
    }
}
