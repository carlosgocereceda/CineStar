/**
 * 
 */
package Integracion.Empleados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Integracion.ConexionMySQL;
import Negocio.Empleados.TEmpleado;
import Negocio.Empleados.TEmpleadoFijo;
import Negocio.Empleados.TEmpleadoParcial;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOEmpleadosImp implements DAOEmpleados {
	/** 
	 * (non-Javadoc)
	 * @see DAOEmpleados#create(TEmpleado TEmpleado)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int create(TEmpleado tEmpleado) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		String insert = "INSERT INTO `empleados`(`DNI`, `Nombre`, `Apellidos`, `TIPO`, `Password`) VALUES (?,?,?,?,?)";
		PreparedStatement ps = null;
		ConexionMySQL conn = new ConexionMySQL();
		Connection conexion = (Connection) conn.getConnection();
		try {
            conexion.setAutoCommit(false);
			ps = (PreparedStatement) conexion.prepareStatement(insert);
			ps.setString(1, tEmpleado.getDni());
            ps.setString(2, tEmpleado.getNombre());
            ps.setString(3, tEmpleado.getApellidos());
            ps.setString(4, tEmpleado.getTipo());
            ps.setString(5, tEmpleado.getPassword());
			ps.executeUpdate();
			conexion.commit();
			Statement st = (Statement) conn.getStatement();
			String sql = "SELECT IDEMPLEADO FROM EMPLEADOS WHERE DNI='"+tEmpleado.getDni()+"'";
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			int idEmpleado = rs.getInt("IDEMPLEADO");
			switch(tEmpleado.getTipo()){
				case "Fijo":
					TEmpleadoFijo tEmpleadoFijo = (TEmpleadoFijo) tEmpleado;
					insert = "INSERT INTO `empleadosfijo`(`IDEmpleado`, `Sueldo`) VALUES (?,?)";
					conexion.setAutoCommit(false);
					ps = (PreparedStatement) conexion.prepareStatement(insert);
					ps.setInt(1, idEmpleado);
					ps.setFloat(2, tEmpleadoFijo.getSueldo());
					ps.executeUpdate();
					conexion.commit();
					break;
				case "Parcial":					
					TEmpleadoParcial tEmpleadoParcial = (TEmpleadoParcial) tEmpleado;
					insert = "INSERT INTO `empleadosparcial`(`IDEmpleado`, `Horas`, `PrecioHora`) VALUES (?,?,?)";					
					ps = (PreparedStatement) conexion.prepareStatement(insert);
					ps.setInt(1, idEmpleado);
					ps.setInt(2, tEmpleadoParcial.getHoras());
					ps.setFloat(3, tEmpleadoParcial.getPrecioHora());
					ps.executeUpdate();
					conexion.commit();
					break;
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
	 * @see DAOEmpleados#read(String dni)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TEmpleado read(int idEmpleado) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		ConexionMySQL conn = new ConexionMySQL();
        TEmpleado tEmpleado = null;
		Statement st;
		try {
			st = (Statement) conn.getStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM EMPLEADOS WHERE IDEMPLEADO ='"+idEmpleado+"'");
			if(rs.next()){
                String tipo = rs.getString("Tipo");
                switch(tipo){
                    case "Fijo":
                    	String dni = rs.getString("DNI");
                        String nombre = rs.getString("Nombre");
                        String apellidos = rs.getString("Apellidos");
                        String password = rs.getString("Password");
                        rs = st.executeQuery("SELECT * FROM EMPLEADOSFIJO WHERE IDEmpleado ='"+idEmpleado+"'");
                        if(rs.next()){
                        	tEmpleado = new TEmpleadoFijo(idEmpleado,dni,nombre,apellidos,password,
                        			rs.getFloat("Sueldo"));
                        }
                        break;
                    case "Parcial":
                    	dni = rs.getString("DNI");
                        nombre = rs.getString("Nombre");
                        apellidos = rs.getString("Apellidos");
                        password = rs.getString("Password");
                        //ArrayList<DiaHoras> diasHoras = new ArrayList();
                        rs = st.executeQuery("SELECT * FROM EMPLEADOSPARCIAL WHERE IDEMPLEADO ='"+idEmpleado+"'");
                        if(rs.next()){
	                        int horas = rs.getInt("Horas");
	                        float precioHora = rs.getFloat("PrecioHora");
	                        tEmpleado = new TEmpleadoParcial(idEmpleado,dni,nombre,apellidos,password,horas,precioHora);
                        }
                        break;
                }			
			}
			rs.close();
		} catch (SQLException ex) {
            ex.printStackTrace();
            return null;
		}
		return tEmpleado;
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see DAOEmpleados#update(String dni)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int update(TEmpleado tEmpleado) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		ConexionMySQL conn = new ConexionMySQL();
		
		String update = "UPDATE `EMPLEADOS` SET `Nombre`=?,`Apellidos`=?,`TIPO`=?, `Password` =? WHERE DNI = '" +tEmpleado.getDni() + "'";
		Connection conexion = (Connection) conn.getConnection();
		PreparedStatement ps;
		try {						
            conexion.setAutoCommit(false);
			ps = (PreparedStatement) conexion.prepareStatement(update);
			conexion.setAutoCommit(false);
			ps.setString(1, tEmpleado.getNombre());
			ps.setString(2, tEmpleado.getApellidos());
			ps.setString(3, tEmpleado.getTipo());
			ps.setString(4, tEmpleado.getPassword());
			ps.executeUpdate();
			conexion.commit();
			switch(tEmpleado.getTipo()){
			
			case "Fijo":
				TEmpleadoFijo tEmpleadoFijo = (TEmpleadoFijo) tEmpleado;
				update = "UPDATE `EMPlEADOSFIJO` SET `Sueldo`=? WHERE IDEmpleado = '" +tEmpleadoFijo.getIdEmpleado() + "'";
				conexion.setAutoCommit(false);
				ps = (PreparedStatement) conexion.prepareStatement(update);
				conexion.setAutoCommit(false);
				ps.setFloat(1, tEmpleadoFijo.getSueldo());
				ps.executeUpdate();
				conexion.commit();
				break;
			case "Parcial":
				TEmpleadoParcial tEmpleadoParcial = (TEmpleadoParcial) tEmpleado;
				update = "UPDATE `EMPlEADOSPARCIAL` SET `Horas`=?,`PrecioHora`=? WHERE IDEmpleado = '" +tEmpleadoParcial.getIdEmpleado() + "'";
				conexion.setAutoCommit(false);
				ps = (PreparedStatement) conexion.prepareStatement(update);
				conexion.setAutoCommit(false);
				ps.setInt(1, tEmpleadoParcial.getHoras());
				ps.setFloat(2, tEmpleadoParcial.getPrecioHora());
				ps.executeUpdate();
				conexion.commit();
				break;
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
	 * @see DAOEmpleados#delete(String dni)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int delete(Integer idEmp) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		PreparedStatement ps = null;
		ConexionMySQL conn = new ConexionMySQL();
		Connection conexion = (Connection) conn.getConnection();
		try {
			String delete = "DELETE FROM EMPLEADOSPARCIAL WHERE IDEmpleado = '" + idEmp
					+ "'";			
            conexion.setAutoCommit(false);
			ps = (PreparedStatement) conexion.prepareStatement(delete);
			conexion.setAutoCommit(false);
			ps.executeUpdate();
			conexion.commit();
			delete = "DELETE FROM EMPLEADOSFIJO WHERE IDEmpleado = '" + idEmp
					+ "'";
			conexion.setAutoCommit(false);
			ps = (PreparedStatement) conexion.prepareStatement(delete);
			conexion.setAutoCommit(false);
			ps.executeUpdate();
			conexion.commit();
			delete = "DELETE FROM EMPLEADOS WHERE IDEmpleado = '" + idEmp
					+ "'";
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
	 * @see DAOEmpleados#readAll()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TEmpleado> readAll() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		ConexionMySQL conn = new ConexionMySQL();
		
		ArrayList<TEmpleado> tEmpleados = new ArrayList<TEmpleado>();
		Statement st;
		try {
			st = (Statement) conn.getStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM EMPLEADOS");
			while (rs.next()) {
				TEmpleado tEmpleado = new TEmpleado(rs.getInt("IdEmpleado"),rs.getString("DNI"),rs.getString("Nombre"),rs.getString("Apellidos"),rs.getString("Tipo"),rs.getString("Password"));
				tEmpleados.add(tEmpleado);
			}
			rs.close();
		} catch (SQLException ex) {
			return null;
		}
		return tEmpleados;  
		// end-user-code
	}

	@Override
	public TEmpleado readByDNI(String DNI) {
		ConexionMySQL conn = new ConexionMySQL();
        TEmpleado tEmpleado = null;
		Statement st;
		try {
			st = (Statement) conn.getStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM EMPLEADOS WHERE DNI ='"+DNI+"'");
			if(rs.next()){
                String tipo = rs.getString("Tipo");
                switch(tipo){
                    case "Fijo":
                    	Integer idEmpleado = rs.getInt("idEmpleado");
                    	String dni = rs.getString("DNI");
                        String nombre = rs.getString("Nombre");
                        String apellidos = rs.getString("Apellidos");
                        String password = rs.getString("Password");
                        rs = st.executeQuery("SELECT * FROM EMPLEADOSFIJO WHERE idEmpleado ='"+idEmpleado+"'");
                        if(rs.next()){
                        	tEmpleado = new TEmpleadoFijo(idEmpleado,dni,nombre,apellidos,password,
                        			rs.getFloat("Sueldo"));
                        }
                        break;
                    case "Parcial":
                    	idEmpleado = rs.getInt("idEmpleado");
                    	dni = rs.getString("DNI");
                        nombre = rs.getString("Nombre");
                        apellidos = rs.getString("Apellidos");
                        password = rs.getString("Password");
                        //ArrayList<DiaHoras> diasHoras = new ArrayList();
                        rs = st.executeQuery("SELECT * FROM EMPLEADOSPARCIAL WHERE IDEMPLEADO ='"+idEmpleado+"'");
                        if(rs.next()){
	                        int horas = rs.getInt("Horas");
	                        float precioHora = rs.getFloat("PrecioHora");
	                        tEmpleado = new TEmpleadoParcial(idEmpleado,dni,nombre,apellidos,password,horas,precioHora);
                        }
                        break;
                }			
			}
			rs.close();
		} catch (SQLException ex) {
            ex.printStackTrace();
            return null;
		}
		return tEmpleado;
	}
}