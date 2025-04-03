package model;

/**
 * Representa uma tarefa no sistema.
 * Aplica o Princípio da Responsabilidade Única (SRP).
 */
public class Task {

    //Variáveis
    private final String titulo;
    private final String descricao;
    private final int prioridade;
    private boolean completo;

    //Cria uma nova instância da classe Task
    public Task(String titulo, String descricao, int prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.completo = false;
    }

    //Método para marcar a tarefa como concluida
    public void markAsCompleted() {
        this.completo = true;
    }

    //Métodos para acessar os valores das propriedades da tarefa
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public int getPrioridade() { return prioridade; }
    public boolean isCompleto() { return completo; }

    //irá marcar se a tarefa foi concluida ou não
    @Override
    public String toString() {
        return (completo ? "[X] " : "[ ] ") + titulo + " (Prioridade: " + prioridade + ")";
    }
}