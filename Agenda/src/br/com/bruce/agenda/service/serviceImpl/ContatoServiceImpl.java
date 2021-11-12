package br.com.bruce.agenda.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import br.com.bruce.agenda.exception.EntidadeNaoEncontradaException;
import br.com.bruce.agenda.model.Contato;
import br.com.bruce.agenda.service.ContatoService;

/*classe responsável por implementar a interface ContatoService aqui 
será sobrescrito todos os métodos da interface
Autor: Lucas Bruce
*/

public class ContatoServiceImpl implements ContatoService {

	private List<Contato> contatos = new ArrayList<>();

	public ContatoServiceImpl(List<Contato> contatos) {
		this.contatos = contatos;
	}

	/* Método responsável por salvar um contato na lista contatos */
	@Override
	public Contato salvarContato(Contato contato) {
		this.contatos.add(contato);

		return contato;
	}

	/*
	 * Método responsável por retornar uma lista de contatos que é a lista contatos
	 */
	@Override
	public List<Contato> listarContatos() {
		return contatos;
	}

	/* Método responsável por retornar um contato específico da lista contatos */
	@SuppressWarnings("unused")
	@Override
	public Contato pesquisarContato(String nome) {
		Contato contatoVar = new Contato(0, null, null, null);
		for (Contato contato : contatos) {
			if (contato.getNome().equals(nome)) {
				contatoVar = contato;
			}
		}
		if (contatoVar == null) {
			throw new EntidadeNaoEncontradaException("Contato não encontrado!");
		} else {
			return contatoVar;
		}

	}

	/* Método responsável por apagar um contato da lista contatos */
	@Override
	public void removerContato(String nome) {
		Contato contato = this.pesquisarContato(nome);
		boolean contatoExiste = this.contatos.contains(contato);

		if (contatoExiste) {
			for (int i = 0; i < contatos.size(); i++) {

				if (contatos.get(i).equals(contato)) {
					contatos.remove(contatos.get(i));
				}
			}
		} else {
			throw new EntidadeNaoEncontradaException("Contato não pode ser apagado porque não existe!");
		}
	}

	/* Método responsável pela atualização de um contato na lista de contatos */
	@Override
	public Contato atualizarContato(String nome, Contato contatoOrigem) {
		Contato contatoDestino = this.pesquisarContato(nome);
		for (int i = 0; i < contatos.size(); i++) {
			if (contatos.get(i).equals(contatoDestino)) {
				contatoDestino.setId(contatoOrigem.getId());
				contatoDestino.setNome(contatoOrigem.getNome());
				contatoDestino.setEmail(contatoOrigem.getEmail());
				contatoDestino.setTelefone(contatoOrigem.getTelefone());
				contatos.set(i, contatoDestino);
				break;
			}
		}
		return contatoOrigem;

	}

}
