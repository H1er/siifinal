package entidades;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;


@Entity
public class Estudiante extends Usuario implements Serializable {

	private String curso;
	private String titulacion;
	
	private static final long serialVersionUID = 1L;
	
	public Estudiante()
	{
		super();
	}

	public Estudiante(String mail,String DNI,String Contrasenia,String Nombre,String apellido1,String apellido2,Date fecha_nacimiento,String Curso,String titulacion) {
		super(mail,DNI,Contrasenia,Nombre,apellido1,apellido2,fecha_nacimiento,"3");
		this.curso=Curso;
		this.titulacion=titulacion;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}


	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}     
}
