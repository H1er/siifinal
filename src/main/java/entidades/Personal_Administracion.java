package entidades;
import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Personal_Administracion extends Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String Tipoo;
	
	public Personal_Administracion()
	{
		super();
	}

	public Personal_Administracion(String mail,String DNI,String Contrasenia,String Nombre,String apellido1,String apellido2,Date fecha_nacimiento,String tipo) {
		super(mail,DNI,Contrasenia,Nombre,apellido1,apellido2,fecha_nacimiento,"4");
		this.Tipoo=tipo;
	}

	public String getTipoo() {
		return Tipoo;
	}

	public void setTipoo(String tipoo) {
		Tipoo = tipoo;
	}
   
}
