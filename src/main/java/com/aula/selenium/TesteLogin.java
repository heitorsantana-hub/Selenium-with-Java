package com.aula.selenium;

/*
    Agora essa classe
    Será para testar o login
    Da página acessada
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;


public class TesteLogin {

    public static void main(String[] args) {
        // Configurar o driver do Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try{
            driver.manage().window().maximize(); //Maximizando a tela para renderizar todos os elementos

            //Caminho da página
            String caminhoArquivo = "file:///Users/heitorreis/selenium-aula/index.html";
            driver.get(caminhoArquivo); //Acessando página

            System.out.println("--- INICIANDO TESTE ---");

            //Esse método espera 10 segundos para um elemento aparecer
            //Assim não deixando que erros aconteçam por conta da velocidade
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            System.out.println("\n--- Teste 1: Login Correto ---");

            //Procurando um elemento usando o id
            WebElement campoUsuario = driver.findElement(By.id("username"));

            //Limpando o campo, se houver qualquer coisa e adicionando o usuario
            campoUsuario.clear();
            campoUsuario.sendKeys("admin");
            System.out.println("Usuario digitado: admin");

            //Procurando elemento usando o id
            WebElement campoSenha = driver.findElement(By.id("password"));
            campoSenha.clear();
            campoSenha.sendKeys("123456");
            System.out.println("Senha digitada: 123456");

            //Procurando elemento usando id
            WebElement botao = driver.findElement(By.id("loginBtn"));
            botao.click();
            System.out.println("Botão de Login clicado");

            //Espera mensagem de sucesso
            WebElement mensagemSucesso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));

            //Pegando o texto e transformando em String
            String textoSucesso = mensagemSucesso.getText();
            System.out.println("Mensagem exibida: " + textoSucesso);

            if (textoSucesso.contains("sucesso")){
                System.out.println("✅ TESTE 1 PASSOU - Login realizado com sucesso!");
            }
            else{
                System.out.println("❌ TESTE 1 FALHOU - Mensagem inesperada");
            }

            //Esperar 3 segundos para visualizar
            Thread.sleep(3000);

            System.out.println("\n--- Teste 2: Login Incorreto ---");


            //Limpando o campo, se houver qualquer coisa e adicionando o usuario
            campoUsuario.clear();
            campoUsuario.sendKeys("usuarioincorreto");
            System.out.println("Usuario digitado: usuarioincorreto");

            //Procurando elemento usando o id
            campoSenha.clear();
            campoSenha.sendKeys("senhaincorreta");
            System.out.println("Senha digitada: senhaincorreta");

            //Procurando elemento usando id
            botao.click();
            System.out.println("Botão de Login clicado");

            //Espera mensagem de sucesso
            WebElement mensagemErro = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage")));

            //Pegando o texto e transformando em String
            String textoErro = mensagemSucesso.getText();
            System.out.println("Mensagem exibida: " + textoErro);

            if (textoErro.contains("incorretos")) {
                System.out.println("✅ TESTE 2 PASSOU - Erro exibido corretamente!");
            } else {
                System.out.println("❌ TESTE 2 FALHOU - Mensagem inesperada");
            }

            //Aguarda visualizar tudo certinho
            Thread.sleep(3000);
        }
        catch (Exception e){
            System.out.println("Captura de erro: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            // Sempre fechar o navegador
            driver.quit();
            System.out.println("\n--- Teste Finalizado ---");
        }

    }

}
