📚 LMS - Learning Management System

Sistema simples de gerenciamento de aprendizagem (LMS) com funcionalidades para cadastro de estudantes, gerenciamento de cursos e controle de tarefas de aprendizagem.

🚀 Tecnologias Utilizadas

Backend

Java 21
Spring Boot 3.4
Spring Data JPA
Spring Security
FlyWay
Banco de dados relacional Postgres

Frontend
Angular 19

Outros
RESTful API
Git

🔐 Segurança

Implementado com Spring Security
Controle de acesso baseado em perfis:
ADMIN: pode gerenciar cursos
ALUNO: pode se registrar, se matricular e registrar tarefas

Proteção de rotas sensíveis e autenticação com JWT (opcional, se implementado)

🧠 Funcionalidades
👤 Registro de Estudantes

Estudantes podem se registrar informando:
Primeiro nome, último nome, data de nascimento, e-mail, telefone

Validações:

Idade mínima de 16 anos (armazenada na tabela parametros)
E-mail deve ser único

🎓 Gerenciamento de Cursos (ADMIN)

Administradores podem:

Criar, editar e remover cursos

Regras:

Nome do curso deve ser único

✅ Matrícula e Tarefas (ALUNO)

Estudantes podem:
Se matricular em até 3 cursos simultaneamente (armazenada na tabela parametros)

⚙️ Tabela de Parâmetros

Criada tabela de parametros no banco de dados para configurar:
Idade mínima para cadastro
Quantidade máxima de cursos por aluno

Usuario Administrador: ADMIN, senha: 123.

A criação das Tabelas e a população são feitas pelo flyway

📁 Como Rodar o Projeto
Backend (Spring Boot)
# Clone o projeto
git clone https://github.com/seu-usuario/seu-repositorio.git
cd backend

# Configure o application.properties ou application.yml com seu banco de dados

# Rode a aplicação
./mvnw spring-boot:run

Frontend (Angular)
cd frontend

# Instale as dependências
npm install

# Rode a aplicação
ng serve
