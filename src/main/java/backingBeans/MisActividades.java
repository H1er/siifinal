package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import EJBs.Dbean;
import backingBeans.autenticacion.ControlAutorizacion;
import entidades.Actividad;
import entidades.Servicio;
import entidades.Usuario;

@ManagedBean
@Named(value="misacts")
@ViewScoped
public class MisActividades implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private Actividad actselec;
	
	@Inject 
	private ControlAutorizacion ctr;
	
	@EJB private Dbean bd;
	
	/**
	 * 
	 */
	public MisActividades()
	{
	
	}
	
	public ControlAutorizacion getCtr() {
		return ctr;
	}

	public void setCtr(ControlAutorizacion ctr) {
		this.ctr = ctr;
	}

	public Dbean getActs() {
		return bd;
	}

	public void setActs(Dbean acts) {
		this.bd = acts;
	}

	public Actividad getActselec() {
		return actselec;
	}

	public void setActselec(Actividad actselec) {
		this.actselec = actselec;
	}
	


}
