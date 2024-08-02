# Projeto: Cadastro de Vendedores
Projeto Final do Módulo 3 do BootCamp DevJr
Oferecido por [abutua](abutua.com)

## Geral
Aplicação do tipo CRUD implementando conceitos básicos de projetos Angular e TypeScript com BootStrap no frontend e Java com SpringBoot no backend.

## O Projeto
Criar uma aplicação para gerenciar Vendedores, permitindo cadastrar, listar, editar e remover vendedores. 
Um vendedor possui: código, nome, sexo (masculino e feminino - opção _Não Informado_ acrescentada por conta própria), salário e percentual de bonificação (de 0% à 100%).

### Entidade
O seguinte modelo deve ser adotado para a entidade:
```
  Seller
-id: Long
-name: String
-salary: Double
-bonus: Double
-gender: Integer
```
tendo como características:
-  Id chave primária
-  Gênero (Masculino e Feminino) 
-  Nome com no mínimo 5 caracteres
-  Salário maior que zero
-  Percentual de bonificação de 0 à 100

## Requisistos do Projeto
### Backend 
Implementar os seguintes endpoints para os vendedores (/sellers) usando: Java, Spring, JPA, DTO, Tratamento de Exceções, Validação e o banco  H2.
-  Recupera todos os vendedores: 	GET  /sellers
-  Recupera um vendedor pelo id:	GET  /sellers/{id}
-  Atualiza um vendedor: 		PUT  /sellers/{id}
-  Cria um vendedor: 			POST /sellers
-  Remove um vendedor: 		DELETE /sellers/{id}

### Frontend 
Implementar os seguintes componentes usando Angular e BootStrap: 
-  Header com NavBar (home e vendedores)
-  Footer,
-  Home,
-  Sellers (Lista todos os vendedores) (Esse componente é pai de SellerForm)
-  SellerForm (formulário para cadastrar ou editar um vendedor) (Esse componente é filho de Sellers). Usar formulário reativo.

### Demais Requisitos
Além das exigencias para aprovação como Repositório único e público, quadro Kanban no GitHub Projects com tarefas de back e frontend, público e commits com fechamento das tarefas, deve também:
-  Consumir os end-points e apresentar os dados.
-  Poder criar, alterar e remover vendedores.
-  Listar todos os vendedores em uma tabela.
-  Fazer as validações no frontend e no backend.
-  Criar um script (data.sql) para fazer o seeding do banco com três vendedores.
-  Tratar as exceções.

## Conclusão
Com interface simples, usando componentes do BootStrap, a aplicação responde aos requisitos do projeto carregando a lista de vendedorres cadastrados, permitindo cadastrar novos vendedores ou mesmo editar/ excluir existentes (utilizando um modal para confirmação).

Na listagem, conceitos do Angular como as diretivas, pipes e bidings foram aplicados na recuperação dos dados do backend para apresentação e formatação. No cadastro, foi adotado o modelo de Formulário Reativo para criar novo vendedor e carregar um vendedor existente para edição.

No backend, a API web fornece os end-points necessários para tratar o CRUD de vendedores, com arquitetura baseada em REST. O banco de dados utilizado para os testes foi o h2.

### Imagens da Interface Final
![Página de Vendedores Cadastrados na horizontal](/UI-Design/VendedoresCadastrados-horizontal.JPG)

![Página de Cadastro de Vendedores na horizontal](/UI-Design/CadastroDeVendedores-horizontal-editing.JPG)

As demais imagens da interface podem ser encontradas em [UI-Design](UI-Design).