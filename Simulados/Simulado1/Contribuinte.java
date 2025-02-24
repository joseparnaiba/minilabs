package Simulado1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contribuinte {
	private String nome;
	private String cpf;
	private String contato;
	private List<Tributo> tributos;
	private List<Tributo> tributospagos;
	
	public Contribuinte(String n,String c,String con) {
		this.contato = con;
		this.cpf = c;
		this.nome = n;
		this.tributos = new ArrayList<>();
		this.tributospagos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getContato() {
		return contato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || (getClass() != obj.getClass()))
			return false;
		Contribuinte other = (Contribuinte) obj;
		return Objects.equals(cpf, other.cpf);
	}
	public void adicionaTributo(Tributo tributo) {
		this.tributos.add(tributo);
	}
	public String pagaTributo(int codig) {
		for(Tributo tributo: tributos) {
			if(tributo.getCodigo() == codig) {
				if(!tributospagos.contains(tributo)) {
					tributospagos.add(tributo);
					return "TRIBUTO PAGO COM SUCESSO";
				} else {
					return "TRIBUTO JÁ PAGO";
				}
				
			}
		}
		 return "TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO";
	}
	public double totalPagoEmTributos(int ano) {
		double total = 0;
		for(Tributo tributo: tributospagos) {
			if(tributo.getAno() == ano) {
				total += tributo.getValor();
			}
		}
		return total;
	}
	public String emitirExtrato() {
		StringBuilder extrato = new StringBuilder();
		if(tributos.isEmpty()) {
			return "EXTRATO VAZIO";
		}
		for(Tributo tributo : tributos) {
			String status = tributospagos.contains(tributo) ? "SIM" : "NÃO";
			extrato.append(String.format("| %s | Tributo: (%d) %s - Valor: R$%.2f Ano Base: %d |\n",
                    status, tributo.getCodigo(), tributo.getDescricao(), tributo.getValor(), tributo.getAno()));
		}
		return extrato.toString();
	}
}
