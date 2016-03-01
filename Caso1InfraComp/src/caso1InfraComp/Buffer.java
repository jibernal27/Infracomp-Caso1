package caso1InfraComp;

import java.util.List;
import java.util.Vector;

public class Buffer {

	/**
	 * el tamaño del buffer
	 */
	private int capacidad;
	/**
	 * la cantidad de clientes que hay en el momento
	 */
	private int  numClientes;
	
	/**
	 *la lista de mensajes
	 */
	private List<Mensaje> data;
	/**
	 * Método Constructor
	 * @param capacidad
	 * @param numClientes
	 */
	public Buffer(int capacidad, int numClientes){
		this.capacidad = capacidad;
		this.numClientes = numClientes;
		
		data = new Vector<Mensaje>();
	}
	/**
	 * envia el mensaje al cliente y lo remueve del buffer
	 * @param mensaje
	 * @return true si el mensaje exite y se envia y false si no existe el mensaje
	 * @throws Exception
	 */
	public synchronized boolean enviar(Mensaje mensaje) throws Exception{
		 if(data.size()==capacidad){
			 return false;
		 }
		 else{
			 data.add(mensaje);
			 
			 return true;
		 }
		
	}
	/**
	 * Obtiene un mensaje y lo agrega al buffer
	 * @return
	 * @throws Exception
	 */
	public synchronized Mensaje obtener() throws Exception
	{
		
		if(data.size()==0){
			
			return null;
		}
		else
		{
			return data.remove(0);
		}
	}
	/**
	 * decrece la cantidad de clientes
	 */
	public synchronized void retirarCliente()
	{
		numClientes--;
		System.out.println("Clientes restantes "+numClientes);
		
	}
	
	public  synchronized boolean acabo()
	{
		if(numClientes==0&&data.size()==0)
		{
			return true;
		}
		return false;
	}
}
