/**
 * 
 */
package Integracion.Pelicula;

import Integracion.ConexionMySQL;

import Negocio.Pelicula.Imagen;
import Negocio.Pelicula.TPelicula;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author gerar
 */
public class DAOPeliculaImp implements DAOPelicula {
	/** 
	 * (non-Javadoc)
	 * @see DAOPelicula#create(TPelicula tPelicula)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int create(TPelicula tPelicula) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		String insert = "insert into Peliculas(idPelicula,Titulo,Duracion,Clasificacion,Estado,nomImg,tamImg) values(NULL,?,?,?,?,?,?)";
		FileInputStream fis = null;
		PreparedStatement ps = null;
		ConexionMySQL conn = new ConexionMySQL();
		Connection conexion = (Connection) conn.getConnection();
		try {
			conexion.setAutoCommit(false);
			File file = new File(tPelicula.getImagen().getRuta());
			fis = new FileInputStream(file);
			ps = (PreparedStatement) conexion.prepareStatement(insert);
			ps.setString(1, tPelicula.getTitulo());
			ps.setInt(2, tPelicula.getDuracion());
			ps.setString(3, tPelicula.getClasificacion());
			ps.setBoolean(4, tPelicula.isEstado());
			ps.setString(5, tPelicula.getTitulo() + ".jpg");
			ps.setBinaryStream(6, fis, (int) file.length());

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
	 * (non-Javadoc)
	 * @see DAOPelicula#delete(TPelicula tPelicula)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int delete(Integer idPelicula) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente		
		String delete = "DELETE FROM PELICULAS WHERE IDPELICULA = '"
				+ idPelicula + "'";
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

	/** 
	 * (non-Javadoc)
	 * @see DAOPelicula#read(String nombre)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TPelicula read(String nombre) {
		ConexionMySQL conn = new ConexionMySQL();
		String sql = "SELECT * FROM PELICULAS WHERE Titulo = '" + nombre + "'";
		Connection conexion = (Connection) conn.getConnection();
		Statement st;
		TPelicula tPelicula = null;
		try {
			st = (Statement) conn.getStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PELICULAS WHERE Titulo = '" + nombre + "'");
			if (rs.next()) {
				Imagen imagen;
				Blob blob = (Blob) rs.getBlob("tamImg");
				//String nombre = rs.getObject("nombre").toString();
				byte[] data = blob.getBytes(1, (int) blob.length());
				BufferedImage img = null;
				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (IOException ex) {

				}
				imagen = new Imagen(img, null);
				tPelicula = new TPelicula(rs.getInt("idPelicula"),
						rs.getString("titulo"), rs.getInt("Duracion"),
						rs.getString("clasificacion"), rs.getBoolean("estado"),
						imagen);
			}
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return tPelicula; 
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOPelicula#readAll()
	 */
	public ArrayList<TPelicula> readAll() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		ConexionMySQL conn = new ConexionMySQL();

		ArrayList<TPelicula> tPeliculas = new ArrayList<TPelicula>();
		Statement st;
		try {
			st = (Statement) conn.getStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PELICULAS");
			while (rs.next()) {
				Imagen imagen;
				Blob blob = (Blob) rs.getBlob("tamImg");
				//String nombre = rs.getObject("nombre").toString();
				byte[] data = blob.getBytes(1, (int) blob.length());
				BufferedImage img = null;
				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (IOException ex) {

				}
				imagen = new Imagen(img, null);
				TPelicula tPelicula = new TPelicula(rs.getInt("idPelicula"),
						rs.getString("titulo"), rs.getInt("Duracion"),
						rs.getString("clasificacion"), rs.getBoolean("estado"),
						imagen);
				tPeliculas.add(tPelicula);
			}
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return tPeliculas;
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see DAOPelicula#update(TPelicula tPelicula)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int update(TPelicula tPelicula) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		PreparedStatement update = null;
		ConexionMySQL conn = new ConexionMySQL();
		Connection conexion = (Connection) conn.getConnection();
        boolean nuevaImagen = true;
		try {
            String sql = "UPDATE peliculas SET Titulo = ?, Duracion = ?, Clasificacion = ?, Estado = ?,nomImg = ?,tamImg = ? WHERE idPelicula = ?";
            if(tPelicula.getImagen().getRuta() == null){
                sql = "UPDATE peliculas SET Titulo = ?, Duracion = ?, Clasificacion = ?, Estado = ?,nomImg = ? WHERE idPelicula = ?";
                nuevaImagen = false;
            }
            update = (PreparedStatement) conexion.prepareStatement(sql);

            update.setString(1, tPelicula.getTitulo());
            update.setInt(2, tPelicula.getDuracion());
            update.setString(3, tPelicula.getClasificacion());
            
            update.setBoolean(4,tPelicula.isEstado());
            update.setString(5, tPelicula.getTitulo() + ".jpg");         
            
            if(nuevaImagen){
                File file = new File(tPelicula.getImagen().getRuta());
                FileInputStream fis = new FileInputStream(file);
                update.setBinaryStream(6, fis, (int) file.length());
                update.setBinaryStream(6, fis, (int) file.length());
                update.setInt(7, tPelicula.getIdPelicula());                        
            }else{
                update.setInt(6, tPelicula.getIdPelicula());  
            }
            
            update.executeUpdate(); 
            return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 1;
		}
		// end-user-code
	}

	@Override
	public ArrayList readAllPorSesionFecha(Date fecha) {
		// TODO Apéndice de método generado automáticamente
		ConexionMySQL conn = new ConexionMySQL();

		ArrayList<TPelicula> tPeliculas = new ArrayList<TPelicula>();
		Statement st;
		try {
			st = (Statement) conn.getStatement();
			String sql = "SELECT * FROM SESIONES S,peliculas P WHERE S.idPelicula = P.idPelicula AND Fecha = '"
			+(fecha.getYear()+1900)+"-"+(fecha.getMonth()+1)+"-"+fecha.getDate()+"' GROUP BY P.IDPelicula";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Imagen imagen;
				Blob blob = (Blob) rs.getBlob("tamImg");
				//String nombre = rs.getObject("nombre").toString();
				byte[] data = blob.getBytes(1, (int) blob.length());
				BufferedImage img = null;
				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (IOException ex) {

				}
				imagen = new Imagen(img, null);
				TPelicula tPelicula = new TPelicula(rs.getInt("idPelicula"),
						rs.getString("titulo"), rs.getInt("Duracion"),
						rs.getString("clasificacion"), rs.getBoolean("estado"),
						imagen);
				tPeliculas.add(tPelicula);
			}
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return tPeliculas;
	}
}