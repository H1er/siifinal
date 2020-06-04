package backingBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import EJBs.Dbean;
import entidades.Actividad;
import entidades.Servicio;
import java.io.Serializable;

@Named (value="publicaractividad")
@ViewScoped
public class publicarActividad implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Dbean bd;
	
	@Temporal(TemporalType.DATE)
    private Date fecha; 
	private String nombre;
    private String localizacion;
    private String descripcion;
    private String duracion;
    private String num;
    private String disponibilidad= "No disponible";
    private List<Servicio> columns;
 


    public String getDisponibilidad() {
		return disponibilidad;
	}
    
    public publicarActividad()
	{
		 columns = new ArrayList<Servicio>();
	     columns.add(new Servicio());
	}
	

    public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
 
    public List<Servicio> getColumns() {
        return columns;
    }
 
    public void setColumns(List<Servicio> columns) {
        this.columns = columns;
    }
 
    public void increment() {
        if (columns.size() < 10) {
            columns.add(new Servicio());
        }
    }
 
    public void decrease() {
        if (columns.size() > 1) {
            columns.remove(columns.size() - 1);
        }
    }
    
    public String aniade()
    {
    	try
    	{
    		if(!this.faltanDatos() && !this.columns.isEmpty())
        	{
        		//comprobar que todos los campos han sido rellenados y añadir la actividad
            	this.addMessage("Su actividad ha sido propuesta","esta será evaluada por nuestros administradores y evaluada en caso de que proceda" );
            	
            	Actividad act = new Actividad(this.nombre, this.fecha, this.localizacion, this.descripcion, this.duracion, this.disponibilidad, Integer.parseInt(num) /*tam lista acts+1*/);
            	
            	for(Servicio serv: columns)
            	{
            		
            		bd.addServicio(serv);
            	}
            	
            	
            	act.setLista_servicio(columns);
            	bd.publicarActividad(act);
            	
            	for(Servicio serv: columns)
            	{
            		serv.setAct(act);
            		bd.updateServicio(serv);
            		
            	}
            	
            	
            	return "publicar.xhtml";
        	}
        	else
        	{
        		this.addMessage("Faltan Datos", "Para registrarse correctamente debe introducir los datos indicados con *  ");
        		return null;
        	}
    		
    	}
    	catch(NullPointerException e)
    	{
    		this.addMessage("Faltan Datos", "Para registrarse correctamente debe introducir los datos indicados con *  ");
    		return null;
    		
    	}
    	
    
    	
    	
    }
    
    public boolean faltanDatos() //devuelve true si faltan datos
	{
		
			return this.nombre.equals("") || this.fecha.equals("") || this.localizacion.equals("") || this.descripcion.equals("") || this.duracion.equals("") || this.num.equals("");
				
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


    public void addMessage(String mensaje1, String mensaje2) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje1, mensaje2);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}