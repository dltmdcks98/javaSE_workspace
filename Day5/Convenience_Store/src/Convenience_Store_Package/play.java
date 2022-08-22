package Convenience_Store_Package;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Scanner;

public class play {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Product> m = new ArrayList<>();
        Product c = null;

        //sample data
        c = new Product(1,"coffee",1000,5,"23.05.01");
        m.add(c);
        c = new Product(2,"snak",500,7,"23.05.01");
        m.add(c);
        c= new Product(3,"naasd",6000,4,"12341234");
        m.add(c);

        //INPUT DATA
//        Scanner input = new Scanner(System.in);
//        int serial_no;
//        String name;
//        int price;
//        int quantity;
//        String expired;

//        for(int idx =0; idx<3; idx++){
//            System.out.println("Serial No");
//            serial_no = Integer.parseInt(input.nextLine());
//            System.out.println("Name");
//            name = input.nextLine();
//            System.out.println("Price");
//            price = Integer.parseInt(input.nextLine());
//            System.out.println("Quantity");
//            quantity = Integer.parseInt(input.nextLine());
//            System.out.println("Expired");
//            expired = input.nextLine();
//
//            c = new Product(serial_no,name,price,quantity,expired);
//            m.add(c);
//        }


        fileInput(m);
        fileOutput();
    }



    public static void fileInput(ArrayList<Product> m ) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\temp\\store.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

        objectOutputStream.writeObject(m);
        objectOutputStream.close();
    }
    public static void fileOutput() throws IOException, ClassNotFoundException {
        //���ϰ� �����Ű�� �κ�(���� ��Ʈ��)
        FileInputStream fileInputStream = new FileInputStream("D:\\temp\\store.txt");
        //Ŀ���� Ŭ����(���������� Ư���� Ŭ����)�� �����Ű�� �κ�
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        //���������� ��ü�� �б�(READ)�� ���� �κ�
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

//        //�Ѱ��� �о�ͼ� p1�� ����
//        Product p1 =(Product) objectInputStream.readObject();
//        //�ι�° ��ü ����
//        Product p2 = (Product) objectInputStream.readObject();
        //�����ߴ� �ڷᱸ���� ���������� �о�´�.
        ArrayList list = (ArrayList) objectInputStream.readObject();


        System.out.println(list.size());
        Product p = (Product) list.get(1);
        System.out.println(p.toString());

        objectInputStream.close();
    }
}

