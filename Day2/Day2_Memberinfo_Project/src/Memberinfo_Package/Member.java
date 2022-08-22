package Memberinfo_Package;

import java.util.Scanner;

public class Member {
    private String name,id,pass,phone;

    public void setMemberInfo(){
        Scanner scn = new Scanner(System.in);

        System.out.print("input your name ");
        this.name = scn.nextLine();
        System.out.print("Input your ID");
        this.id = scn.nextLine();
        System.out.print("Input your pw");
        this.pass = scn.nextLine();
        System.out.print("Input your phone");
        this.phone = scn.nextLine();
    }
    public void putMemberInfo(){
        System.out.println("name :" + name +" ID :" + id+" pw :" + pass+" phone :" + phone);
    }

    public String getMemberName() {
        return name;
    }

    public String getMemberId() {
        return id;
    }

    public String getMemberPass() {
        return pass;
    }

    public String getMemberPhone() {
        return phone;
    }
}
