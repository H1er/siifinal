package backingBeans.autenticacion;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import EJBs.Dbean;
import entidades.Usuario;


@Named(value = "login")
@RequestScoped
public class Login {

    public ControlAutorizacion getCtrl() {
		return ctrl;
	}

	public void setCtrl(ControlAutorizacion ctrl) {
		this.ctrl = ctrl;
	}

	private String usuario;
    private String contrasenia;
    

    @EJB private Dbean  bd;

    
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
    
    }

    public void addMessage(String mensaje1, String mensaje2) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje1, mensaje2);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String autenticar() 
    {
    	if(this.bd.getUsuarios()!=null)
    	{
    		for(Usuario usr : this.bd.getUsuarios())
    		{
    			if(usr.getMail().equals(usuario) && usr.getContrasenia().equals(contrasenia))
    			{
        		
    				this.ctrl.setUsuario(usr);
    				return "micuenta.xhtml";
    			}
    		}
    	}
    	

    	
    	this.addMessage("Usuario o contraseña incorrectos", "");
    	
    	return null;
    }
 
}
