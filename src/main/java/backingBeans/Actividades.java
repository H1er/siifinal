package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import EJBs.Dbean;
import backingBeans.autenticacion.ControlAutorizacion;
import entidades.Actividad;
import entidades.Servicio;

@ManagedBean
@Named(value="acts")
@ViewScoped
public class Actividades implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Actividad actselec;
	
	@EJB private Dbean bd;

	public Actividades()
	{
		
	}
	
	 public void addMessage(String mensaje1, String mensaje2) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje1, mensaje2);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
	public ControlAutorizacion getCtrl() {
		return ctrl;
	}

	public void setCtrl(ControlAutorizacion ctrl) {
		this.ctrl = ctrl;
	}

	@Inject
	private ControlAutorizacion ctrl;
	
	public List<Actividad> getActividades() {
		return this.bd.getDisponibles();
	}

	
	public Actividad getActselec() {
		return actselec;
	}

	public void setActselec(Actividad actselec) {
		this.actselec = actselec;
	}
	
	public void apuntaUsuario(Servicio s)
	{
		
			if(!this.ctrl.getUsuario().getParticipa_en().contains(this.actselec))
			{
				this.ctrl.getUsuario().getParticipa_en().add(this.actselec);
				this.ctrl.getUsuario().getParticipa_serv().add(s);
				s.getParticipan().add(this.ctrl.getUsuario());
				
				this.bd.updateServicio(s);
				this.bd.updateUser(this.ctrl.getUsuario());
			}
			else
			{
				this.addMessage("Error", "Solo te puedes apuntar a un servicio por actividad");
			}

	}

}