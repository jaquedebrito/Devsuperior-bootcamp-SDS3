# 📚 Documentação da API - DSVendas

## Base URL

- **Desenvolvimento**: `http://localhost:8080`
- **Produção**: `https://seu-app.herokuapp.com` (substitua pela URL real)

## Autenticação

Atualmente, a API não requer autenticação. O Spring Security está configurado para permitir todas as requisições.

---

## Endpoints

### 📊 Sales (Vendas)

#### 1. Listar Vendas (Paginado)

Retorna uma lista paginada de todas as vendas.

**Endpoint**: `GET /sales`

**Parâmetros de Query**:
| Parâmetro | Tipo | Padrão | Descrição |
|-----------|------|--------|-----------|
| `page` | integer | 0 | Número da página (começa em 0) |
| `size` | integer | 20 | Quantidade de itens por página |
| `sort` | string | - | Campo para ordenação (ex: `date,desc`) |

**Exemplo de Requisição**:
```bash
GET /sales?page=0&size=20&sort=date,desc
```

**Resposta de Sucesso** (200 OK):
```json
{
  "content": [
    {
      "id": 1,
      "visited": 103,
      "deals": 88,
      "amount": 15017.0,
      "date": "2021-08-01",
      "seller": {
        "id": 1,
        "name": "Anakin"
      }
    },
    {
      "id": 2,
      "visited": 117,
      "deals": 74,
      "amount": 7091.0,
      "date": "2021-07-31",
      "seller": {
        "id": 2,
        "name": "Logan"
      }
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 20,
    "offset": 0,
    "paged": true
  },
  "totalPages": 10,
  "totalElements": 200,
  "last": false,
  "first": true,
  "empty": false
}
```

---

#### 2. Total de Vendas por Vendedor

Retorna a soma total de vendas agrupada por vendedor.

**Endpoint**: `GET /sales/amount-by-seller`

**Parâmetros**: Nenhum

**Exemplo de Requisição**:
```bash
GET /sales/amount-by-seller
```

**Resposta de Sucesso** (200 OK):
```json
[
  {
    "sellerName": "Anakin",
    "sum": 234567.0
  },
  {
    "sellerName": "Logan",
    "sum": 198234.5
  },
  {
    "sellerName": "Padme",
    "sum": 176543.2
  },
  {
    "sellerName": "Loki",
    "sum": 165432.8
  },
  {
    "sellerName": "Thor",
    "sum": 154321.6
  }
]
```

**Campos da Resposta**:
| Campo | Tipo | Descrição |
|-------|------|-----------|
| `sellerName` | string | Nome do vendedor |
| `sum` | number | Soma total de vendas em valor monetário |

---

#### 3. Taxa de Sucesso por Vendedor

Retorna a taxa de sucesso (deals/visited) agrupada por vendedor.

**Endpoint**: `GET /sales/success-by-seller`

**Parâmetros**: Nenhum

**Exemplo de Requisição**:
```bash
GET /sales/success-by-seller
```

**Resposta de Sucesso** (200 OK):
```json
[
  {
    "sellerName": "Padme",
    "visited": 3847,
    "deals": 3154
  },
  {
    "sellerName": "Loki",
    "visited": 3691,
    "deals": 2925
  },
  {
    "sellerName": "Thor",
    "visited": 3659,
    "deals": 2888
  },
  {
    "sellerName": "Anakin",
    "visited": 3567,
    "deals": 2787
  },
  {
    "sellerName": "Logan",
    "visited": 3412,
    "deals": 2632
  }
]
```

**Campos da Resposta**:
| Campo | Tipo | Descrição |
|-------|------|-----------|
| `sellerName` | string | Nome do vendedor |
| `visited` | integer | Total de visitas realizadas |
| `deals` | integer | Total de negócios fechados |

**Taxa de Sucesso** é calculada como: `(deals / visited) * 100`

---

### 👤 Sellers (Vendedores)

#### 1. Listar Vendedores

Retorna a lista de todos os vendedores cadastrados.

**Endpoint**: `GET /sellers`

**Parâmetros**: Nenhum

