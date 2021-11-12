package br.com.bruce.agenda.service;

import java.util.List;

import br.com.bruce.agenda.model.Contato;

/*Esta interface tem como objetivo criar a assinatura dos mêtodos assim firmando o contrato para
que qualquer classe que venha implementa-lá implemente todos os seus mêtodos*/

public interface ContatoService {

	Contato salvarContato(Contato contato);
	List<Contato> listarContatos();
	Contato pesquisarContato(String nome);
	void removerContato(String nome);
	Contato atualizarContato(String nome, Contato contato);
	
}
