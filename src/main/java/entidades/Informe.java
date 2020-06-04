package entidades;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Informe implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_informe; 
	
	private String observacion;
	
	@Temporal(TemporalType.DATE)
	private Date fechaRealizacion;
	
	@OneToOne
	private Entidad ent; 
	
	@ManyToOne
	private Servicio serv;
	
	@ManyToOne
	private Usuario sujeto;

    
	private static final long serialVersionUID = 1L;

	public Informe(Integer id_informe,String Observacion,Date FechaREalizacion,Entidad ent) 
	{
		this.id_informe=id_informe;
		this.observacion=Observacion;
		this.fechaRealizacion=FechaREalizacion;
		this.ent=ent;

	}
	
	public Informe()
	{
		super();
	}
	
	
   
}
