package bingo;
import java.util.ArrayList;
public class Bombo {
//atributos
	private ArrayList<Integer> bolitas = new ArrayList<Integer>();
	private static  ArrayList<Integer> panel= new ArrayList<>();
	boolean sacarBolita = true;
//constructor
	public Bombo() {
		llenarBombo();
	}
//metodos del bombo		
	private ArrayList<Integer> llenarBombo() {
		vaciarPanel();
		for (int i = 0; i <= 99; i++) {
			bolitas.add(i);
		}
		return bolitas;
	}
	public ArrayList<Integer> verBombo() {
		return bolitas;
	}
	public int sacarBola() {
		int valorBola;
		int posicionBola = (int) (Math.random() * bolitas.size());
		valorBola = bolitas.get(posicionBola);
		System.out.println("Eeel "+valorBola);
		bolitas.remove(posicionBola);
		llenarPanel(valorBola);
		return valorBola;
	}
//metodos del panel	
	private ArrayList<Integer> llenarPanel(int numero) {
		panel.add(numero);
		return panel;
	}	
	private ArrayList<Integer> vaciarPanel (){
		panel.clear();
		return panel;
	}
	public ArrayList<Integer> verPanel() {
		return panel;
	}
	
//test bombo 	
	public static void main(String[] args) {
		Bombo testBombo = new Bombo();
		for (int z : testBombo.verBombo()) {
			System.out.println("bola " + z);
		}
		for (int i = 0; i < 50; i++) {
			
			testBombo.sacarBola();
		}
		for (int z : testBombo.verBombo()) {
			System.out.println("bolas restantes "+testBombo.verBombo().size()+" Numero "+ z);
		}
		System.out.println(testBombo.verPanel());
		testBombo.vaciarPanel();
		System.out.println(testBombo.verPanel());
	}
}
