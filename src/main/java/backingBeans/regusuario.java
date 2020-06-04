package backingBeans;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import EJBs.Dbean;
import backingBeans.autenticacion.ControlAutorizacion;
import entidades.Docente;
import entidades.Entidad;
import entidades.Estudiante;
import entidades.Personal_Administracion;
import entidades.Usuario;



@ManagedBean
@Named(value = "Regusr")
@ViewScoped
public class regusuario implements Serializable
{
	
	@Inject
	private ControlAutorizacion ctr;
	
	private static final long serialVersionUID = 1L;
	private String tipouser;
	private String mail;
	private String dni; 
	private String contrasenia; 
	private String contrasenia2; 
	private String nombre; 
	private String apellido1; 
	private String apellido2; 
	
	@Temporal(TemporalType.DATE)
	private Date fechanacim; 
	
	private String departamento; 
	private String web; 
	private String titulacion; 
	private String curso; 
	private String tipo_cargo; 
	private String direccion; 
	private String tlf; 
	private String pais; 
	private String ciudad; 
	private String tipo_origen; 
	
	@Inject
	private Dbean bd;

	public regusuario()
	{
		
	}
	
	public String getTipouser() {
		return tipouser;
	}

	public void setTipouser(String tipouser) {
		this.tipouser = tipouser;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTipo_cargo() {
		return tipo_cargo;
	}

	public void setTipo_cargo(String tipo_cargo) {
		this.tipo_cargo = tipo_cargo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getContrasenia2() {
		return contrasenia2;
	}

	public void setContrasenia2(String contrasenia2) {
		this.contrasenia2 = contrasenia2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFechanacim() {
		return fechanacim;
	}

	public void setFechanacim(Date fechanacim) {
		this.fechanacim = fechanacim;
	}
	
	public String creaUsuario()
	{
		
		if(this.tipouser != null)
		{
			
			if(!this.faltanDatos(tipouser))
			{
				if(this.contrasenia.equals(contrasenia2))
				{
					switch(this.tipouser)
					{
						
					case "1":
						Usuario usr = new Usuario(this.mail,this.dni, this.contrasenia, this.nombre, this.apellido1, this.apellido2, this.fechanacim, "1");
						bd.addUser(usr);
						this.ctr.setUsuario(usr);
						return "micuenta.xhtml";
						
					case "2":
						Docente doc = new Docente(this.mail,this.dni,this.contrasenia,this.nombre,this.apellido1,this.apellido2,this.fechanacim,this.departamento);
						this.ctr.setUsuario(doc);
						bd.addUser(doc);
						return "micuenta.xhtml";
						
					case "3":
						Estudiante est = new Estudiante(this.mail,this.dni,this.contrasenia,this.nombre,this.apellido1,this.apellido2,this.fechanacim,this.curso,this.titulacion);
						this.ctr.setUsuario(est);
						bd.addUser(est);
						return "micuenta.xhtml";
						
					case "4":
						Personal_Administracion pdipas = new Personal_Administracion(this.mail,this.dni,this.contrasenia,this.nombre,this.apellido1,this.apellido2,this.fechanacim,this.tipo_cargo);
						this.ctr.setUsuario(pdipas);
						bd.addUser(pdipas);
						return "micuenta.xhtml";
						
					case "5":
						Entidad ent = new Entidad(this.mail,this.dni,this.contrasenia,this.nombre,this.direccion,this.tlf,this.pais,this.ciudad,this.tipo_origen,this.web.isEmpty()? "N/A": this.web);
						this.ctr.setUsuario(ent);
						bd.addUser(ent);
						return "micuenta.xhtml";
					}
				}
				else
				{
					this.warn("Error", "Las contraseñas deben coincidir");	
				}
				
			}
			else
			{
				this.warn("Faltan Datos", "Para registrarse correctamente debe introducir los datos indicados con *  ");	
			}
		}
			

		return null;
		
	}
		
		
	
	public boolean faltanDatos(String n) //devuelve true si faltan datos
	{
		switch(n)
		{
		case "1": 
			return this.mail.equals("") || this.dni.equals("") || this.contrasenia.equals("") || this.contrasenia2.equals("") || this.nombre.equals("") || this.apellido1.equals("") || this.apellido2.equals("") ||this.fechanacim.equals("");
				
		case "2": 
			return this.faltanDatos("1") || this.departamento.equals(""); 
		
		case "3": 
			return this.faltanDatos("1") || this.titulacion.equals("");  //curso tiene valor por defecto, por lo que nunca va a ser null
		
		case "4": 
			return this.faltanDatos("1") || this.tipo_cargo.equals("");
		
		case "5": 
			return this.mail  .equals("") || this.dni  .equals("") || this.contrasenia  .equals("") || this.contrasenia2  .equals("") || this.nombre  .equals("") || this.direccion  .equals("") || this.tlf  .equals("") || this.pais  .equals("") || this.ciudad  .equals("") || this.tipo_origen  .equals("");
			
		}
		
		return true;
	}
	
	public void warn(String mensaje1, String mensaje2) 
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje1, mensaje2);
		FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	@Override
	public String toString()
	{
		switch(this.tipouser)
		{
		case "1": return this.mail + this.dni+ this.contrasenia +this.contrasenia2 +this.nombre+this.apellido1 +this.apellido2+this.fechanacim.toString();
				
		case "2": return this.faltanDatos("1") + this.departamento; 
		
		case "3": return this.faltanDatos("1") + this.titulacion;  //curso tiene valor por defecto, por lo que nunca va a ser null
		
		case "4": return this.faltanDatos("1") + this.tipo_cargo; 
		
		case "5": return this.mail+this.dni+ " " + this.contrasenia+ " " + this.contrasenia2+ " " + this.nombre+ " " + this.direccion+ " " + this.tlf+ " " + this.pais+ " " + this.ciudad; 
		
		}
		
		return "No ha entrao loco";
		
	}
	
	
	
	
}