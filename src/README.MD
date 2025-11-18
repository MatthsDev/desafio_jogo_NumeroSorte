# 🎰 Projeto --- Número da Sorte (Java)

## 🚀 Descrição

Aplicação console em Java para geração de bilhetes numéricos, listagem
de bilhetes do usuário e realização de um sorteio do bilhete premiado.

Projeto criado para treinar conceitos de **POO**, **modularidade**,
**organização de código** e boas práticas como **SRP**, **DRY** e
separação clara de responsabilidades.

------------------------------------------------------------------------

## 🎯 Objetivo

Oferecer uma aplicação simples e didática onde o usuário pode:

-   Gerar bilhetes únicos (0000--9999);
-   Visualizar todos os bilhetes gerados;
-   Sortear um número vencedor;
-   Verificar se foi premiado;
-   Estudar um modelo de código limpo e estruturado em Java.

------------------------------------------------------------------------

## ✅ Funcionalidades

-   ✔️ Gerar *N* bilhetes únicos
-   ✔️ Listar bilhetes gerados
-   ✔️ Sortear bilhete vencedor
-   ✔️ Comparar com bilhetes do usuário
-   ✔️ Menu interativo via console
-   ✔️ Estrutura preparada para testes unitários

------------------------------------------------------------------------

## 🗂 Estrutura do Projeto

    src/
    └─ br/com/projeto/
       ├─ Main.java
       ├─ controller/
       │   └─ AppController.java
       ├─ models/
       │   └─ Bilhete.java
       ├─ services/
       │   ├─ BilheteService.java
       │   └─ SorteioService.java
       └─ view/
           └─ Menu.java

### 📌 Função de cada diretório

-   **Main** -- ponto de entrada da aplicação
-   **AppController** -- coordena fluxo e regras de operação
-   **Bilhete** -- representa um bilhete formatado e encapsulado
-   **BilheteService** -- responsável por gerar e gerenciar bilhetes
-   **SorteioService** -- realiza o sorteio do número vencedor
-   **Menu** -- interface textual (exibição e entrada de dados)

------------------------------------------------------------------------

## 🛠 Requisitos

-   Java **17+**
-   IntelliJ IDEA / VSCode (recomendados)

------------------------------------------------------------------------

## ▶️ Como executar via terminal

### 1. Acesse a pasta `src`:

``` bash
cd src
```

### 2. Compile os arquivos:

``` bash
javac br/com/projeto/*.java br/com/projeto/controller/*.java br/com/projeto/models/*.java br/com/projeto/services/*.java br/com/projeto/view/*.java
```

### 3. Execute a aplicação:

``` bash
java br.com.projeto.Main
```

💡 **Se estiver usando IntelliJ**, basta executar a classe `Main`.

------------------------------------------------------------------------

## 🧭 Fluxo do Programa

Ao iniciar, o menu exibirá:

    1 — Gerar bilhetes
    2 — Listar bilhetes
    3 — Sortear vencedor
    0 — Sair

O usuário escolhe quantos bilhetes deseja gerar → todos ficam entre
**0000 e 9999**.\
No sorteio, o programa informa:

-   o número premiado
-   se algum dos bilhetes do usuário venceu

------------------------------------------------------------------------

## 🧩 Decisões de Arquitetura

-   **SRP (Single Responsibility Principle)** --- cada classe tem uma
    função clara
-   **Serviços não estáticos** --- facilitam evolução e testes
-   **Controller limpo** --- sem regras de negócio
-   **Encapsulamento no model Bilhete**
-   **Injeção de dependência simples** --- instâncias criadas no Main
-   **ThreadLocalRandom** --- eficiente para geração de números

------------------------------------------------------------------------

## 🔧 Próximas Melhorias
Ainda tô pensando no que posso adicionar daqui pra frente… então se tiver alguma ideia legal, manda aí!\
A ideia é ir evoluindo o projeto junto com a contribuição da galera.

-   ✔️ Criar API REST (Spring Boot)
-   ✔️ ...
-   ✔️ ...
-   ✔️ ...

------------------------------------------------------------------------

## 🤝 Como Contribuir

1.  Faça **fork** do repositório
2.  Crie uma branch:

``` bash
git checkout -b feature/minha-feature
```

3.  Faça commits pequenos e objetivos
4.  Abra um **Pull Request** descrevendo suas alterações

------------------------------------------------------------------------
## ✉️ Contato

**Matheus Araujo**\
📧 Email: **wmatheus.dev@gmail.com**\
🔗 LinkedIn: **https://www.linkedin.com/in/matheus-araujo-7a4388302**
