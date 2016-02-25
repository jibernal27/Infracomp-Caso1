package caso1InfraComp;

public class Cliente extends Thread

{
	
	private int numConsultas;
	private double respuesta;
	private Buffer buff;
	/**
	 * Constructur para un cliente. 
	 * @param consul Número de consultas que hará el cliente
	 * @param buf Buffer con el cual se relacionara el cliente
	 */
	public Cliente(int consul,Buffer buf )
	{
		//Dado por parametro
		numConsultas=consul;
		//Relación al buffer
		buff=buf;
	}
	
	/**
	 *  Crear el mensaje y enviarlo al Buffer
	 * @return Retorna true si ya termino todas las consultas, false en caso contrario
	 * @throws Exception Excepción heredada del Buffer
	 */
	public  synchronized void hacerConsulta() throws Exception
	{
		
		if(numConsultas>0)
		{
			//Generar un número aleatorio de 1 a 50
			double num= (Math. random() * 50 + 1);
			 Mensaje nuevo=new Mensaje(this);
			 nuevo.crearConsulta(num);
        //Si no puede enviar el mensaje se queda esperando hasta que pueda en espera activa.
			 while(!buff.enviar(nuevo))
			 {
				yield();
			 }
			//Si puede enviar el mensaje espera hasta tener la respuesta del mensaje
			 //espera pasiva.  La espera esta en el enviar del mensaje
			 
			 //Guarda la respuesta de un mensaje. 
			 respuesta+=nuevo.darRespuesta();
		
		}
		else
		{
			//Le avisa al buffer que se va a retirar
			buff.retirarCliente();
		}
		
	}
	/**
	 * Hace que un mensaje reduzca el número de consultas 
	 */
	public synchronized void reducirConsultas()
	{
		numConsultas--;
	}
	
}
