package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Levy;

import java.sql.PreparedStatement;

public class LevyDAO {

	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement stmtPrep = null;
	private String sql;

	private Connection yhdista() {
		Connection con = null;
		String JDBCAjuri = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/a1602727";
		try {
			Class.forName(JDBCAjuri);
			con = DriverManager.getConnection(url, "xxxxxxxx", "xxxxxxxxx"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String login(String kayttaja, String salasana) {
		String nimi = null;
		sql = "SELECT Nimi FROM kayttaja WHERE kayttaja = ? AND salasana = ?";
		try {
			con = yhdista();
			stmtPrep = con.prepareStatement(sql);
			stmtPrep.setString(1, kayttaja);
			stmtPrep.setString(2, salasana);
			rs = stmtPrep.executeQuery();

			if (rs.isBeforeFirst()) {
				rs.next();
				nimi = rs.getString("Nimi");
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nimi;
	}

	public boolean lisaaLevy(Levy levy) {
		boolean paluu = true;
		sql = "INSERT INTO levy (levyArtisti, levyNimi, julkaisuVuosi, formaatti, levyYhtio, genre) VALUES (?, ?, ?, ?, ?, ?);";
		try {
			con = yhdista();
			stmtPrep = con.prepareStatement(sql);
			stmtPrep.setString(1, levy.getLevyArtisti());
			stmtPrep.setString(2, levy.getLevyNimi());
			stmtPrep.setInt(3, levy.getJulkaisuVuosi());
			stmtPrep.setString(4, levy.getFormaatti());
			stmtPrep.setString(5, levy.getLevyYhtio());
			stmtPrep.setString(6, levy.getGenre());
			stmtPrep.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			paluu = false;
		}
		return paluu;
	}

	public ArrayList<Levy> listaaKaikki() {
		ArrayList<Levy> levyt = new ArrayList<Levy>();
		sql = "SELECT * FROM levy";
		try {
			con = yhdista();
			if (con != null) {
				stmtPrep = con.prepareStatement(sql);
				rs = stmtPrep.executeQuery();
				if (rs != null) {
					con.close();
					while (rs.next()) {
						Levy levy = new Levy();
						levy.setId(rs.getInt(1));
						levy.setLevyArtisti(rs.getString(2));
						levy.setLevyNimi(rs.getString(3));
						levy.setJulkaisuVuosi(rs.getInt(4));
						levy.setFormaatti(rs.getString(5));
						levy.setLevyYhtio(rs.getString(6));
						levy.setGenre(rs.getString(7));
						levyt.add(levy);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return levyt;

	}

	public ArrayList<Levy> listaaKaikki(String hakusana) {
		ArrayList<Levy> levyt = new ArrayList<Levy>();
		sql = "SELECT * FROM levy WHERE levyArtisti LIKE ? OR levyNimi LIKE ? OR formaatti LIKE ? OR levyYhtio LIKE? OR genre LIKE ?;";

		try {
			con = yhdista();
			if (con != null) {
				stmtPrep = con.prepareStatement(sql);
				stmtPrep.setString(1, "%" + hakusana + "%");
				stmtPrep.setString(2, "%" + hakusana + "%");
				stmtPrep.setString(3, "%" + hakusana + "%");
				stmtPrep.setString(4, "%" + hakusana + "%");
				stmtPrep.setString(5, "%" + hakusana + "%");
				rs = stmtPrep.executeQuery();
				if (rs != null) {
					con.close();
					while (rs.next()) {
						Levy levy = new Levy();
						levy.setId(rs.getInt(1));
						levy.setLevyArtisti(rs.getString(2));
						levy.setLevyNimi(rs.getString(3));
						levy.setJulkaisuVuosi(rs.getInt(4));
						levy.setFormaatti(rs.getString(5));
						levy.setLevyYhtio(rs.getString(6));
						levy.setGenre(rs.getString(7));
						levyt.add(levy);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return levyt;
	}
	
	public boolean poistaLevy(String id){
		boolean paluu= true;
		sql = "DELETE FROM levy WHERE levyId = ?;";
		try {
			con = yhdista();
			stmtPrep = con.prepareStatement(sql);
			stmtPrep.setString(1, id);
			stmtPrep.executeUpdate();
			con.close();
		} catch (SQLException e) {				
			e.printStackTrace();
			paluu = false;
		}
		return paluu;
	}
	
	public boolean muutaLevy(Levy levy, String id){
		boolean paluu = true;
		sql = "UPDATE levy SET levyArtisti = ?, levyNimi = ?, julkaisuVuosi = ?, formaatti = ?, levyYhtio = ?, genre = ? WHERE levyId = ?";
		try {
			con = yhdista();
			stmtPrep = con.prepareStatement(sql);
			stmtPrep.setString(1, levy.getLevyArtisti());
			stmtPrep.setString(2, levy.getLevyNimi());
			stmtPrep.setInt(3, levy.getJulkaisuVuosi());
			stmtPrep.setString(4, levy.getFormaatti());
			stmtPrep.setString(5, levy.getLevyYhtio());
			stmtPrep.setString(6, levy.getGenre());
			stmtPrep.setString(7, id);
			stmtPrep.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			paluu = false;
		}
		
		return paluu;
	}
	

}
