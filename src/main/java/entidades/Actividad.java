package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity 
public class Actividad implements Serializable, Comparable<Actividad> {
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String localizacion;
	private String descripcion;
	

	private String duracion;
	private String disponibilidad;
	private Integer plazas;  
	private boolean disponible;
	
	public List<Usuario> getParticipan() {
		return participan;
	}

	
	
	public boolean isDisponible() {
		return disponible;
	}
	
	public boolean estadisponible()
	{
		return this.disponibilidad.equals("Disponible");
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public void setParticipan(List<Usuario> participan) {
		this.participan = participan;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@ManyToMany
	private List<Usuario> participan = new LinkedList<>();

	@OneToMany
	private List <Servicio> lista_servicio= new ArrayList<>(); 
		
	
	public Actividad()
	{
		
	}
	
	public Actividad(String nombre,Date f,String l,String d,String dur,String dis,Integer nump) {
		this.fecha=f;
		this.localizacion=l;
		this.descripcion=d;
		this.duracion=dur;
		this.disponibilidad=dis;
		this.plazas=nump;
		this.lista_servicio=new ArrayList<>();
		this.nombre=nombre;
	}  

	
	
	public int compareTo(Actividad act)
	{
		return this.hashCode()-act.hashCode();
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalizacion() {
		return localizacion;
	}
	
	@Override
	public boolean equals(Object o)
	{
		Actividad a = o instanceof Actividad ? (Actividad) o : null;
		return a != null && a.codigo == this.codigo;
	}
	
	@Override
	public int hashCode()
	{
		return Integer.hashCode(this.codigo);
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

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Integer getPlazas() {
		return plazas;
	}

	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<Servicio> getLista_servicio() {
		return lista_servicio;
	}

	public void setLista_servicio(List<Servicio> lista_servicio) {
		this.lista_servicio = lista_servicio;
	}


	

}
