# 🎨 DSVendas Frontend

Frontend da aplicação DSVendas desenvolvido com React, TypeScript e ApexCharts.

## 📋 Sobre

Este é o frontend do projeto DSVendas, uma aplicação de dashboard de vendas que exibe:
- Gráficos interativos de vendas
- Tabela com dados paginados
- Interface responsiva e moderna

## 🚀 Tecnologias

- **React** 17.0.2
- **TypeScript** 4.1.2
- **ApexCharts** - Gráficos interativos
- **Bootstrap** 5.1.1 - Estilização
- **Axios** - Requisições HTTP
- **React Router DOM** - Roteamento

## 🛠️ Scripts Disponíveis

### `npm start` ou `yarn start`

Executa a aplicação em modo de desenvolvimento.\
Abra [http://localhost:3000](http://localhost:3000) para visualizar no navegador.

A página recarrega automaticamente quando você faz alterações.\
Você também verá erros de lint no console.

### `npm test` ou `yarn test`

Inicia o executor de testes em modo interativo.\
Veja mais informações em [running tests](https://facebook.github.io/create-react-app/docs/running-tests).

### `npm run build` ou `yarn build`

Cria o build de produção na pasta `build`.\
Otimiza e minifica o código para melhor performance.

Os arquivos são minificados e incluem hashes nos nomes.\
Está pronto para deploy!

## 📁 Estrutura de Pastas

```
src/
├── assets/          # Imagens e recursos estáticos
├── components/      # Componentes reutilizáveis
│   ├── BarChart/   # Gráfico de barras
│   ├── DataTable/  # Tabela de dados
│   ├── DonutChart/ # Gráfico de rosca
│   ├── Footer/     # Rodapé
│   └── NavBar/     # Barra de navegação
├── pages/          # Páginas da aplicação
│   ├── Dashboard/  # Página do dashboard
│   └── Home/       # Página inicial
├── types/          # Definições de tipos TypeScript
├── utils/          # Funções utilitárias
├── App.tsx         # Componente principal
├── Routes.tsx      # Configuração de rotas
└── index.tsx       # Ponto de entrada
```

## 🔌 Configuração da API

A URL base da API está configurada em `utils/requests.ts`:

```typescript
export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? 'http://localhost:8080';
```

Para usar uma API diferente em desenvolvimento, crie um arquivo `.env.local`:

```env
REACT_APP_BACKEND_URL=http://sua-api.com
```

## 🎨 Componentes Principais

### Dashboard
Página principal com gráficos e tabela de vendas.

### BarChart
Exibe o total de vendas por vendedor em formato de gráfico de barras.

### DonutChart
Mostra a taxa de sucesso por vendedor em gráfico de rosca.

### DataTable
Tabela paginada com todos os dados de vendas.

## 📦 Deploy

### Netlify

1. Faça o build:
   ```bash
   npm run build
   ```

2. Configure no Netlify:
   - Build command: `npm run build`
   - Publish directory: `build`
   - Environment variable: `REACT_APP_BACKEND_URL=<sua-api-url>`

## 📚 Saiba Mais

- [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started)
- [React documentation](https://reactjs.org/)
- [TypeScript documentation](https://www.typescriptlang.org/)
- [ApexCharts documentation](https://apexcharts.com/docs/)

## 🤝 Contribuindo

Veja o arquivo [CONTRIBUTING.md](../CONTRIBUTING.md) no repositório principal.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](../LICENSE) para mais detalhes.
