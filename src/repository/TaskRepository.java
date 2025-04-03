package repository;

import model.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsável pelo armazenamento das tarefas em memória.
 * Aplica o Princípio da Responsabilidade Única (SRP).
 * Aplica o Princípio da Inversão de Dependência (DIP), pois expomos métodos abstratos ao serviço.
 */
public class TaskRepository {

    //Declara a lista e inicializa a lista como uma implementação da interface task
    private final List<Task> tasks = new ArrayList<>();

    //Adiciona um objeto Task à lista tasks
    public void addTask(Task task) {
        tasks.add(task);
    }

    //Cria e retorna um novo  Arraylist com o mesmo conteúdo da lista original.
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }
}
