#  Task Manager - Spring Boot

![GitHub repo size](https://img.shields.io/github/repo-size/seu-usuario/task-manager)
![GitHub language count](https://img.shields.io/github/languages/count/seu-usuario/task-manager)
![GitHub top language](https://img.shields.io/github/languages/top/seu-usuario/task-manager)
![License](https://img.shields.io/github/license/seu-usuario/task-manager)

> Uma aplicação de gerenciamento de tarefas desenvolvida com **Spring Boot**, **Spring Data JPA** e **H2 Database**. Permite criar, listar e atualizar tarefas com status **TODO → DOING → DONE**. Ideal para estudar backend em Java e integração com front-end.


##  Funcionalidades

 ✅ Criar novas tarefas
 📋 Listar todas as tarefas
 🔄 Atualizar status de tarefas (TODO → DOING → DONE) com validação
 🛠️ Estrutura pronta para integração com front-end
 ⚡ Projeto leve, usando banco em memória H2


## 💻 Tecnologias utilizadas


 Java 21
 Spring Boot 4.0.1
 Spring Data JPA
 H2 Database
 Bean Validation (JSR 380 / Jakarta)
 Lombok
 Maven


## 🚀 Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST   | `/tasks` | Criar nova tarefa |
| GET    | `/tasks` | Listar todas as tarefas |
| PUT    | `/tasks/{id}/status` | Atualizar status de tarefa |


Exemplo de payload para criar task:

json
{
  "title": "Estudar React",
  "description": "Estudar fundamentos do React.js",
  "priority": "HIGH"


Exemplo de payload para atualizar status:

{
  "status": "DOING"
}


🏃 Como rodar localmente?

1- Clone o repositório:
 git clone https://github.com/seu-usuario/task-manager.git
 cd task-manager

2- Rode com Maven:
 mvn spring-boot:run

3- Acesse http://localhost:8080/tasks via Postman ou outros softwares de testes.


## 🚀 Próximos Recursos / Roadmap

- [ ] Front-end completo com **React.js**  
- [ ] Deploy do projeto em **AWS** ou **Heroku**  
- [ ] Persistência de dados em **MySQL** ou **PostgreSQL**  
- [ ] Funções de **delete** de tarefas  
- [ ] Dashboard interativo com **gráficos de progresso**  
- [ ] Busca e filtros avançados de tarefas  
- [ ] Autenticação e autorização de usuários  
- [ ] Notificações de status (email ou push)  
- [ ] Maior quantidade de **tratamento de erros** para fluxos complexos 


👨‍💻 autor

Daniel Almeida
Idade: 18 anos
Focado em Java, estudos de React e Desenvolvimento Full-Stack
Buscando evoluir projetos de backend + frontend



