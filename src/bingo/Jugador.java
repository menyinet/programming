package bingo;

public class Jugador {
//atributos
	private String nombre;
	private int credito ;
	private int cartones;
	private int partidasJugadas;
	private int partidasGanadas;
	private int idJugador;
	private static int idSiguiente=0;

	
//contructor sin parametros asigna valores iniciales
	public Jugador() {
		this.nombre="";
		idJugador=idSiguiente;
		idSiguiente++;
//		this.partidasGanadas=Partida.getGanadas(idJugador);
//		this.cartones=Partida.getCartonesJugando(idJugador);;
//		this.partidasJugadas=Partida.getPartidasJugador(idJugador);
		//this.credito= Partida.getCreditoJugador(idJugador);
	}
//constructor con parametro nombre	
	public Jugador(String tuNombre) {
		this.nombre=tuNombre;
		idJugador=idSiguiente;
		idSiguiente++;
//		this.partidasGanadas=Partida.getGanadas(idJugador);
//		this.cartones=Partida.getCartonesJugando(idJugador);;
//		this.partidasJugadas=Partida.getPartidasJugador(idJugador);
//		this.credito= Partida.getCreditoJugador(idJugador);
	}
//getter pulicos
	public int getPartidasJugadas() {
		return partidasJugadas;
	}
	public int getIdJugador() {
		return idJugador;
	}
	public int getCredito() {
		return credito;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getCartones() {
		return cartones;
	} 
	public int getIdSiguiente() {
		return idSiguiente;
	}
//setter


	public void setNombre(String tunombre) {
		this.nombre = tunombre;
	}



//metodos	
@Override
	public String toString() {
		String txt="Nombre jugador | Crédito actual | Partidas Jugadas | Partidas Ganadas";
		
		return txt;
	}
public static void main(String[] args) {
	Jugador j1 = new Jugador();
	Jugador j2 = new Jugador();
	Jugador j3 = new Jugador();
	Jugador j4 = new Jugador(); 
	
	System.out.println("id j3 es:"+j3.idJugador+"_"+j3.credito);
}


}
