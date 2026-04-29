package com.aula.selenium;

// Importações necessárias
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

/**
 * Exemplo de automação de login
 * Este programa testa o formulário de login da nossa página HTML
 */
public class TesteLogin {

    public static void main(String[] args) {
        // Configurar o driver do Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Abrir a página de teste
            driver.manage().window().maximize();
            String caminhoArquivo = "file:///C:/selenium-aula/pagina-teste.html";
            driver.get(caminhoArquivo);

            System.out.println("=== INICIANDO TESTE DE LOGIN ===");

            // Criar um objeto WebDriverWait para esperas inteligentes
            // Ele espera até 10 segundos por um elemento aparecer
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // TESTE 1: Login com dados corretos
            System.out.println("\n--- Teste 1: Login correto ---");

            // Localizar o campo de usuário pelo ID
            // By.id("username") procura um elemento com id="username"
            WebElement campoUsuario = driver.findElement(By.id("username"));

            // Limpar o campo (caso tenha algo digitado) e digitar o usuário
            campoUsuario.clear();
            campoUsuario.sendKeys("admin");
            System.out.println("✓ Usuário digitado: admin");

            // Localizar o campo de senha pelo ID
            WebElement campoSenha = driver.findElement(By.id("password"));
            campoSenha.clear();
            campoSenha.sendKeys("123456");
            System.out.println("✓ Senha digitada: 123456");

            // Localizar e clicar no botão de login
            WebElement botaoLogin = driver.findElement(By.id("loginBtn"));
            botaoLogin.click();
            System.out.println("✓ Botão de login clicado");

            // Esperar pela mensagem de sucesso aparecer
            // ExpectedConditions.visibilityOfElementLocated espera o elemento ficar visível
            WebElement mensagemSucesso = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("successMessage"))
            );

            // Verificar se a mensagem contém o texto esperado
            String textoSucesso = mensagemSucesso.getText();
            System.out.println("✓ Mensagem exibida: " + textoSucesso);

            if (textoSucesso.contains("sucesso")) {
                System.out.println("✅ TESTE 1 PASSOU - Login realizado com sucesso!");
            } else {
                System.out.println("❌ TESTE 1 FALHOU - Mensagem inesperada");
            }

            // Aguardar 3 segundos para visualizar
            Thread.sleep(3000);

            // TESTE 2: Login com dados incorretos
            System.out.println("\n--- Teste 2: Login incorreto ---");

            // Limpar os campos e digitar dados incorretos
            campoUsuario.clear();
            campoUsuario.sendKeys("usuarioerrado");
            System.out.println("✓ Usuário digitado: usuarioerrado");

            campoSenha.clear();
            campoSenha.sendKeys("senhaerrada");
            System.out.println("✓ Senha digitada: senhaerrada");

            // Clicar no botão de login novamente
            botaoLogin.click();
            System.out.println("✓ Botão de login clicado");

            // Esperar pela mensagem de erro aparecer
            WebElement mensagemErro = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage"))
            );

            // Verificar a mensagem de erro
            String textoErro = mensagemErro.getText();
            System.out.println("✓ Mensagem exibida: " + textoErro);

            if (textoErro.contains("incorretos")) {
                System.out.println("✅ TESTE 2 PASSOU - Erro exibido corretamente!");
            } else {
                System.out.println("❌ TESTE 2 FALHOU - Mensagem inesperada");
            }

            // Aguardar para visualizar o resultado
            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("❌ Erro durante o teste: " + e.getMessage());
            e.printStackTrace();

        } finally {
            // Sempre fechar o navegador
            driver.quit();
            System.out.println("\n=== TESTE FINALIZADO ===");
        }
    }
}