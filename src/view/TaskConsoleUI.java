package view;

import model.Task;
import service.TaskService;
import java.util.List;
import java.util.Scanner;

/**
 * Gerencia a interação com o usuário via console.
 * Aplica o Princípio da Segregação de Interfaces (ISP), pois poderia ser dividida em interfaces específicas.
 */
public class TaskConsoleUI {

    //Um objeto da classe TaskService, que fornece funcionalidades para gerenciar tarefas.
    private final TaskService service;

    //Capturar entrada de texto do usuário no console.
    private final Scanner scanner = new Scanner(System.in);

    //Inicia o atributo  com o objeto fornecido como parâmetro.
    public TaskConsoleUI(TaskService service) {
        this.service = service;
    }

    //Exibe o menu principal para o usuário.
    public void showMenu() {
        while (true) {
            System.out.println("\n=== Gerenciador de Tarefas ===");
            System.out.println("1. Criar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Filtrar Tarefas por Prioridade");
            System.out.println("5. Exibir Relatório");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            //Recebe a entrada do usuário como um número inteiro
            int x = scanner.nextInt();
            scanner.nextLine();

            //Usa um switch  para executar diferentes métodos com base na opção escolhida.
            switch (x) {
                case 1 -> createTask();
                case 2 -> listTasks();
                case 3 -> markTaskAsCompleto();
                case 4 -> filterByPrioridade();
                case 5 -> showReport();
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    //Captura as informações da tarefa.
    //Usa o método createTask do service para criar a nova tarefa.
    private void createTask() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Prioridade (1-5): ");
        int prioridade = scanner.nextInt();
        scanner.nextLine();

        //Exibe uma mensagem confirmando que a tarefa foi criada.
        service.createTask(titulo, descricao, prioridade);
        System.out.println("Tarefa criada!");
    }

    //Recupera todas as tarefas do sistema e exibe no console
    private void listTasks() {
        service.getAllTasks().forEach(System.out::println);
    }

    //Solicita ao usuário o título da tarefa a ser marcada como concluída.
    private void markTaskAsCompleto() {
        System.out.print("Título da Tarefa: ");
        String titulo = scanner.nextLine();

        //Usa o método markTaskAsCompleto do service para atualizar o estado da tarefa.
        service.markTaskAsCompleto(titulo);
        System.out.println("Tarefa marcada como concluída!");
    }

    //Solicita ao usuário uma prioridade.
    private void filterByPrioridade() {
        System.out.print("Prioridade desejada: ");
        int prioridade = scanner.nextInt();
        scanner.nextLine();
        //Recupera a lista de tarefas filtradas por essa prioridade usando o método TasksByPrioridade do service.
        List<Task> tasks = service.getTasksByPrioridade(prioridade);

        //Se não houver exibe essa mensagem.
        if (tasks.isEmpty()) {
            System.out.println("Não há tarefas com a prioridade especificada.");

            //Se houver exibe á tarefa.
        } else {
            tasks.forEach(System.out::println);
        }

    }

    //Exibe todos os título do relatório .
    private void showReport() {
        System.out.println("\n=== Relatório de Tarefas ===");
        listTasks();
    }
}
