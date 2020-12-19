package ProjectOOP.src.Model.Process;
import ProjectOOP.src.Model.Handle.DataInput;
import ProjectOOP.src.Model.Handle.DataOutput;

import java.util.LinkedList;
import java.util.List;

public class GroupPersonal extends Group {
    //override lại phương thức để lấy value ứng với key
    @Override
    public String replaceVariable(String key) {
        return this.eachMap.get(key);
    }

    @Override
    public String getOutput(List<String> list) {
        return divideSentences(randomSentence(list));
    }

    //List chứa các câu sau khi đã random và xử lí từng nhóm câu
    List<String> done= new LinkedList<>();

    @Override
    public String begin(List<DataOutput> data) {//xem lai
        return null;
    }

    //trả về 1 list chứa các câu cần thiết
    public List<String> Process(List<DataOutput> data,String name){

        List<String> temp1 = new LinkedList<>();
        temp1.add("Trong phiên giao dịch ngày hôm nay, <date> , cổ phiếu của <name> có dấu hiệu <link> <level>.");
        temp1.add("Tính đến cuối ngày hôm nay, <date>, cổ phiếu với mã <name> đã có dấu hiệu <link> <level>.");
        temp1.add("Nói đến <name> thì đến cuối ngày <date> cổ phiếu đã <link> <level>.");

        List<String> temp2 = new LinkedList<>();
        temp2.add("Mở đầu phiên giao dịch, <name> đạt <numOpen> đồng/ cổ phiếu, có thời điểm đạt tới <numHigh> đồng và kết thúc phiên, cổ phiếu <name> ổn định ở mức <numClose> đồng/cổ phiếu, <link> <level> <percent>% so với đầu phiên. ");
        temp2.add("<name> mở đầu phiên giao dịch với <numOpen> đồng/CP và <link> <levelPC> <percent>% ở cuối phiên, cụ thể là <numClose> đồng/CP, có lúc cổ phiếu của <name> đã đạt đến <numHigh> đồng. ");

        List<String> temp3 = new LinkedList<>();
        temp3.add("Bên cạnh đó, tổng khối lượng giao dịch của ngày hôm nay được thống kê là <volume1> cổ phiếu, đạt giá trị <gtgd> đồng , đây là một dấu hiệu <dauhieu> và khi ta đem so sánh với <nameSS> với <volume2> cổ phiếu thì nhận thấy rằng lượng cổ phiếu được bán ra <compare> <levelSS>. ");
        temp3.add("Còn về khối lượng giao dịch trong ngày thì <name> đã bán được <volume1> cổ phiếu, tương ứng với <gtgd> đồng, so sánh với <nameSS> với <volume2> cổ phiếu được bán ra thì <name> <compare> <levelSS>, đây có thể coi là một dấu hiệu <dauhieu> đối với mã cổ phiếu này. ");

        //thay thế key cho các câu đã được chọn và đưa vào list done.
        this.eachMap = (new RulePersonal()).PushInMap(data,name);
        done.add(getOutput(temp1));
        done.add(getOutput(temp2));
        done.add(getOutput(temp3));

        //đưa tất cả câu đã chọn thành 1 đoạn văn và đưa vào dữ liệu chung
        return done;




    }


}
