package simple_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class KoneksiDb {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/perpustakaan";
    static final String USER = "pbo";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("MENU PILIHAN");
    	System.out.println("1. insert");
    	System.out.println("2. show");
    	System.out.println("3. update");
    	System.out.println("4. delete");
    	System.out.print("Pilih opsi: ");

    	int opsi;

    	
    	while (true) {
    		opsi = scanner.nextInt();
    		if (opsi < 1 || opsi > 4) {
    			System.out.println("Opsi tidak valid. Pilih lagi: ");
    			scanner.nextLine();
    			continue;
    		}
    		break;
    	}
		
		switch (opsi) {
		case 1:
			insert();
			break;
		case 2:
			show();
			break;
		case 3:
			update();
			break;
		case 4:
			delete();
			break;
		}
    	
    	scanner.close();
    	
    }
    
	
	public static void insert()	{
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Judul buku: ");
			String judul_buku = scanner.nextLine();
			System.out.print("Tahun terbit: ");
			int tahun_terbit = scanner.nextInt();
			scanner.nextLine();		
			int stok;
			while (true) {
				System.out.print("Stok: ");
				stok = scanner.nextInt();
				scanner.nextLine();		
				if (stok >= 0 && stok <= 255) {
					break;
				}
				System.out.println("Nilai stok tidak valid. Pastikan masuk ke dalam range 0-255");
			}
			System.out.print("ID Penulis: ");
			int id_penulis = scanner.nextInt();
			
			try {
				
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				PreparedStatement ps;
				int id_buku;
				while (true) {
					System.out.print("ID Buku: ");
					id_buku = scanner.nextInt();
					String primary_check_stmt = "SELECT * FROM buku WHERE id=?";
					ps = conn.prepareStatement(primary_check_stmt);
					ps.setInt(1, id_buku);
					
					rs = ps.executeQuery();
					
					if (rs.next()) {
						System.out.println("ID buku sudah tercatat. Masukkan yang lain.");
						continue;
					}
					
					break;
				}
				
				
				String sql = "INSERT INTO buku (id, judul_buku, tahun_terbit, stok, penulis) VALUES (?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, id_buku);
				ps.setString(2, judul_buku);
				ps.setInt(3, tahun_terbit);
				ps.setInt(4, stok);
				ps.setInt(5, id_penulis);
				
				ps.execute();
				
				System.out.println("Data berhasil diinput.");
				
				
				ps = conn.prepareStatement("SELECT * FROM penulis WHERE id=?");
				ps.setInt(1, id_penulis);
				rs = ps.executeQuery();
				
				if (!rs.next()) {
					System.out.println("Nama penulis belum terdaftar.");
					System.out.println("Masukkan nama penulis");
					String nama_penulis = scanner.nextLine();
					ps = conn.prepareStatement("INSERT INTO penulis VALUES (?, ?)");
					ps.setInt(1, id_penulis);
					ps.setString(2, nama_penulis);
					ps.execute();
					
					System.out.println("Penulis berhasil terdaftar.");
				}
				
				scanner.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	public static void show()
		{
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery("SELECT * FROM buku");
				
				int i = 1;
				while(rs.next())
				{
					System.out.println("Data ke-"+i);
					System.out.println("Id buku: " + rs.getString("id"));
					System.out.println("Judul buku: "+rs.getString("judul_buku"));
					System.out.println("Tahunt terbit: "+rs.getString("tahun_terbit"));
					System.out.println("Stok: "+rs.getString("stok"));
					System.out.println("Id penulis: "+rs.getString("penulis"));
					System.out.println("-".repeat(20));
					i++;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	public static void update() {
			
			
			try {
				
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				
				Scanner scanner = new Scanner(System.in);
				System.out.print("ID buku yang mau diupdate: ");
				int id_buku = scanner.nextInt();
				// Cek apakah id buku memang ada
				String check_statement = "SELECT * FROM buku WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(check_statement);
				while (true) {
					ps.setInt(1, id_buku);
					rs = ps.executeQuery();
					if (!rs.next()) {
						System.out.print("ID Buku tidak ditemukan. Masukkan yang lain: ");
						id_buku = scanner.nextInt();
						continue;
					}
					break;
				}
				scanner.nextLine();			
				System.out.print("Judul buku: ");
				String judul_buku = scanner.nextLine();
				System.out.print("Tahun terbit: ");
				int tahun_terbit = scanner.nextInt();
				scanner.nextLine();		
				int stok;
				while (true) {
					System.out.print("Stok: ");
					stok = scanner.nextInt();
					scanner.nextLine();		
					if (stok >= 0 && stok <= 255) {
						break;
					}
					System.out.println("Nilai stok tidak valid. Pastikan masuk ke dalam range 0-255");
				}
				System.out.print("ID Penulis: ");
				int id_penulis = scanner.nextInt();
				scanner.nextLine();				

				String core_statement = "UPDATE buku SET judul_buku=?, tahun_terbit=?, stok=?, penulis=? WHERE id=?";		
				ps = conn.prepareStatement(core_statement);
				
				ps.setString(1, judul_buku);
				ps.setInt(2, tahun_terbit);
				ps.setInt(3, stok);
				ps.setInt(4, id_penulis);
				ps.setInt(5, id_buku);
				ps.execute();
				
				System.out.println("Data berhasil diupdate.");
				
				
				ps = conn.prepareStatement("SELECT * FROM penulis WHERE id=?");
				ps.setInt(1, id_penulis);
				rs = ps.executeQuery();
				
				if (!rs.next()) {
					System.out.println("Nama penulis belum terdaftar.");
					System.out.println("Masukkan nama penulis");
					String nama_penulis = scanner.nextLine();
					ps = conn.prepareStatement("INSERT INTO penulis VALUES (?, ?)");
					ps.setInt(1, id_penulis);
					ps.setString(2, nama_penulis);
					ps.execute();
					
					System.out.println("Penulis berhasil terdaftar.");
				}
				
				scanner.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	public static void delete() {
		
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Masukkan ID Buku yang ingin dihapus: ");
			int id_buku = scanner.nextInt();
			
			scanner.close();
			
			
			String delete_statement = "DELETE FROM buku WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(delete_statement);
			
			ps.setInt(1, id_buku);
			
			ps.execute();
			
			System.out.println("Data berhasil dihapus.");
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
