package mx.com.sga.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import mx.com.sga.domain.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService{
	
	private List<Persona> listaPersonas = new ArrayList<Persona>();
	
	public List<Persona> listarPersonas() {
		// solo para simular los datos
		System.out.println(listaPersonas.size()+"tamaño");
		if(listaPersonas.size()<2){
			this.auxiliarPersonas();
		}
		return listaPersonas;
	}

	
	public void registrarPersona(Persona persona) {
		// TODO Auto-generated method stub
		listaPersonas.add(
				new Persona(	
						(listaPersonas.size()+1), 
						persona.getNombre(), 
						persona.getApellidoPaterno(), 
						persona.getApellidoMaterno(),  
						persona.getEmail(),
						persona.getTelefono()
				));
	}

	public Persona encontrarPersonaPorID(Integer idPersona) {
		// TODO Auto-generated method stub		
		return listaPersonas.get(idPersona);
	}

	public void modificarPersona(Persona persona) {
		// TODO Auto-generated method stub
		listaPersonas.set(persona.getIdPersona(), persona);
	}

	public void eliminarPersona(Persona persona) {
		// TODO Auto-generated method stub
		listaPersonas.remove(persona);
	}

	public Persona encontrarPersonaPorEmail(String email) {
		// TODO Auto-generated method stub
		Persona p = new Persona();
		for (Persona persona2 : listaPersonas) {
			if(persona2.getEmail().equals(email)){
				p=persona2;
			}
		}
		
		return p;
	}

	private void auxiliarPersonas(){
		listaPersonas.add(new Persona(1, "Fredy R.", "Vazquez", "Geronimo",  "crazzy-rock@live.com.mx","9818194912"));
		listaPersonas.add(new Persona(2, "Sebastian", "Vazquez", "Ake",  "sbt99@hotmail.com","98180001111"));
	}
}
