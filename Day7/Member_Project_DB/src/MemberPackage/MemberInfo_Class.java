package MemberPackage;

import java.io.Serializable;
import java.sql.*;

public class MemberInfo_Class implements Serializable {
   String m_name, m_phone,m_id,m_pw;
    public MemberInfo_Class() {

    }



    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_phone() {
        return m_phone;
    }

    public void setM_phone(String m_phone) {
        this.m_phone = m_phone;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_pw() {
        return m_pw;
    }

    public void setM_pw(String m_pw) {
        this.m_pw = m_pw;
    }

    public void putM_name(){
        System.out.println(m_name);
    }
    public void putM_id(){
        System.out.println(m_id);
    }
    public void putM_phone(){
        System.out.println(m_phone);
    }
    public void putM_pw(){
        System.out.println(m_pw);
    }

    void insertSQL(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/member_db","root","");
            String str = "INSERT INTO member_t(m_name,m_phone,m_id,m_pw) VALUES (?,?,?,?)";
            PreparedStatement p_stmt;
            p_stmt = con.prepareStatement(str);

            p_stmt.setString(1,m_name);
            p_stmt.setString(2,m_phone);
            p_stmt.setString(3,m_id);
            p_stmt.setString(4,m_pw);

            //서버로 SQL 명령어 전송
            p_stmt.execute();

            System.out.println("success");
        }catch (SQLException e){
            System.err.println("con err");
            e.printStackTrace();
        }

        try{
            if(con != null){
                con.close();
            }
        }catch (SQLException e){

        }
    }

    void searchSQL(String input){
        Connection con = null;
        ResultSet rs =null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/member_db","root","");

            String str = "SELECT * FROM member_t WHERE m_name =?";
            PreparedStatement p_stmt;
            p_stmt = con.prepareStatement(str);

            p_stmt.setString(1,input);

            rs = p_stmt.executeQuery();
            while(rs.next()){
//                인덱스가 1부터 시작
                System.out.println("name :"+rs.getString(1)+"\n"+
                        "phone : "+rs.getString(2)+"\n"+
                        "id : "+rs.getString(3)+"\n"+
                        "pw : "+rs.getString(4)
                );
            }

            System.out.println("success");
        }catch (SQLException e){
            System.err.println("con err");
            e.printStackTrace();
        }

        try{
            if(con != null){
                con.close();
            }
        }catch (SQLException e){

        }
    }
    void deleteSQL(String input){
        Connection con =null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/member_db","root","");
            String str = "DELETE FROM member_t WHERE m_name = ?";
            PreparedStatement p_stmt;
            p_stmt = con.prepareStatement(str);
            p_stmt.setString(1, input);
            p_stmt.execute();

            System.out.println("success");
        }catch (SQLException e){
            System.err.println("con err");
            e.printStackTrace();
        }

        try{
            if(con != null){
                con.close();
            }
        }catch (SQLException e){

        }
    }
}
