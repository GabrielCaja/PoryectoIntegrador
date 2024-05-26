package modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import conexion.AbstractConexion;
import conexion.Conexion;


public class ControladorRecusos extends AbstractConexion{

	public ArrayList<Recursos> findAll() {
		conn= Conexion.getConnection();
		ArrayList<Recursos> listaDisponibles = new ArrayList<>();
		

		try {
			st = conn.createStatement();
			
			String query = "select * from recursos;";
		
			rs = st.executeQuery(query);
		
			while(rs.next()) {
				int id , codigoPostal,idEmpresa, idLocalizacion;
				String nombre , fecha, estadisticas;
				nombre  = rs.getString("nombre");
				id = rs.getInt("id_recurso");
				codigoPostal= rs.getInt("codigo_postal");
				idEmpresa = rs.getInt("id_empresa");
				idLocalizacion = rs.getInt("id_localizacion");
				fecha = rs.getString("fecha");
				estadisticas = rs.getString("estadisticas");
				Recursos recurso = new Recursos(id,nombre, estadisticas, fecha, codigoPostal, idEmpresa, idLocalizacion, false);
				listaDisponibles.add(recurso);

				
			}
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(listaDisponibles);
		return listaDisponibles;
	}
	
	public String nombreUbicacion(int id) {
		conn= Conexion.getConnection();
		String nombre="";

		try {
			st = conn.createStatement();
			
			String query = "select localizacion.nombre from recursos inner join localizacion on localizacion.id_localizacion = recursos.id_localizacion where recursos.id_localizacion = "+id+";";
		
			rs = st.executeQuery(query);
			
		
			while(rs.next()) {
				nombre = rs.getString("nombre");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nombre);

		return nombre;
	}
	
	public int idUbicacion(String nombre) {
		conn= Conexion.getConnection();
		int id = 0;


		try {
			st = conn.createStatement();
			
			String query = "select localizacion.id_localizacion from recursos inner join localizacion on localizacion.id_localizacion = recursos.id_localizacion where localizacion.nombre = '"+nombre+"';";
		
			rs = st.executeQuery(query);
			while(rs.next()) {
				id = rs.getInt("id_localizacion");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
		
	}
	public int agregarRecurso(Recursos recurso)  {
		conn = Conexion.getConnection();
		int id = 0;
		int filasAfectadas = 0;
		try {
			int  codigoPostal, lugar, empresa;
			String nombre , fecha, sts;			
			codigoPostal = recurso.getCodigoPostal();
			lugar= recurso.getIdLocalizacion();
			empresa=recurso.getIdEmpresa();
			nombre=recurso.getNombre();
			fecha=recurso.getFecha();
			sts=recurso.getEstadisticas();
			
			String query = "INSERT INTO recursos (id_recurso,nombre, fecha, codigo_postal, estadisticas, id_empresa,id_localizacion ) VALUES (?,?,?,?,?,?,?);";
			String subquery = "select count(*)+1 as nuevaId from recursos";

			
			st = conn.createStatement();
			rs = st.executeQuery(subquery);
			while (rs.next()) {
				id = rs.getInt(1);
			}
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, nombre);
			pst.setString(3, fecha);
			pst.setInt(4, codigoPostal);
			pst.setString(5, sts);
			pst.setInt(6, empresa);
			pst.setInt(7, lugar);
	
			 filasAfectadas = pst.executeUpdate();

			System.out.println("Ha sido añadido correctamente!");	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filasAfectadas;
	}

	public void eliminarRecurso(int codigo) {
		conn = Conexion.getConnection();

		try {
			st = conn.createStatement();

			String query = "DELETE FROM recursos WHERE id_recurso = " + codigo + ";";
			System.out.println("Eliminado");
			rs = st.executeQuery(query);

			



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<String> cargarUbicaciones() {
		conn = Conexion.getConnection();
		ArrayList<String> lista = new ArrayList();
		String nombre = "";
		try {
			st = conn.createStatement();

			String query = "select nombre from localizacion;";
			System.out.println("Eliminado");
			rs = st.executeQuery(query);
			while (rs.next()) {
				nombre = rs.getString("nombre");
				lista.add(nombre);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista ;
	}
	
	public ArrayList<String> buscarPorUbicacion(String nombre) {
		conn = Conexion.getConnection();
		String nombreRecurso = "";
		ArrayList<String> listaUbicaciones = new ArrayList<String>();
		try {
			st = conn.createStatement();

			String query = "select recursos.nombre from recursos inner join localizacion on localizacion.id_localizacion = recursos.id_localizacion where localizacion.nombre = '"+nombre+"';";

			rs = st.executeQuery(query);

			
			while(rs.next()) {
				nombreRecurso = rs.getString("nombre");
				listaUbicaciones.add(nombreRecurso);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaUbicaciones;
	}
	
	public int totalUbicaciones() {
		int total = 0;
		conn = Conexion.getConnection();
		try {
			st = conn.createStatement();

			String query = "select count(id_localizacion) as Total from localizacion;";

			rs = st.executeQuery(query);
				total = rs.getInt("Total");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return total;
	}
	
	public int nuevaUbicacion(String ubi) {
		conn = Conexion.getConnection();
		int id = 0;
		int filasAfectadas = 0;
		try {
			String query = "INSERT INTO localizacion (id_localizacion, nombre, codigo_postal) VALUES (?,?,?)";
			String subquery = "select count(*)+1 as nuevaId from localizacion";
			st = conn.createStatement();
			rs = st.executeQuery(subquery);
			while (rs.next()) {
				id = rs.getInt(1);
			}
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, ubi);
			double random = Math.random()*100000;
			int codigoPostal= (int)random;
			pst.setInt(3, codigoPostal);		
			filasAfectadas = pst.executeUpdate();

			System.out.println("Ha sido añadido correctamente!");	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public int eliminarUbicacion(String ubi) {
		conn = Conexion.getConnection();
		int filasAfectadas = 0;

		try {
			st = conn.createStatement();

			String query = "DELETE FROM localizacion WHERE localizacion.nombre = ?;";
			System.out.println("Eliminado");
			pst = conn.prepareStatement(query);
			pst.setString(1, ubi);
			filasAfectadas = pst.executeUpdate();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasAfectadas;

	}
	
	public int nuevaEmpresa(String ubi) {
		int id =0 ; 
		conn = Conexion.getConnection();
		int filasAfectadas = 0;
		try {
			String query = "INSERT INTO superempresa (id_empresa, nombre) VALUES (?,?)";
			String subquery = "select count(*)+1 as nuevaId from superempresa";
			st = conn.createStatement();
			rs = st.executeQuery(subquery);
			while (rs.next()) {
				id = rs.getInt(1);
			}
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, ubi);
			filasAfectadas = pst.executeUpdate();

			System.out.println("Ha sido añadido correctamente!");	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	public int eliminarEmpresa(String ubi) {
		conn = Conexion.getConnection();
		int filasAfectadas = 0;

		try {
			st = conn.createStatement();

			String query = "DELETE FROM superempresa WHERE localizacion.nombre = ?;";
			System.out.println("Eliminado");
			pst = conn.prepareStatement(query);
			pst.setString(1, ubi);
			filasAfectadas = pst.executeUpdate();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasAfectadas;

	}
	
}
