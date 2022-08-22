import java.util.Scanner;

public class Omain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double cm, kg;
        String name;
        name = input.nextLine();
        cm = Double.parseDouble(input.nextLine());
        kg = Double.parseDouble(input.nextLine());
        System.out.println(name+" is : ");
        chk(cm,kg);

    }

    public static void chk(double height, double weight){
        double bmi = Math.round(weight/((height/100)*(height/100)));
        if(bmi>=30){
            System.out.println("Extremely Obese");
            System.out.println("BMI :" + bmi);
        } else if (bmi>=25) {
            System.out.println("Obese");
            System.out.println("BMI :" + bmi);
        } else if (bmi>= 23) {
            System.out.println("Overweight");
            System.out.println("BMI :" + bmi);
        } else if (bmi>=18.5) {
            System.out.println("normal");
            System.out.println("BMI :" + bmi);
        }else{
            System.out.println("under weight");
            System.out.println("BMI :" + bmi);
        }
    }
}
