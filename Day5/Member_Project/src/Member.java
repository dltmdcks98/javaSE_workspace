import java.io.Serializable;
import java.util.Scanner;

public class Member implements Serializable {
    private String name,address;
    private boolean sex;
    private int age;

    public Member(String name, String address, boolean sex, int age) {
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String temSex;

        if(sex){
            temSex = "man";
        }else {
            temSex = "woman";
        }

        return "Member{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + temSex +
                ", age=" + age +
                '}';
    }
}
class setInfo extends Member{
    public setInfo(String name, String address, boolean sex, int age) {
        super(name, address, sex, age);
    }

    public void Input(){
        Scanner input = new Scanner(System.in);
        System.out.println("your name : ");
        super.setName(input.nextLine());

        System.out.println("your address : ");
        super.setAddress(input.nextLine());

        System.out.println("Are you man? : ");
        super.setSex(Boolean.parseBoolean(input.nextLine()));

        System.out.println("Your Age? : ");
        super.setAge(Integer.parseInt(input.nextLine()));

    }

}
