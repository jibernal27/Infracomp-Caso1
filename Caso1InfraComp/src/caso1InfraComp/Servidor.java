package caso1InfraComp;

public class Servidor extends Thread
{
	
	/**
	 * numero de elementos en el servidor
	 */
	
	public static int terminado=0;
	public static Double total=(double) 0;
	/**
	 * buffer del proyecto
	 */
	private Buffer buffer;
	/**
	 * avisa si el servidor está en espera o no
	 */
	private boolean despierto;
	
	/**
	 * Metodo constructor
	 */
	public Servidor(Buffer buf)
	{
		
		this.buffer=buf;
		this.despierto = true;
		
	}
	/**
	 * Avisa si el servidor está en espera o no.
	 * @return true el servidor no estpa en espera.
	 */
	public boolean estaDespierto(){
		return despierto;
	}
	/**
	 * Metodo que crea el mensaje y aunmente el num de consultas
	 * @param mensaje
	 */
	public  void procesarMensaje(Mensaje mensaje){
		Double actual=mensaje.darConsulta();
		aumen(actual);
		mensaje.crearREspuesta(total);
	
	}
	public static synchronized double aumen(Double var)
	{
		total+=var;
		return total;
	}
	

	public  synchronized void procesaeMensajes()
	{
		Mensaje men;
		try {
			while(buffer.acabo()!=1)
			{
			
			men = (Mensaje) buffer.obtener();
			while(men==null&&(buffer.acabo()!=1))
			{
				yield();
				men=(Mensaje) buffer.obtener();
				
			}
			//System.out.println("Proceso un mensaje");
			if(men!=null)
			{
				procesarMensaje(men);
			}
			
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
	
	
	public void run() 
	{
		
		procesaeMensajes();
		
		
	}
	

}
