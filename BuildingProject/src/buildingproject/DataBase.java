package buildingproject;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javax.swing.JOptionPane;

public class DataBase {
  public static String DB_NAME =  "building_material_company";
  public static String HOST = "127.0.0.1";
  public static int PORT = 3306;
  public static String PASS = "";
 
  
  public static Connection getConnection(){
      Connection con = null;
      try {
          con = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DB_NAME,"root","");
      } catch (SQLException ex) {
         System.out.println(ex+"");
      }
      
      return con;
  }
    
  public static void insertProduct(String code,String designation,float prix_unitaire,String unite_de_mesure,int disponibilty,String type){
      Connection con = null;
      try {
          String sql = "INSERT INTO products (code,designation,prix_unitaire,unite_de_mesure,disponibility,type) VALUES (?,?,?,?,?,?)";
          con = getConnection();
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, code);
          ps.setString(2, designation);
          ps.setFloat(3, prix_unitaire);
          ps.setString(4, unite_de_mesure);
          ps.setInt(5, disponibilty);
          ps.setString(6, type);
          ps.executeUpdate();
          
      } catch (Exception e) {
          System.out.println(e+"");
      }
     
  }
  
  
  
   public static void updateProduct(String designation,int disponibility){
      Connection con = null;
      try {
          String sql = "UPDATE  products  SET disponibility=? WHERE designation=?";
          con = getConnection();
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setInt(1, disponibility);
          ps.setString(2, designation);
          
          ps.executeUpdate();
          
      } catch (Exception e) {
          System.out.println(e+"");
          JOptionPane.showMessageDialog(null, "Ther is not such this product name in data base");
      }
   }
   
   public static void delProduct(String designation){
      Connection con = null;
      try {
          String sql = "DELETE FROM  products WHERE designation=?";
          con = getConnection();
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, designation);
          
          ps.executeUpdate();
          
      } catch (Exception e) {
          System.out.println(e+"");
          JOptionPane.showMessageDialog(null, "Ther is not such this product name in data base");
      }
   }
   
   public static ObservableList<Product> fetchAllProducts(String type){
       ObservableList<Product> list = FXCollections.observableArrayList();
       Connection con = null;
       try {
           con = getConnection();
           String sql = "SELECT * FROM products WHERE type=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, type);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
               list.add(new Product(rs.getString("code"), rs.getString("designation"), rs.getFloat("prix_unitaire"), rs.getString("unite_de_mesure"), rs.getInt("disponibility")));
               
           }
       } catch (Exception e) {
           System.out.println(e+"");
       }
       
       
       
       return list;
       
   }
   
   // Authontication && authorization 
   
   public static boolean isExist(String username, String password){
       Connection con = null;
       boolean exists = false;
       try {
           con = getConnection();
           String sql = "SELECT password,username FROM auth WHERE username = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, username);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
               if(rs.getString("password").equals(password) && rs.getString("username").equals(username)){
                   exists = true;
                   break;
               }
           }
           
       } catch (Exception e) {
       }
       
       return exists;
   }
   
   // DEALER DATA BASE .
   public static void insertDealer(String type, String nome, String prenome, String ville, String n2t,float payments, float dues, String date, String time, String matricule,int received){
       Connection con = null;
       try {
           con = getConnection();
           String sql = "INSERT INTO dealers (dealer_type,nome,prenome,ville,num_telephone,payments,dues,date,time,matricule,received) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, type);
           ps.setString(2, nome);
           ps.setString(3, prenome);
           ps.setString(4,ville);
           ps.setString(5, n2t);
           ps.setFloat(6, payments);
           ps.setFloat(7, dues);
           ps.setString(8, date);
           ps.setString(9, time);
           ps.setString(10, matricule);
           ps.setInt(11, received);
           ps.executeUpdate();
       
       } catch (Exception e) {
           System.out.println(e+"");
       }
   }
   
   // CLIENTS  && Black lists
   
   public static ObservableList<Dealer> fetchClients(){
       ObservableList<Dealer> list = FXCollections.observableArrayList();
       Connection con = null;
       try {
           con = getConnection();
           String sql = "SELECT matricule, nome, prenome, dues, num_telephone FROM dealers  WHERE dealer_type = ? AND black_list = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1,"Client");
           ps.setInt(2, 0);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               list.add(new Dealer(rs.getString("nome"), rs.getString("prenome"), rs.getFloat("dues"), rs.getString("matricule"),rs.getString("num_telephone")));
               System.out.println("HHH");
           }
           
       } catch (Exception e) {
           System.out.println(""+e);
       }
       return list;
   }
   
   public static ObservableList<Dealer> fetchCliensBL(){
       ObservableList<Dealer> list = FXCollections.observableArrayList();
       Connection con = null;
       try {
           con = getConnection();
           String sql = "SELECT matricule, nome, prenome, dues, num_telephone FROM dealers  WHERE dealer_type = ? AND black_list = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1,"Client");
           ps.setInt(2, 1);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               list.add(new Dealer(rs.getString("nome"), rs.getString("prenome"), rs.getFloat("dues"), rs.getString("matricule"),rs.getString("num_telephone")));
               System.out.println("HHH2");
           }
           
       } catch (Exception e) {
           System.out.println(""+e);
       }
       return list;
   }
   
   public static ObservableList<Dealer> fetchFourn(){
       ObservableList<Dealer> list = FXCollections.observableArrayList();
       Connection con = null;
       try {
           con = getConnection();
           String sql = "SELECT matricule, nome, prenome, dues, num_telephone FROM dealers  WHERE dealer_type = ? AND black_list = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1,"Fourniseur");
           ps.setInt(2, 0);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               list.add(new Dealer(rs.getString("nome"), rs.getString("prenome"), rs.getFloat("dues"), rs.getString("matricule"),rs.getString("num_telephone")));
               System.out.println("HHH3");
           }
           
       } catch (Exception e) {
           System.out.println(""+e);
       }
       return list;
   }
   
   public static ObservableList<Dealer> fetchFournBL(){
       ObservableList<Dealer> list = FXCollections.observableArrayList();
       Connection con = null;
       try {
           con = getConnection();
           String sql = "SELECT matricule, nome, prenome, dues, num_telephone FROM dealers  WHERE dealer_type = ? AND black_list = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1,"Fourniseur");
           ps.setInt(2, 1);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               list.add(new Dealer(rs.getString("nome"), rs.getString("prenome"), rs.getFloat("dues"), rs.getString("matricule"),rs.getString("num_telephone")));
               System.out.println("HHH4");
           }
           
       } catch (Exception e) {
           System.out.println(""+e);
       }
       return list;
   }
   
   public static void clientToBL(String matricule){
       Connection con = null;
       
       try {
           con = getConnection();
           String sql = "UPDATE dealers SET black_list= ? WHERE matricule = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, 1);
           ps.setString(2, matricule);
           ps.executeUpdate();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Matricule Not Found IN DataBase !!!!");
           
       }
   }
   
   public static void clientFromBL(String matricule){
       Connection con = null;
       
       try {
           con = getConnection();
           String sql = "UPDATE dealers SET black_list= ? WHERE matricule = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, 0);
           ps.setString(2, matricule);
           ps.executeUpdate();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Matricule Not Found IN DataBase !!!!");
           
       }
   }
   
   public static void fournToBL(String matricule){
       Connection con = null;
       
       try {
           con = getConnection();
           String sql = "UPDATE dealers SET black_list= ? WHERE matricule = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, 1);
           ps.setString(2, matricule);
           ps.executeUpdate();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Matricule Not Found IN DataBase !!!!");
           
       }
   }
   
   public static void fournFromBL(String matricule){
       Connection con = null;
       
       try {
           con = getConnection();
           String sql = "UPDATE dealers SET black_list= ? WHERE matricule = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, 0);
           ps.setString(2, matricule);
           ps.executeUpdate();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Matricule Not Found IN DataBase !!!!");
           
       }
   }
   
   public static void truncateAutTabl(){
       Connection con = null;
       try {
           con = getConnection();
           String sql = "TRUNCATE TABLE auth";
           PreparedStatement ps = con.prepareStatement(sql);
           
           ps.executeUpdate();
       } catch (Exception e) {
           System.out.println(e+"");
       }
   }
   
   public static void changeUserLogin(String name, String password){
       truncateAutTabl();
       Connection con = null;
       try {
           con = getConnection();
           String sql = "INSERT into auth (username, password) VALUES (?,?)";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, name);
           ps.setString(2, password);
           ps.executeUpdate();
       } catch (Exception e) {
           System.out.println(e+"");
       }
   }
   
   // ===============================================================
   
   public static ArrayList<Float> statistics(){
       ArrayList<Float> list = new ArrayList<>();
       Connection con = null;
       float fp = 0;
       float fd = 0;
       float cp = 0;
       float cd = 0;
       
       try {
           con = getConnection();
           String sql = "SELECT * FROM dealers";
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
               if(rs.getString("dealer_type").equals("Fourniseur")){
                   fp += rs.getFloat("payments");
                   fd += rs.getFloat("dues");
               }else if(rs.getString("dealer_type").equals("Client")){
                   cp += rs.getFloat("payments");
                   cd += rs.getFloat("dues");
               }
           }
           list.add(fp);
           list.add(fd);
           list.add(cp);
           list.add(cd);
       } catch (Exception e) {
           System.out.println(e+"");
       }
       return list;
   }
   
   
   // BON COUNT 
   
   
   public static int getCountBon(){
       Connection con = null;
       int result = 0;
       try {
           con = getConnection();
           String sql = "SELECT count From bon_count";
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               result = rs.getInt("count");
           }
       } catch (Exception e) {
       }
       
       return result;
   }
   
    public static void truncateCountTabl(){
       Connection con = null;
       try {
           con = getConnection();
           String sql = "TRUNCATE TABLE bon_count";
           PreparedStatement ps = con.prepareStatement(sql);
           
           ps.executeUpdate();
       } catch (Exception e) {
           System.out.println(e+"");
       }
   }
    
    public static void incrementCount(){
        Connection con = null;
        int count = getCountBon();
        System.out.println(count+"");
        ++count;
        truncateCountTabl();
        try {
            con = getConnection();
            String sql = "INSERT INTO bon_count (count) VALUES(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, count);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void closeConnectionDB(){
        try {
            Connection con = getConnection();
            con.close();
        } catch (Exception e) {
        }
    }
    
    
   
   
   
   
   
  
}
