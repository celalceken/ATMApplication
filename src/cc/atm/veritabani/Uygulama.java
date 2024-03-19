package cc.atm.veritabani;

/***** Veritabanı sorgulama örneği *****/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Uygulama {

    public static void main(String[] args)
    {
        try
        {   /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nw4",
                    "postgres", "LecturePassword");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");


            String sql= "SELECT *  FROM \"customers\"";

            /***** Sorgu çalıştırma *****/
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            /***** Bağlantı sonlandırma *****/
            conn.close();

            String musteriNo;
            String adi;
            String soyadi;

            while(rs.next())
            {
                /***** Kayda ait alan değerlerini değişkene ata *****/
                musteriNo  = rs.getString("CustomerID");
                adi = rs.getString("CompanyName");
                soyadi = rs.getString("ContactName");

                /***** Ekrana yazdır *****/
                System.out.print("Sıra No:"+ musteriNo);
                System.out.print(", Adı:" + adi);
                System.out.println(", Soyadı:" + soyadi);
            }

            /***** Kaynakları serbest bırak *****/
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
