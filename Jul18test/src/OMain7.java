import java.util.ArrayList;
import java.util.Random;

public class OMain7 {
    public static void main(String[] args) {
        //로또 프로그램
        //6개를 랜덤으로 중복 x
        Random r = new Random();
//        ArrayList<Integer> list = new ArrayList<>();
//        while(true){
//            if(list.size()>6){
//                break;
//            }else {
//                int num = r.nextInt(45)+1;
//                chk(list,num);
//            }
//
//        }
//        for(int i =0; i<list.size(); i++){
//            System.out.println(list.get(i));
//        }
//    }
//
//    static void chk(ArrayList temp, int ran) {
//        for (int i = 0; i < temp.size(); i++) {
//            if (temp.get(i).equals(ran)) {
//                System.out.println("error");
//            } else{
//                temp.add(ran);
//                System.out.println("add : "+ran);
//            }
//        }
        int lotto[] = new int[6];
        for(int i =0; i<lotto.length;i++){
            lotto[i] = r.nextInt(45)+1;

        }
        for(int i =0; i<lotto.length-1;i++){
            if(lotto[i]==lotto[i+1]){
                System.out.println("error");
                lotto[i+1] = r.nextInt(45)+1;
            }
        }

        for(int i : lotto){
            System.out.println(i);
        }

        //java 1.5 이상
        gd:for(int i =0; i<args.length;i++){
            gd2:for(int j =0; j<args.length;j++){
                break gd2;
            }
        }

        for(int i=0; i<10;i++){
            if(i==5){
//                break;
                continue;
            }
            System.out.println(i);
        }


    }
}
