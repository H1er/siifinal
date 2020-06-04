package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Usuario implements Serializable 
{
	private static int n=0;
	
	@Embeddable
	@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
	public static class UsuarioId implements Serializable 
	{
		private static final long serialVersionUID = 1L;

	    private int codigo;
		
		private String dni;
	 
	    public UsuarioId()
	    {
	    	
	    }
	 
	    public UsuarioId(String dni) 
	    {
	        this.dni = dni;	  
	    }
	 
	    @Override
		public int hashCode()
		{
			return Integer.hashCode(codigo)+dni.hashCode();
		}
	    
	    @Override
		public boolean equals(Object usr)
		{
			Usuario us = usr instanceof Usuario? (Usuario) usr: null;
			
			return us!=null && this.codigo == us.codigo;
			
		}
	    
	    public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}
	}
	
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setParticipa_en(List<Actividad> participa_en) {
		this.participa_en = participa_en;
	}
	
	public List<Actividad> getParticipa_en() {
		return participa_en;
	}
	
	public void setParticipan(List<Actividad> participan) {
		this.participa_en = participan;
	}

	public List<Informe> getInformes() {
		return informes;
	}

	public void setInformes(List<Informe> informes) {
		this.informes = informes;
	}

	public void setParticipa_serv(List<Servicio> participa_serv) {
		this.participa_serv = participa_serv;
	}
	
	private String tipouser;
	
	 
	@EmbeddedId
	UsuarioId key;
	
	
	@Column(name = "columndni")
	private String dni;
	
	 @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="comuncode")
	private int codigo;
	

	private String mail;
	
	private String Contrasenia;
	
	private String Nombre;
	
	private String Apellido1;
	
	private String Apellido2;
	
	@Temporal(TemporalType.DATE)
	private Date Fechanacimiento;
	
	@ManyToMany
	private List<Actividad> participa_en = new LinkedList<>();
	
	@OneToMany
	private List<Informe> informes= new LinkedList<>();
	
	@ManyToMany
	private List<Servicio> participa_serv= new LinkedList<>();
	
	private static final long serialVersionUID = 1L;
	
	public Usuario()
	{
		
	}

	public Usuario(String mail,String DNI,String Contrasenia,String Nombre,String apellido1,String apellido2,Date fecha_nacimiento) 
	{
		this.key = new UsuarioId();
		this.key.setDni(DNI);
		this.key.setCodigo(n);
		this.codigo = n;
		this.setDni(DNI);
		n++;
		this.mail=mail;
	
		this.Contrasenia=Contrasenia;
		this.Nombre=Nombre;
		this.Apellido1=apellido1;
		this.Apellido2=apellido2;
		this.Fechanacimiento=fecha_nacimiento;
		this.tipouser="1";
	}

	public Usuario(String mail,String DNI,String Contrasenia,String Nombre,String apellido1,String apellido2,Date fecha_nacimiento,String tipo) {
		this.key = new UsuarioId();
		this.key.setDni(DNI);
		this.key.setCodigo(n);
		n++;
		this.mail=mail;
	
		this.Contrasenia=Contrasenia;
		this.Nombre=Nombre;
		this.Apellido1=apellido1;
		this.Apellido2=apellido2;
		this.Fechanacimiento=fecha_nacimiento;
		this.tipouser=tipo;
	}
	
	public Usuario(String mail,String DNI,String Contrasenia,String Nombre,String tipo) {
		this.key = new UsuarioId();
		this.key.setDni(DNI);
		this.key.setCodigo(n);
		n++;
		this.mail=mail;
	
		this.Contrasenia=Contrasenia;
		this.Nombre=Nombre;
		this.tipouser=tipo;
	}

	
	
	public UsuarioId getKey() {
		return key;
	}

	public void setKey(UsuarioId key) {
		this.key = key;
	}

	public String getTipouser() {
		return tipouser;
	}

	public void setTipouser(String tipouser) {
		this.tipouser = tipouser;
	}

	public String getMail() 
	{
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	

	public String getContrasenia() {
		return Contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}

	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido1() {
		return Apellido1;
	}

	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}

	public String getApellido2() {
		return Apellido2;
	}

	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}

	public Date getFechanacimiento() {
		return Fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		Fechanacimiento = fechanacimiento;
	}

	public List<Servicio> getParticipa_serv() {
		return participa_serv;
	}

	@Override
	public boolean equals(Object usr)
	{
		Usuario us = usr instanceof Usuario? (Usuario) usr: null;
		
		return us!=null && this.key.codigo == us.key.codigo && us.key.dni.equals(this.key.dni);
	}
	
	@Override
	public int hashCode()
	{
		return Integer.hashCode(codigo)+this.key.dni.hashCode();
	}

	public void setParticipaserv_(List<Servicio>  participa_en) {
		this.participa_serv = participa_en;
	}

}
