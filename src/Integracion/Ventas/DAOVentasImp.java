/**
 * 
 */
package Integracion.Ventas;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.imageio.ImageIO;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Integracion.ConexionMySQL;
import Negocio.Empleados.TEmpleado;
import Negocio.Pelicula.Imagen;
import Negocio.Pelicula.TPelicula;
import Negocio.Sala.TSala;
import Negocio.Sesion.TSesion;
import Negocio.Ventas.LineaVenta;
import Negocio.Ventas.TVenta;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOVentasImp implements DAOVentas {
	/** 
	 * (non-Javadoc)
	 * @see DAOVentas#read(Integer idVenta)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TVenta read(Integer idVenta) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		ConexionMySQL conn = new ConexionMySQL();
		Statement st;
		TVenta tVenta = null;
		try {
			st = (Statement) conn.getStatement();
			String sql = "SELECT * FROM `ventas` V,sesiones SE,salas S,peliculas P,empleados E "+
					"WHERE V.IDSesion = SE.IDSesion AND SE.IDSala = S.IDSala AND SE.IDPelicula = P.IDPelicula AND "+
					"V.IDEmpleado = E.IDEmpleado AND IdVenta = '"+idVenta+"'";
			ResultSet rs = st
					.executeQuery(sql);
			HashMap<Integer,LineaVenta> lineasVentas = new HashMap();
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
				lineasVentas.put(tSesion.getIdSesion(), new LineaVenta(tSesion,rs.getInt("Cantidad")));
			}			
			rs.close();
			tVenta = new TVenta(idVenta,lineasVentas);
		} catch (SQLException ex) {
			return null;
		}
		return tVenta;
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see DAOVentas#readAll()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TVenta> readAll() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		ConexionMySQL conn = new ConexionMySQL();

		ArrayList<TVenta> tVentas = new ArrayList<TVenta>();
		Statement st;
		TVenta tVenta = null;
		try {
			st = (Statement) conn.getStatement();
			String sql = "SELECT * FROM `ventas` V,sesiones SE,salas S,peliculas P,empleados E "+
					"WHERE V.IDSesion = SE.IDSesion AND SE.IDSala = S.IDSala AND SE.IDPelicula = P.IDPelicula AND "+
					"V.IDEmpleado = E.IDEmpleado";
			ResultSet rs = st
					.executeQuery(sql);
			Integer idVenta = null;
			HashMap<Integer,LineaVenta> lineasVentas = null;
			TEmpleado tEmpleado = null;
			while (rs.next()) {
				if(idVenta == null){
					idVenta = rs.getInt("IdVenta");
					tEmpleado = new TEmpleado(rs.getString("DNI"),rs.getString("Nombre"),rs.getString("Apellidos"),rs.getString("Tipo"),rs.getString("Password"));
					lineasVentas = new HashMap();
				}else if(rs.getInt("IdVenta") != idVenta){
					tVenta = new TVenta(idVenta,lineasVentas,tEmpleado);
					tVentas.add(tVenta);	
					idVenta = rs.getInt("IdVenta");
					tEmpleado = new TEmpleado(rs.getString("DNI"),rs.getString("Nombre"),rs.getString("Apellidos"),rs.getString("Tipo"),rs.getString("Password"));
					lineasVentas = new HashMap();
				}
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
				lineasVentas.put(tSesion.getIdSesion(), new LineaVenta(tSesion,rs.getInt("Cantidad")));
			}
			if(!lineasVentas.isEmpty()){
				tVenta = new TVenta(idVenta,lineasVentas,tEmpleado);
				tVentas.add(tVenta);	
			}
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return tVentas;
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see DAOVentas#delete(Integer idVenta)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int delete(Integer idVenta) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		String delete = "DELETE FROM VENTAS WHERE IDVenta = '"+idVenta+"'";
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
	
	public int deleteLineaVenta(Integer idVenta,Integer idSesion) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		String delete = "DELETE FROM VENTAS WHERE IDVenta = '"+idVenta+"' AND  IDSesion = '" + idSesion+ "'";
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
	 * @see DAOVentas#update(Integer idventa)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int update(TVenta tVenta) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		
		
				PreparedStatement update = null;
		ConexionMySQL conn = new ConexionMySQL();
		Connection conexion = (Connection) conn.getConnection();
		try {
            String sql;
         
            for (Iterator iterator = tVenta.getLineasVentas().values().iterator(); iterator.hasNext();) {
				LineaVenta lineaVenta = (LineaVenta) iterator.next();
				sql = "UPDATE `ventas` SET `IdEmpleado`=?,`Cantidad`=? WHERE idVenta ='"+tVenta.getIdVenta()+"' AND IDSesion = '"+lineaVenta.gettSesion().getIdSesion()+"'";
			 	update = (PreparedStatement) conexion.prepareStatement(sql);
	
	            update.setInt(1, tVenta.gettEmpleado().getIdEmpleado());
	            update.setInt(2,lineaVenta.getCant());	                     
	            
	            update.executeUpdate(); 
			}
           
            return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 1;
		}	
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see DAOVentas#create(TVenta TVentas)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int create(TVenta tVenta) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		String insert = "INSERT INTO `ventas`(`IdVenta`, `IdSesion`, `IdEmpleado`, `Cantidad`) VALUES (NULL,?,?,?)";
		PreparedStatement ps = null;
		ConexionMySQL conn = new ConexionMySQL();
		Connection conexion = (Connection) conn.getConnection();
		try {
            conexion.setAutoCommit(false);
			ps = (PreparedStatement) conexion.prepareStatement(insert);
			conexion.setAutoCommit(false);
			Object[] lineasVentas = tVenta.getLineasVentas().values().toArray();
			LineaVenta primeraLineaVenta = (LineaVenta) lineasVentas[0];
			ps.setInt(1, primeraLineaVenta.gettSesion().getIdSesion());
			//ps.setInt(2, tVenta.gettEmpleado().getIdEmpleado());
			ps.setInt(2, tVenta.gettEmpleado().getIdEmpleado());
			ps.setInt(3, primeraLineaVenta.getCant());
			
			ps.executeUpdate();
			conexion.commit();
			Statement st = (Statement) conn.getStatement();
			ResultSet rs = st.executeQuery("SELECT DISTINCT LAST_INSERT_ID() \"LAST_ID\" FROM Ventas");
			rs.next();
			int idVenta = rs.getInt("LAST_ID");
			insert = "INSERT INTO `ventas`(`IdVenta`, `IdSesion`, `IdEmpleado`, `Cantidad`) VALUES (?,?,?,?)";			
			for (int i = 1; i < lineasVentas.length; i++) {
				conexion.setAutoCommit(false);
				ps = (PreparedStatement) conexion.prepareStatement(insert);
				conexion.setAutoCommit(false);
				LineaVenta lineaVenta = (LineaVenta) lineasVentas[i];
				ps.setInt(1, idVenta);
				ps.setInt(2, lineaVenta.gettSesion().getIdSesion());
				//ps.setInt(3, tVenta.gettEmpleado().getIdEmpleado());
				ps.setInt(3, tVenta.gettEmpleado().getIdEmpleado());
				ps.setInt(4, lineaVenta.getCant());
				ps.executeUpdate();
				conexion.commit();
			}
			return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			//Error con la BBDD.
			return 3;
		} finally {
			try {
				ps.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// end-user-code
	}
	
	public int createWithID(TVenta tVenta) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		String insert = "INSERT INTO `ventas`(`IdVenta`, `IdSesion`, `IdEmpleado`, `Cantidad`) VALUES (?,?,?,?)";
		PreparedStatement ps = null;
		ConexionMySQL conn = new ConexionMySQL();
		Connection conexion = (Connection) conn.getConnection();
		try {
            conexion.setAutoCommit(false);
			ps = (PreparedStatement) conexion.prepareStatement(insert);
			conexion.setAutoCommit(false);
			int idVenta =tVenta.getIdVenta();
			Object[] lineasVentas = tVenta.getLineasVentas().values().toArray();
			LineaVenta primeraLineaVenta = (LineaVenta) lineasVentas[0];
			ps.setInt(1, idVenta);
			ps.setInt(2, primeraLineaVenta.gettSesion().getIdSesion());
			//ps.setInt(2, tVenta.gettEmpleado().getIdEmpleado());
			ps.setInt(3, tVenta.gettEmpleado().getIdEmpleado());
			ps.setInt(4, primeraLineaVenta.getCant());
			
			ps.executeUpdate();
			conexion.commit();
			Statement st = (Statement) conn.getStatement();
			
			insert = "INSERT INTO `ventas`(`IdVenta`, `IdSesion`, `IdEmpleado`, `Cantidad`) VALUES (?,?,?,?)";			
			for (int i = 1; i < lineasVentas.length; i++) {
				conexion.setAutoCommit(false);
				ps = (PreparedStatement) conexion.prepareStatement(insert);
				conexion.setAutoCommit(false);
				LineaVenta lineaVenta = (LineaVenta) lineasVentas[i];
				ps.setInt(1, idVenta);
				ps.setInt(2, lineaVenta.gettSesion().getIdSesion());
				//ps.setInt(3, tVenta.gettEmpleado().getIdEmpleado());
				ps.setInt(3, tVenta.gettEmpleado().getIdEmpleado());
				ps.setInt(4, lineaVenta.getCant());
				ps.executeUpdate();
				conexion.commit();
			}
			return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			//Error con la BBDD.
			return 3;
		} finally {
			try {
				ps.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// end-user-code
	}

	@Override
	public ArrayList readByIDSesion(int idSesion) {
		// TODO Apéndice de método generado automáticamente
		ConexionMySQL conn = new ConexionMySQL();

		ArrayList<TVenta> tVentas = new ArrayList<TVenta>();
		Statement st;
		TVenta tVenta = null;
		try {
			st = (Statement) conn.getStatement();
			String sql = "SELECT * FROM `ventas` V,sesiones SE,salas S,peliculas P,empleados E "+
					"WHERE V.IDSesion = SE.IDSesion AND SE.IDSala = S.IDSala AND SE.IDPelicula = P.IDPelicula AND "+
					"V.IDEmpleado = E.IDEmpleado AND V.idSesion = '"+idSesion+"'";
			ResultSet rs = st
					.executeQuery(sql);
			Integer idVenta = null;
			HashMap<Integer,LineaVenta> lineasVentas = null;
			while (rs.next()) {
				if(idVenta == null){
					idVenta = rs.getInt("IdVenta");
					lineasVentas = new HashMap();
				}else if(rs.getInt("IdVenta") != idVenta){
					tVenta = new TVenta(idVenta,lineasVentas);
					tVentas.add(tVenta);	
					idVenta = rs.getInt("IdVenta");
					lineasVentas = new HashMap();
				}
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
				lineasVentas.put(tSesion.getIdSesion(), new LineaVenta(tSesion,rs.getInt("Cantidad")));
			}												
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return tVentas;
	}

	@Override
	public int deleteLineasVentaPorSesion(Integer idSesion) {
		// TODO Apéndice de método generado automáticamente
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
	}

	@Override
	public LineaVenta readLineaVenta(Integer idVenta, Integer idSesion) {
		// TODO Apéndice de método generado automáticamente
		ConexionMySQL conn = new ConexionMySQL();
		
		Statement st;
		LineaVenta lineaVenta = null;
		try {
			st = (Statement) conn.getStatement();
			String sql = "SELECT * FROM `ventas` V,sesiones SE,salas S,peliculas P,empleados E "+
					"WHERE V.IDSesion = SE.IDSesion AND SE.IDSala = S.IDSala AND SE.IDPelicula = P.IDPelicula AND "+
					"V.IDEmpleado = E.IDEmpleado AND V.IDVenta = '"+idVenta+"' AND V.idSesion = '"+idSesion+"'";
			ResultSet rs = st
					.executeQuery(sql);
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
				TSesion tSesion = new TSesion(rs.getInt("idSesion"), tPelicula,
						tSala, rs.getDate("Fecha"),
						rs.getTime("Hora"), rs.getInt("CantidadLibres"),
						rs.getFloat("PrecioUnitario"));
				lineaVenta = new LineaVenta(tSesion,rs.getInt("Cantidad"));
			}												
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return lineaVenta;
	}

	@Override
	public int deleteByIDEmpleado(Integer idEmpleado) {
		// TODO Apéndice de método generado automáticamente
		String delete = "DELETE FROM VENTAS WHERE IDEmpleado = '"+idEmpleado+"'";
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
	}


}