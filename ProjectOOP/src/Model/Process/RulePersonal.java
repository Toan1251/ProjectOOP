package ProjectOOP.src.Model.Process;
import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Random;

public class RulePersonal extends Rules {

    //phương thức dùng để tìm ra đối tượng ngẫu nhiên sẽ dùng để so sánh.
    private Random random = new Random();

    //tìm đối tượng ngẫu nhiên trong 1 list các dataoutput và trả về 1 dataoutput
    private DataOutput randomOBJ(List<DataOutput> data){
        int index = random.nextInt(data.size());
        return data.get(index);
    }

    //đây chính là volume value
    private double dauhieu(DataOutput obj){
        return (1000000*obj.getData().getHigh()+obj.getData().getLow())/2*(obj.getData().getVolume());
    }

    //thay thế cho compare (so sánh)
    private void sosanh(DataOutput a,DataOutput b){

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
    private void level(DataOutput a,DataOutput b){

        if(dauhieu(a)-dauhieu(b)<=1000000){
            map.put("levelSS","một chút");}
        else if ((dauhieu(a)-dauhieu(b))>1000000 && (dauhieu(a)-dauhieu(b))<5000000){
            map.put("levelSS","khá nhiều");
        }
        else {
            map.put("levelSS","rất nhiều");
        }
    }


    public Map<String, String> PushInMap(List<DataOutput> data,String name) {

        //tìm kiếm đối tượng có tên muốn tìm và trả về đối tượng đó.
        //tạo tmp y hệt đối tượng tìm được.
        DataOutput tmp = data.stream().filter(x->x.getData().getName().equals(name)).findAny().orElse(null);

        //tạo kiểu hiển thị ngày tháng năm (pattern)
        //như ở dưới là day/month/year.
        String pattern ="dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        //change có giá trị bằng độ chênh lệch của giá trị cổ phiếu.
        double change=tmp.getData().getClose()-tmp.getData().getOpen();
//        double percent=Math.abs ((double) Math.round((((tmp.getData().getClose())*1000)/((tmp.getData().getOpen())*1000)-1)*10000)/100);
        double percent=tmp.getData().getChangePercent();

        //lấy tỉ lệ % tăng hoặc giảm


        //truyền vào các cặp key và value tương ứng.
        map.put("name",tmp.getData().getName());
        map.put("date",dateFormat.format(tmp.getData().getDate()));
        map.put("numOpen",Double.toString(tmp.getData().getOpen()*1000));
        map.put("numHigh",Double.toString(tmp.getData().getHigh()*1000));
        map.put("numClose",Double.toString(tmp.getData().getClose()*1000));
        map.put("percent",Double.toString(percent));
        map.put("volume1",Double.toString(tmp.getData().getVolume()));
        map.put("gtgd",Double.toString(dauhieu(tmp)/1000000));//tỉ đồng

        //thay thế chỗ dấu hiệu dựa vào lượng gtgd.
        if(dauhieu(tmp)>=8000000){map.put("dauhieu","rất khả quan");}// đã chia 1000, giá trị thực phải *1000;
        else if(5000000<dauhieu(tmp) &&dauhieu(tmp)<8000000){map.put("dau hieu","khá khả quan");}
        else {map.put("dauhieu","không mấy khả quan");}


        //nói về tình trạng cổ phiếu
        if (change>0){map.put("link","tăng");}
        else if(change<0){map.put("link","giảm");}
        else if(change ==0 && (tmp.getData().getOpen()==tmp.getData().getHigh() || tmp.getData().getOpen()==tmp.getData().getLow())){map.put("link","đứng giá");}
        else map.put("link","biến động");

        //nói về mức độ
        map.put("level",level(change));
        map.put("levelPC",levelPc(tmp.getData().getChangePercent()));

        //nếu obj cần tìm thuộc nhóm ngân hàng
        switch (name) {
            case "BID":
            case "CTG":
            case "HDB":
            case "MBB":
            case "TCB":
            case "VCB":
            case "VPB":
            case "NVB":
            case "SHB": {
                List<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random

                List<DataOutput> nullList = new LinkedList<>();
                nullList.add(null);

                demo.add(filterByName(data, "BID"));
                demo.add(filterByName(data, "CTG"));
                demo.add(filterByName(data, "HDB"));
                demo.add(filterByName(data, "MBB"));
                demo.add(filterByName(data, "TCB"));
                demo.add(filterByName(data, "VCB"));
                demo.add(filterByName(data, "VPB"));
                demo.add(filterByName(data, "NVB"));
                demo.add(filterByName(data, "SHB"));

                demo.removeAll(nullList);

                DataOutput obj = randomOBJ(demo);
                map.put("nameSS", obj.getData().getName() + "thuộc cùng nhóm ngân hàng");
                map.put("volume2", Double.toString(obj.getData().getVolume()));
                sosanh(tmp, obj);
                level(tmp, obj);

                break;
            }
            case "ASP":
            case "PGC":
            case "PJT":
            case "PLX":
            case "PVD":
            case "PVT":
            case "PXS": {
                LinkedList<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random

                demo.add(filterByName(data, "ASP"));
                demo.add(filterByName(data, "PGC"));
                demo.add(filterByName(data, "PJT"));
                demo.add(filterByName(data, "PLX"));
                demo.add(filterByName(data, "PVD"));
                demo.add(filterByName(data, "PVT"));
                demo.add(filterByName(data, "PXS"));
                demo.add(filterByName(data,"APP"));
                demo.add(filterByName(data,"PCT"));
                demo.add(filterByName(data,"PGS"));
                demo.add(filterByName(data,"PLC"));
                demo.add(filterByName(data,"PVB"));
                demo.add(filterByName(data,"PVC"));
                demo.add(filterByName(data,"PVG"));
                demo.add(filterByName(data,"PVS"));
                DataOutput obj = randomOBJ(demo);
                map.put("nameSS", obj.getData().getName() + "thuộc cùng nhóm dầu khí");
                map.put("volume2", Double.toString(obj.getData().getVolume()));
                sosanh(tmp, obj);
                level(tmp, obj);

                break;
            }
            case "ANV":
            case "IDI":
            case "VHC":
            case "TS4": {
                LinkedList<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random

                demo.add(filterByName(data, "ANV"));
                demo.add(filterByName(data, "IDI"));
                demo.add(filterByName(data, "VHC"));
                demo.add(filterByName(data, "TS4"));
                DataOutput obj = randomOBJ(demo);
                map.put("nameSS", obj.getData().getName() + "thuộc cùng nhóm thuỷ sản");
                map.put("volume2", Double.toString(obj.getData().getVolume()));
                sosanh(tmp, obj);
                level(tmp, obj);

                break;
            }
            case "HVN":
            case "VJC":
            case "CIA":
            case "MAS": {
                LinkedList<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random


                demo.add(filterByName(data, "HVN"));
                demo.add(filterByName(data, "VJC"));
                demo.add(filterByName(data, "ARM"));
                demo.add(filterByName(data, "CIA"));
                demo.add(filterByName(data, "MAS"));


                DataOutput obj = randomOBJ(demo);
                map.put("nameSS", obj.getData().getName() + "thuộc cùng nhóm hàng không");
                map.put("volume2", Double.toString(obj.getData().getVolume()));
                sosanh(tmp, obj);
                level(tmp, obj);

                break;
            }
            case "DRC":
            case "DPR":
            case "TNC":
            case "HRC":
            case "TRC":
            case "CSM": {
                LinkedList<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random

                demo.add(filterByName(data, "DRC"));
                demo.add(filterByName(data, "DPR"));
                demo.add(filterByName(data, "TNC"));
                demo.add(filterByName(data, "HRC"));
                demo.add(filterByName(data, "TRC"));
                demo.add(filterByName(data, "CSM"));
                DataOutput obj = randomOBJ(demo);
                map.put("nameSS", obj.getData().getName() + "thuộc cùng nhóm cao su");
                map.put("volume2", Double.toString(obj.getData().getVolume()));
                sosanh(tmp, obj);
                level(tmp, obj);

                break;
            }
            case "NKG":
            case "TLH":
            case "POM":
            case "MWG":
            case "PET":
            case "BVG":
            case "HPG":
            case "HSG":
            case "SMC": {
                LinkedList<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random

                demo.add(filterByName(data, "NKG"));
                demo.add(filterByName(data, "TLH"));
                demo.add(filterByName(data, "POM"));
                demo.add(filterByName(data, "MWG"));
                demo.add(filterByName(data, "PET"));
                demo.add(filterByName(data, "BVG"));
                demo.add(filterByName(data, "HPG"));
                demo.add(filterByName(data, "HSG"));
                demo.add(filterByName(data, "SMC"));
                DataOutput obj = randomOBJ(demo);
                map.put("nameSS", obj.getData().getName() + "thuộc cùng nhóm thép");
                map.put("volume2", Double.toString(obj.getData().getVolume()));
                sosanh(tmp, obj);
                level(tmp, obj);

                break;
            }
            case "VIC":
            case "VHM":
            case "VRE": {
                LinkedList<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random

                demo.add(filterByName(data, "VIC"));
                demo.add(filterByName(data, "VHM"));
                demo.add(filterByName(data, "VRE"));
                DataOutput obj = randomOBJ(demo);
                map.put("nameSS", obj.getData().getName() + "thuộc cùng nhóm họ Vin ");
                map.put("volume2", Double.toString(obj.getData().getVolume()));
                sosanh(tmp, obj);
                level(tmp, obj);

                break;
            }
            default: {
                LinkedList<DataOutput> demo = new LinkedList<>();//list chứa các đối tượng để random

                for (DataOutput datum : data) {
                    if (!(datum.getData().getName().equals("BID") || datum.getData().getName().equals("HDB")
                            || datum.getData().getName().equals("MBB") || datum.getData().getName().equals("TCB") || datum.getData().getName().equals("VCB")
                            || datum.getData().getName().equals("VPB") || datum.getData().getName().equals("CTG") || datum.getData().getName().equals("ASP")
                            || datum.getData().getName().equals("PGC") || datum.getData().getName().equals("PJT") || datum.getData().getName().equals("PLX")
                            || datum.getData().getName().equals("PVD") || datum.getData().getName().equals("PVT") || datum.getData().getName().equals("PXS")
                            || datum.getData().getName().equals("ANV") || datum.getData().getName().equals("IDI") || datum.getData().getName().equals("VHC")
                            || datum.getData().getName().equals("TS4") || datum.getData().getName().equals("HVN") || datum.getData().getName().equals("VJC")
                            || datum.getData().getName().equals("DRC") || datum.getData().getName().equals("DPR") || datum.getData().getName().equals("TRC")
                            || datum.getData().getName().equals("HRC") || datum.getData().getName().equals("CSM")
                            || datum.getData().getName().equals("NKG") || datum.getData().getName().equals("TLH") || datum.getData().getName().equals("POM")
                            || datum.getData().getName().equals("MWG") || datum.getData().getName().equals("PET") || datum.getData().getName().equals("BVG")
                            || datum.getData().getName().equals("HPG") || datum.getData().getName().equals("HSG") || datum.getData().getName().equals("SMC")
                            || datum.getData().getName().equals("VIC") || datum.getData().getName().equals("VHM") || datum.getData().getName().equals("VRE")
                            || datum.getData().getName().equals("^AEX") || datum.getData().getName().equals("^AORD") || datum.getData().getName().equals("^ATX")
                            || datum.getData().getName().equals("^BDS") || datum.getData().getName().equals("^BFX") || datum.getData().getName().equals("^BSESN")
                            || datum.getData().getName().equals("^CAOSU") || datum.getData().getName().equals("^CK") || datum.getData().getName().equals("^CONGNGHE")
                            || datum.getData().getName().equals("^DAUKHI") || datum.getData().getName().equals("^DICHVU") || datum.getData().getName().equals("^DJI")
                            || datum.getData().getName().equals("^DTPT") || datum.getData().getName().equals("^DTXD") || datum.getData().getName().equals("^DUOCPHAM")
                            || datum.getData().getName().equals("^FCHI") || datum.getData().getName().equals("^FTSE") || datum.getData().getName().equals("^GDAXI")
                            || datum.getData().getName().equals("^GIAODUC") || datum.getData().getName().equals("^GSPC") || datum.getData().getName().equals("^HASTC")
                            || datum.getData().getName().equals("^HK") || datum.getData().getName().equals("^HNX30") || datum.getData().getName().equals("^HSI")
                            || datum.getData().getName().equals("^IXIC") || datum.getData().getName().equals("^JKSE") || datum.getData().getName().equals("^KHOANGSAN")
                            || datum.getData().getName().equals("^KLSE") || datum.getData().getName().equals("^KS11") || datum.getData().getName().equals("^LARGECAP")
                            || datum.getData().getName().equals("^MIDCAP") || datum.getData().getName().equals("^N255") || datum.getData().getName().equals("^NANGLUONG")
                            || datum.getData().getName().equals("^NGANHANG") || datum.getData().getName().equals("^NHUA") || datum.getData().getName().equals("^NYA")
                            || datum.getData().getName().equals("^NZ50") || datum.getData().getName().equals("^OMXSPI") || datum.getData().getName().equals("OSEAX")
                            || datum.getData().getName().equals("^PHANBON") || datum.getData().getName().equals("^SMALLCAP") || datum.getData().getName().equals("^SSMI")
                            || datum.getData().getName().equals("^STI") || datum.getData().getName().equals("^SKXD") || datum.getData().getName().equals("^THEP")
                            || datum.getData().getName().equals("^THUCPHAM") || datum.getData().getName().equals("^THUONGMAI") || datum.getData().getName().equals("^THUYSAN")
                            || datum.getData().getName().equals("^TWII") || datum.getData().getName().equals("^UPCOM") || datum.getData().getName().equals("^VANTAI")
                            || datum.getData().getName().equals("^VLXD") || datum.getData().getName().equals("^VN30") || datum.getData().getName().equals("^VNINDEX")
                            || datum.getData().getName().equals("^XAYDUNG")|| datum.getData().getName().equals("APP")|| datum.getData().getName().equals("PCT")
                            || datum.getData().getName().equals("PGS")|| datum.getData().getName().equals("PLC")|| datum.getData().getName().equals("PVB")
                            || datum.getData().getName().equals("PVC")|| datum.getData().getName().equals("PVG")|| datum.getData().getName().equals("PVS")
                            || datum.getData().getName().equals("ARM")|| datum.getData().getName().equals("CIA")|| datum.getData().getName().equals("MAS"))) {
                        demo.add(datum);
                    }
                }
                DataOutput obj = randomOBJ(demo);
                map.put("nameSS", obj.getData().getName());
                map.put("volume2", Double.toString(obj.getData().getVolume()));
                sosanh(tmp, obj);
                level(tmp, obj);

                break;
            }
        }
        return map;
    }
}
