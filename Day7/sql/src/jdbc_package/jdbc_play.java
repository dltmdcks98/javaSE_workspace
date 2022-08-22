package jdbc_package;

import java.sql.*;

public class jdbc_play {
    public static void main(String[] args) {
        Connection con = null;

        String server = "localhost:3306";
        String database = "jdbc_db";
        String user_name = "root";
        String password = "";

        //드라이버 로딩
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e ){
            System.err.println("JDBC err");
            e.printStackTrace();
        }
//연결
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","");

            //jdbc 를 이용해서 어떤 작업(저장,검색,삭제,수정을 실행하는 부분
            //jdbc는 프리페어드라라는 기능을 사용할 수 있음(Prepared)
            //이 기능은 SQL명령어에서 특정한 부분 (데이터가 들어가는)을 변수처리한다음, 나중에 처리하는 방식
            String str = "INSERT INTO jdbc_db(name,id,pass) VALUES (?,?,?)";
            String del = "DELETE FROM jdbc_db";
            String search = "SELECT name FROM jdbc_db WHERE name = 'LEE'";
            PreparedStatement p_stmt;

            p_stmt = con.prepareStatement(search);


            p_stmt.setString(1,"LEE");
            p_stmt.setString(2,"admin");
            p_stmt.setString(3,"17171");

//            서버로 SQL 명령어 전송, 저장
            p_stmt.execute();



            System.out.println("success");
        }catch (SQLException e){
            System.err.println("con err");
            e.printStackTrace();
        }
////해제
//        try{
//            if(con != null){
//                con.close();
//            }
//        }catch (SQLException e){
//
//        }

    }
}
