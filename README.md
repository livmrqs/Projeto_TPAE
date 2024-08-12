<h1 align="center">Controle de Estoque para um Mercado</h1>
<h2 align="center">Projeto final desenvolvido para a disciplina de Técnicas de Programação Aplicada à Engenharia</h2>


## 📌 Índice
1. [Objetivo do Projeto](#-objetivo-do-projeto)
2. [Lógica de funcionamento](#-lógica-de-funcionamento)
3. [Estrutura de pastas](#-estrutura-de-pastas)
4. [Como usar o sistema](#-como-usar-o-sistema)
5. [Tecnologias utilizadas](#-tecnologias-utilizadas)
6. [Dificuldades encontradas](#️-dificuldades-encontradas)


## 📖 Objetivo do Projeto
Projeto final desenvolvido com o intuito de criar um sistema de controle de estoque, mais voltado para um mercado. Em que seria possível gerenciar funcionários, clientes, fornecedores, vendas, estoque e lucro.


## 🎯 Lógica de funcionamento
Consulte o [vídeo de exemplo](https://youtu.be/sftIRrLOudY?si=DNa7W7eMbMwQYqse) para melhor entender a lógica de funcionamento do sistema e como cada elemento foi implementado.

## 📂 Estrutura de pastas
 
```
ControleDeEstoqueMercado/
├── src/
│   └── br/
│       └── com/
│           └── ControleDeEstoque/
│               ├── dao/
│               │   ├── ClientDAO.java
│               │   ├── EmployeesDAO.java
│               │   ├── ProductsDAO.java
│               │   ├── SalesDAO.java
│               │   ├── SalesItensDAO.java
│               │   └── SuppliersDAO.java
│               ├── jdbc/
│               │   ├── ConnectionFactory.java
│               │   └── TestConnection.java
│               ├── model/
│               │   ├── Clientes.java
│               │   ├── Employees.java
│               │   ├── Products.java
│               │   ├── Sales.java
│               │   ├── SalesItens.java
│               │   ├── Suppliers.java
│               │   └── Utilities.java
│               └── view/
│                   ├── FrmClient.java
│                   ├── FrmEmployees.java
│                   ├── FrmInventory.java
│                   ├── FrmLogin.java
│                   ├── FrmMenu.java
│                   ├── FrmPayments.java
│                   ├── FrmProducts.java
│                   ├── FrmRecentsSales.java
│                   ├── FrmSales.java
│                   ├── FrmSalesDetails.java
│                   ├── FrmSuppliers.java
│                   └── FrmTotal.java
└── README.md
```

## 🚀 Como usar o sistema

1. Clone o repositório
```bash
git clone https://github.com/livmrqs/Projeto_TPAE.git
```
2. Instale o [Netbeans](https://netbeans.apache.org/front/main/download/nb122/nb122/) para poder utilizar as funções necessárias para java e abra o diretório do projeto
 
3. Clique em "Run" para iniciar o build, ou pressione o atalho *F6* no NetBeans

- Há dois *níveis de acesso* disponíveis no sistema, usuário e administrador. Caso queira testar o *usuário*, faça login com as seguintes credenciais:
```bash
pedromagal@gmail.com
```
```bash
678910
```
Caso queira testar o *administrador*, faça login com as seguintes credenciais:
```bash
johnkennedy@gmail.com
```
```bash
12345
```

## 💻 Tecnologias utilizadas
- [Java](https://docs.oracle.com/javase/)
- [MySQL](https://dev.mysql.com/doc/)
- [Netbeans](https://netbeans.apache.org/front/main/download/nb122/nb122/)


## 🛠️ Dificuldades encontradas
Por ser o primeiro contato com a linguagem utilizada, tive algumas dificuldades com a estruturação dos arquivos e de adaptação com a plataforma utilizada. Alguns comandos do MySQL apresentaram mau funcionamento também, porém foram resolvidos com o uso de jdbc. A princípio surgiram algumas dúvidas sobre como faria a integração total do sistema, mas ao consultar a documentação consegui lidar bem com isso.

## ✍🏻 
Criado e desenvolvido por [Lívia Marques Rodrigues](https://github.com/livmrqs)


