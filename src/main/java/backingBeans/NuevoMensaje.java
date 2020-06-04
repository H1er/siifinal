package backingBeans;

import java.io.Serializable;
import java.time.LocalDate;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import EJBs.Dbean;
import backingBeans.autenticacion.ControlAutorizacion;
import entidades.Mensaje;
import entidades.Usuario;

@ManagedBean
@Named(value="nuevom")
@ViewScoped
public class NuevoMensaje implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
    private ControlAutorizacion ctrl;
	
	@EJB
	private Dbean bd;
	
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

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getDniremitente() {
		return dniremitente;
	}

	public void setDniremitente(String dniremitente) {
		this.dniremitente = dniremitente;
	}

	private Mensaje mensaje;
	private String asunto;
	private String texto;
	private String destinatario;
	private String dniremitente;
	private String s;

	
	public ControlAutorizacion getCtrl() {
		return ctrl;
	}

	public void setCtrl(ControlAutorizacion ctrl) {
		this.ctrl = ctrl;
	}

	public Dbean getBd() {
		return bd;
	}

	public void setBd(Dbean bd) {
		this.bd = bd;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public NuevoMensaje()
	{
		mensaje = new Mensaje();
	}
	
	public void enviarMensaje()
	{
		LocalDate currentDate = LocalDate.now();
		
		Usuario dest = bd.getUserByDni(destinatario);
		s = dest.getKey().getDni();
		if(dest != null)
		{
			mensaje.setFecha(java.sql.Date.valueOf(currentDate));
			
			mensaje.setTexto(this.texto);
			mensaje.setAsunto(this.asunto);
			mensaje.setReceptor(dest);
			
			mensaje.setEmisor(ctrl.getUsuario());
			
			bd.enviarMensaje(mensaje);
		}	
	}
	
	
	
	public Mensaje getMensaje()
	{
		return mensaje;
	}
	
}