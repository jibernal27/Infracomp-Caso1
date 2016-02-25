package caso1InfraComp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main
{
	public static final String datos=",/data/conf.txt";
	 
	private int	numerDeClientes;
	private int	numeroDeServidores;
	private int	numeroConsultaClientes;
	private int	tamanioBuffer;
	public main()
	{
		
	}
	public void cargarDatos(String url) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(url));
		String line;
		while((line = in.readLine()) != null)
		{
			//TODO: Terminar
		    if(line.startsWith("numero de clientes:"))
		    {
		    	
		    }
		}
		in.close();
	}

}
