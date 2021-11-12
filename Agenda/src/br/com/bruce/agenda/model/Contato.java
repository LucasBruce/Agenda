package br.com.bruce.agenda.model;

import java.util.Objects;

/*classe Contato é a classe responsável por representar os atributos de 
um contato na agenda
Autor:Lucas Bruce
*/

public class Contato {

	//Atributos de um contato
	private int id;
	private String nome;
	private String email;
	private String telefone;

	public Contato(int id, String nome, String email, String telefone) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	//seção dos getters e setters onde atribuimos valores e retornamos os mesmos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/*
	 * este método esta sobrescrevendo o método toString da classe Object fazendo
	 * isso eu consigo personalizar como será impresso os valores
	 */
	@Override
	public String toString() {
		return "  id: " + id + 
				"\n nome: " + nome 
				+ "\n email: " + email 
				+ "\n telefone: " + telefone
				+"\n";
	}

	/*
	 * O método hashCode para melhorar o desempenho da pesquisa este método também
	 * está sendo sobrescrito do object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/*
	 *  O método equals também está sendo sobrescrito para que na comparação de
	 * valores ele compare por id e não por endereco de instancia
	 */	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return id == other.id;
	}

}
