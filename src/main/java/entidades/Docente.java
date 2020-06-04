package entidades;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;


@Entity
public class Docente extends Usuario implements Serializable {

	private String departamento;

	private static final long serialVersionUID = 1L;
	
	public Docente()
	{
		super();
	}

	public Docente(String mail,String DNI,String Contrasenia,String Nombre,String apellido1,String apellido2,Date fecha_nacimiento,String departamento) {
		super(mail,DNI,Contrasenia,Nombre,apellido1,apellido2,fecha_nacimiento,"2");
		this.departamento=departamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	  
	
}
