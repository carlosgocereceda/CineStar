/**
 * 
 */
package Integracion.Sesion;

import Integracion.ConexionMySQL;
import Negocio.Pelicula.Imagen;
import Negocio.Pelicula.TPelicula;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Statement;

import Negocio.Sala.TSala;
import Negocio.Sesion.TSesion;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.Date;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOSesionImp implements DAOSesion {

	/** 
	 * (non-Javadoc)
	 * @see DAOSesion#read(Integer idSesion)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TSesion read(Integer idSesion) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		TSesion tSesion = null;
		ConexionMySQL conn = new ConexionMySQL();

		Statement st;
		try {
			st = (Statement) conn.getStatement();
			String sql = "SELECT * FROM SESIONES S,peliculas P,salas SA "
					+ "WHERE S.idSala = SA.idSala AND S.idPelicula = P.idPelicula AND S.idSesion = '"+idSesion+"'";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				Imagen imagen;
				Blob blob = (Blob) rs.getBlob("tamImg");
				byte[] data = blob.getBytes(1, (int) blob.length());
				BufferedImage img = null;
				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (IOException ex) {

				}
				imagen = new Imagen(img, null);

				TPelicula tPelicula = new TPelicula(rs.getInt("idPelicula"),
						rs.getString("titulo"), Integer.parseInt(rs
								.getString("duracion")),
						rs.getString("clasificacion"), rs.getBoolean("estado"),
						imagen);
				TSala tSala = new TSala(rs.getInt("idSala"),
						rs.getBoolean("Estado"), rs.getInt("Filas"),
						rs.getInt("Columnas"), rs.getString("Nombre"));
				tSesion = new TSesion(idSesion, tPelicula,
						tSala, rs.getDate("Fecha"),
						rs.getTime("Hora"), rs.getInt("CantidadLibres"),
						rs.getFloat("PrecioUnitario"));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return tSesion;
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see DAOSesion#readAll()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList readAll() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		ConexionMySQL conn = new ConexionMySQL();

		ArrayList<TSesion> tSesiones = new ArrayList<TSesion>();
		Statement st;
		try {
			st = (Statement) conn.getStatement();
			ResultSet rs = st
					.executeQuery("SELECT * FROM SESIONES S,peliculas P,salas SA "
							+ "WHERE S.idSala = SA.idSala AND S.idPelicula = P.idPelicula ORDER BY S.idSala,Hora");
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
						rs.getString("titulo"), Integer.parseInt(rs
								.getString("duracion")),
						rs.getString("clasificacion"), rs.getBoolean("estado"),
						imagen);
				TSala tSala = new TSala(rs.getInt("idSala"),
						rs.getBoolean("Estado"), rs.getInt("Filas"),
						rs.getInt("Columnas"), rs.getString("Nombre"));
				TSesion tSesion = new TSesion(rs.getInt("idSesion"), tPelicula,
						tSala, rs.getDate("Fecha"),
						rs.getTime("Hora"), rs.getInt("CantidadLibres"),
						rs.getFloat("PrecioUnitario"));
				tSesiones.add(tSesion);
			}
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return tSesiones;
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see DAOSesion#delete(Integer idSesion)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int delete(Integer idSesion) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		/*ConexionMySQL conn = new ConexionMySQL();
		String sql = "DELETE FROM SESIONES WHERE IDSesion = '" + idSesion
				+ "'";
		conn.execute(sql);
		return 1;*/
		
		String delete = "DELETE FROM SESIONES WHERE IDSesion = '" + idSesion+ "'";
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
	 * @see DAOSesion#update(Integer idSesion)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int update(TSesion tSesion) {
		// begin-user-code
				// TODO Ap�ndice de m�todo generado autom�ticamente
		/*ConexionMySQL conn = new ConexionMySQL();
		int estado = 0;
		String sql = "UPDATE `SESIONES` SET `idSesion`='" + tSesion.getIdSesion() + "',"
				+ "`IdPelicula`='" + tSesion.gettPelicula().getIdPelicula() + "',`idSala`='"
				+ tSesion.gettSala().getIdSala() + "',`Fecha`='" + tSesion.getFecha() +
				"',`Hora`='" + tSesion.getHora() + "',`CantidadLibres`='" + tSesion.getCantLibres()
				+ "',`PrecioUnitario`='" + tSesion.getPrecioUnitario() + "' "
				+ "WHERE IDSESION = '" + tSesion.getIdSesion() + "'";
		conn.execute(sql);*
		// end-user-code
		return 0;*/
				
		PreparedStatement update = null;
		ConexionMySQL conn = new ConexionMySQL();
		Connection conexion = (Connection) conn.getConnection();
		try {
            String sql = "UPDATE `sesiones` SET `idPelicula`=?,`idSala`=?,`Fecha`=?,`Hora`=?,`CantidadLibres`=?,`PrecioUnitario`=? WHERE idSesion='"+tSesion.getIdSesion()+"'";
            
            update = (PreparedStatement) conexion.prepareStatement(sql);

            update.setInt(1, tSesion.gettPelicula().getIdPelicula());
            update.setInt(2,tSesion.gettSala().getIdSala());
            Date fecha = tSesion.getFecha();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getYear(),fecha.getMonth(),fecha.getDate());
            update.setDate(3,fechaSQL);
            Date hora = tSesion.getHora();
            java.sql.Time horaSQL = new java.sql.Time(hora.getHours(),hora.getMinutes(),hora.getSeconds());
            update.setTime(4, horaSQL);
            update.setInt(5, tSesion.getCantLibres());
            update.setFloat(6,tSesion.getPrecioUnitario());           
            
            update.executeUpdate(); 
            return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 1;
		}
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see DAOSesion#readPorSala(TSala tSala)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList readPorSala(TSala tSala) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		ConexionMySQL conn = new ConexionMySQL();
		
		ArrayList<TSesion> tSesiones = new ArrayList<TSesion>();
		Statement st;
		try {
			st = (Statement) conn.getStatement();
                        String sql = "SELECT * FROM SESIONES S,peliculas P,salas SA "
							+ "WHERE S.idSala = SA.idSala AND S.idPelicula = P.idPelicula AND S.idSala = '"
							+ tSala.getIdSala() + "' ORDER BY Hora";
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
						rs.getString("titulo"), Integer.parseInt(rs
								.getString("duracion")),
						rs.getString("clasificacion"), rs.getBoolean("estado"),
						imagen);

				TSesion tSesion = new TSesion(rs.getInt("idSesion"), tPelicula,
						tSala, rs.getDate("Fecha"),
						rs.getTime("Hora"), rs.getInt("CantidadLibres"),
						rs.getFloat("PrecioUnitario"));
				tSesiones.add(tSesion);
			}
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return tSesiones;
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see DAOSesion#create(TSesion tSesion)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int create(TSesion tSesion) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
        String insert = "INSERT INTO `sesiones`(`idSesion`, `idPelicula`, `idSala`, `Fecha`, `Hora`, `CantidadLibres`, `PrecioUnitario`) VALUES (null,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ConexionMySQL conn = new ConexionMySQL();
		Connection conexion = (Connection) conn.getConnection();
		try {
                        conexion.setAutoCommit(false);
			ps = (PreparedStatement) conexion.prepareStatement(insert);
			conexion.setAutoCommit(false);
			ps.setInt(1, tSesion.gettPelicula().getIdPelicula());
            ps.setInt(2, tSesion.gettSala().getIdSala());
            Date fecha = tSesion.getFecha();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getYear(),fecha.getMonth(),fecha.getDate());
            ps.setDate(3,fechaSQL);
            Date hora = tSesion.getHora();
            java.sql.Time horaSQL = new java.sql.Time(hora.getHours(),hora.getMinutes(),00);
            ps.setTime(4,horaSQL);
            ps.setInt(5,tSesion.getCantLibres());
            ps.setFloat(6, tSesion.getPrecioUnitario());
            
			ps.executeUpdate();
			conexion.commit();
			return 0;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return 1;
		}
		// end-user-code
	}

    @Override
    public ArrayList<TSesion> readPorPelicula(Integer idPelicula) {
        ConexionMySQL conn = new ConexionMySQL();

		ArrayList<TSesion> tSesiones = new ArrayList<TSesion>();
		Statement st;
		try {
			st = (Statement) conn.getStatement();
                        String sql = "SELECT * FROM SESIONES S,peliculas P,salas SA "
                                        + "WHERE S.idSala = SA.idSala AND S.idPelicula = P.idPelicula AND S.idPelicula = '"
                                        + idPelicula + "' ORDER BY S.idSala,Hora";
			ResultSet rs = st
					.executeQuery(sql);
			while (rs.next()) {
				Imagen imagen;
				Blob blob = (Blob) rs.getBlob("tamImg");
				byte[] data = blob.getBytes(1, (int) blob.length());
				BufferedImage img = null;
				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (IOException ex) {

				}
				imagen = new Imagen(img, null);
                TSala tSala = new TSala(rs.getInt("idSala"),
						rs.getBoolean("Estado"), rs.getInt("Filas"),
						rs.getInt("Columnas"), rs.getString("Nombre"));
                TPelicula tPelicula = new TPelicula(rs.getInt("idPelicula"),
						rs.getString("titulo"), rs.getInt("Duracion"),
						rs.getString("clasificacion"), rs.getBoolean("estado"),
						imagen);
				TSesion tSesion = new TSesion(rs.getInt("idSesion"), tPelicula,
						tSala, rs.getDate("Fecha"),
						rs.getTime("Hora"), rs.getInt("CantidadLibres"),
						rs.getFloat("PrecioUnitario"));
				tSesiones.add(tSesion);
			}
			rs.close();
		} catch (SQLException ex) {
            ex.printStackTrace();
            return null;
		}
		return tSesiones;
    }

	@Override
	public ArrayList readPorSalaFecha(int idSala, Date fecha) {
		// TODO Auto-generated method stub
		ConexionMySQL conn = new ConexionMySQL();

		ArrayList<TSesion> tSesiones = new ArrayList<TSesion>();
		Statement st;
		try {
			st = (Statement) conn.getStatement();
			//java.sql.Date fechaSQL = new java.sql.Date(fecha.get(Calendar.YEAR),fecha.get(Calendar.MONTH),fecha.get(Calendar.DAY_OF_MONTH));
            String sql = "SELECT * FROM SESIONES S,peliculas P,salas SA "
				+ "WHERE S.idSala = SA.idSala AND S.idPelicula = P.idPelicula AND S.idSala = '"
				+ idSala + "' AND Fecha = '"+(fecha.getYear()+1900)+"-"+(fecha.getMonth()+1)+"-"+fecha.getDate()+"' ORDER BY Hora";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Imagen imagen;
				Blob blob = (Blob) rs.getBlob("tamImg");
				byte[] data = blob.getBytes(1, (int) blob.length());
				BufferedImage img = null;
				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (IOException ex) {

				}
				imagen = new Imagen(img, null);

				TSala tSala = new TSala(rs.getInt("idSala"),
						rs.getBoolean("Estado"), rs.getInt("Filas"),
						rs.getInt("Columnas"), rs.getString("Nombre"));
				TPelicula tPelicula = new TPelicula(rs.getInt("idPelicula"),
						rs.getString("titulo"), rs.getInt("Duracion"),
						rs.getString("clasificacion"), rs.getBoolean("estado"),
						imagen); 
				TSesion tSesion = new TSesion(rs.getInt("idSesion"), tPelicula,
						tSala, rs.getDate("Fecha"),
						rs.getTime("Hora"), rs.getInt("CantidadLibres"),
						rs.getFloat("PrecioUnitario"));
				tSesiones.add(tSesion);
			}
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return tSesiones;
	}

	@Override
	public ArrayList<TSesion> readPorFecha(Date fecha) {
		// TODO Apéndice de método generado automáticamente
		ConexionMySQL conn = new ConexionMySQL();

		ArrayList<TSesion> tSesiones = new ArrayList<TSesion>();
		Statement st;
		try {
			st = (Statement) conn.getStatement();
			String sql = "SELECT * FROM SESIONES S,peliculas P,salas SA "
					+ "WHERE S.idSala = SA.idSala AND S.idPelicula = P.idPelicula AND S.Fecha='"+(fecha.getYear()+1900)
					+"-"+(fecha.getMonth()+1)+"-"+fecha.getDate()+"' ORDER BY S.idSala,Hora";
			ResultSet rs = st
					.executeQuery(sql);
			while (rs.next()) {
				Imagen imagen;
				Blob blob = (Blob) rs.getBlob("tamImg");
				byte[] data = blob.getBytes(1, (int) blob.length());
				BufferedImage img = null;
				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (IOException ex) {

				}
				imagen = new Imagen(img, null);

				TPelicula tPelicula = new TPelicula(rs.getInt("idPelicula"),
						rs.getString("titulo"), Integer.parseInt(rs
								.getString("duracion")),
						rs.getString("clasificacion"), rs.getBoolean("estado"),
						imagen);
				TSala tSala = new TSala(rs.getInt("idSala"),
						rs.getBoolean("Estado"), rs.getInt("Filas"),
						rs.getInt("Columnas"), rs.getString("Nombre"));
				TSesion tSesion = new TSesion(rs.getInt("idSesion"), tPelicula,
						tSala, rs.getDate("Fecha"),
						rs.getTime("Hora"), rs.getInt("CantidadLibres"),
						rs.getFloat("PrecioUnitario"));
				tSesiones.add(tSesion);
			}
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return tSesiones;
	}

	@Override
	public ArrayList<TSesion> readPorPeliculaFecha(Integer idPelicula,
			Date fecha) {
		// TODO Apéndice de método generado automáticamente
		ConexionMySQL conn = new ConexionMySQL();

		ArrayList<TSesion> tSesiones = new ArrayList<TSesion>();
		Statement st;
		try {
			st = (Statement) conn.getStatement();
            String sql = "SELECT * FROM SESIONES S,peliculas P,salas SA "
                            + "WHERE S.idSala = SA.idSala AND S.idPelicula = P.idPelicula AND S.idPelicula = '"
                            + idPelicula + "' AND Fecha ='"+(fecha.getYear()+1900)
                        	+"-"+(fecha.getMonth()+1)+"-"+fecha.getDate()+"' ORDER BY S.idSala,Hora";
			ResultSet rs = st
					.executeQuery(sql);
			while (rs.next()) {
				Imagen imagen;
				Blob blob = (Blob) rs.getBlob("tamImg");
				byte[] data = blob.getBytes(1, (int) blob.length());
				BufferedImage img = null;
				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (IOException ex) {

				}
				imagen = new Imagen(img, null);
                TSala tSala = new TSala(rs.getInt("idSala"),
						rs.getBoolean("Estado"), rs.getInt("Filas"),
						rs.getInt("Columnas"), rs.getString("Nombre"));
                TPelicula tPelicula = new TPelicula(rs.getInt("idPelicula"),
						rs.getString("titulo"), rs.getInt("Duracion"),
						rs.getString("clasificacion"), rs.getBoolean("estado"),
						imagen);
				TSesion tSesion = new TSesion(rs.getInt("idSesion"), tPelicula,
						tSala, rs.getDate("Fecha"),
						rs.getTime("Hora"), rs.getInt("CantidadLibres"),
						rs.getFloat("PrecioUnitario"));
				tSesiones.add(tSesion);
			}
			rs.close();
		} catch (SQLException ex) {
            ex.printStackTrace();
            return null;
		}
		return tSesiones;
	}
}