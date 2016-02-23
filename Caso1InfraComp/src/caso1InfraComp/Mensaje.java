package caso1InfraComp;

public class Mensaje {

	private Integer consulta;
	
	private Integer respuesta;
	
	public Mensaje(){
		consulta = null;
		respuesta = null;
	}
	
	public void crearConsulta (Integer nConsulta){
		this.consulta = nConsulta;
	}
	
	public void crearREspuesta(Integer nRespuesta){
		this.respuesta = nRespuesta;
	}
	
	public Integer darRespuesta(){
		return respuesta;
	}
	
}
