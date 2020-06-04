package backingBeans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.ManyToMany;

import EJBs.Dbean;
import entidades.Mensaje;
import entidades.Usuario;

@ManagedBean
@Named(value="bandeja")
@RequestScoped
public class BandejaMensajes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Dbean bd;
	
	@ManyToMany
	private List<Mensaje> enviados;
	
	@ManyToMany
	private List<Mensaje> recibidos;


	private Mensaje seleccionado;
	private Mensaje seleccionado2;
	
	public Mensaje getSeleccionado2() {
		return seleccionado2;
	}

	public void setSeleccionado2(Mensaje seleccionado2) {
		this.seleccionado2 = seleccionado2;
	}

	public BandejaMensajes() 
	{	
		enviados=new LinkedList<>();
		recibidos=new LinkedList<>();
	}
	

	public List<Mensaje> getEnviados(int codigo) 
	{
		enviados = this.bd.getMensajesEnviadosPor(codigo);
		return enviados;
	}

	public void setEnviados(List<Mensaje> enviados) {
		this.enviados = enviados;
	}

	public List<Mensaje> getRecibidos(int codigo) {
		
		recibidos = this.bd.getmensajesRecibidosPor(codigo);
		return recibidos;
	}

	public void setRecibidos(List<Mensaje> recibidos) {
		this.recibidos = recibidos;
	}

	public Mensaje getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(Mensaje seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	  public void addMessage(String mensaje1, String mensaje2) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje1, mensaje2);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }

	
	

}