**Exemplo de Requisição**:
```bash
GET /sellers
```

**Resposta de Sucesso** (200 OK):
```json
[
  {
    "id": 1,
    "name": "Anakin"
  },
  {
    "id": 2,
    "name": "Logan"
  },
  {
    "id": 3,
    "name": "Padme"
  },
  {
    "id": 4,
    "name": "Loki"
  },
  {
    "id": 5,
    "name": "Thor"
  }
]
```

**Campos da Resposta**:
| Campo | Tipo | Descrição |
|-------|------|-----------|
| `id` | integer | ID único do vendedor |
| `name` | string | Nome do vendedor |

---

## Códigos de Status HTTP

| Código | Descrição |
|--------|-----------|
| 200 | OK - Requisição bem-sucedida |
| 400 | Bad Request - Parâmetros inválidos |
| 404 | Not Found - Recurso não encontrado |
| 500 | Internal Server Error - Erro no servidor |

---

## Tipos de Dados

### Sale (Venda)
```typescript
{
  id: number;
  visited: number;      // Quantidade de visitas
  deals: number;        // Quantidade de negócios fechados
  amount: number;       // Valor total em R$
  date: string;         // Data no formato ISO (YYYY-MM-DD)
  seller: Seller;       // Informações do vendedor
}
```

### Seller (Vendedor)
```typescript
{
  id: number;
  name: string;
}
```

### SaleSumDTO
```typescript
{
  sellerName: string;
  sum: number;          // Soma total de vendas
}
```

### SaleSuccessDTO
```typescript
{
  sellerName: string;
  visited: number;      // Total de visitas
  deals: number;        // Total de negócios fechados
}
```

---

## Exemplos de Uso

### cURL

```bash
# Listar vendas
curl -X GET "http://localhost:8080/sales?page=0&size=10"

# Obter total por vendedor
curl -X GET "http://localhost:8080/sales/amount-by-seller"

# Obter taxa de sucesso
curl -X GET "http://localhost:8080/sales/success-by-seller"

# Listar vendedores
curl -X GET "http://localhost:8080/sellers"
```

### JavaScript (Axios)

```javascript
import axios from 'axios';

const BASE_URL = 'http://localhost:8080';

// Listar vendas
const getSales = async (page = 0, size = 20) => {
  const response = await axios.get(`${BASE_URL}/sales`, {
    params: { page, size }
  });
  return response.data;
};

// Obter total por vendedor
const getAmountBySeller = async () => {
  const response = await axios.get(`${BASE_URL}/sales/amount-by-seller`);
  return response.data;
};

// Obter taxa de sucesso
const getSuccessBySeller = async () => {
  const response = await axios.get(`${BASE_URL}/sales/success-by-seller`);
  return response.data;
};

// Listar vendedores
const getSellers = async () => {
  const response = await axios.get(`${BASE_URL}/sellers`);
  return response.data;
};
```

### Python (Requests)

```python
import requests

BASE_URL = 'http://localhost:8080'

# Listar vendas
def get_sales(page=0, size=20):
    response = requests.get(f'{BASE_URL}/sales', params={'page': page, 'size': size})
    return response.json()

# Obter total por vendedor
def get_amount_by_seller():
    response = requests.get(f'{BASE_URL}/sales/amount-by-seller')
    return response.json()

# Obter taxa de sucesso
def get_success_by_seller():
    response = requests.get(f'{BASE_URL}/sales/success-by-seller')
    return response.json()

# Listar vendedores
def get_sellers():
    response = requests.get(f'{BASE_URL}/sellers')
    return response.json()
```

---

## CORS

O CORS está habilitado para todas as origens durante o desenvolvimento. Para produção, configure adequadamente as origens permitidas no arquivo `SecurityConfig.java`.

---

## Notas Adicionais

- Todos os endpoints retornam dados em formato JSON
- A paginação usa indexação baseada em zero (primeira página = 0)
- Datas estão no formato ISO 8601 (YYYY-MM-DD)
- Valores monetários são representados como números decimais

---

## Suporte

Para reportar problemas ou sugerir melhorias na API, por favor abra uma issue no GitHub.
