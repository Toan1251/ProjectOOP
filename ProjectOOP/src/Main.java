package ProjectOOP.src;

import ProjectOOP.src.Controller.Controller;
import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Cập nhật dữ liệu chứng khoán mới nhất
        Controller c = new Controller();
        System.out.println(c.HSX.getTagManager().isHaveThisTag("GroupVin"));
        List<DataOutput> respond = new LinkedList<>();
        for (DataOutput output : c.HSX.getData()) {
            if (output.getTags().isHaveThisTag("GroupVin")) {
                respond.add(output);
            }
        }
        for (DataOutput dO: respond){
            System.out.println(dO.getSentence_nganh());
        }

        //todo: Xây dựng luồng hđ cho dữ liệu
    }
}
