# FIAP FOOD

## Equipe

- Bruno Eduardo Martins Rosselli - RM353094
- Bruno de Sousa Araújo - RM352627
- Diego da Silva Nassula - RM353126
- Milton Willamis Da Silva - RM352999
- Robson Luis Ramos - RM352557

## Swagger

https://fiap-food-1.onrender.com/swagger-ui/index.html

## Descrição

FIAP FOOD é uma API Rest desenvolvida seguindo a metodologia de Clean Architecture. Ela fornece funcionalidades para cadastro de restaurantes, reserva de mesas, avaliações e comentários, busca de restaurantes e gerenciamento de reservas.

## Funcionalidades

### Cadastro de Restaurantes

Os restaurantes podem se cadastrar no sistema, fornecendo informações como nome, localização, tipo de cozinha, horários de funcionamento e capacidade.

### Reserva de Mesas

Os usuários podem fazer reservas para datas e horários específicos.

### Avaliações e Comentários

Após a visita, os usuários podem avaliar o restaurante e deixar comentários sobre sua experiência.

### Busca de Restaurantes

Os usuários podem buscar restaurantes por nome, localização ou tipo de cozinha.

### Gerenciamento de Reservas

Os restaurantes podem gerenciar as reservas, visualizando e atualizando o status das mesas.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Clean Architecture
- Test-Driven Development (TDD) com JUnit
- Testes de Integração
- Testes de Controller
- Continuous Integration (CI)
- Coverage (Cobertura de Testes)
- Deploy no Render

## Deploy

O deploy foi configurado para ser feito automáticamente após o merge de alguma PR.
Ele está junto das pipelines de verificação.
Você pode conferir nesse link a versão "deployada" https://fiap-food-grupo04.onrender.com

## Como Executar

1. Clone o repositório do projeto:

```bash
git clone https://github.com/seu-usuario/fiap-food.git
```

2. Acesse o diretório do projeto:

```bash
cd fiap-food
```
3. Execute o projeto:

```bash
./gradlew bootRun
```
