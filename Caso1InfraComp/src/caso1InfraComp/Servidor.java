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
	
	
	/**
	 * Metodo constructor
	 */
	public Servidor(Buffer buf)
	{
		
		this.buffer=buf;
		this.despierto = false;
		
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
	public synchronized void procesarMensaje(Mensaje mensaje){
		mensaje.crearREspuesta(mensaje.darConsulta() +1);
		mensaje.notify();
	}
	public void run()
	{
			despierto = true;
			Mensaje men;
			try {
				men = (Mensaje) buffer.obtener();
				procesarMensaje(men);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			despierto = false;
		
		
	}
	

}
