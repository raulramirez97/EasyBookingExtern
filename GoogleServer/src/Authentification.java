package user.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Authentification extends UnicastRemoteObject implements IAuthentification
{
	private static final long serialVersionUID = 1L;
	private static String usuarios[][];
	
	protected Authentification () throws RemoteException 
	{
		super();
	}	
	
	public static void main(String[] args) 
	
	{
		if (args.length != 3) {
			System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]");
			System.exit(0);
		}
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		try 
		{		
			IAuthentification objServer = new Authentification ();
			Registry registry = LocateRegistry.createRegistry(Integer.valueOf(args[1]));
			registry.rebind(name, (Remote) objServer);
			System.out.println("* Server '" + name + "' active and waiting...");
		} 
		catch (Exception e) 
		{
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
		
		registrarUsuarios();
	}
	
	public boolean ComprobarUsuario(String usuario, String contrasena)
	{
		
		int x;
		
		for (x=0; x<usuarios.length; x++) 
		{
		    if (usuarios[x][0].equals(usuario))
		    {	
		    	if(usuarios[x][1].equals(contrasena))
		    	{
		    		System.out.println("Sesion iniciada");
		    		
		    		return true;
		    	}else
			    	{
			    		System.out.println("La contrasena es erronea");
			    	}
		    }else
		    {
		    	System.out.println("Usuario no encontrado");
		    }
		}
		return false;
	}
	
	private static void registrarUsuarios ()
	{
		usuarios = new String[4][];
		usuarios[0] = new String[] {"Jon", "Jon"};
		usuarios[1] = new String[] {"Julen", "Julen"};
		usuarios[2] = new String[] {"Dani", "Dani"};
		usuarios[3] = new String[] {"Raul", "Raul"};
	}


}

