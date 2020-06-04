package BasesDatos;


import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import Entidades.Mensaje;

public class DatosMensajes {
	
	public List<Mensaje> getListamensajes() {
		return listamensajes;
	}

	public void setListamensajes(List<Mensaje> listamensajes) {
		this.listamensajes = listamensajes;
	}

	private List<Mensaje> listamensajes;
	
	Mensaje enviado1 = new Mensaje(138, new Date(120,0,10),"CAMBIO HORA ACTIVIDAD SÁBADO","Pasamos la actividad planeada el sabádo para las 16:00 a las 18:00","45681267P","48957123J");
	
	Mensaje enviado2 = new Mensaje(217, new Date(119,11,5),"SUSPENSIÓN ACTIVIDAD MARTES","La actividad prevista para el martes ha sido cancelada debido al mal tiempo que se prevee","48957123J","16452378S");
	
	Mensaje enviado3 = new Mensaje(101, new Date(119,9,13),"FELIZ CUMPLEAÑOS","Me he enterado de que hoy es tu cumpleaños, espero que pases un buen día","78921640Q","48957123J");
	
	Mensaje enviado4 = new Mensaje(610, new Date(120,1,19),"NUEVA ACTIVIDAD DISPONIBLE","Han publicado una nueva actividad que creo que te puede interesar, échale un vistazo","61274395H","174893524C");
	
	Mensaje enviado5 = new Mensaje(128, new Date(120,1,4),"ACTIVIDAD DE AYER", "La actividad de ayer fue todo un éxito, gracias por la participación","174893524C","61274395H");
	
	Mensaje enviado6 = new Mensaje(515, new Date(119,11,27),"ACTIVIDAD DE NOCHEVIEJA", "La actividad del día 31 empezará finalmente a las 9:30","174893524C","19735151B");
	
	public DatosMensajes () {
		listamensajes = new ArrayList();
		listamensajes.add(enviado1);
		listamensajes.add(enviado2);
		listamensajes.add(enviado3);
		listamensajes.add(enviado4);
		listamensajes.add(enviado5);
		listamensajes.add(enviado6);
	}
}