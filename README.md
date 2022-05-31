# Cadastros

Cadastros é uma aplicação desenvolvida para praticar desenvolvimento web utilizando SpringBoot e mais alguns outros projetos do ecossistema Spring. A aplicação consiste em receber dados sobre pessoas (nome, sobrenome e idade) e salvá-los em um banco de dados PostGreSQL.

As funcionalidades implementadas são: 
1. Cadastro de uma nova pessoa via preenchimento e envio de dados de um formulário;
2. Apresentação das pessoas cadastradas em uma tabela quando solicitado pelo usuário ou após realização de cadastro de novo usuário;
3. Edição de dados previamente cadastrados para uma pessoa;
4. Pesquisa pelo primeiro nome da pessoa cadastrada;

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
- vários outros pontos.

### Estrutura do backend

O backend do projeto está dividido em três pacotes: `model`, `controllers` e `repositories`. Os nomes dos pacotes já explicam o conteúdo de cada um deles.

### Estrutura do frontend

O frontent está construído utilizando puro HTML5. Atualmente existe uma página inicial (index.html) e uma página de cadastro de pessoas (`cadastro-de-pessoa.html`). A página de cadastro de pessoas está estruturada com um formulário que captura todos os dados para criar um objeto do tipo `Pessoa`, com excessão do campo `id`, o qual é gerado automaticamente. 