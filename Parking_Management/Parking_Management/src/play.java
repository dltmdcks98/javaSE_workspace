import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class play {
    public static void main(String[] args) throws ParseException {
        ArrayList<Park> m = new ArrayList<>();

        Park park;
        Scanner input = new Scanner(System.in);


        while(true){
            //메뉴 구성
            System.out.println("menu");
            System.out.println("===================================================");
            System.out.println("1. IN");
            System.out.println("2. OUT ");
            System.out.println("==================================================");

            park = new Park();
            switch (Integer.parseInt(input.nextLine())){
                case 1:
                    if(m.size()>=5){
                        System.err.println("Parking area full");
                    }else{
                        System.out.println("Enter car number : ");
                        String num = input.nextLine();
                        if(chkCarIn(num,m)){

                            System.out.println("Enter time? : ");
                            int time = Integer.parseInt(input.nextLine());

                            if(chkTime(time)){
                                park.carIn(num,time);
                                m.add(park);
                                System.out.println("Success");
                                break;
                            }
                        } System.err.println("error"); break;
                    }
                    break;
                case 2:
                    if(m.size()==0){
                     System.err.println("dont have any car");
                        break;
                    }
                    System.out.println("Enter car number : ");
                    String car_num = input.nextLine();
                    for(int idx=0; idx<m.size(); idx++){
                        if(car_num.equals(m.get(idx).getCarNum())){
                            System.out.println("Enter out time : ");
                            int time = Integer.parseInt(input.nextLine());
                            if(chkTime(time)) {
                                m.get(idx).carOut(time);
                                m.remove(idx);
                                break;
                            }else{
                                break;
                            }
                        }else{
                            System.err.println("not exist");
                            break;
                        }
                    }


                    break;
                default:
                    System.err.println("menu error");
                    break;
            }
        }

    }
    static boolean chkTime(int time){
        if((time/100)>24){
            System.err.println("Enter Hour data is error");
            return false;
        }else if((time%100)>59){
            System.err.println("Enter minute data is error");
            return false;
        }
        return true;
    }

    static boolean chkCarIn(String num, ArrayList<Park> m){

        for(int idx=0; idx<m.size(); idx++){
            if(num.equals(m.get(idx).getCarNum())){
                System.err.println("exist car");
                return false;
            }
        }
        return true;
    }

}
