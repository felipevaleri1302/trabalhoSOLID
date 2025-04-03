package main;

import repository.TaskRepository;
import service.TaskService;
import view.TaskConsoleUI;

/**
 * Classe principal que inicia o sistema.
 */
public class Main {
    public static void main(String[] args) {

        //Cria um objeto da classe TaskRepository, para gerenciar o armazenamento e recuperação de tarefas.
        TaskRepository repository = new TaskRepository();

        // TaskService usa TaskRepository para realizar operações sobre as tarefas
        TaskService service = new TaskService(repository);

        //TaskConsoleUI gerencia a interface do usuário no console, permitindo interação com as tarefas por meio de TaskService.
        TaskConsoleUI ui = new TaskConsoleUI(service);

        //exibe opções no console
        ui.showMenu();
    }
}

