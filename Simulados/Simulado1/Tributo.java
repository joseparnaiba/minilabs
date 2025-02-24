package Simulado1;

import java.util.Objects;

public class Tributo {
	private int codigo;
	private String descricao;
	private double valor;
	private int ano;
	
	
	public Tributo(int c,String des,double va, int ano) {
		this.codigo = c;
		this.descricao = des;
		this.valor = va;
		this.ano = ano;
	}
	public int getCodigo() {
		return codigo;
	}
	public double getValor() {
		return valor;
	}
	public int getAno() {
		return ano;
	}
	public void setValor(double valor) {
        this.valor = valor;
	}
	public void setAno(int ano) {
        this.ano = ano;
    }
	public String getDescricao() {
		return this.descricao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || (getClass() != obj.getClass()))
			return false;
		Tributo other = (Tributo) obj;
		return codigo == other.codigo;
	}
	public double reajustaValor(double percentual) {
		this.valor += this.valor * (percentual / 100);
		return this.valor;
	}
	
	
}
