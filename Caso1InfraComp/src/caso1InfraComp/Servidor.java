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
	 * avisa si el servidor est� en espera o no
	 */
	private boolean despierto;
	
	
	public Servidor()
	{
		
		
	}
	/**
	 * Avisa si el servidor est� en espera o no.
	 * @return true el servidor no estpa en espera.
	 */
	public boolean estaDespierto(){
		return despierto;
	}
	public void run()
	{
		
	}
	

}
