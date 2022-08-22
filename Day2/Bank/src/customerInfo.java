import javax.naming.event.ObjectChangeListener;
import java.io.Serializable;
import java.util.Scanner;

public class customerInfo implements Serializable {
     String name, account;
     int cash;

    public customerInfo(String name, String account, int cash) {
        this.name = name;
        this.account = account;
        this.cash = cash;
    }

    public  void putCash(int Icash){
        if(Icash<0){
            System.out.println("Input upper 0");
        }else {
            this.cash += Icash;
            System.out.println(this.cash);
        }
    }
    public  void outCash(int Ocash){
        if(Ocash>this.cash){
            System.out.println("Input under cash");
        }else {
            this.cash -= Ocash;
            System.out.println(this.cash);
        }
    }


    public boolean contains(String o){
        if(o.equals(name)||o.equals(account)){
            return true;
        }else return false;
    }

    public boolean range(int upper,int under){
        if(upper < cash && cash<under){
            System.out.println("Success");
            return true;
        }else  return false;
    }

//    public  String getName() {
//        return this.name;
//    }
//
//    public static void setName(String name) {
//        customerInfo.name = name;
//    }
//
//    public  String getAccount() {
//        return this.account;
//    }
//
//    public static void setAccount(String account) {
//        customerInfo.account = account;
//    }
//
//    public  int getCash() {
//        return this.cash;
//    }
//
//    public static void setCash(int cash) {
//        customerInfo.cash = cash;
//    }
}
