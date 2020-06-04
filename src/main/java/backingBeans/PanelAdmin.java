package backingBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import EJBs.Dbean;
import entidades.Actividad;
import entidades.Servicio;

@ManagedBean
@Named(value="admin")
@ViewScoped
public class PanelAdmin implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private Actividad actselec = new Actividad();
	private String nombreintro; //1
	private Date fechaintro; 
	private String localizacionintro; //3
	private String descripcionintro;//4
	private String duracionintro;//5
	private String plazasintro;//6
	private String disponibilidad;//7
	
	
	private Servicio servicioselec;
	private String desc2intro;
	private String horas; //tienen que ser int
	private String participantesintro; //titneen que ser int
	
	
	
	
	
	
	
	
	@EJB
    private Dbean bd;
	
	
	public PanelAdmin() {
		super();
	

	}

	public List<Actividad> getAs() {
		return bd.getActividades();
		
	}

	public void updatedescS(Servicio s)
	{
		s.setDescripcion(this.desc2intro);
		this.bd.updateServicio(s);
	}
	
	public void updatehorS(Servicio s)
	{
		try
		{
			s.setHoras(Integer.parseInt(this.horas));
			this.bd.updateServicio(s);
		}
		catch(Exception e)
		{
			this.addMessage("Error", "Las horas deben ser un numero");
		}
		
	}
	
	
	public void updatepartS(Servicio s)
	{
		try
		{
			s.setNumParticipantes(Integer.parseInt(this.participantesintro));
			this.bd.updateServicio(s);
		}
		catch(Exception e)
		{
			this.addMessage("Error", "Los participantes deben ser un numero");
		}
		
	}
	
	
	
	
	
	
	public String getDesc2intro() {
		return desc2intro;
	}

	public void setDesc2intro(String desc2intro) {
		this.desc2intro = desc2intro;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getParticipantesintro() {
		return participantesintro;
	}

	public void setParticipantesintro(String participantesintro) {
		this.participantesintro = participantesintro;
	}

	public Actividad getActselec() {
		return actselec;
	}
	
	public void updateServicio(Servicio s)
	{
		this.bd.updateServicio(s);
	}
	
	public void updateActividades()
	{
		 this.addMessage("Code", Integer.toString(this.actselec.getCodigo()));
		 
		 this.bd.updateActividad(actselec);
	}
	
	 public void addMessage(String mensaje1, String mensaje2) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje1, mensaje2);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
	 public void stct(Actividad a)
	 {
		 this.actselec = a;
		 this.addMessage("Code", Integer.toString(this.actselec.getCodigo()));
		//this.bd.updateActividad(actselec);
		 
		 
	 }
	 
	 
	 
	public String getNombreintro() {
		return nombreintro;
	}

	public void setNombreintro(String nombreintro) {
		this.nombreintro = nombreintro;
	}
	
	public void updatenombreA(Actividad a)
	{
		a.setNombre(this.nombreintro);
		this.bd.updateActividad(a);
	}
	
	public void updatelocA(Actividad a)
	{
		a.setLocalizacion(this.localizacionintro);
		this.bd.updateActividad(a);
	}
	
	public void updatedesA(Actividad a)
	{
		a.setDescripcion(this.descripcionintro);
		this.bd.updateActividad(a);
	}
	
	public void updatedurA(Actividad a)
	{
		a.setDuracion(this.duracionintro);
		this.bd.updateActividad(a);
	}
	
	public void updateplazA(Actividad a)
	{
		try
		{
			a.setPlazas(Integer.parseInt(this.plazasintro));
			this.bd.updateActividad(a);
		}
		catch(Exception e)
		{
			this.addMessage("Error", "Las plazas deben ser un numero");
		}
		
	}
	
	public void cambiarDisponibilidad(Actividad a)
	{
		if(a.getDisponibilidad().equals("Disponible") )
		{
			a.setDisponibilidad("No Disponible");
			a.setDisponible(false);
		}
		else
		{
			a.setDisponibilidad("Disponible");
			a.setDisponible(true);
		}
		
		this.bd.updateActividad(a);
		
	}

	
	
		

	public void updateFecha(Actividad a)
	{
		a.setFecha(this.fechaintro);
		
		this.bd.updateActividad(a);
		
		
	}
	
	

	public Servicio getServicioselec() {
		return servicioselec;
	}

	public void setServicioselec(Servicio servicioselec) {
		this.servicioselec = servicioselec;
	}

	public void setActselec(Actividad actselec) {
		
		
		this.actselec = actselec;
	}
	
	
	

	public Date getFechaintro() {
		return fechaintro;
	}

	public void setFechaintro(Date fechaintro) {
		this.fechaintro = fechaintro;
	}

	public String getLocalizacionintro() {
		return localizacionintro;
	}

	public void setLocalizacionintro(String localizacionintro) {
		this.localizacionintro = localizacionintro;
	}

	public String getDescripcionintro() {
		return descripcionintro;
	}

	public void setDescripcionintro(String descripcionintro) {
		this.descripcionintro = descripcionintro;
	}

	public String getDuracionintro() {
		return duracionintro;
	}

	public void setDuracionintro(String duracionintro) {
		this.duracionintro = duracionintro;
	}

	public String getPlazasintro() {
		return plazasintro;
	}

	public void setPlazasintro(String plazasintro) {
		this.plazasintro = plazasintro;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	

}