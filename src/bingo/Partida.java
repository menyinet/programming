package bingo;

import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
//atributos generales de la partida 
static Scanner sc = new Scanner(System.in);	
static Jugador banca = new Jugador("La Banca"); //jugador por defecto banca	
private int numJugadoresXpartida; //resto de jugadores
private int credito; //credito inicial para cada nueva partida
private int cartones=0;
final String txtCuantosCartones="Cada carton cuesta 1 monedita.\nCuantos cartones quieres jugar:";
//array de ojetos tipo Jugador que guarda los jugadores de cada objeto partida 
private ArrayList<Jugador> objetosJugadoresXpartida = new ArrayList<>();
//aray de tipo que guarda y asigna los datos de credito y cartones de todos los jugadores de la partida
private int posicionId =0;
private int posicionCredito =1;
private int posicionCartonesXpartida=2;
private ArrayList<int[]> idCreditoCartonesXpartida = new ArrayList<>();
private ArrayList<int[]> idCartonesXjugador = new ArrayList<>();
//jugador minimo para iniciar partida contra la banca
static int cartonesXpartida=0;
static Carton testCarton = new Carton();

//constructor sin parametros para empezar una partida
public Partida () {
	 objetosJugadoresXpartida.clear();
	 idCreditoCartonesXpartida.clear();
	 credito=10;
}
/** 
 * PASO 01 ESTABLECER Y VALIDAR NUMERO DE JUGADORES DE LA PARTIDA 
 * int numJugadoresXPartida
 * si el numero de jugadores en menor que 1 o mayor que 4 automaticamente se asigna 1 jugador a la partida
 * en caso contrario el valor de numJugadoresXpartida es igual que el numeo pasado por parametro
 */
private int setNumJugadoresXpartida(int numJugadores) {
	if(numJugadores<1 || numJugadores>4) {
		numJugadoresXpartida=1;
		System.out.println("El numero de jugadores introducido no esta permitido. \nEl numero de Jugadores sera asignado automaticamente.");
	}else {numJugadoresXpartida = numJugadores;}
		return numJugadoresXpartida;	
}
public void menuNumJugadores() {
	System.out.println("**COMIENZA EL BINGO**\n Introduce el número de Jugadores. Minimo 1 Máximo 4 por partida");
	try {
		numJugadoresXpartida = sc.nextInt();	
	} catch (Exception e) {
		// el valor introducido no es un numero entero valido
		System.out.println("El valor introducido no es un número valido. \nEl numero de Jugadores sera asignado automaticamente.");
		numJugadoresXpartida =1;
	}
	setNumJugadoresXpartida(numJugadoresXpartida);
	System.out.println("El numero de Jugadores para esta partida es de: "+getnumJugadoresXpartida());
	crearJugadoreXPartida();
}
public int getnumJugadoresXpartida () {
	return numJugadoresXpartida ;
}
/**
 * PASO 2 CREAR JUGADORES
 */
private void crearJugadoreXPartida() {
	objetosJugadoresXpartida.add(banca);
	for (int i = 0; i < numJugadoresXpartida; i++) {
		Jugador jugadorNum = new Jugador();
		objetosJugadoresXpartida.add(jugadorNum);
	}
}

/**
 * PASO 03 ESTABLECER NOMBRE DE CADA JUGADOR DE LA PARTIDA 
 * se pide el nombre del jugadr y el numero de cartones que quiere jugar
 * la primera partida siemre se juega, al tener el jugador un saldo de 10 automaticamente
 * siendo el numero maximo de cartones / jugador x partida de 4
 */
public void menuNombreJugadores() {
	String nombreJugador="";
	System.out.println("NOMBRE DE LOS JUGADORES");
	//pedir nombre para cada jugador
	for (int i = 1; i <objetosJugadoresXpartida.size();i++ ) {
		System.out.println("Introduce el nombre del jugador  "+i);
		nombreJugador= sc.next();
		objetosJugadoresXpartida.get(i).setNombre(nombreJugador);
		System.out.println(objetosJugadoresXpartida.get(i).getNombre()+" tu Id de Juego es: "+objetosJugadoresXpartida.get(i).getIdJugador());
		
	}
	menuCreditoInicial();
}
/**
 * PASO 04 ESTABLECER CREDITO Y NUMERO DE CARTONES PARA CADA JUGADOR EN LA PRIMERA PARTIDA 
 */

private void menuCreditoInicial() {
	int[] idCreditoCartonesBanca = new int[3];
	//iniciamos los valores para la Banca
	idCreditoCartonesBanca[posicionId]=0;
	idCreditoCartonesBanca[posicionCredito]=10;
	idCreditoCartonesBanca[posicionCartonesXpartida]=2;
	idCreditoCartonesXpartida.add(0,idCreditoCartonesBanca);
	//valores para el resto de jugadores
	for (int i = 1; i < objetosJugadoresXpartida.size(); i++) {
		int[] idCreditoCartonesXjugador = new int[3];
		System.out.println(objetosJugadoresXpartida.get(i).getNombre()+", como es tu primera partida tienes un credito de inicio de "+credito+" moneditas.\n"+txtCuantosCartones);
		int numCartones= sc.nextInt();
		setCartones(numCartones);
		int creditoJugador= credito-numCartones;	
		//array para guardar id+ saldo + cupones de cada jugador por partida
		idCreditoCartonesXjugador[0]=objetosJugadoresXpartida.get(i).getIdJugador();
		idCreditoCartonesXjugador[1]=creditoJugador;
		idCreditoCartonesXjugador[2]=numCartones;
		//guardamos los datos de cad jugador como un array int dentro del arraylist
		idCreditoCartonesXpartida.add(idCreditoCartonesXjugador);
	}		

}
private void setCartones(int cartones) {
	if (cartones<=4 && cartones>0) {
		this.cartones = cartones;
		System.out.println("Gracias en esta partida juegas: "+cartones);
	}else {
		System.out.println("Como no has introducido un número válido de cartones. \n Se te ha asignado automaticamente 1 Cartón para esta partida.");
		this.cartones=1;
		}
}

