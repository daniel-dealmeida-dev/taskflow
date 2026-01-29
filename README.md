# 📝 Task Manager - Spring Boot

![GitHub repo size](https://img.shields.io/github/repo-size/daniel-dealmeida-dev/task-manager)
![GitHub language count](https://img.shields.io/github/languages/count/daniel-dealmeida-dev/task-manager)
![GitHub top language](https://img.shields.io/github/languages/top/daniel-dealmeida-dev/task-manager)
![License](https://img.shields.io/github/license/daniel-dealmeida-dev/task-manager)

Uma aplicação de gerenciamento de tarefas desenvolvida com **Spring Boot**, **Spring Data JPA** e **H2 Database**. Permite criar, listar, atualizar, deletar e filtrar tarefas com status **TODO → DOING → DONE**, além de oferecer documentação via **Swagger**. 🖥️

---

## 🚀 Funcionalidades

✅ Criar novas tarefas  
📋 Listar todas as tarefas  
🔄 Atualizar status de tarefas (TODO → DOING → DONE) com validação  
🗑️ Deletar tarefas por ID  
🔍 Filtrar tarefas por status e/ou prioridade   
📖 Documentação interativa via Swagger  
🛠️ Estrutura pronta para integração com front-end  
⚡ Projeto leve, usando banco em memória H2  

---

## 💻 Tecnologias utilizadas

- Java 21 ☕  
- Spring Boot 4.0.1  
- Spring Data JPA  
- H2 Database 🗄️  
- Bean Validation (JSR 380 / Jakarta)  
- Lombok  
- Maven ⚙️  

---

## 📡 Endpoints

| Método | Endpoint             | Descrição                                                                |
| ------ | -------------------- | ------------------------------------------------------------------------ |
| POST   | `/tasks`             | Criar nova tarefa                                                        |
| GET    | `/tasks`             | Listar todas as tarefas                                                  |
| GET    | `/tasks/filter`      | Filtrar tarefas por status ou prioridade (`?status=DOING&priority=HIGH`) |
| PUT    | `/tasks/{id}/status` | Atualizar status de tarefa                                               |
| DELETE | `/tasks/{id}`        | Deletar tarefa pelo ID                                                   |

---

### 🛠️ Exemplos de payload

**Criar nova task:**
`json
{
  "title": "Estudar React",
  "description": "Estudar fundamentos do React.js",
  "priority": "HIGH"
}`
Atualizar status da task:

`{
  "status": "DOING"
}`
Exemplo de query para filtro:

GET /tasks/filter?status=DOING&priority=HIGH


🏃 Como rodar localmente:

Clone o repositório:

git clone https://github.com/daniel-dealmeida-dev/task-manager.git
cd task-manager
Entre na pasta demo e rode com Maven:

cd demo

# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
Teste a API via Postman ou outro cliente HTTP:
http://localhost:8080/tasks


POST:

<img width="832" height="510" alt="image" src="https://github.com/user-attachments/assets/fdeed9d0-0531-449b-b76f-82e3292b197e" />



GET:

<img width="849" height="548" alt="image" src="https://github.com/user-attachments/assets/7d6c9a32-b073-4837-8ca3-08af352abfce" />



GET com FILTRO:

<img width="835" height="590" alt="image" src="https://github.com/user-attachments/assets/e3ee9e8e-6938-4d85-9f88-c74f8e38ab4c" />



PUT com FILTRO:

<img width="832" height="533" alt="image" src="https://github.com/user-attachments/assets/70f84e7d-9592-4111-b4f0-abaca60c9e98" />



DELETE:

<img width="839" height="362" alt="image" src="https://github.com/user-attachments/assets/353a39b9-1019-47e3-b5d0-b80027a02e01" />



DELETE em algo que não existe:

<img width="840" height="523" alt="image" src="https://github.com/user-attachments/assets/9223ccbb-d436-4fc9-93a3-08bc3b9fdf9a" />



Acessar Swagger:
Abra no navegador:

http://localhost:8080/swagger-ui.html
Você verá todos os endpoints, poderá testar as requisições diretamente pelo Swagger e conferir exemplos de payload. 📖✨

## 🖼️ Swagger UI

Abra o Swagger em: `http://localhost:8080/swagger-ui.html`

Veja todos os endpoints e exemplos de payload diretamente no navegador:
![Swagger Endpoint Example](<img width="1426" height="774" alt="image" src="https://github.com/user-attachments/assets/6cf4a8bc-5cea-4e67-a3c8-f8fbef1d92cb" />
)

🛣️ Próximos Recursos / Roadmap
[ ]Front-end completo com React.js ⚛️

[ ]Deploy do projeto em AWS ou Heroku ☁️

[ ] Persistência de dados em MySQL ou PostgreSQL 🗄️

[✅] Funções de delete de tarefas 🗑️

[ ]Dashboard interativo com gráficos de progresso 📊

[✅] Busca e filtros avançados de tarefas 🔍

[ ]Autenticação e autorização de usuários 🔒

[ ]Notificações de status (email ou push) ✉️🔔

[✅] Maior quantidade de tratamento de erros para fluxos complexos ⚠️

[ ] Deixar mais fácil de utilizar os filtros ⚠️

👨‍💻 Autor
Daniel Almeida
Idade: 18 anos
Focado em Java, estudos de React e Desenvolvimento Full-Stack
Buscando evoluir projetos de backend + frontend 
