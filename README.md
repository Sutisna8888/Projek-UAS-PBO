**#Penjelasan file:**

**DBConnection.java**
Berisi kode untuk membuat koneksi ke database MySQL menggunakan driver JDBC. File ini menjadi dasar koneksi yang dipakai oleh file lain.

**InsertBarang.java**
Program yang digunakan untuk memasukkan data barang ke database. Data diinput oleh user, kemudian dikirim ke database menggunakan CALL PROCEDURE. Jika insert berhasil, trigger akan otomatis menyimpan log waktu ke tabel log_insert_barang.

**viewBarang.java**
Program untuk menampilkan data barang dari VIEW yang telah dibuat di database. Output ditampilkan dalam bentuk tabel yang rapi, termasuk kolom total_nilai.

**lib/mysql-connector-j-9.3.0.jar**
Merupakan file JDBC driver resmi dari MySQL. File ini diperlukan agar program Java dapat berkomunikasi dengan database. 
