# Cadastros

Cadastros é uma aplicação desenvolvida para praticar desenvolvimento web utilizando SpringBoot e mais alguns outros projetos do ecossistema Spring. A aplicação consiste em receber dados sobre pessoas (nome, sobrenome e idade) e salvá-los em um banco de dados PostGreSQL.

As funcionalidades implementadas são: 
1. Cadastro de uma nova pessoa via preenchimento e envio de dados de um formulário (a pessoa deve ser maior de idade);
2. Apresentação das pessoas cadastradas em uma tabela quando solicitado pelo usuário ou após realização de cadastro de novo usuário;
3. Edição de dados previamente cadastrados para uma pessoa;
4. Pesquisa pelo primeiro nome da pessoa cadastrada;
5. Cada pessoa cadastrada possui uma página de detalhes, onde é possível visualizar, cadastrar ou excluir números de telefone.

## Tópicos praticados

Durante o desenvolvimento do projeto foi possível ter contato e praticar:

- criação de projetos com estrutura maven via start.spring.io;
- adição de dependências utilizando o arquivo `pom.xml`;
- produção de páginas de navegação utilizando Thymeleaf;
- persistência de dados utilizando Spring Data JPA;
- conexão com banco de dados PostGreSQL;
- utilização de anotações na classe principal do projeto: `@EntityScan` (permite a criação automática de tabelas), 
`@ComponentScan` (força o mapeamento das pastas indicadas - localização de Controller),
`@EnableJpaRepositories` (reconhecimento dos repositories) e `@EnableTransactionManagement` (habilitação de transações);
- injeção de dependências utilizando anotação `@Autowired`;
- criação de repositories com `@Repository`;
- criação de controllers com `@Controller`;
- geração automática de tabelas no banco de dados utilizando `@Entity` em objetos;
- queries personalizadas em repositórios utilizando `@Query`;
- anotações de relações entre tabelas (`@OneToMany`, `@ManyToOne`);
- validações no lado do servidor utilizando `@NotNull`, `@NotEmpty`, `@Min`, `@Valid`;
- vários outros pontos.

### Estrutura do backend

O backend do projeto está dividido em três pacotes: `model`, `controllers` e `repositories`.

No pacote `model`, estão definidas as classes do modelo da aplicação: `Pessoa` e `Telefone`.
No pacote `controllers`, estão definidos os controladores da aplicação: `IndexController` e `CadastroController`.
No pacote `repositories` estão definidos os repositórios da aplicação: `PessoaRepository` e `TelefoneRepository`.

### Estrutura do frontend

O frontent está construído utilizando Thymeleaf. A estilização das páginas foi realizada com Materialize CSS, já que o foco da construção da aplicação não era em praticar desenvolvimento frontend. Atualmente existe uma página inicial (index.html), uma página de cadastro de pessoas (`cadastro-de-pessoa.html`) e uma página de detalhes da pessoa selecionada (detalhes/id). 

A página de cadastro de pessoas está estruturada com um formulário que captura dados para criar um objeto do tipo `Pessoa`, com excessão do campo `id`, o qual é gerado automaticamente.

Na página de cadastro de pessoas é possível solicitar a visualização de todas as pessoas cadastradas no banco de dados. A apresentação das pessoas cadastradas é realizada através de uma tabela carregada abaixo do formulário de cadastro de uma nova pessoa. Além disso, existe uma opção de realizar pesquisa pelo primeiro nome de uma pessoa. Isso permite a verificação e fácil localização de uma pessoa previamente cadastrada.

O primeiro nome de cada pessoa cadastrada é exibido na tabela de visualização como um link para a página de detalhes dessa pessoa. Nessa página é possível realizar o cadastro do telefone da pessoa selecionada e visualizar todos os dados registrados.