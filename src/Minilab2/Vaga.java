package Minilab2;

import java.util.Objects;

public class Vaga {
    private String endereco;
    private int num;
    private double area;
    private boolean livre;
    private String linkMaps;
    private final double precoM = 3.0;

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
   
    public int getNumero() { 
    	return num; 
    	}
    @Override
	public int hashCode() {
		return Objects.hash(area, num);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null|| (getClass() != obj.getClass()))
			return false;
		Vaga other = (Vaga) obj;
		return Double.doubleToLongBits(area) == Double.doubleToLongBits(other.area) && num == other.num;
	}
	public boolean isLivre() {
    	return livre; 
    	}
    public void mudarStatus() {
    	livre = !livre;
    	}
    public int calculaValor(int quanthora){
    	if(quanthora < 0) {
    		throw new IllegalArgumentException("A quantidade de horas deve ser maior ou igual a zero.");
    	}
    	return (int) (quanthora * precoM + 0.1 * area);
    }
    @Override 
    public String toString() {
    	return num+ " - " + endereco + " - " + linkMaps + " - " + (livre ? "LIVRE" : "OCUPADA");
    }
}