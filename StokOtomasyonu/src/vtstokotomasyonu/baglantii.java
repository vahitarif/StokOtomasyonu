package vtstokotomasyonu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baglantii {
	
	static Connection mconn;
	static Statement myStat;
	
	static ResultSet yap() {
		ResultSet mrs = null;
		try {
			
			mconn = (Connection) DriverManager.getConnection("jdbc:sqlite:A://ödev/stokotomasyonu.db");
			myStat = (Statement) mconn.createStatement();
			mrs = myStat.executeQuery("select * from tblmusteriler");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mrs;
	}
	
	static boolean baglan() {
        Statement st;
        ResultSet rs;

        try {
            mconn = DriverManager.getConnection("jdbc:sqlite:A://ödev/stokotomasyonu.db");
            System.out.println("Baðlantý mükemmel!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	static void yenimusteri(String sql_string) {
		
		try {
			myStat.executeUpdate(sql_string);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void musteriguncelleme(String sql_string) {
		try {
			myStat.executeUpdate(sql_string);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void musterisilme(String sql_string) {
        Statement st;
        try {
            st = mconn.createStatement();
            st.executeUpdate(sql_string);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	static ResultSet sorgu(String sql_string) {
		ResultSet mrs = null;
		
		try {
			mrs= myStat.executeQuery(sql_string);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mrs;
	}
}
