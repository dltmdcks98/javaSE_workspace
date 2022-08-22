import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class play {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        setInfo member = null;
        ArrayList<setInfo> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        member = new setInfo("aaa","seoul",true,25);
        list.add(member);

//        fileInput(list);
//        fileOutput();

        //메뉴 구성"
        System.out.println("menu");
        System.out.println("===================================================");
        System.out.println("1. info input ");
        System.out.println("2. Read Member ");
        System.out.println("3. Print Member ");
        System.out.println("==================================================");

        while(true){
            switch (Integer.parseInt(input.nextLine())){
                case 1 :
                    System.out.println("number of repetitions");
                    for(int idx=0; idx<Integer.parseInt(input.nextLine());idx++) {
                        member.Input();
                        list.add(member);
                    }
                    fileInput(list);
                    break;
                case 2:
                    fileOutput();
                    break;
                case 3 :
                    filePrint();
                    break;
                default:
                    System.err.println("Error");
                    continue;
            }
        }
    }
    public static void fileInput(ArrayList<setInfo> m ) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\temp\\Member.txt",true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

        objectOutputStream.writeObject(m);
        objectOutputStream.close();
    }
    public static void fileOutput() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:\\temp\\Member.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

        ArrayList list = (ArrayList) objectInputStream.readObject();


        System.out.println(list.size());

        objectInputStream.close();
    }
    public static void filePrint() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:\\temp\\Member.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

        ArrayList list = (ArrayList) objectInputStream.readObject();


        setInfo p = (setInfo) list.get(0);
        System.out.println(p.toString());

        objectInputStream.close();

    }
}
