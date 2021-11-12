package br.com.bruce.agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.bruce.agenda.model.Contato;
import br.com.bruce.agenda.service.ContatoService;
import br.com.bruce.agenda.service.serviceImpl.ContatoServiceImpl;

public class Main {
	private static ContatoService contatoService;

	public static void main(String[] args) {

		List<Contato> contats = new ArrayList<>();

		inicializacaoDoSistema();

		try (Scanner scan = new Scanner(System.in)) {
			
			String continuar = "s";
			while (continuar.equalsIgnoreCase("s")) {
				menu();
				int digito = scan.nextInt();
				
				switch (digito) {
				case 1:
					contats = Main.contatoService.listarContatos();
					contats.forEach(System.out::println);
					break;
				case 2:
					Contato contato = new Contato(0, null, null, null);
					System.out.println("Digite o id do contato:");
					int idContato = scan.nextInt();
					contato.setId(idContato);

					System.out.println("Digite o nome do contato:");
					String nomeContato = scan.next();
					contato.setNome(nomeContato);

					System.out.println("Digite o email do contato:");
					String emailContato = scan.next();
					contato.setEmail(emailContato);

					System.out.println("Digite o telefone do contato:");
					String telefoneContato = scan.next();
					contato.setTelefone(telefoneContato);
					System.out.println();
					System.out.println(Main.contatoService.salvarContato(contato)); 
				
					break;
				case 3:
					System.out.println("Digite o nome do contato:");
					String nomePesquisa = scan.next();
					Contato contatoPesquisado = Main.contatoService.pesquisarContato(nomePesquisa);
					System.out.println();
					System.out.println(contatoPesquisado);
					System.out.println();
					break;
				case 4:
					System.out.println("Digite o nome do contato:");
					String nomeRemover = scan.next();
					Main.contatoService.removerContato(nomeRemover);
					System.out.println("Contato removido com sucesso!");
					break;
				case 5:
					System.out.println("Digite o nome do contato:");
					String nomeAtualizar = scan.next();
					
					Contato contatoAtualiza = new Contato(0, null, null, null);
					System.out.println("Digite o id do contato:");
					int idAtualiza = scan.nextInt();
					contatoAtualiza.setId(idAtualiza);

					System.out.println("Digite o nome do contato:");
					String nomeAtualiza = scan.next();
					contatoAtualiza.setNome(nomeAtualiza);

					System.out.println("Digite o email do contato:");
					String emailAtualiza = scan.next();
					contatoAtualiza.setEmail(emailAtualiza);

					System.out.println("Digite o telefone do contato:");
					String telefoneAtualiza = scan.next();
					contatoAtualiza.setTelefone(telefoneAtualiza);
					
					Contato contatoAtualizado = Main.contatoService.atualizarContato(nomeAtualizar, contatoAtualiza);
					System.out.println();
					System.out.println("Contato atualizado com sucesso!");
					System.out.println();
					System.out.println(contatoAtualizado);
					break;
				}
				System.out.println("Deseja continuar <S> para continuar <N> para finalizar programa:");
				continuar = scan.next();

			}
			System.out.println("Finalizado...");
		}
	}

	private static void menu() {
		System.out.println("### AGENDA TELEFÔNICA ###");
		System.out.println("Para listar contatos digite   <1>.");
		System.out.println("Para salvar contatos digite   <2>.");
		System.out.println("Para pesquisar contato digite <3>.");
		System.out.println("Para remover contato digite   <4>.");
		System.out.println("Para atualizar contato digite <5>.");
	}

	private static void inicializacaoDoSistema() {
		Contato jonas = new Contato(1, "jonas", "jonas@yahoo.com", "2333-22222");
		Contato steve = new Contato(2, "steve", "steve@yahoo.com", "9999-88888");
		Contato hernesto = new Contato(3, "hernesto", "hernesto@yahoo.com", "5555-6666");

		List<Contato> contatos = new ArrayList<>();
		contatos.add(jonas);
		contatos.add(steve);
		contatos.add(hernesto);

		contatoService = new ContatoServiceImpl(contatos);
	}
}
