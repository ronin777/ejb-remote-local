package mx.com.sga.servicio;

import java.util.List;

import javax.ejb.Remote;

import mx.com.sga.domain.Persona;

@Remote
public interface PersonaServiceRemote {

	public List<Persona> listarPersonas();

	public Persona encontrarPersonaPorID(Integer idPersona);

	public Persona encontrarPersonaPorEmail(String email);
	
}
