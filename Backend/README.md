# 🚇 Sistema de Rotas do Metrô do Recife (Java)

Versão do projeto desenvolvida em Java com Spring Boot, com o objetivo de disponibilizar uma API para consulta de estações e cálculo de rotas entre estações do metrô do Recife.

---

## 📌 Funcionalidades

- Listagem de estações
- Busca de estação por nome
- Busca de estações por linha
- Cálculo de rota entre estações
- Cálculo da distância total do trajeto
- Cálculo do tempo estimado de viagem
- Rotas nos dois sentidos
- Tratamento de estação não encontrada
- API REST utilizando Spring Boot

---

## 🛠️ Tecnologias utilizadas

- Java
- Spring Boot
- Maven
- API REST
- Programação Orientada a Objetos
- Collections e Streams
- Estruturas de dados e lógica de programação

---

## ▶️ Como executar o projeto

### Pré-requisitos
- Java JDK 26 ou superior
- Maven (opcional, pois o projeto possui Maven Wrapper)

### Passos

```bash
git clone https://github.com/medeirosanderson/metro-recife.git
cd metro-recife
./mvnw spring-boot:run
```

No Windows, também é possível executar:

```cmd
mvnw.cmd spring-boot:run
```

---

## 🔗 Endpoints principais

- **Listar todas as estações:**
  ```http
  GET /estacoes
  ```

- **Buscar estações por linha:**
  ```http
  GET /estacoes/buscarlinha?linha=Centro
  ```

- **Buscar estação por nome:**
  ```http
  GET /estacoes/buscarestacao?nome=Recife
  ```

- **Calcular uma rota:**  
  O endpoint de rotas permite informar uma estação de origem e uma estação de destino para obter o caminho, a distância total e o tempo estimado de viagem.

  **Exemplo:**
  ```http
  GET /rotas?origem=1&destino=8
  ```

  **Exemplo de estrutura da resposta:**
  ```json
  {
    "origem": {
      "id": 1,
      "nome": "Recife",
      "linha": "Centro"
    },
    "destino": {
      "id": 8,
      "nome": "Barro",
      "linha": "Centro"
    },
    "caminho": [
      {
        "id": 1,
        "nome": "Recife",
        "linha": "Centro"
      }
    ],
    "distanciaTotal": 0,
    "tempoEstimado": 0
  }
  ```
  *Os valores apresentados acima são apenas um exemplo da estrutura da resposta da API.*

---

## 💡 Objetivo do projeto

Este projeto foi desenvolvido com o objetivo de praticar:

- Desenvolvimento de APIs REST
- Java e Programação Orientada a Objetos
- Spring Boot
- Organização de código em camadas
- Estruturas de dados
- Manipulação de listas e objetos
- Cálculo de rotas
- Tratamento de exceções
- Consumo e teste de endpoints

> **Nota:** A velocidade média utilizada para estimar o tempo de viagem é de 40 km/h.

---

## 🔄 Evolução do projeto

Este projeto faz parte da evolução de um projeto anterior desenvolvido em Python e C.

A versão atual utiliza Java e Spring Boot para transformar a lógica de cálculo de rotas em uma API REST.

🔗 Versão em Python:  
https://github.com/medeirosanderson/metro-recife-python  

🔗 Versão em C:  
https://github.com/medeirosanderson/metro-recife-c  

---

## 📷 Exemplo de uso

Uma consulta de rota pode ser realizada informando a estação de origem e a estação de destino:

```text
Origem: Recife
Destino: Barro

Distância total: 4.2 km
Tempo estimado: 6 minutos
```

*A calculadora também permite realizar o trajeto no sentido inverso, mantendo a mesma distância e o mesmo tempo estimado.*

---

## 👨‍💻 Autor

**Anderson Medeiros**  
📍 Recife - PE  
🔗 https://github.com/medeirosanderson  
🔗 https://www.linkedin.com/in/medeirosanderson/  

---

## 📄 Licença

Este projeto está sob a licença MIT.