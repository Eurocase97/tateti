package tateti;

public class Player {
	
	static int cantidadJuadores=0;
	private String name;
	
	public Player(){
		cantidadJuadores++;
		name="jugador"+cantidadJuadores;
	}
	
	public String get_name() {
		return name;
	}
	

}
