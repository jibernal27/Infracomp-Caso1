package caso1InfraComp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
	public static final String datos="./data/conf.txt";
	 
	private int	numerDeClientes;
	private int	numeroDeServidores;
	private int	numeroConsultaClientes;
	private int	tamanioBuffer;
	public Main()
	{
		
	}
	
	public static void main(String[] args)
	{
		Main incializar=new Main();
		
		try {
			incializar.cargarDatos(Main.datos);
			incializar.incializarCaso1();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cargarDatos(String url) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(url));
		String line;
		while((line = in.readLine()) != null)
		{
			//El número de clientes que habran. 
		    if(line.startsWith("numero de clientes:"))
		    {
		    	numerDeClientes=Integer.parseInt(line.substring("numero de clientes:".length(),line.length()));
		    	
		    }
		    if(line.startsWith("numero consulta clientes:"))
		    {
		    	numeroConsultaClientes=Integer.parseInt(line.substring("numero consulta clientes:".length(),line.length()));
		    }
		    if(line.startsWith("numero de servidores:"))
		    {
		    	numeroDeServidores=Integer.parseInt(line.substring("numero de servidores:".length(),line.length()));
		    }
		    if(line.startsWith("tamanio buffer:"))
		    {
		    	tamanioBuffer=Integer.parseInt(line.substring("tamanio buffer:".length(),line.length()));
		    }
		}
		in.close();
	}
	
	
	private void incializarCaso1()
	{
		//Inicialización de Buffer
		Buffer buffer= new Buffer(tamanioBuffer, numerDeClientes);
		
		//Para hacer pruebas se pondra un valor conocido de consultas de cada cliente
		
		//Se inicializan los clientes y los servidores al tiempo
		int numServidores=numeroDeServidores;
		int numClientes=numerDeClientes;
		int total=numServidores+numClientes;
		while(total>0)
		{
			
			//Iniciar Primero un cliente
			if(numClientes>0)
			{
				Cliente nuevo= new Cliente(numeroConsultaClientes, buffer);
				nuevo.start();
				numClientes--;
				
			}
			
			//Iniciar un Servidor
			if(numServidores>0)
			{
				Servidor nuevo= new Servidor(buffer) ;
				nuevo.start();
				numServidores--;
			}
			total=numServidores+numClientes;
			
			
		}
		while(!buffer.acabo())
		{
			
		}
		System.out.println("El resultado es " +Servidor.total);
		
	}

}