/**
 * PASO 05 GENERAR TODOS LOS CARTONES DE CADA JUGADOR POR PARTIDA 
 */
private void generarCartonesXjugador() {
	for (int i = 1; i <objetosJugadoresXpartida.size();i++ ) {
		
		Carton tuCarton = new Carton();
		
	}
}
public void menuCartonesJugadores() {
	int numCartones;
	System.out.println("CARTONES POR JUGADOR");
	for (int i = 1; i <objetosJugadoresXpartida.size();i++ ) {
		System.out.println(objetosJugadoresXpartida.get(i).getNombre()+" cuantos cartones quieres jugar en la proxima partida");
		numCartones= sc.nextInt();
		
	//	objetosJugadoresXpartida.get(i).setCartones(numCartones);
	}
	
//	try {
//	cartonesXpartida= sc.nextInt();//necesita validacion capturar exception InputMismatchException
//} catch (InputMismatchException e) {
//	System.out.println("El valor introducido no es un numero. Se te asignara automaticamente 1 CARTON");
//}
	
}
public static void menuCreditoJugadores() {
	
/**Comprobamos el credito del jugador y si tiene suficiente como para jugar el numero de cartones solicitados
 * Asignamos el numero de cartones de cada partida a cada uno de los jugadores y
 * A la banca se asigna el mismo numero de cartones 
 */
//	jugadorBase.setCartones(cartonesXpartida);
//	banca.setCartones(jugadorBase.getCartones());
//	System.out.println(jugadorBase.getCartones());
	
}
//3-2-1 empieza el juego
/**
 * Para cada jugador se genera y asigna el numero de cartones elegidos para la partida
 * siempre que se valide el credito del jugador y el numero de cartones a jugar
 */
//private static int creditoInicial() {
//	int primeraPartida=jugadorBase.getPartidasJugadas();
//	if (primeraPartida==0) {
//		creditoJugador[0]=1;
//		creditoJugador[1]=10;
//	}
//	return creditoJugador[1];
//}
//private static boolean comprobarCredito() {
//	jugadorBase.getCredito();
//	return true;
//}
private static void asignarCartonesXJugador() {
	//generar cartones indicados para cada jugador y guardarlos en el Array
//	for (int i = 0; i < jugadorBase.getCartones(); i++) {
//		cartonesXjugador.add(testCarton);
//	}
	System.out.println("Tus cartones son: ");
//	for (Carton carton : cartonesXjugador) {
//		carton.rellenarCarton();
//		 
//	}
}
//constructor con parametros ... para opcioon multiples jugadores
//public Partida(int numJugadores, ArrayList<Jugador> jugadoresActivos) {
//}
/**
 * METODOS PUBLICOS GETTER
 */
//falta validar int idJugador
public int getCreditoJugador(int idJugador) {
	int IdBusqueda=objetosJugadoresXpartida.get(idJugador).getIdJugador();
	int [] arrayBusqueda = idCreditoCartonesXpartida.get(IdBusqueda);
	return arrayBusqueda[posicionCredito];
}

public int getCartonesJugador(int idJugador) {
	int IdBusqueda=objetosJugadoresXpartida.get(idJugador).getIdJugador();
	int [] arrayBusqueda = idCreditoCartonesXpartida.get(IdBusqueda);
	return arrayBusqueda[posicionCartonesXpartida];
}



public Jugador ganadorPartida() {
	return banca;
}
private int aumentarCredito(Jugador ganador) {
	int nuevoCredito= ganador.getCartones()+(Carton.precioCarton*2);
	int setCredito = ganador.getCredito()+nuevoCredito;
	return nuevoCredito;
	//opcion para banca para opcion multiple partidasGanadas*(numeroJugadores-1) si es multiple 
}
private int disminuirCredito(Jugador jugadorActivo) {
	return	jugadorActivo.getCredito()-Carton.precioCarton*jugadorActivo.getCartones();
}
public static void main(String[] args) {
	Partida pruebaPartida = new Partida();
	pruebaPartida.menuNumJugadores();
//	System.out.println(pruebaPartida.getnumJugadoresXpartida());
	pruebaPartida.menuNombreJugadores();
	System.out.println("banca "+pruebaPartida.getCreditoJugador(0));
	System.out.println("j1 "+pruebaPartida.getCreditoJugador(1));
	System.out.println("j1 "+pruebaPartida.getCreditoJugador(2));
	System.out.println("cartones");
	System.out.println("banca "+pruebaPartida.getCartonesJugador(0));
	System.out.println("j1 "+pruebaPartida.getCartonesJugador(1));
	System.out.println("j1 "+pruebaPartida.getCartonesJugador(2));
	//datos 1 jugador especificado por posicion en el ArrayList
//	System.out.println(pruebaPartida.objetosJugadoresXpartida.get(1));
	//con la banca inlucida
	//System.out.println(pruebaPartida.objetosJugadoresXpartida.size());
	//datos de todos los jugadores del ArrayList
	//System.out.println(pruebaPartida.objetosJugadoresXpartida.toString());

}

}
