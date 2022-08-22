package jdbc_package;

import java.sql.*;

public class jdbc_play {
    public static void main(String[] args) {
        Connection con = null;

        String server = "localhost:3306";
        String database = "jdbc_db";
        String user_name = "root";
        String password = "";

        //����̹� �ε�
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e ){
            System.err.println("JDBC err");
            e.printStackTrace();
        }
//����
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","");

            //jdbc �� �̿��ؼ� � �۾�(����,�˻�,����,������ �����ϴ� �κ�
            //jdbc�� ����������� ����� ����� �� ����(Prepared)
            //�� ����� SQL��ɾ�� Ư���� �κ� (�����Ͱ� ����)�� ����ó���Ѵ���, ���߿� ó���ϴ� ���
            String str = "INSERT INTO jdbc_db(name,id,pass) VALUES (?,?,?)";
            String del = "DELETE FROM jdbc_db";
            String search = "SELECT name FROM jdbc_db WHERE name = 'LEE'";
            PreparedStatement p_stmt;

            p_stmt = con.prepareStatement(search);


            p_stmt.setString(1,"LEE");
            p_stmt.setString(2,"admin");
            p_stmt.setString(3,"17171");

//            ������ SQL ��ɾ� ����, ����
            p_stmt.execute();



            System.out.println("success");
        }catch (SQLException e){
            System.err.println("con err");
            e.printStackTrace();
        }
////����
//        try{
//            if(con != null){
//                con.close();
//            }
//        }catch (SQLException e){
//
//        }

    }
}
