package ProjectOOP.src.Process;

import ProjectOOP.src.Model.DataFileInput;
import ProjectOOP.src.Model.DataInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Random;

public class RulePersonal extends Rules {

    //phương thức dùng để tìm ra đối tượng ngẫu nhiên sẽ dùng để so sánh.
    private final Random random = new Random();

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
        map.put("volume1",Double.toString(tmp.getVolume()));
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
            map.put("volume2",Double.toString(obj.getVolume()));
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
            map.put("volume2",Double.toString(obj.getVolume()));
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
            map.put("volume2",Double.toString(obj.getVolume()));
            sosanh(tmp,obj);
            level(tmp,obj);

        }

        else if (name.equals("HVN") || name.equals("VJC")){
            ArrayList<DataInput> demo=new ArrayList<DataInput>();//list chứa các đối tượng để random
            demo.add(filterByName(data,"HVN"));
            demo.add(filterByName(data,"VJC"));
            DataInput obj= randomOBJ(demo);
            map.put("nameSS",obj.getName()+"thuộc cùng nhóm hàng không");
            map.put("volume2",Double.toString(obj.getVolume()));
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
            map.put("volume2",Double.toString(obj.getVolume()));
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
            map.put("volume2",Double.toString(obj.getVolume()));
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
            map.put("volume2",Double.toString(obj.getVolume()));
            sosanh(tmp,obj);
            level(tmp,obj);

        }
        else {
            ArrayList<DataInput> demo=new ArrayList<DataInput>();//list chứa các đối tượng để random
            for (int i=0;i<data.size();i++){
                if(!(data.get(i).getName().equals("BID") || data.get(i).getName().equals("CTG") || data.get(i).getName().equals("HDB")
                   ||data.get(i).getName().equals("MBB") || data.get(i).getName().equals("TCB") || data.get(i).getName().equals("VCB")
                   ||data.get(i).getName().equals("VPB") || data.get(i).getName().equals("CTG") || data.get(i).getName().equals("ASP")
                   ||data.get(i).getName().equals("PGC") || data.get(i).getName().equals("PJT") || data.get(i).getName().equals("PLX")
                   ||data.get(i).getName().equals("PVD") || data.get(i).getName().equals("PVT") || data.get(i).getName().equals("PXS")
                   ||data.get(i).getName().equals("ANV") || data.get(i).getName().equals("IDI") || data.get(i).getName().equals("VHC")
                   ||data.get(i).getName().equals("TS4") || data.get(i).getName().equals("HVN") || data.get(i).getName().equals("VJC")
                   ||data.get(i).getName().equals("DRC") || data.get(i).getName().equals("DPR") || data.get(i).getName().equals("TRC")
                   ||data.get(i).getName().equals("HRC") || data.get(i).getName().equals("TRC") || data.get(i).getName().equals("CSM")
                   ||data.get(i).getName().equals("NKG") || data.get(i).getName().equals("TLH") || data.get(i).getName().equals("POM")
                   ||data.get(i).getName().equals("MWG") || data.get(i).getName().equals("PET") || data.get(i).getName().equals("BVG")
                   ||data.get(i).getName().equals("HPG") || data.get(i).getName().equals("HSG") || data.get(i).getName().equals("SMC")
                   ||data.get(i).getName().equals("VIC") || data.get(i).getName().equals("VHM") || data.get(i).getName().equals("VRE")
                   ||data.get(i).getName().equals("^AEX")|| data.get(i).getName().equals("^AORD")||data.get(i).getName().equals("^ATX")
                   ||data.get(i).getName().equals("^BDS")|| data.get(i).getName().equals("^BFX") ||data.get(i).getName().equals("^BSESN")
                   ||data.get(i).getName().equals("^CAOSU")||data.get(i).getName().equals("^CK") ||data.get(i).getName().equals("^CONGNGHE")
                   ||data.get(i).getName().equals("^DAUKHI")||data.get(i).getName().equals("^DICHVU")||data.get(i).getName().equals("^DJI")
                   ||data.get(i).getName().equals("^DTPT")||data.get(i).getName().equals("^DTXD")||data.get(i).getName().equals("^DUOCPHAM")
                   ||data.get(i).getName().equals("^FCHI")||data.get(i).getName().equals("^FTSE")||data.get(i).getName().equals("^GDAXI")
                   ||data.get(i).getName().equals("^GIAODUC")||data.get(i).getName().equals("^GSPC") ||data.get(i).getName().equals("^HASTC")
                   ||data.get(i).getName().equals("^HK")||data.get(i).getName().equals("^HNX30")||data.get(i).getName().equals("^HSI")
                   ||data.get(i).getName().equals("^IXIC")||data.get(i).getName().equals("^JKSE")||data.get(i).getName().equals("^KHOANGSAN")
                   ||data.get(i).getName().equals("^KLSE")||data.get(i).getName().equals("^KS11")||data.get(i).getName().equals("^LARGECAP")
                   ||data.get(i).getName().equals("^MIDCAP")||data.get(i).getName().equals("^N255")||data.get(i).getName().equals("^NANGLUONG")
                   ||data.get(i).getName().equals("^NGANHANG")||data.get(i).getName().equals("^NHUA")||data.get(i).getName().equals("^NYA")
                   ||data.get(i).getName().equals("^NZ50")||data.get(i).getName().equals("^OMXSPI")||data.get(i).getName().equals("OSEAX")
                   ||data.get(i).getName().equals("^PHANBON")||data.get(i).getName().equals("^SMALLCAP")||data.get(i).getName().equals("^SSMI")
                   ||data.get(i).getName().equals("^STI")||data.get(i).getName().equals("^SKXD")||data.get(i).getName().equals("^THEP")
                   ||data.get(i).getName().equals("^THUCPHAM")||data.get(i).getName().equals("^THUONGMAI")||data.get(i).getName().equals("^THUYSAN")
                   ||data.get(i).getName().equals("^TWII")||data.get(i).getName().equals("^UPCOM")||data.get(i).getName().equals("^VANTAI")
                   ||data.get(i).getName().equals("^VLXD")||data.get(i).getName().equals("^VN30")||data.get(i).getName().equals("^VNINDEX")
                   ||data.get(i).getName().equals("^XAYDUNG")))

                {
                    demo.add(data.get(i));
                }
            }
            DataInput obj= filterByName(demo,name);
            map.put("nameSS",obj.getName());
            map.put("volume2",Double.toString(obj.getVolume()));
            sosanh(tmp,obj);
            level(tmp,obj);

        }
        return map;
    }
}
