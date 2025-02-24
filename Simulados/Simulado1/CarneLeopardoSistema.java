package Simulado1;

import java.util.ArrayList;
import java.util.List;

class CarneLeopardoSistema {
    private List<Contribuinte> contribuintes;
    private List<Tributo> tributos;

    public CarneLeopardoSistema() {
        this.contribuintes = new ArrayList<>();
        this.tributos = new ArrayList<>();
    }

    // Cadastro de contribuinte
    public String cadastrarContribuinte(String cpf, String nome, String contato) {
        // Verifica se o CPF já está cadastrado
        for (Contribuinte contribuinte : contribuintes) {
            if (contribuinte.getCpf().equals(cpf)) {
                throw new IllegalArgumentException("Contribuinte já cadastrado!");
            }
        }
        Contribuinte contribuinte = new Contribuinte(cpf, nome, contato);
        contribuintes.add(contribuinte);
        return cpf;
    }

    // Listar todos os contribuintes
    public String[] listarContribuintes() {
        List<String> contribuintesList = new ArrayList<>();
        for (Contribuinte contribuinte : contribuintes) {
            contribuintesList.add(String.format("Contribuinte: %s - CPF: %s - Contato: %s",
                    contribuinte.getNome(), contribuinte.getCpf(), contribuinte.getContato()));
        }
        return contribuintesList.toArray(new String[0]);
    }

    // Cadastro de tributo
    public int cadastrarTributo(int codigoTributo, String descricao, double valor, int ano) {
        if (codigoTributo < 1 || codigoTributo > 60) {
            throw new IndexOutOfBoundsException("A faixa disponível para códigos tributários é de 1 a 60!");
        }

        for (Tributo tributo : tributos) {
            if (tributo.getCodigo() == codigoTributo) {
                throw new IllegalArgumentException("O código já está sendo utilizado por outro tributo!");
            }
        }

        Tributo tributo = new Tributo(codigoTributo, descricao, valor, ano);
        tributos.add(tributo);
        return codigoTributo;
    }

    // Listar todos os tributos
    public String[] listarTributos() {
        List<String> tributosList = new ArrayList<>();
        for (Tributo tributo : tributos) {
            tributosList.add(String.format("Tributo: (%d) %s - Valor: R$%.2f; Ano Base: %d",
                    tributo.getCodigo(), tributo.getDescricao(), tributo.getValor(), tributo.getAno()));
        }
        return tributosList.toArray(new String[0]);
    }

    // Reajustar tributo
    public double reajustarTributo(int codigoTributo, int ano, double percentual) {
        for (Tributo tributo : tributos) {
            if (tributo.getCodigo() == codigoTributo && tributo.getAno() != ano) {
                return tributo.reajustaValor(percentual);
            }
        }
        return 0;
    }

    // Atribuir tributo a contribuinte
    public String atribuirTributoAoContribuinte(int codigoTributo, String cpfContribuinte) {
        Contribuinte contribuinte = null;
        for (Contribuinte c : contribuintes) {
            if (c.getCpf().equals(cpfContribuinte)) {
                contribuinte = c;
                break;
            }
        }

        if (contribuinte == null) {
            return "TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO";
        }

        for (Tributo tributo : tributos) {
            if (tributo.getCodigo() == codigoTributo) {
                contribuinte.adicionaTributo(tributo);
                return "TRIBUTO ADICIONADO COM SUCESSO";
            }
        }

        return "TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO";
    }

    // Pagar tributo
    public String pagarTributo(String cpfContribuinte, int codigoTributo) {
        for (Contribuinte contribuinte : contribuintes) {
            if (contribuinte.getCpf().equals(cpfContribuinte)) {
                return contribuinte.pagaTributo(codigoTributo);
            }
        }
        return "TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO";
    }
}

