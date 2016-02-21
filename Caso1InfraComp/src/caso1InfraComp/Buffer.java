package caso1InfraComp;

import java.util.List;
import java.util.Vector;

public class Buffer {

	private int capacidad;
	private List<Mensaje> data;
	
	public Buffer(int capacidad){
		this.capacidad = capacidad;
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
		if(data.size()==0){
			wait();
			return null;
		}
		else{
			return data.size()==0? null:data.remove(0);
		}
	}
}
