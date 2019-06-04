package airline.rmi.server;

import java.util.List;


public interface IAirline {
	public List<Flight> BuscarVuelos(String origen, String destination, String fecha, int passenger);
	public List<Flight> BuscarTodoVuelos();
	public String ReservaVuelo(int cod_vuelo, String usuario, int pasajeros);
}
