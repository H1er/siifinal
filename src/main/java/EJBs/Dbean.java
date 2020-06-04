package EJBs;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import backingBeans.autenticacion.ControlAutorizacion;
import entidades.Actividad;
import entidades.Mensaje;
import entidades.Servicio;
import entidades.Usuario;



@Stateless
@LocalBean
public class Dbean 
{
	
	@PersistenceContext(unitName = "trabajogruposii")
	private EntityManager em;

	ControlAutorizacion ctr;
    public Dbean() 
    {
        
    }
    
    public List<Actividad> getActividades()
    {
    	TypedQuery<Actividad> query = em.createQuery("select a from Actividad a", Actividad.class);
    	
    	List<Actividad> acts= query.getResultList();
    	return new LinkedList<Actividad>(acts);
    	
    }
    
    public List<Actividad> getDisponibles()
    {
    	TypedQuery<Actividad> query = em.createQuery("select a from Actividad a where a.disponible = 1", Actividad.class);
    	
    	List<Actividad> acts= query.getResultList();
    	return new LinkedList<Actividad>(acts);
    	
    }
    
    public List<Usuario> getUsuarios()
    {
    	TypedQuery<Usuario> query = em.createQuery("select a from Usuario a", Usuario.class);
    	List<Usuario> users= query.getResultList();
    	return users;
    	
    }
    
    public void updateUser(Usuario us)
    {
    	this.em.merge(us);
    	this.em.flush();
    	this.em.clear();
    }
    
    public void updateServicio(Servicio s)
    {
    	this.em.merge(s);
    	this.em.flush();
    	this.em.clear();
    }
    
    public void updateActividad(Actividad s)
    {
    	this.em.merge(s);
    	this.em.flush();
    	this.em.clear();
    }
    
    
    
    public List<Mensaje> getMensajesEnviadosPor(int id)
    {
    	TypedQuery<Mensaje> query = em.createQuery("SELECT e FROM Mensaje e WHERE e.emisor.id.codigo = :id1", Mensaje.class).setParameter("id1", id);
        return query.getResultList();
    }
    
    public List<Mensaje> getmensajesRecibidosPor(int id)
    {
    	TypedQuery<Mensaje> query = em.createQuery("SELECT r FROM Mensaje r WHERE r.receptor.id.codigo = :id2", Mensaje.class).setParameter("id2", id);
     
        
        return query.getResultList();
    }
    
    public Usuario getUserByDni(String dni)
    {
    	TypedQuery<Usuario> query = em.createQuery("select u from Usuario u WHERE u.id.dni = :dni", Usuario.class).setParameter("dni", dni);
    	return query.getResultList().isEmpty()? null:query.getResultList().get(0);
    }
    
    public void addUser(Usuario usuario)
    {
    	em.persist(usuario);
    	em.flush();
    	this.em.clear();
    }
    
    public void addServicio(Servicio s)
    {
    	this.em.persist(s);
    	this.em.flush();
    	this.em.clear();
    }
    
    public void enviarMensaje(Mensaje mensaje)
    {
    	em.merge(mensaje);
    	this.em.flush();
    	this.em.clear();
    }
    
    public void publicarActividad(Actividad act)
    {
    	em.persist(act);
    	em.flush();  
    }
    
    
    public int getMsize()
    {
    	TypedQuery<Mensaje> query = em.createQuery("SELECT m FROM Mensaje m ", Mensaje.class);
    	return query.getResultList() == null ? 0 : query.getResultList().size();
    }
  
}
