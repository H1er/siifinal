package entidades;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ServicioVoluntariado  extends Servicio{
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	@OneToOne
	private Informe inf;
	
	public ServicioVoluntariado()
	{
		super();
	}
	
	public ServicioVoluntariado(Integer codigo,String pais,String ciudad,Integer horas,Integer numParticipantes,String descripcion, Actividad act) {
		super(pais,ciudad,horas,numParticipantes,descripcion, act);
		
		this.inf = new Informe();
	}

	

	public Informe getInf() {
		return inf;
	}

	public void setInf(Informe inf) {
		this.inf = inf;
	}
}
