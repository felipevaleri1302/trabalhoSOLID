package service;

import model.Task;
import repository.TaskRepository;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Contém regras de negócio para gerenciamento de tarefas.
 * Aplica o Princípio Aberto/Fechado (OCP) - permite adicionar novos filtros sem modificar a classe.
 * Aplica o Princípio da Substituição de Liskov (LSP) - futuras subclasses de Task devem manter o comportamento esperado.
 */
public class TaskService {

    //Campo privado que armazena uma referência ao repositório , que é utilizado para armazenar e recuperar tarefas
    private final TaskRepository repository;

    //O construtor recebe uma instância de TaskRepository  como parâmetro e a atribui ao campo repository
    // isso permite que a classe TaskService ultilize os métodos do repositório
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    //Cria uma nova tarefa.Recebe o título, descrição e prioridade como parâmetros.
    //Cria um objeto  Task com essas informações e o adiciona ao repositório, utilizando o método addTask.
    public void createTask(String titulo, String descricao, int prioridade) {
        repository.addTask(new Task(titulo, descricao, prioridade));
    }

    //Retorna todas as tarefas armazenadas no repositório.
    public List<Task> getAllTasks() {
        return repository.getAllTasks();
    }

    //Retorna a lista de tarefas que possuem a prioridade buscada.
    //Recupera todas as tarefas do repositório  e filtra apenas aquelas cuja prioridade seja igual ao valor fornecido.
    public List<Task> getTasksByPrioridade(int prioridade) {
        return repository.getAllTasks().stream()
                .filter(task -> task.getPrioridade() == prioridade)
                .collect(Collectors.toList());
    }

    //Marca uma tarefa como concluída (completa) com base no título fornecido.
    //Se encontrar a tarefa, chama o método markAsCompleted na tarefa.
    public void markTaskAsCompleto(String titulo) {
        repository.getAllTasks().stream()
                .filter(task -> task.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .ifPresent(Task::markAsCompleted);
    }
}