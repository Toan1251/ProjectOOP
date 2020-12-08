package ProjectOOP.src.Process;

import ProjectOOP.src.Model.DataInput;
import java.util.ArrayList;
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
    List<String> done= new ArrayList<String>();

    @Override
    public void begin(ArrayList<DataInput> data) {}

    public void Process(ArrayList<DataInput> data,String name){

        List<String> temp1 = new ArrayList<String>();
        temp1.add("Trong phiên giao dịch ngày hôm nay, <date> , cổ phiếu của <name> có dấu hiệu <link> <level>.");
        temp1.add("Tính đến cuối ngày hôm nay, <date>, cổ phiếu với mã <name> đã có dấu hiệu <link> <level>.");
        temp1.add("Nói đến <name> thì đến cuối ngày <date> cổ phiếu đã <link> <level>.");

        List<String> temp2 = new ArrayList<String>();
        temp2.add("Mở đầu phiên giao dịch, <name> đạt <numOpen> đồng/ cổ phiếu, có thời điểm đạt tới <numHigh> đồng và kết thúc phiên, cổ phiếu <name> ổn định ở mức <numClose> đồng/cổ phiếu, <link> <level> <percent>% so với đầu phiên. ");
        temp2.add("<name> mở đầu phiên giao dịch với <numOpen> đồng/CP và <link> <level> <percent>% ở cuối phiên, cụ thể là <numClose> đồng/CP, có lúc cổ phiếu của <name> đã đạt đến <numHigh> đồng. ");

        List<String> temp3 = new ArrayList<String>();
        temp3.add("Bên cạnh đó, tổng khối lượng giao dịch của ngày hôm nay được thống kê là <volume1> cổ phiếu, đạt giá trị <gtgd> đồng , đây là một dấu hiệu <dauhieu> và khi ta đem so sánh với <nameSS> với <volume 2> cổ phiếu thì nhận thấy rằng lượng cổ phiếu được bán ra <compare> <levelSS>. ");
        temp3.add("Còn về khối lượng giao dịch trong ngày thì <name> đã bán được <volume1> cổ phiếu, tương ứng với <gtgd> đồng, so sánh với <nameSS> với <volume2> cổ phiếu được bán ra thì <name> <compare> <levelSS>, đây có thể coi là một dấu hiệu <dauhieu> đối với mã cổ phiếu này. ");

        //thay thế key cho các câu đã được chọn và đưa vào list done.
        this.eachMap = (new RulePersonal()).PushInMap(data,name);
        done.add(getOutput(temp1));
        done.add(getOutput(temp2));
        done.add(getOutput(temp3));

        //đưa tất cả câu đã chọn thành 1 đoạn văn và đưa vào dữ liệu chung
        addSentences(done.get(0)+done.get(1)+done.get(2));
    }


}
