<img src="https://img.shields.io/github/workflow/status/HarissonNascimento/bank-transactions-mapping/bank-transactions%20CI" alt="Project Workflow Badge"/>

## 🔨Missão do projeto
Dentro de 48 horas desenvolver um endpoint que retorne uma lista de transações bancárias mapeando o json para os campos descritos na [tabela abaixo](https://github.com/HarissonNascimento/bank-transactions-mapping#mapeamento) (coluna Mapeamento no DevDojo).

A requisição deverá ser feita para /transactions/{accountId} e o endpoint deverá retornar o conteúdo do arquivo [transactions.json](https://github.com/HarissonNascimento/bank-transactions-mapping/blob/master/spring-manager/src/main/resources/json/transactions.json) mapeado para os campos

Observação

    • Somente usuários autenticados poderão acessar esse endpoint.
    • Cada usuário deve ter 1 accountId e ele deve ser único por usuário. Exemplo: William tem uma conta 123,  David tem uma conta 890. O usuário William não poderá ver as transações da conta 890 e o usuário David não poderá ver as transações da conta 123. Caso tente, deverá ser retornado o status 403.
    • Não tem problema retornar as mesmas transações para ambas as contas, disponíveis no arquivo transactions.json
   
## 📋Requisitos
 Para execução deste projeto é necessário ter pré-instalado e configurado:
 - [Docker](https://docs.docker.com/get-docker/)
 
## 💻Executando o projeto
Execute o docker, abra o terminal em '.../bank-transactions-mapping' e execute o comando:

```sh
docker-compose up
```

Feito isso você terá a aplicação rodando em **localhost:8080**

## 📰Mapeamento

|        Campos originais      	|             Mapeamento no DevDojo            	|
|:----------------------------:	|:--------------------------------------------:	|
| encodedKey                   	| id                                           	|
| parentAccountKey             	| arrangementId                                	|
| creationDate                 	| bookingDate                                  	|
| type                         	| type                                         	|
| valueDate                    	| valueDate                                    	|
| amount                       	| amount                                       	|
| currencyCode                 	| currencyCode                                 	|
| currencyCode                 	| currency                                     	|
| amount                       	| creditDebitIndicator (DEBIT < 0, CREDIT >=0) 	|
| accountBalances.totalBalance 	| runningBalance                               	|
| id                           	| counterPartyAccountNumber                    	|
| parentAccountKey             	| reference                                    	|
| type                         	| typeGroup                                    	|
| amount                        | instructedAmount                              |

