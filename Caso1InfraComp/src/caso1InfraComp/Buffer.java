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
		
		
	}
	
	/**
	 * Pureba si el buffer ya no tiene más usuaos 
	 * Retorna 1 si no existen más clientes y además es buffer esta vacio
	 * 2 Si todos los clientes ya han sido atentidos
	 * 3 Si no hay más clientes que atender pero aun hay mensajes que sacar
	 * 0 en caso contraro
	 * @return
	 */
	public  synchronized int acabo()
	{
		 if(numClientes==0&&data.size()!=0)
		{
			return 3;
		}
		 else if(numClientes==0&&data.size()==0)
		{
			return 1;
		}
		
		else if(numClientes==0)
		{
			return 2;
		}
		return 0;
	}
}
