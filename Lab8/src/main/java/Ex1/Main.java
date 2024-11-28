package Ex1;

import java.sql.*;
import java.util.Scanner;

class MainApp {
    public static void adaugare(Connection connection,  String nume, int varsta) {
        String sql="insert into persoane (Nume,Varsta) values (?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setString(1, nume);
            ps.setInt(2, varsta);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void excursie(Connection connection,String value, int id_excursie,int id_persoana,String destinatie,int anul) throws SQLException {
        String checkSQL = "SELECT COUNT(*) FROM persoane WHERE Nume = ?";
        PreparedStatement pstmt = connection.prepareStatement(checkSQL);
        pstmt.setString(1, value);
        ResultSet rs = pstmt.executeQuery();
         if (rs.next()) {
         int count = rs.getInt(1);
            if (count > 0) {
                System.out.println("User exists.");
                String sql="insert into excursii (Destinatie,anul,id_persoana) values (?,?,?)";
                PreparedStatement ps=connection.prepareStatement(sql);
                ps.setString(1, destinatie);
                ps.setInt(2, anul);
                ps.setInt(3, id_persoana);
                int nr_randuri=ps.executeUpdate();
                System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
            }
            else { System.out.println("User does not exist."); } }

    }
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/schema";
        String sql="select * from persoane";
        Connection connection= DriverManager.getConnection(url, "root", "12345");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next())
            System.out.println("id=" + rs.getInt("Id") + ", Nume= "
                    + rs.getString("Nume") + ",Varsta=" + rs.getInt("Varsta"));
        adaugare(connection,"Cocos3",15);
        excursie(connection,"Cocos3",1,1,"Malai",2000);
        connection.close();
        statement.close();
        rs.close();
    }
}