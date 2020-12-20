package ProjectOOP.src.Model.Crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/* Khởi tạo lớp này sẽ cập nhật dữ liệu mới nhất từ web
* */
//todo: maybe add Interface Runable
public class CrawlData{
    public final Calendar lastDay;
    private static final SimpleDateFormat SDF1 = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat SDF2 = new SimpleDateFormat("ddMMyyyy");
    private static final String ZIP_DIRECTORY = "ProjectOOP/StockDataEOD/";
    private static final String URL_TEMPLATE = "http://images1.cafef.vn/data/yyyyMMdd/CafeF.SolieuGD.ddMMyyyy.zip";

    public CrawlData(){
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        if(i == 1 || i ==2){
            calendar.add(Calendar.DATE, -i);
        }
        calendar.add(Calendar.DATE, -1);
        this.lastDay = calendar;
    }

    protected void crawl() throws IOException{
        String url = URL_TEMPLATE.replace("ddMMyyyy.zip", getZipName()).replace("yyyyMMdd", getDayToString());
        new FileOutputStream(getZipPath()).getChannel().transferFrom(Channels.newChannel(new URL(url).openStream()), 0, Long.MAX_VALUE);
    }

    private String getZipName(){
        return SDF2.format(lastDay.getTime()) + ".zip";
    }

    private String getDayToString(){
        return SDF1.format(lastDay.getTime());
    }

    public String getZipPath(){
        return ZIP_DIRECTORY + getZipName();
    }

    public String getDirectory(){
        return ZIP_DIRECTORY + getDayToString();
    }



}
