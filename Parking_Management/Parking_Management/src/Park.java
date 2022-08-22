import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Park {
    String carNum;
    int time=0;

    public Park() {
        this.carNum = carNum;
        this.time = time;
    }
    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    void carIn(String num, int time){
        this.carNum=num;
        this.time=time;
    }
    void carOut(int time) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmm");
        Date inTime = simpleDateFormat.parse(String.valueOf(this.time));
        Date outTime = simpleDateFormat.parse(String.valueOf(time));

        long intime = inTime.getTime();
        long outtime = outTime.getTime();
        long between = (outtime-intime)/60000;
        System.out.println(between);
        System.out.println("pay :"+ (between/10)*1000 +"won");
    }
}
