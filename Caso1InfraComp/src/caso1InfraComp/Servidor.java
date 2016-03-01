package caso1InfraComp;

public class Servidor extends Thread
{
	
	/**
	 * numero de elementos en el servidor
	 */
	private int total;
	/**
	 * buffer del proyecto
	 */
	private Buffer buffer;
	/**
	 * avisa si el servidor está en espera o no
	 */
	private boolean despierto;
	
	
	
	public Servidor(Buffer buf)
	{
		
		buffer=buf;
	}
	/**
	 * Avisa si el servidor está en espera o no.
	 * @return true el servidor no estpa en espera.
	 */
	public boolean estaDespierto(){
		return despierto;
	}
	public void run()
	{
		
	}
	

}
