package backingBeans.autenticacion;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import EJBs.Dbean;
import entidades.Usuario;


@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
  
    @EJB Dbean bd;
    
    public ControlAutorizacion() {
    }

    public void setUsuario(Usuario usuario) {
    	
    		this.usuario = usuario;
    	
        
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void up ()
    {
    	Usuario u = this.usuario;
    	bd.updateUser(usuario);
    	
    	this.usuario = u;
    }
    
    
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        	
        	this.setUsuario(null);
        
        usuario = null;
        return "login.xhtml";
    }
    

    /**
     * Creates a new instance of ControlAutorizacion
     */
   
}
