package entidades;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entidad extends Usuario implements Serializable {


	private String direccion;
	private String telefono;
	private String pais;
	private String ciudad;
	private String tipo_origen;
	private String pagina_web;
	private static final long serialVersionUID = 1L;
	
	public Entidad()
	{
		super();
	}

	public Entidad(String mail,String DNI,String Contrasenia,String Nombre,String Direccion,String Telefono,String Pais,String Ciudad,String tipo_origen,String pagina_web) {
		super(mail,DNI,Contrasenia,Nombre,"5");
		this.direccion=Direccion;
		this.telefono=Telefono;
		this.pais=Pais;
		this.ciudad=Ciudad;
		this.tipo_origen=tipo_origen;
		this.pagina_web=pagina_web;
		
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTipo_origen() {
		return tipo_origen;
	}

	public void setTipo_origen(String tipo_origen) {
		this.tipo_origen = tipo_origen;
	}

	public String getPagina_web() {
		return pagina_web;
	}

	public void setPagina_web(String pagina_web) {
		this.pagina_web = pagina_web;
	}
	
	

	
}
