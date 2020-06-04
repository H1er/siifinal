package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Servicio implements Serializable, Comparable<Servicio> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigo;

	private String Descripcion;
	private Integer Horas;
	private Integer NumParticipantes;
	
	

	@ManyToMany
	private List <Usuario> participan; 
	
	private static final long serialVersionUID = 1L;
 
	@ManyToOne
	private Actividad Act; 
	
	public Servicio()
	{
		super();
	}
	
	public Servicio(String pais,String ciudad,Integer horas,Integer numParticipantes,String descripcion, Actividad act) 
	{
        this.Horas=horas;
        this.NumParticipantes=numParticipantes;
        this.Descripcion=descripcion;
        this.Act = act;
	}   
	

	
	public List<Usuario> getParticipan() {
		return participan;
	}

	public void setParticipan(List<Usuario> participan) {
		this.participan = participan;
	}

	public Actividad getAct() {
		return Act;
	}

	public void setAct(Actividad act) {
		Act = act;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public Integer getHoras() {
		return this.Horas;
	}

	public void setHoras(Integer Horas) {
		this.Horas = Horas;
	}   
	public Integer getNumParticipantes() {
		return this.NumParticipantes;
	}

	public void setNumParticipantes(Integer NumParticipantes) {
		this.NumParticipantes = NumParticipantes;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}
	
	
	@Override
	public boolean equals(Object o)
	{
		Servicio s = o instanceof Servicio? (Servicio) o:null;
		return s != null && s.codigo == this.codigo;
		
	}
	
	@Override
	public int compareTo(Servicio s)
	{
		return s.codigo - this.codigo;
		
	}
	
	@Override
	public int hashCode()
	{
		return Integer.hashCode(this.codigo);
	}
   
}
