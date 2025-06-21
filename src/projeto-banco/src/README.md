# Sistema de Gerenciamento Bancário Simples em Java
Este projeto implementa um sistema de gerenciamento bancário básico em Java, utilizando conceitos de Programação Orientada a Objetos (POO) como encapsulamento, classes e objetos para simular operações bancárias.

## Estrutura do Projeto
O projeto é composto por três classes principais:

### Cliente.java: Representa um cliente do banco.
### Conta.java: Representa uma conta bancária.
### Main.java: Contém o método principal (main) para executar o menu do sistema e interagir com o usuário.

##Classe Cliente
A classe Cliente possui os seguintes atributos:

nome (String): Nome completo do cliente.
cpf (String): CPF (Cadastro de Pessoas Físicas) do cliente.
endereco (String): Endereço completo do cliente.
Ela inclui um construtor para inicializar os objetos Cliente e métodos Getters e Setters para acessar e modificar seus atributos, além de um método toString() para facilitar a visualização dos dados do cliente.

## Classe Conta
A classe Conta possui os seguintes atributos:

titular (Cliente): Uma referência ao objeto Cliente que é o titular da conta. Isso estabelece a associação entre uma conta e seu cliente.
saldo (double): O valor monetário atual da conta.
numeroConta (String): O número único de identificação da conta.
Além de um construtor para criar novas contas e métodos Getters e Setters, a classe Conta implementa as principais operações bancárias:

depositar(double valor): Adiciona um valor ao saldo da conta.
sacar(double valor): Retira um valor do saldo da conta, com validação para saldo insuficiente.
transferir(Conta destino, double valor): Transfere um valor desta conta para uma conta de destino, reutilizando os métodos sacar e depositar.
Também possui um método toString() para uma representação clara dos detalhes da conta.

## Classe Main
A classe Main é o ponto de entrada do programa. Ela:

Mantém listas (ArrayList) de objetos Cliente e Conta para gerenciar todos os clientes e contas criados.
Apresenta um menu interativo para o usuário via console.
Permite a criação de um novo cliente e uma conta associada em uma única operação.
Inclui um método auxiliar (encontrarConta) para localizar contas na lista por seu número, facilitando as operações de depósito, saque e transferência.
Contém a estrutura para implementar as funcionalidades de depósito, saque, transferência e listagem de clientes/contas.
