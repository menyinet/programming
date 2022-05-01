package bingo;

public class Carton {
	
	final int filas =3;
	final int columnas=9;
	final int huecosXfila =4;
	final int numerosXfila= columnas-huecosXfila;
	final int totalNumerosCarton = numerosXfila*filas;
	static int precioCarton=1;
	private int[] unCarton = new int[totalNumerosCarton];

	//private int numeroInicio=0;
//constructor
	public Carton() {
		rellenarCarton();
	}
//metodos	
public  int[]rellenarCarton(){
	int decena=0;
	for (int i = 0; i <10 ; i++) {
		unCarton[i]=((int)(Math.random()*(10))+decena);
		decena=decena+10;
	}
	return unCarton;
}
//	int numeroCarton;
//	boolean numeroExiste=false;
//	while (unCarton.size()!=totalNumerosCarton) {
//		numeroCarton=(int) Math.random()*(100);
//		if (numeroExiste) {
//			numeroCarton=(int) Math.random()*(100);
//		}else {
//			unCarton.add(numeroCarton);
//
//		}
//	}


//while(unCarton.length()<totalNumerosCarton) {
//		unCarton.add((int)(Math.random()*(100)));

//		if (unoMas>100) {
//			decena=0;
//		}
//		int unoMas=(int) (Math.random()*2);
//		if (unoMas==1) {
//			unCarton.add((int)(Math.random()*(10))+decena);
//			decena=decena+10;
//		}else decena=decena+10;
//}


	
public String imprimirCarton() {

	
//	for (int i = 0; i < filas; i++) {
//
//		for (int j = 0; j < columnas; j++) {
//		
//			System.out.print("| "+unCarton.get(i)+" | ");
//			
//		}
//		System.out.print("\n");
//	}
	return "";
}

public static void main(String[] args) {
	Carton c1 = new Carton();
	for (Integer x : c1.unCarton) {
		System.out.println(x);
	}
//	c1.imprimirCarton();
//	int unoMas=(int) (Math.random()*2);
	System.out.println("ddd"+c1.unCarton.length);

}
}
