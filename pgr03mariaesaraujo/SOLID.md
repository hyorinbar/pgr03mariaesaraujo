1. S — Single Responsibility Principle (Responsabilidade Única)

Arquivo: UsuarioService.java — linhas 11 a 15 e 22 a 61.

O UsuarioService é responsável pelas regras de negócio dos usuários, enquanto o UsuarioDao é responsável pelo acesso aos dados. Assim, cada classe possui uma responsabilidade específica.

2. O — Open/Closed Principle (Aberto/Fechado)

Arquivo: GenericDao.java — linhas 12 a 18 e 20 a 69.

A classe GenericDao permite reutilizar operações de persistência para diferentes entidades. Novos DAOs podem aproveitar essas operações sem precisar modificar a classe genérica.

3. L — Liskov Substitution Principle (Substituição de Liskov)

Arquivo: UsuarioDao.java — linha 17.

UsuarioDao herda de GenericDao e mantém suas operações de persistência, podendo utilizar os comportamentos genéricos e acrescentar a busca específica por login.

4. I — Interface Segregation Principle (Segregação de Interfaces)

Arquivos:

UsuarioIDao.java — linhas 14 a 17.

PacienteIDao.java — linhas 14 a 17.

PsicologoIDao.java — linhas 14 a 17.

As interfaces possuem operações específicas para cada entidade. Por exemplo, UsuarioIDao possui busca por login, PacienteIDao possui busca por e-mail e PsicologoIDao possui busca por CRP.

5. D — Dependency Inversion Principle (Inversão de Dependência)

Arquivo: UsuarioService.java — linhas 12 a 16.

O UsuarioService depende da interface UsuarioIDao, e não diretamente da classe UsuarioDao. A dependência é recebida pelo construtor, permitindo utilizar diferentes implementações.