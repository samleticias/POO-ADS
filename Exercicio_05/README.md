## Questionamentos

### a. Você concorda que o banco faz o cadastro de duas entidades e ainda faz regras de negócios?

Não concordo, pois isso viola o princípio da responsabilidade única (SRP). A classe Banco deve focar apenas nas operações bancárias, enquanto regras e validações de clientes e contas devem ser tratadas separadamente.

### b. Não seria adequado o banco ter uma class CadastroDeClientes e CadastroDeContas e algumas regras de validação serem feitas no banco e deixar os métodos de consulta e inclusão os mais simples possíveis?

Sim, seria adequado, pois separar o cadastro de contas e clientes em classes específicas tornaria o sistema mais organizado e alinhado ao princípio da responsabilidade única (SRP).

### c. O método associar cliente a uma conta deveria estar em que classe? Banco, CadastroDeContas ou CadastroDeClientes?

Deveria estar na classe CadastroDeContas.
