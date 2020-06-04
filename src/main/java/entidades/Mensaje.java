package entidades;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Mensaje implements Serializable {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String asunto;
	private String texto;
	
	
	@ManyToOne
	private Usuario emisor;
	
	@ManyToOne
	private Usuario receptor;
	
	private static final long serialVersionUID = 1L;
	
	public Mensaje() {
	}

	public Mensaje(Date Fecha,String Asunto,String Texto, Usuario emisor, Usuario receptor) 
	{
		this.fecha=Fecha;
		this.asunto=Asunto;
		this.texto=Texto;
		
	}   
	
	
	@Override
	public boolean equals(Object o)
	{
		Mensaje m = o instanceof Mensaje? (Mensaje) o : null;
		
		return m!=null && m.getId() == this.id;
	}
	
	@Override
	public int hashCode()
	{
		return Integer.hashCode(this.id);
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}   
	
	
}

