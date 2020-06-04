

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entidades.Actividad;
import Entidades.Administrador;
import Entidades.Docente;
import Entidades.Entidad;
import Entidades.Estudiante;
import Entidades.Personal_Administracion;
import Entidades.Servicio;
import Entidades.ServicioFormacion;
import Entidades.ServicioInvestigacion;
import Entidades.ServicioVoluntariado;
import Entidades.Usuario;


@Named(value="datosact")
@SessionScoped
public class BaseDatos implements Serializable{

	
 public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

private ArrayList <Actividad> actividades = new ArrayList<>();
 private ArrayList <Servicio> servicios = new ArrayList<>();
	 
 
 public ArrayList<Servicio> getServicios() {
	return servicios;
}

public void setServicios(ArrayList<Servicio> servicios) {
	this.servicios = servicios;
}

private static final long serialVersionUID = 1L;
Usuario user1 = new Usuario("lopezcarlos@correo.com", "45681267P" , "lopez1234" , "Carlos" , "Lopez" , "Jimenez", new Date (85,04,6));
Usuario user2 = new Usuario("josefahg@correo.com", "48957123J" , "jhgcnt1" , "Josefa" , "Diaz" , "Rosado" ,new Date (100,8,4));

Administrador admin1 = new Administrador("C.jesa@correo.com", "61274395H" , "cloniSh", "Carolina" , "Solano" , "Hernández", new Date (80,01,07), "ADMINISTRADOR");

Docente docent1 = new Docente("Antonio.LNG@correo.com" , "174893524C" , "Lngre6" , "Antonio" , "Merino", "Casado" , new Date (75,11,17), "LENGUA");
Docente docent2 = new Docente("Jb64mat@correo.com", "58941743I", "ghju789" , "Javier", "Barrios" , "Miranda", new Date (79,03,12), "MATEMATICAS");


Entidad enti1 = new Entidad("AyudaSinFronteras@correo.com", "K12345517P" , "helpu45" , "Ayuda Sin Fronteras", "Polígono Industrial el Viso" , "723489148" , "España" , "Málaga" , "Sin ánimo de lucro" ,"www.AyudaSinFronteras.com");
Entidad enti2 = new Entidad ("Alteza.alim@correo.com", "K4478937L", "Kontra57" , "Alteza alimentación" , "Polígono Industrial Moltaria" , "647892217", "España" , "Valencia" , "Con ánimo de lucro" , "www.AltezaAlimentacion.com");

Estudiante est1 = new Estudiante("sergi_lm@correo.com" , "47895578Q" , "sergi123r" , "Sergio" , "Leandro", "Millán", new Date (109,05,17), "2" , "Ingeniería Informática");
Estudiante est2 = new Estudiante("Antonella.78@correo.com" , "77701487L", "AntxIn" , "Antonella", "Martín", "De los Ríos", new Date (107,06,07),"2", "Historia");

Personal_Administracion pa1 = new Personal_Administracion("GeraMon@correo.com", "41789854T", "jrdr.124" , "Gerardo" , "Montes" , "Serrano" , new Date (60,8,17), "JARDINERO");
Personal_Administracion pa2 = new Personal_Administracion("paquita.95@correo.com" , "74413578S" , "211jilq", "Paquita" , "Flores" , "Fernández" , new Date (71,9,04), "LIMPIADORA");

private List<Usuario> usuarios = new LinkedList<>();




public List<Usuario> getUsuarios() {
	return usuarios;
}

 private Actividad actividad1 = new Actividad("Limpieza",new Date(120,6,9), "Málaga, España", "Limpiar escombros de la calle", "3 semanas", "Disponible",16, 284);
 private ServicioVoluntariado serviciovoluntariado1 = new ServicioVoluntariado(2841, "España" , "Málaga" , 2, 4, "Equipo de barrido", actividad1);
 private ServicioVoluntariado serviciovoluntariado2 = new ServicioVoluntariado(2842, "España" , "Málaga" , 6, 8, "Equipo de retirada de material", actividad1);
 private ServicioVoluntariado serviciovoluntariado3 = new ServicioVoluntariado(2843, "España" , "Málaga" , 8, 4, "Equipo de organización", actividad1);
 List<Servicio> lista1 = new ArrayList<>();
 

 
 private Actividad actividad2 = new Actividad("Profesor",new Date(121,6,9),"San Juan, Puerto Rico","Profesor auxiliar en una escuela","4 meses","Disponible",6, 143);
 private ServicioFormacion servicioformacion1 = new ServicioFormacion(1431, "Puerto Rico" , "San Juan" , 8, 3, "Profesor auxiliar de matemáticas", actividad2);
 private ServicioFormacion servicioformacion2 = new ServicioFormacion(1432, "Puerto Rico" , "San Juan" , 8, 3, "Profesor auxiliar de Inglés", actividad2);
 List<Servicio> lista2 = new ArrayList<>();
 
 private Actividad actividad3 = new Actividad("Profesor de Idiomas",new Date(121,6,9),"Tijuana, Mexico","Enseñanza de idiomas: Chino y Japones","2 meses","No Disponible",10, 798);
 private ServicioFormacion servicioformacion3 = new ServicioFormacion(7981, "Mexico" , "Tijuana" , 8, 5, "Profesor de japonés", actividad3);
 private ServicioFormacion servicioformacion4 = new ServicioFormacion(7982, "Mexico" , "Tijuana" , 8, 5, "Profesor de chino", actividad3);
 List<Servicio> lista3 = new ArrayList<>();
 
