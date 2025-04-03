#trabalhoSOLID

Esse sistema permite criar, listar, filtrar e marcar tarefas como concluídas, além de exibir um relatório.

-A classe main é a classe pricipal que permite a inicialização do código.

-A classe Task Representa uma tarefa individual, com atributos como título, descrição, prioridade e estado de conclusão. 
Inclui métodos para marcar a tarefa como concluída e para retornar sua representação em texto.

-A classe TaskRepository gerencia o armazenamento das tarefas em uma lista,
permitindo adicionar novas tarefas e recuperar a lista completa das tarefas.

-A classe TaskService funciona como a camada de lógica do sistema, utiliza a classe taskRepository
para criar, listar, filtrar tarefas por prioridade e marcar tarefas como concluídas.

-A classe TaskConsoleUI gerencia a interação com o usuário via console apresenta um menu com opções
para criar, listar, filtrar tarefas, marcar como concluídas e exibir um relatório.
