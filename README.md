# 🚇 Metrô do Recife — Frontend

Interface web em **React + TypeScript** para consultar estações do metrô do Recife e calcular rotas entre elas. O frontend consome a API REST [metro-recife-API](https://github.com/medeirosanderson/metro-recife-API), desenvolvida em Java com Spring Boot.

> Projeto de estudo: o objetivo é praticar React e TypeScript construindo uma aplicação real, passo a passo.

---

## 📌 Funcionalidades

- **Lista de estações** carregada da API (nome e linha de cada estação)
- **Busca por nome**, ignorando maiúsculas e acentos (`tejipio` encontra `Tejipió`)
- **Filtro por linha** (Todas, Centro, Sul), gerado automaticamente a partir dos dados
- **Calculadora de rotas**: escolha origem e destino e veja distância (km), tempo estimado (min), número de estações e o trajeto completo
- **Atalhos na lista**: botões **Origem** e **Destino** em cada estação preenchem a calculadora
- **Layout responsivo**: duas colunas no desktop, uma coluna no celular

---

## 🛠️ Tecnologias

| Ferramenta | Uso |
|---|---|
| [React](https://react.dev/) | Construção da interface com componentes |
| [TypeScript](https://www.typescriptlang.org/) | Tipagem estática dos dados e componentes |
| [Vite](https://vite.dev/) | Servidor de desenvolvimento e build |
| CSS puro | Estilização (variáveis CSS, Flexbox e Grid) |

---

## 📁 Estrutura do projeto

```
Projeto-MetroREC-Web/
├── Backend/                  ← API Java + Spring Boot
└── Frontend/                 ← este projeto
    ├── src/
    │   ├── components/
    │   │   ├── CalculadoraRota.tsx   ← seleção de origem/destino e resultado da rota
    │   │   └── ListaEstacoes.tsx     ← lista com busca e filtro por linha
    │   ├── services/
    │   │   └── metroService.ts       ← chamadas à API com fetch
    │   ├── types/
    │   │   └── metro.ts              ← interfaces Estacao e Rota
    │   ├── App.tsx                   ← componente raiz e estado compartilhado
    │   ├── main.tsx                  ← ponto de entrada do React
    │   └── index.css                 ← estilos globais
    ├── vite.config.ts                ← configuração do Vite (inclui o proxy da API)
    └── package.json
```

---

## ▶️ Como executar

### Pré-requisitos

- [Node.js](https://nodejs.org/) (versão LTS)
- A API rodando em `http://localhost:8080` (veja a seção abaixo)

### 1. Subir a API

```bash
cd Backend
mvn spring-boot:run
```

Deixe esse terminal aberto. A API precisa de um JDK compatível com a versão definida no `pom.xml`.

### 2. Subir o frontend

Em **outro terminal**:

```bash
cd Frontend
npm install
npm run dev
```

Abra o endereço mostrado no terminal (normalmente `http://localhost:5173`).

---

## 🔗 Integração com a API

O frontend roda em `localhost:5173` e a API em `localhost:8080`. Para evitar bloqueio de **CORS** no navegador, o Vite funciona como proxy: toda chamada que começa com `/api` é repassada para a API, com o prefixo removido.

```ts
// vite.config.ts
server: {
  proxy: {
    '/api': {
      target: 'http://localhost:8080',
      changeOrigin: true,
      rewrite: (path) => path.replace(/^\/api/, ''),
    },
  },
},
```

Exemplo: `fetch('/api/estacoes')` no navegador chega na API como `GET /estacoes`.

### Endpoints da API

| Endpoint | Retorno | Usado no frontend |
|---|---|---|
| `GET /estacoes` | Lista de estações | ✅ Lista e seletores |
| `GET /estacoes/linha?linha=Centro` | Estações de uma linha | Disponível no serviço (o filtro atual é feito no frontend) |
| `GET /estacoes/estacao?nome=Recife` | Estações por nome | Disponível no serviço (a busca atual é feita no frontend) |
| `GET /estacoes/{id}` | Uma estação | — |
| `GET /rotas?origem=1&destino=8` | Rota completa | ✅ Calculadora |
| `GET /rotas/distancia?origem=1&destino=8` | Distância (km) | — |
| `GET /rotas/tempo?origemId=1&destinoId=8` | Tempo (min) | — |

### Tipos TypeScript

As interfaces espelham o JSON devolvido pela API:

```ts
export interface Estacao {
  id: number
  nome: string
  linha: string
}

export interface Rota {
  origem: Estacao
  destino: Estacao
  caminho: Estacao[]
  distanciaTotal: number // km
  tempoEstimado: number  // minutos
}
```

---

## 🧠 Conceitos praticados

**React**
- Componentes de função e JSX
- Props e composição de componentes
- `useState` para estado local
- `useEffect` para buscar dados ao carregar a página
- Listas com `.map()` e `key`
- Renderização condicional (`&&` e operador ternário)
- Componentes controlados (`input` e `select`)
- Levantar o estado (*lifting state up*): `App` guarda origem e destino e os compartilha entre a calculadora e a lista
- Dados derivados: filtros e resultado da rota calculados a partir do estado, sem estados extras

**TypeScript**
- `interface` para modelar os dados da API
- Tipagem de props e de funções (`(id: string) => void`)
- Tipo união (`Rota | null`)
- Generics (`buscar<T>`)
- Eventos tipados (`ChangeEvent<HTMLInputElement>`)
- `import type` para importar apenas tipos

**Outros**
- `fetch` com `async/await` e camada de serviço separada dos componentes
- Proxy do Vite para contornar CORS em desenvolvimento
- CSS com variáveis, Flexbox, Grid e `@media` para responsividade

---

## 🗺️ Próximos passos

- [ ] Destacar na lista as estações escolhidas como origem e destino
- [ ] Extrair a busca de estações para um *custom hook*
- [ ] Exibir estados de carregamento (*loading*) e de erro
- [ ] Tratar respostas de erro da API (por exemplo, estação não encontrada)
- [ ] Guardar origem e destino como `number | null` em vez de texto
- [ ] Usar os endpoints de busca da API no lugar do filtro local
- [ ] Testes de componentes

---

## 👨‍💻 Autor

**Anderson Medeiros**
📍 Recife - PE
🔗 [github.com/medeirosanderson](https://github.com/medeirosanderson)
