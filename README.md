### DESAFIO ESSIA
## OBJETIVO
Implementar um mini sistema de arquivos virtuais.

O sistema deverá permitir operar sobre diretórios e arquivos através de uma API REST, além de exibir uma listagem de diretórios em um frontend básico.

## 💻 Pré-requisitos

Antes de começar, é necessário a instalação do Docker e a utilização de um cliente API REST (POSTMAN | INSOMINIA).

## 🚀 Instalando

Para instalar o desafio essia, siga estas etapas:

```bash
sudo docker compose up
```

## ☕ Iniciando a API essia.

Para usar a API frontend, utilize o endereço que será exibido no console:

```bash
- Network: http://172.18.0.4:8081/
```

Para usar a API backend, siga estas etapas utilizando cliente API REST de sua escolha:

# Adicionando o diretório raiz:
Forneça um objeto Json com o atributo nome e seu valor, como no exemplo.

POST http://localhost:8080/api/diretorios
```json
{
  "nome": "DIRETORIO"
}
```
# Adicionando subdiretorio:
Forneça um objeto Json com o atributo nome e seu valor e um objeto diretorioPai com o atributo id como no exemplo.

POST http://localhost:8080/api/diretorios
```json
{
  "nome": "SUBDIRETORIO",
  "diretorioPai": {
    "id":1
  }
}
```
# Removendo diretório ou subdiretorio:
Adicione ao final da url um valor inteiro para remover o diretório desejado.

DELETE http://localhost:8082/api/diretorios/1

# Adicionando arquivo a um diretorio raiz:
Forneça um objeto Json com o atributo nome e tipo e seus valores, e ao final da url um valor inteiro para especificar o diretório desejado para adicionar o arquivo, como no exemplo.

POST http://localhost:8080/api/arquivos/diretorios/1
```json
{
    "nome": "arquivo.pdf",
    "tipo": "pdf"
}
```
# Removendo diretório ou subdiretorio:
Adicione ao final da url um valor inteiro para remover o arquivo desejado.

DELETE http://localhost:8080/api/arquivos/diretorios/1



