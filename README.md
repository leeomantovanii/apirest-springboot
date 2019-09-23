# apirest-springboot

Tutorial de como rodar a aplicação.

### Instalação

1. Faça o clone deste projeto com `git clone https://github.com/leeomantovanii/apirest-springboot.git`
2. Abra o projeto e instale as dependências do maven
3. Crie o banco de dados MySQL `contatos` para o ORM criar a estrutura das tabelas e seus relacionamentos
4. Altere usuário e senha do seu MySQL no arquivo `application.properties`
5. Vá no package `com.contatos.apirest` e start a aplicação na classe `ApirestApplication.java` 

### Testando a aplicação

1. Abra o browser e visite a página `http://localhost:8080/swagger-ui.html`, lá estará todos os serviços disponibilizados pela aplicação juntamente com sua documentação/contrato, demonstrando a estrutura json esperada e qual o retorno a aplicação cliente receberá depois de executar o serviço.

![image](https://user-images.githubusercontent.com/20550151/65398875-04f98000-dd90-11e9-9cea-90f73893bad5.png)

2. Abra o Postman, insira os dados necessários do serviço e execute para obter o resultado desejado.

### Exemplo de contrato 

Exemplo de contrato do serviço `http://localhost:8080/api/contato` que insere um contato novo.

![image](https://user-images.githubusercontent.com/20550151/65399258-13e13200-dd92-11e9-8e1f-46a5f85762c2.png)