 private Actividad actividad4 = new Actividad("Ayuda Granja",new Date(122,6,9),"Caracas, Venezuela","Ayudar en una granja","2 semanas","Disponible",20, 649);
 private ServicioVoluntariado serviciovoluntariado4 = new ServicioVoluntariado(6492, "Cape Town" , "Sudáfrica" , 6, 7, "Equipo de recogida de legumbres", actividad4);
 private ServicioVoluntariado serviciovoluntariado5 = new ServicioVoluntariado(6493, "Cape Town" , "Sudáfrica" , 6, 6, "Equipo de bricolaje y fontanería", actividad4);
 List<Servicio> lista4 = new ArrayList<>();
 
 private Actividad actividad5 = new Actividad("Ayuda Hospital",new Date(120,6,9),"Cape Town, Sudáfrica","Ayudar en un hospital","4 meses","No Disponible",8, 463);
 private ServicioVoluntariado serviciovoluntariado6 = new ServicioVoluntariado(4631, "Cape Town" , "Sudáfrica" , 4, 6, "Equipo de transporte de material", actividad5);
 private ServicioInvestigacion servicioinvestigacion1 = new ServicioInvestigacion(4632, "Cape Town" , "Sudáfrica" , 8, 2, "Investigación sobre el impacto de la calidad del agua en la esperanza de vida media", actividad5);
 List<Servicio> lista5 = new ArrayList<>();
 
@PersistenceContext(unitName = "trabajogruposii")
private EntityManager em;

 
 
	public BaseDatos() 
	{
		
		
		usuarios = new ArrayList<>();
		
		usuarios.add(user1);
		usuarios.add(user2);

		usuarios.add(admin1);
	
		usuarios.add(docent1);
		usuarios.add(docent2);

		
		usuarios.add(enti1);
		usuarios.add(enti2);
		
		
		usuarios.add(est1);
		usuarios.add(est2);
		
		
		usuarios.add(pa1);
		usuarios.add(pa2);
		
		System.out.println("1");
		
		lista1.add(this.serviciovoluntariado1);
		lista1.add(this.serviciovoluntariado2);
		lista1.add(this.serviciovoluntariado3);
		this.actividad1.setLista_servicio(lista1);
		
		lista2.add(this.servicioformacion1);
		lista2.add(this.servicioformacion2);
		this.actividad2.setLista_servicio(lista2);
		
		lista3.add(this.servicioformacion3);
		lista3.add(this.servicioformacion4);
		this.actividad3.setLista_servicio(lista3);
		
		lista4.add(this.serviciovoluntariado4);
		lista4.add(this.serviciovoluntariado5);
		this.actividad4.setLista_servicio(lista4);
		
		lista5.add(this.serviciovoluntariado6);
		lista5.add(this.servicioinvestigacion1);
		this.actividad5.setLista_servicio(lista5);
		
		System.out.println("2");
		
		
		
		
		this.actividades.add(actividad1);
		this.actividades.add(actividad2);
		this.actividades.add(actividad3);
		this.actividades.add(actividad4);
		this.actividades.add(actividad5);
		
		System.out.println("3");
		
		this.user1.getAct_participa().add(this.actividad1);
		this.user1.getParticipa_serv().add(this.serviciovoluntariado1);
		
		this.user1.getAct_participa().add(actividad2);
		this.user1.getParticipa_serv().add(servicioformacion2);
		
		this.user2.getAct_participa().add(actividad3);
		this.user2.getParticipa_serv().add(servicioformacion3);
		
		this.user2.getAct_participa().add(actividad4);
		this.user2.getParticipa_serv().add(serviciovoluntariado5);
		
		
		
		
		
		
		
		docent1.getAct_participa().add(actividad1);
		docent1.getParticipa_serv().add(serviciovoluntariado3);
		
		docent1.getAct_participa().add(actividad1);
		docent1.getParticipa_serv().add(serviciovoluntariado2);
		
		docent2.getAct_participa().add(actividad4);
		docent2.getParticipa_serv().add(serviciovoluntariado4);
		
		docent2.getAct_participa().add(actividad3);
		docent2.getParticipa_serv().add(servicioformacion3);
		
		
		enti1.getAct_participa().add(actividad4);
		enti1.getParticipa_serv().add(serviciovoluntariado4);
		
		enti1.getAct_participa().add(actividad3);
		enti1.getParticipa_serv().add(servicioformacion4);
		
		enti2.getAct_participa().add(actividad1);
		enti2.getParticipa_serv().add(serviciovoluntariado2);
		
		enti2.getAct_participa().add(actividad2);
		enti2.getParticipa_serv().add(servicioformacion2);
		
		for(Usuario user : usuarios)
		{
			//em.persist(user);
		}
		
		for(Actividad act : this.actividades)
		{
			//em.persist(act);
		}
		
		
		
		
		
		
	}
	
	public ArrayList<Actividad> getActividades() {
		return actividades;
	}
	 
	 public void AnadirActividad (Actividad a) {
		 actividades.add(a);
	 }
	 
	 public void EliminarActividad (Actividad a) {
		 actividades.remove(a);
	 }
	
}