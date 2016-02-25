package caso1InfraComp;

import java.util.List;
import java.util.Vector;

public class Buffer {

	private int capacidad;
	private int  numClientes;
	private List<Mensaje> data;
	
	public Buffer(int capacidad, int numClientes){
		this.capacidad = capacidad;
		this.numClientes = numClientes;
		data = new Vector<Mensaje>();
	}
	
	public synchronized boolean enviar(Mensaje mensaje) throws Exception{
		 if(data.size()==capacidad){
			 return false;
		 }
		 else{
			 data.add(mensaje);
			 notifyAll();
			 return true;
		 }
		
	}
	
	public synchronized Mensaje obtener() throws Exception
	{
		//TODO: Hacer un criterio para que el servidor pare
		if(data.size()==0&&numClientes==0)
		{
			return new Mensaje(null);
		}
		if(data.size()==0){
			wait();
			return null;
		}
		else
		{
			return data.size()==0? null:data.remove(0);
		}
	}
	public synchronized void retirarCliente()
	{
		numClientes--;
	}
}
