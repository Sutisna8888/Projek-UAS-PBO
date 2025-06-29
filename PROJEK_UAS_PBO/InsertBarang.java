import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class InsertBarang {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Kode: ");
            String kode = sc.nextLine().trim();
            System.out.print("Nama: ");
            String nama = sc.nextLine().trim();
            System.out.print("Harga: ");
            int harga = sc.nextInt();
            System.out.print("Stok: ");
            int stok = sc.nextInt();

            if (kode.isEmpty() || nama.isEmpty()) {
                System.out.println("Error: Kode dan nama barang tidak boleh kosong.");
                return;
            }
            if (harga < 0 || stok < 0) {
                System.out.println("Error: Harga dan stok harus bernilai positif.");
                return;
            }

            Connection conn = DBConnection.getConnection();
            CallableStatement stmt = conn.prepareCall("{CALL insert_barang(?, ?, ?, ?)}");
            stmt.setString(1, kode);
            stmt.setString(2, nama);
            stmt.setInt(3, harga);
            stmt.setInt(4, stok);
            stmt.execute();

            System.out.println("Data berhasil dimasukkan ke dalam database.");
            conn.close();

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Gagal insert: Kode barang sudah ada di database.");
        } catch (SQLException e) {
            System.out.println("Kesalahan SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Kesalahan umum: " + e.getMessage());
        }
    }
}
