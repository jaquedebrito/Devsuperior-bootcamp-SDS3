# 📊 DSVendas - Dashboard de Vendas

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/jaquedebrito/Devsuperior-bootcamp-SDS3)
[![Java](https://img.shields.io/badge/Java-11-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-green)](https://spring.io/projects/spring-boot)
[![React](https://img.shields.io/badge/React-17.0.2-blue)](https://reactjs.org/)
[![TypeScript](https://img.shields.io/badge/TypeScript-4.1.2-blue)](https://www.typescriptlang.org/)

Um sistema completo de dashboard de vendas desenvolvido durante a **Semana Spring React - SDS 3.0** da DevSuperior. Esta aplicação full stack moderna permite visualizar e analisar dados de vendas através de gráficos interativos e relatórios detalhados.

🔗 **[Acesse a aplicação ao vivo](https://dsvendas-jaqueline.netlify.app)**

---

## 📑 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias](#-tecnologias)
- [Arquitetura](#-arquitetura)
- [Primeiros Passos](#-primeiros-passos)
- [Instalação e Execução](#-instalação-e-execução)
- [API Endpoints](#-api-endpoints)
- [Deploy](#-deploy)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Contribuindo](#-contribuindo)
- [Licença](#-licença)
- [Contato](#-contato)

---

## 🎯 Sobre o Projeto

DSVendas é uma aplicação de gerenciamento e visualização de vendas que permite:

- **Análise de Performance**: Acompanhamento do desempenho de vendedores através de métricas e gráficos
- **Visualização Intuitiva**: Dashboard interativo com gráficos de barras e rosca
- **Dados em Tempo Real**: Integração com API RESTful para dados atualizados
- **Responsividade Total**: Interface adaptada para desktop, tablet e mobile

Este projeto foi desenvolvido como parte do bootcamp DevSuperior, focando em boas práticas de desenvolvimento full stack.

---

## ✨ Funcionalidades

### Dashboard Principal
- 📊 Gráfico de taxa de sucesso por vendedor (gráfico de rosca)
- 📈 Gráfico de volume de vendas por vendedor (gráfico de barras)
- 📱 Design responsivo para todos os dispositivos

### Backend API
- 🔍 Listagem paginada de vendas
- 📊 Agregação de dados por vendedor
- 🎯 Cálculo de taxa de sucesso de vendas
- 💰 Soma de valores de vendas por vendedor

### Recursos Técnicos
- ⚡ Performance otimizada com paginação
- 🔒 Segurança com Spring Security
- 💾 Persistência de dados com JPA/Hibernate
- 🌐 CORS configurado para integração frontend/backend

---

## 🚀 Tecnologias

### Backend
| Tecnologia | Versão | Descrição |
|-----------|--------|-----------|
| Java | 11 | Linguagem de programação principal |
| Spring Boot | 2.5.4 | Framework para criação da API |
| Spring Data JPA | 2.5.4 | Persistência e acesso a dados |
| Spring Security | 2.5.4 | Segurança da aplicação |
| H2 Database | Runtime | Banco de dados em memória (desenvolvimento) |
| PostgreSQL | Runtime | Banco de dados (produção) |
| Maven | - | Gerenciador de dependências |

### Frontend
| Tecnologia | Versão | Descrição |
|-----------|--------|-----------|
| React | 17.0.2 | Biblioteca para construção da UI |
| TypeScript | 4.1.2 | Superset JavaScript com tipagem |
| Axios | 0.21.4 | Cliente HTTP para consumo da API |
| ApexCharts | 3.28.1 | Biblioteca de gráficos interativos |
| Bootstrap | 5.1.1 | Framework CSS para estilização |
| React Router DOM | 5.3.0 | Roteamento da aplicação |

### DevOps & Deploy
| Serviço | Uso |
|---------|-----|
| Netlify | Hospedagem do Frontend |
| Heroku/Render | Hospedagem do Backend |
| Git | Controle de versão |

---

## 🏗️ Arquitetura

### Arquitetura da Aplicação

```
┌─────────────────────────────────────────────────────────────┐
│                         FRONTEND                            │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  React + TypeScript + ApexCharts + Bootstrap         │  │
│  │  - Componentes reutilizáveis                         │  │
│  │  - Gerenciamento de estado local                     │  │
│  │  - Rotas com React Router                            │  │
│  └──────────────────────────────────────────────────────┘  │
│                           ↓ HTTP/REST                       │
└─────────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────────┐
│                         BACKEND                             │
│  ┌──────────────────────────────────────────────────────┐  │
│  │              REST API (Spring Boot)                   │  │
│  │  ┌────────────────────────────────────────────────┐  │  │
│  │  │  Controllers (SaleController, SellerController) │  │  │
│  │  └────────────────────────────────────────────────┘  │  │
│  │  ┌────────────────────────────────────────────────┐  │  │
│  │  │  Services (Business Logic)                      │  │  │
│  │  └────────────────────────────────────────────────┘  │  │
│  │  ┌────────────────────────────────────────────────┐  │  │
│  │  │  Repositories (Spring Data JPA)                 │  │  │
│  │  └────────────────────────────────────────────────┘  │  │
│  │  ┌────────────────────────────────────────────────┐  │  │
│  │  │  Entities (Sale, Seller)                        │  │  │
│  │  └────────────────────────────────────────────────┘  │  │
│  └──────────────────────────────────────────────────────┘  │
│                           ↓                                 │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  Database (H2 / PostgreSQL)                          │  │
│  └──────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────┘
```

### Modelo de Dados

```
Seller                        Sale
┌──────────────┐       ┌──────────────────┐
│ id (PK)      │───┐   │ id (PK)          │
│ name         │   └──<│ seller_id (FK)   │
└──────────────┘       │ visited          │
                       │ deals            │
                       │ amount           │
                       │ date             │
                       └──────────────────┘
```

---

## 🎬 Primeiros Passos

### Pré-requisitos

Certifique-se de ter instalado em sua máquina:

- **Java 11+** - [Download](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **Node.js 12+** e **npm/Yarn** - [Download](https://nodejs.org/)
- **Git** - [Download](https://git-scm.com/)

### Verificar instalação

```bash
# Verificar Java
java -version

# Verificar Node.js
node -v

# Verificar npm
npm -v
```

---

## 💻 Instalação e Execução

### 1️⃣ Clone o repositório

```bash
git clone https://github.com/jaquedebrito/Devsuperior-bootcamp-SDS3.git
cd Devsuperior-bootcamp-SDS3
```

### 2️⃣ Backend

```bash
# Navegar para o diretório do backend
cd backend

# Dar permissão de execução ao Maven Wrapper (Linux/Mac)
chmod +x mvnw

# Executar o projeto
./mvnw spring-boot:run

# Ou no Windows
mvnw.cmd spring-boot:run
```

O backend estará disponível em: `http://localhost:8080`

**Console H2**: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: *(deixe em branco)*

### 3️⃣ Frontend

Em um novo terminal:

```bash
# Navegar para o diretório do frontend
cd frontend

# Instalar dependências
npm install
# ou
yarn install

# Executar o projeto
npm start
# ou
yarn start
```

O frontend estará disponível em: `http://localhost:3000`

### 4️⃣ Executar testes

**Backend:**
```bash
cd backend
./mvnw test
```

**Frontend:**
```bash
cd frontend
npm test
```

---

## 🔌 API Endpoints

### Base URL
- **Desenvolvimento**: `http://localhost:8080`
- **Produção**: `https://seu-backend.herokuapp.com`

### Endpoints Disponíveis

#### 📊 Sales

| Método | Endpoint | Descrição | Parâmetros |
|--------|----------|-----------|------------|
| GET | `/sales` | Lista todas as vendas (paginado) | `page`, `size`, `sort` |
| GET | `/sales/amount-by-seller` | Soma de vendas por vendedor | - |
| GET | `/sales/success-by-seller` | Taxa de sucesso por vendedor | - |

#### 👤 Sellers

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/sellers` | Lista todos os vendedores |

### Exemplos de Requisições

```bash
# Listar vendas (primeira página, 20 itens)
curl http://localhost:8080/sales?page=0&size=20

# Obter total de vendas por vendedor
curl http://localhost:8080/sales/amount-by-seller

# Obter taxa de sucesso por vendedor
curl http://localhost:8080/sales/success-by-seller

# Listar vendedores
curl http://localhost:8080/sellers
```

### Exemplo de Resposta

**GET** `/sales/success-by-seller`:
```json
[
  {
    "sellerName": "João Silva",
    "visited": 150,
    "deals": 120,
    "successRate": 80.0
  },
  {
    "sellerName": "Maria Santos",
    "visited": 200,
    "deals": 180,
    "successRate": 90.0
  }
]
```

---

## 🌐 Deploy

### Frontend (Netlify)

1. Faça build do projeto:
   ```bash
   cd frontend
   npm run build
   ```

2. Deploy no Netlify:
   - Conecte seu repositório GitHub
   - Configure build command: `npm run build`
   - Configure publish directory: `build`

### Backend (Heroku/Render)

1. Crie um arquivo `system.properties` (já incluído):
   ```properties
   java.runtime.version=11
   ```

2. Configure as variáveis de ambiente:
   ```
   APP_PROFILE=prod
   DATABASE_URL=<sua-url-postgresql>
   ```

3. Deploy via Git:
   ```bash
   git push heroku main
   ```

---

## 📁 Estrutura do Projeto

```
Devsuperior-bootcamp-SDS3/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/devsuperior/dsvendas/
│   │   │   │   ├── config/          # Configurações (Security, CORS)
│   │   │   │   ├── controllers/     # REST Controllers
│   │   │   │   ├── dto/              # Data Transfer Objects
│   │   │   │   ├── entities/         # Entidades JPA
│   │   │   │   ├── repositories/     # Repositórios Spring Data
│   │   │   │   ├── service/          # Lógica de negócio
│   │   │   │   └── DsvendasApplication.java
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       ├── application-dev.properties
│   │   │       ├── application-prod.properties
│   │   │       └── import.sql        # Dados de seed
│   │   └── test/
│   ├── pom.xml                       # Dependências Maven
│   └── system.properties             # Config Heroku
│
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── assets/                   # Imagens e recursos
│   │   ├── components/               # Componentes React
│   │   │   ├── BarChart/
│   │   │   ├── DataTable/
│   │   │   ├── DonutChart/
│   │   │   ├── Footer/
│   │   │   └── NavBar/
│   │   ├── pages/                    # Páginas da aplicação
│   │   │   ├── Dashboard/
│   │   │   └── Home/
│   │   ├── types/                    # TypeScript types
│   │   ├── utils/                    # Funções utilitárias
│   │   ├── App.tsx
│   │   ├── Routes.tsx
│   │   └── index.tsx
│   ├── package.json
│   └── tsconfig.json
│
└── README.md
```

---

## 🤝 Contribuindo

Contribuições são sempre bem-vindas! Siga os passos abaixo:

1. **Fork** o projeto
2. Crie uma **branch** para sua feature (`git checkout -b feature/MinhaFeature`)
3. **Commit** suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. **Push** para a branch (`git push origin feature/MinhaFeature`)
5. Abra um **Pull Request**

### Diretrizes de Contribuição

- Mantenha o código limpo e bem documentado
- Siga os padrões de código do projeto
- Adicione testes quando aplicável
- Atualize a documentação conforme necessário

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 📚 Sobre o Bootcamp

A **Semana Spring React - SDS 3.0** é um evento gratuito organizado pela [DevSuperior](https://devsuperior.com.br/), focado em ensinar as tecnologias mais demandadas do mercado através da construção de um projeto prático e completo.

**Conteúdo abordado:**
- Desenvolvimento full stack com Spring Boot e React
- Integração backend/frontend via API REST
- Implantação em produção (Heroku e Netlify)
- Boas práticas de programação
- Versionamento com Git e GitHub

---

## 👩‍💻 Contato

**Jaqueline Ferreira de Brito**

- LinkedIn: [jaqueline-brito-developer](https://www.linkedin.com/in/jaqueline-brito-developer/)
- GitHub: [@jaquedebrito](https://github.com/jaquedebrito)
- E-mail: [seu-email@example.com]

---

<div align="center">
  
### ⭐ Se este projeto te ajudou, considere dar uma estrela!

**Feito com 💻 e ☕ por Jaqueline Ferreira de Brito**

</div>
