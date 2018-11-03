/**
 * 
 */
package Integracion.Sala;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Integracion.ConexionMySQL;

import Negocio.Sala.TSala;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author gerar
 */
public class DAOSalaImp implements DAOSala {
	/** 
	 * (non-Javadoc)
	 * @see DAOSala#create(TSala tSala)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int create(TSala tSala) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		String insert = "INSERT INTO `SALAS` (`IdSala`, `Nombre`, `Columnas`, `Filas`, `Estado`) "
				+ "VALUES (NULL,?,?,?,?);";
		ConexionMySQL conn = new ConexionMySQL();
		Connection conexion = (Connection) conn.getConnection();
		try {
			conexion.setAutoCommit(false);
			PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(insert);
			ps.setString(1, tSala.getNombre());
			ps.setInt(2, tSala.getColumnas());
			ps.setInt(3, tSala.getFilas());
			ps.setBoolean(4, tSala.isEstado());
			ps.executeUpdate();
			conexion.commit();
			return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 1;
		} 
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOSala#read(String Nombre)
	 */
	public TSala read(String Nombre) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		ConexionMySQL conn = new ConexionMySQL();
		
		Statement st;
		TSala tSala = null;
		try {
			st = (Statement) conn.getStatement();
			String sql = "SELECT * FROM SALAS WHERE Nombre = '" + Nombre + "'";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				tSala = new TSala(rs.getInt("IdSala"),rs.getBoolean("Estado"),
						rs.getInt("Filas"), rs.getInt("Columnas"), rs.getString("Nombre"));
			}
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return tSala;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOSala#readAll()
	 */
	public ArrayList<TSala> readAll() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente		
		ConexionMySQL conn = new ConexionMySQL();
		
		Statement st;
		ArrayList<TSala> tSalas = new ArrayList<TSala>();
		try {
			st = (Statement) conn.getStatement();
			String sql = "SELECT * FROM SALAS";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				TSala tSala = new TSala(rs.getInt("IdSala"),rs.getBoolean("Estado"),
						rs.getInt("Filas"), rs.getInt("Columnas"), rs.getString("Nombre"));
				tSalas.add(tSala);
			}
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return tSalas;
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see DAOSala#update(TSala tSala)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int update(TSala tSala) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		/*ConexionMySQL conn = new ConexionMySQL();
		int estado = 0;
		if (tSala.isEstado()) {
			estado = 1;
		}
		String sql = "UPDATE `SALAS` SET `Nombre`='" + tSala.getNombre() + "',"
				+ "`Columnas`='" + tSala.getColumnas() + "',`Filas`='"
				+ tSala.getFilas() + "',`Estado`='" + estado + "' "
				+ "WHERE IDSALA = '" + tSala.getIdSala() + "'";
		conn.execute(sql);
		return 1;*/
		
		PreparedStatement update = null;
		ConexionMySQL conn = new ConexionMySQL();
		Connection conexion = (Connection) conn.getConnection();
        boolean nuevaImagen = true;
		try {
            String sql = "UPDATE `salas` SET `Nombre`=?,`Columnas`=?,`Filas`=?,`Estado`=? WHERE IdSala = '"+tSala.getIdSala()+"'";
            
            update = (PreparedStatement) conexion.prepareStatement(sql);

            update.setString(1, tSala.getNombre());
            update.setInt(2,tSala.getColumnas());
            update.setInt(3,tSala.getFilas());   
            update.setBoolean(4, tSala.isEstado());
            
            update.executeUpdate(); 
            return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 1;
		}
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOSala#delete()
	 */
	public int delete(TSala tSala) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		/*ConexionMySQL conn = new ConexionMySQL();
		String sql = "DELETE FROM SALAS WHERE IDSALA = '" + tSala.getIdSala()
				+ "'";
		conn.execute(sql);
		return 1;*/
		
		String delete = "DELETE FROM SALAS WHERE IDSALA = '" + tSala.getIdSala()+"'";
		PreparedStatement ps = null;
		ConexionMySQL conn = new ConexionMySQL();
		Connection conexion = (Connection) conn.getConnection();
		try {
            conexion.setAutoCommit(false);
			ps = (PreparedStatement) conexion.prepareStatement(delete);
			conexion.setAutoCommit(false);
			ps.executeUpdate();
			conexion.commit();
			return 0;			
		} catch (Exception ex) {
			ex.printStackTrace();
			return 1;
		}
		// end-user-code
	}
	
}