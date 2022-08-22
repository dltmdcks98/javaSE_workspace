import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class play implements Serializable {
    public static void main(String[] args)  {
        ArrayList<customerInfo> m = new ArrayList<customerInfo>();
        customerInfo c;
        int menu = 0;
        Scanner input = new Scanner(System.in);


////sample data
//        m.add(new customerInfo("aa","123123",5000));m.add(new customerInfo("bb","123444",5000));

        while (true) {
            //메뉴 구성"
            System.out.println("menu");
            System.out.println("===================================================");
            System.out.println("1. info input ");
            System.out.println("2. out cash ");
            System.out.println("3. put cash ");
            System.out.println("4. search");
            System.out.println("5. view all 0info");
            System.out.println("6. clear");
            System.out.println("7. exit");
            System.out.println("==================================================");


            menu = Integer.parseInt(input.nextLine());
            switch (menu) {
                case 1:
                    //사용자를 계속 넣을 수 있는 코드
                    System.out.println("If you want exit input 'exit' in name space");
                    while (true) {
                        try {
                            input = new Scanner(System.in);

                            System.out.println("input name");
                            String name = input.nextLine();
                            if (name.equals("exit")) throw new Exception();

                            System.out.println("input account");
                            String account = input.nextLine();


                            System.out.println("input cash");
                            int cash = Integer.parseInt(input.nextLine());

                            c = new customerInfo(name, account, cash);
                            m.add(c);
                        } catch (Exception e) {
                            System.out.println("stop add info");
                            fileInput(m);
//                            break;
                        }
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Enter account");
                    input = new Scanner(System.in);
                    for (int idx = 0; idx < m.size(); idx++) {
                        if (m.get(idx).contains(String.valueOf(input.nextInt()))) {
                            System.out.println("Enter Withdrawal");
                            Scanner inpCash = new Scanner(System.in);
                            m.get(idx).outCash(inpCash.nextInt());
                            System.out.println("success");
                            break;
                        } else System.out.println("fail");
                        break;

                    }
                    break;
                case 3:
                    System.out.println("Enter account");
                    input = new Scanner(System.in);
                    for (int idx = 0; idx < m.size(); idx++) {
                        if (m.get(idx).contains(String.valueOf(input.nextInt()))) {
                            System.out.println("Enter Deposit");
                            Scanner inpCash = new Scanner(System.in);
                            m.get(idx).putCash(inpCash.nextInt());
                            System.out.println("success");
                            break;
                        } else System.out.println("fail");
                        break;

                    }
                    break;
                case 4:
                    System.out.println("input search name or account");
                    input = new Scanner(System.in);
                    String info = input.nextLine();
                    for (int idx = 0; idx < m.size(); idx++) {
                        if (m.get(idx).contains(info)) {
                            System.out.println("success");
                            System.out.println("name : " + m.get(idx).name + " account : " + m.get(idx).account + " cash : " + m.get(idx).cash);
                            break;
                        } else System.out.println("fail");
                        break;
                    }
                case 5:
//                    for (int idx = 0; idx < m.size(); idx++) {
//                        System.out.println("name : "+m.get(idx).getName()+" accout : "+m.get(idx).getAccount()+" money : "+m.get(idx).getCash());
//                    }

//                    //READ File
//                    try{
//
//                        //하드디스크의 특정파일과 filestream 래퍼런스를 연결해준다..
//                        //그러면, 이제부터는 fileStream이라는게 파일을 담당 (이걸로 접근 가능)
//                        FileInputStream fileInputStream = new FileInputStream(file);
//                        //프로그래머가 객체 작업을 하려면 ObjectInputStream을 사용해야한다.
//                        //그래서 ObjectInputStream 과 fileStream을 연결해줘야함
//                        //그러면 결론적으로 객체작업담당 <---------> 파일작업 담당으로 연결
//                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//                        //연결은 다 되었지만, 데이터를 파일에서 읽어와서 메모리에 저장해준다음이 문제,
//                        //읽어온 객체가 어떤타입인지 모르기때문에 반드시 타입캐스팅을 해줘야함
//
//                        Object object = objectInputStream.readObject();
//
//                        //원래 저장할 때 컨테이너 타입이 ArrayList였다. 그러므로 일단 그 타입으로 캐스팅해야함
//                        //그 다음 그 안에 들어있는 각각의 객체가 String 타입이었음
//                        //각각의 String 타입객체를 뽑아서 화면에 출력
//
//                        //데이터파싱(Parsing)
//                        ArrayList<String> members = (ArrayList<String>) object;
//                        System.out.println(members.size());
//
//                        objectInputStream.close();
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
                    fileOutput(m);
                    break;

                case 6:
                    try {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        break;
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                case 7:
                    System.out.println("exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("again select menu");
                    break;
            }
        }
    }
    public static  void fileInput(ArrayList m){
        try{
            //파일 스트림 (객체를 저장할 곳)
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\temp\\infoDB.txt");
            //객체 저장 스트림(객체를 파일과 연결)=>파이프연결
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(m);
            //저장할때 압축해서 저장하므로 인간이 읽을 수 없다.

            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);}
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void fileOutput(ArrayList m){
        //READ File
        try{

            //하드디스크의 특정파일과 filestream 래퍼런스를 연결해준다..
            //그러면, 이제부터는 fileStream이라는게 파일을 담당 (이걸로 접근 가능)
            FileInputStream fileInputStream = new FileInputStream("D:\\temp\\infoDB.txt");
            //프로그래머가 객체 작업을 하려면 ObjectInputStream을 사용해야한다.
            //그래서 ObjectInputStream 과 fileStream을 연결해줘야함
            //그러면 결론적으로 객체작업담당 <---------> 파일작업 담당으로 연결
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            //연결은 다 되었지만, 데이터를 파일에서 읽어와서 메모리에 저장해준다음이 문제,
            //읽어온 객체가 어떤타입인지 모르기때문에 반드시 타입캐스팅을 해줘야함

            Object object = objectInputStream.readObject();

            //원래 저장할 때 컨테이너 타입이 ArrayList였다. 그러므로 일단 그 타입으로 캐스팅해야함
            //그 다음 그 안에 들어있는 각각의 객체가 String 타입이었음
            //각각의 String 타입객체를 뽑아서 화면에 출력

            //데이터파싱(Parsing)
            ArrayList<String> members = (ArrayList<String>) object;
            System.out.println(members.size());

            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
