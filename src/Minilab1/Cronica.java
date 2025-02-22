package Minilab1;

public class Cronica {
	private String titulo;
	private String texto;
	private String autor;
	private String data;
	private int contCro;
	
	public Cronica(String t,String te,String au,String d) {
		this.titulo = t;
		this.texto = te;
		this.autor = au;
		this.data = d;
		this.contCro = 0;
	}
	
	@Override
	public String toString() {
		return this.titulo + "\n"+"Data: "+ this.data + "\n" + "Autor: "+ this.autor + "\n" + this.texto + "\n";
	}
	public void addQLeitura() {
		this.contCro++;
	}
	public int getQleitura(int qtdeleitura) {
		return this.contCro = qtdeleitura;
	}
	public String formataTitulo() {
		return this.titulo + " - lida" + this.contCro;
	}
}
