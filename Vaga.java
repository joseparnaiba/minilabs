package Miniab2;

public class Vaga {
	private String endereco;
	private int num;
	private double area;
	private boolean livre;
	private String linkMaps;
	
	public Vaga(String end,int n,double ar) {
		this.endereco = end;
		this.num = n;
		this.area = ar;
		this.linkMaps = "https://";
		this.livre = true;
	}
	public Vaga(String end,int n,String linkmp,double ar) {
		this.endereco = end;
		this.num = n;
		this.linkMaps = linkmp;
		this.area = ar;
		this.livre = true;
	}
}