package view;

import control.TarefaService;
import model.Tarefa;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TarefaService service = new TarefaService();

        int opcao;
        do {
            System.out.println("\n===== MENU DE TAREFAS =====");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Atualizar tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Marcar tarefa como completa");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1 -> {
                    System.out.print("Título da tarefa: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descrição da tarefa: ");
                    String descricao = sc.nextLine();
                    service.criarTarefa(titulo, descricao);
                    System.out.println(" Tarefa criada com sucesso!");
                }

                case 2 -> {
                    List<Tarefa> lista = service.listarTarefas();
                    if (lista.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        System.out.println("\n--- LISTA DE TAREFAS ---");
                        for (Tarefa t : lista) {
                            System.out.println("ID: " + t.getId());
                            System.out.println("Título: " + t.getTitulo());
                            System.out.println("Descrição: " + t.getDescricao());
                            System.out.println("Data: " + t.getDataHora());
                            System.out.println("Completa: " + (t.isComplemento() ? "Sim " : "Não "));
                            System.out.println("-----------------------------");
                        }
                    }
                }

                case 3 -> {
                    System.out.print("ID da tarefa a atualizar: ");
                    long id = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Novo título: ");
                    String novoTitulo = sc.nextLine();
                    System.out.print("Nova descrição: ");
                    String novaDescricao = sc.nextLine();

                    boolean atualizado = service.atualizarTarefa(id, novoTitulo, novaDescricao, true);
                    if (atualizado) {
                        System.out.println("️ Tarefa atualizada com sucesso!");
                    } else {
                        System.out.println(" Tarefa não encontrada!");
                    }
                }
                
                /
                case 4 -> {
                    System.out.print("ID da tarefa a ser removida: ");
                    long idParaRemover = sc.nextLong();
                    sc.nextLine(); 

                    boolean removido = service.removerTarefa(idParaRemover);
                    if (removido) {
                        System.out.println("Tarefa removida com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada!");
                    }
                }
                
                case 0 -> System.out.println("Saindo... ");

                default -> System.out.println("Opção inválida, tente novamente!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
