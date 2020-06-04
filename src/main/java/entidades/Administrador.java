package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Administrador extends Usuario implements Serializable {

	private String rango;
	
	private static final long serialVersionUID = 1L;
	
	public Administrador()
	{
		super();
	}

	public Administrador(String mail,String DNI,String Contrasenia,String Nombre,String apellido1,String apellido2,Date fecha_nacimiento,String rango) {
		super(mail,DNI,Contrasenia,Nombre,apellido1,apellido2,fecha_nacimiento,"6");
		this.rango=rango;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}   
}
