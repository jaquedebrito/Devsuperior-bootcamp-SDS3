# Contribuindo para DSVendas

Obrigado por considerar contribuir com o DSVendas! 🎉

## Como Contribuir

### Reportando Bugs

Se você encontrou um bug, por favor abra uma issue incluindo:

- **Descrição clara** do problema
- **Passos para reproduzir** o bug
- **Comportamento esperado** vs **comportamento atual**
- **Screenshots** se aplicável
- **Ambiente**: versões de Java, Node.js, navegador, etc.

### Sugerindo Melhorias

Para sugerir melhorias ou novas funcionalidades:

1. Verifique se já não existe uma issue sobre o assunto
2. Abra uma nova issue com:
   - Descrição detalhada da melhoria
   - Justificativa (por que seria útil?)
   - Exemplos de uso, se aplicável

### Enviando Pull Requests

1. **Fork** o repositório
2. **Clone** seu fork localmente:
   ```bash
   git clone https://github.com/seu-usuario/Devsuperior-bootcamp-SDS3.git
   ```

3. **Crie uma branch** para sua feature:
   ```bash
   git checkout -b feature/minha-feature
   ```

4. **Faça suas alterações** seguindo os padrões do projeto

5. **Teste suas alterações**:
   ```bash
   # Backend
   cd backend
   ./mvnw test
   
   # Frontend
   cd frontend
   npm test
   ```

6. **Commit** suas mudanças:
   ```bash
   git commit -m "feat: adiciona nova funcionalidade X"
   ```
   
   Use commits semânticos:
   - `feat:` para novas funcionalidades
   - `fix:` para correções de bugs
   - `docs:` para documentação
   - `style:` para formatação de código
   - `refactor:` para refatoração
   - `test:` para testes
   - `chore:` para tarefas de manutenção

7. **Push** para seu fork:
   ```bash
   git push origin feature/minha-feature
   ```

8. **Abra um Pull Request** no repositório original

### Padrões de Código

#### Backend (Java)
- Siga as convenções do Java e Spring Boot
- Use nomes descritivos para classes, métodos e variáveis
- Adicione comentários JavaDoc para métodos públicos
- Mantenha métodos pequenos e focados
- Use DTOs para transferência de dados

#### Frontend (React/TypeScript)
- Use TypeScript para tipagem estática
- Componentes funcionais com hooks
- Nomes de componentes em PascalCase
- Props e variáveis em camelCase
- CSS Modules ou styled-components para estilos isolados
- Mantenha componentes pequenos e reutilizáveis

### Estrutura de Commits

```
tipo(escopo): descrição curta

[corpo opcional com mais detalhes]

[rodapé opcional com referências a issues]
```

Exemplo:
```
feat(api): adiciona endpoint de filtro de vendas

Implementa novo endpoint GET /sales/filter que permite
filtrar vendas por período e vendedor

Closes #123
```

### Processo de Review

- Todos os PRs serão revisados antes do merge
- Mantenha o PR focado em uma única feature ou correção
- Responda aos comentários e faça ajustes quando solicitado
- Certifique-se de que todos os testes passam

### Código de Conduta

- Seja respeitoso e inclusivo
- Aceite críticas construtivas
- Foque no que é melhor para a comunidade
- Mostre empatia com outros membros da comunidade

## Dúvidas?

Se tiver dúvidas sobre como contribuir, sinta-se à vontade para:
- Abrir uma issue com a tag `question`
- Entrar em contato via LinkedIn

Obrigado por contribuir! 🚀
