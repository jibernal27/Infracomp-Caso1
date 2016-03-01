package caso1InfraComp;

public class Mensaje {

	/**
	 * 
	 */
	private Double consulta;
	
	private Double respuesta;
	
	private Cliente origen;
	/**
	 * m�todo constructor
	 * @param or
	 */
	public Mensaje(Cliente or){
		consulta = null;
		respuesta = null;
		origen=or;
	}
	
	public void crearConsulta (Double nConsulta) throws InterruptedException{
		this.consulta = nConsulta;
		//Espera hasta que lo despierte el servidor
		
	}
	
	public void crearREspuesta(Double nRespuesta){
		this.respuesta = nRespuesta;
		// Despierta a los mensajes que mantiene detenido a un cliente
		origen.despertar();
	}
	
	public Double darRespuesta(){
		return respuesta;
	}
	public Double darConsulta(){
		return consulta;
	}
	
}
