package mvcDatabaseContactList;

import java.sql.Connection;
import  java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import  java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Model {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbcontact";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public Model() {
        try {
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public void insertContact(String nama, String noHP, String umur, String email) {
        try{
            String query = "INSERT INTO `contact` (`nama`, `noHP`, `umur`, `email`) VALUES ('"+nama+"','"+noHP+"','"+umur+"','"+email+"')";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Contact was successfully added");
            JOptionPane.showMessageDialog(null, "Successfull!");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readContact() {
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][4];

            String query = "Select * from `contact`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("Nama");
                data[jmlData][1] = resultSet.getString("NoHP");
                data[jmlData][2] = resultSet.getString("Umur");
                data[jmlData][3] = resultSet.getString("Email");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public ArrayList<String> readNama(){
        try{
            ArrayList<String> data = new ArrayList<>();
            String query = "Select * from `contact`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data.add(resultSet.getString("Nama"));
            }
            return data;
        }catch (SQLException e) {
            return null;
        }
    }

    public int getBanyakData() {
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `contact`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteContact (String nama) {
        try{
            String query = "DELETE FROM `contact` WHERE `nama` = '"+nama+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Successfully Deleted");
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void updateContact(String nama, String noHP, String umur, String email) {
        try{
            String query = "UPDATE `contact` set `nama`='"+nama+"', `noHP`='"+noHP+"', `umur`='"+umur+"', `email`='"+email+"' where nama='"+nama+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Updated Successfully");
            JOptionPane.showMessageDialog(null, "Database Updated Successfully");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
}
