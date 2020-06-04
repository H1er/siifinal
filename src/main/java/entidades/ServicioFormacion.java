package entidades;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ServicioFormacion extends Servicio{

	
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Informe val;
	
	@OneToOne
	private Informe inf;
	
	public ServicioFormacion(Integer codigo,String pais,String ciudad,Integer horas,Integer numParticipantes,String descripcion, Actividad act) {
		super(pais,ciudad,horas,numParticipantes,descripcion, act);
		this.val = new Informe();
		this.inf = new Informe();
	}
	
	public ServicioFormacion()
	{
		super();
	}
	
	public Informe getVal() {
		return val;
	}

	public void setVal(Informe val) {
		this.val = val;
	}

	public Informe getInf() {
		return inf;
	}

	public void setInf(Informe inf) {
		this.inf = inf;
	}

	
}
