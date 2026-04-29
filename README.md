# 🚀 Selenium with Java - Automação de Testes de Sistemas

Este repositório contém uma série de exercícios e implementações práticas focadas em testes automatizados de software utilizando **Java** e **Selenium WebDriver**. O projeto faz parte da minha jornada de aprendizado em Engenharia de Software, explorando como garantir a qualidade e o comportamento esperado de aplicações web.

## 🛠️ Tecnologias e Ferramentas
* **Linguagem:** Java (JDK 25)
* **Framework de Automação:** [Selenium WebDriver](https://www.selenium.dev/)
* **Gerenciador de Dependências:** Maven
* **Auxiliares:** [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) (para gestão automática de drivers) e SLF4J para logs.
* **IDE:** IntelliJ IDEA
* **Sistema Operacional:** macOS (MacBook Air M4)

## 📋 Funcionalidades Implementadas
O projeto cobre os fundamentos da automação web, incluindo:
* **Configuração de Driver:** Uso do WebDriverManager para setup do ChromeDriver.
* **Navegação Básica:** Abertura de páginas locais e externas.
* **Mapeamento de Elementos:** Localização de campos e botões via `ID` e outros seletores.
* **Sincronização:** Uso de `WebDriverWait` (Expected Conditions) para lidar com a latência de carregamento de elementos.
* **Suíte de Teste de Login:**
    * Cenário de Sucesso: Entrada de credenciais válidas e validação de mensagem de boas-vindas.
    * Cenário de Erro: Teste de credenciais inválidas com verificação de alertas de erro.
* **Evidências:** Captura automática de Screenshots (.png) durante a execução dos testes.

## 📁 Estrutura do Projeto
* `src/main/java/com/aula/selenium/`: Contém as classes principais de teste:
    * `PrimeiroTeste.java`: Script inicial de exploração.
    * `TesteLogin.java`: Fluxo completo de validação de formulário de acesso.
* `index.html`: Página web local utilizada como ambiente controlado para os testes.

## 🚀 Como executar
1.  Certifique-se de ter o **Maven** e o **Java** instalados.
2.  Clone o repositório:
    ```bash
    git clone https://github.com/heitorsantana-hub/Selenium-with-Java.git
    ```
3.  Abra o projeto no IntelliJ IDEA.
4.  Aguarde a sincronização das dependências do Maven (clique no ícone de "Reload" se necessário).
5.  Execute a classe `TesteLogin.java`.

> **Nota:** Certifique-se de atualizar o caminho da variável `caminhoArquivo` dentro do código para o diretório onde o seu `index.html` está salvo localmente.

---
Feito por **Heitor Reis de Santana** 🎓 
Engenharia de Software | Software Engineering Student at UniJorge / SENAI CIMATEC

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/heitor-reis-de-santana/)
[![Instagram](https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/heitorsantana.dev/)
