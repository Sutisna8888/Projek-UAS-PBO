import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
 
public class viewBarang {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM view_barang");

            System.out.println("===== DAFTAR BARANG =====");
            System.out.printf("%-10s %-20s %-10s %-10s %-15s\n", "Kode", "Nama", "Harga", "Stok", "Total Nilai");

            boolean dataAda = false;
            while (rs.next()) {
                dataAda = true;
                System.out.printf(
                    "%-10s %-20s Rp%-9d %-10d Rp%-15d\n",
                    rs.getString("kode"),
                    rs.getString("nama"),
                    rs.getInt("harga"),
                    rs.getInt("stok"),
                    rs.getInt("total_nilai")
                );
            }

            if (!dataAda) {
                System.out.println("Tidak ada data barang yang tersedia.");
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Kesalahan SQL saat menampilkan data: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Kesalahan umum: " + e.getMessage());
        }
    }
}
