# ⚙️ DSVendas Backend

Backend da aplicação DSVendas desenvolvido com Spring Boot e Java 11.

## 📋 Sobre

Este é o backend do projeto DSVendas, uma API RESTful que fornece:
- Endpoints para consulta de vendas
- Agregação de dados por vendedor
- Paginação de resultados
- Integração com banco de dados H2/PostgreSQL

## 🚀 Tecnologias

- **Java** 11
- **Spring Boot** 2.5.4
- **Spring Data JPA** - Persistência de dados
- **Spring Security** - Segurança
- **H2 Database** - Banco em memória (desenvolvimento)
- **PostgreSQL** - Banco de dados (produção)
- **Maven** - Gerenciamento de dependências

## 🛠️ Como Executar

### Pré-requisitos
- Java 11 ou superior
- Maven (opcional, o projeto inclui Maven Wrapper)

### Desenvolvimento

```bash
# Navegar para o diretório do backend
cd backend

# Dar permissão de execução (Linux/Mac)
chmod +x mvnw

# Executar a aplicação
./mvnw spring-boot:run

# Ou no Windows
mvnw.cmd spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

### Console H2

Acesse o console do H2 em: `http://localhost:8080/h2-console`

**Configurações de conexão:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: *(deixe em branco)*

### Executar Testes

```bash
./mvnw test
```

### Gerar Build

```bash
./mvnw clean package
```

O arquivo JAR será gerado em: `target/dsvendas-0.0.1-SNAPSHOT.jar`

## 📁 Estrutura do Projeto

```
src/main/java/com/devsuperior/dsvendas/
├── config/
│   └── SecurityConfig.java        # Configurações de segurança e CORS
├── controllers/
│   ├── SaleControllers.java       # Endpoints de vendas
│   └── SellerControllers.java     # Endpoints de vendedores
├── dto/
│   ├── SaleDTO.java               # DTO de venda
│   ├── SaleSuccessDTO.java        # DTO de taxa de sucesso
│   ├── SaleSumDTO.java            # DTO de soma de vendas
│   └── SellerDTO.java             # DTO de vendedor
├── entities/
│   ├── Sale.java                  # Entidade Venda
│   └── Seller.java                # Entidade Vendedor
├── repositories/
│   ├── SaleRepository.java        # Repositório de vendas
│   └── SellerRepository.java      # Repositório de vendedores
├── service/
│   ├── SaleService.java           # Lógica de negócio de vendas
│   └── SellerService.java         # Lógica de negócio de vendedores
└── DsvendasApplication.java       # Classe principal

src/main/resources/
├── application.properties          # Configurações principais
├── application-dev.properties      # Configurações de desenvolvimento
├── application-prod.properties     # Configurações de produção
├── application-test.properties     # Configurações de teste
└── import.sql                      # Dados de seed
```

## 🔌 Endpoints da API

Veja a documentação completa em [API.md](../API.md)

### Principais Endpoints

```
GET  /sales                    - Lista vendas (paginado)
GET  /sales/amount-by-seller   - Total de vendas por vendedor
GET  /sales/success-by-seller  - Taxa de sucesso por vendedor
GET  /sellers                  - Lista vendedores
```

## 🗄️ Banco de Dados

### Perfis de Execução

O projeto possui 3 perfis:

**test** (padrão) - Usa H2 em memória
```bash
./mvnw spring-boot:run
```

**dev** - Usa PostgreSQL local
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

**prod** - Usa PostgreSQL em produção
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

### Modelo de Dados

```sql
-- Tabela de Vendedores
CREATE TABLE tb_sellers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

-- Tabela de Vendas
CREATE TABLE tb_sales (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    seller_id BIGINT,
    visited INTEGER,
    deals INTEGER,
    amount DECIMAL(19,2),
    date DATE,
    FOREIGN KEY (seller_id) REFERENCES tb_sellers(id)
);
```

## 🔒 Segurança

O Spring Security está configurado para permitir todas as requisições durante o desenvolvimento. Para produção, considere implementar autenticação adequada.

## 🌐 CORS

O CORS está habilitado para todas as origens. Para produção, configure origens específicas em `SecurityConfig.java`.

## 📦 Deploy

### Heroku

1. Certifique-se que o arquivo `system.properties` existe:
   ```properties
   java.runtime.version=11
   ```

2. Configure as variáveis de ambiente:
   ```
   APP_PROFILE=prod
   DATABASE_URL=<url-do-postgresql>
   ```

3. Deploy:
   ```bash
   git push heroku main
   ```

### Render

1. Conecte seu repositório
2. Configure:
   - Build Command: `./mvnw clean install -DskipTests`
   - Start Command: `java -jar target/dsvendas-0.0.1-SNAPSHOT.jar`
3. Adicione variáveis de ambiente conforme necessário

## 🧪 Testes

Execute os testes com:

```bash
./mvnw test
```

Para gerar relatório de cobertura:

```bash
./mvnw test jacoco:report
```

## 🤝 Contribuindo

Veja o arquivo [CONTRIBUTING.md](../CONTRIBUTING.md) no repositório principal.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](../LICENSE) para mais detalhes.
