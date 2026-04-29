package com.aula.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Exemplos de funcionalidades básicas do Selenium
 * Este programa demonstra várias operações úteis
 */
public class ExemplosBasicos {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Abrir nossa página de teste
            driver.manage().window().maximize();
            String caminhoArquivo = "file:///C:/selenium-aula/pagina-teste.html";
            driver.get(caminhoArquivo);

            System.out.println("=== EXEMPLOS DE FUNCIONALIDADES BÁSICAS ===");

            // Exemplo 1: Obter informações da página
            System.out.println("\n--- Exemplo 1: Informações da página ---");
            System.out.println("Título: " + driver.getTitle());
            System.out.println("URL atual: " + driver.getCurrentUrl());

            // Exemplo 2: Verificar se elementos existem e estão visíveis
            System.out.println("\n--- Exemplo 2: Verificando elementos ---");

            WebElement campoUsuario = driver.findElement(By.id("username"));
            System.out.println("Campo usuário está visível? " + campoUsuario.isDisplayed());
            System.out.println("Campo usuário está habilitado? " + campoUsuario.isEnabled());

            // Exemplo 3: Obter atributos dos elementos
            System.out.println("\n--- Exemplo 3: Atributos dos elementos ---");

            String placeholder = campoUsuario.getAttribute("placeholder");
            System.out.println("Placeholder do campo usuário: " + placeholder);

            String tipoInput = campoUsuario.getAttribute("type");
            System.out.println("Tipo do input: " + tipoInput);

            // Exemplo 4: Trabalhar com CSS
            System.out.println("\n--- Exemplo 4: Informações de CSS ---");

            String corFundo = campoUsuario.getCssValue("background-color");
            System.out.println("Cor de fundo do campo: " + corFundo);

            // Exemplo 5: Capturar screenshot (foto da tela)
            System.out.println("\n--- Exemplo 5: Capturando screenshot ---");

            capturarScreenshot(driver, "C:/selenium-aula/screenshot-teste.png");

            // Exemplo 6: Preencher o formulário e verificar mudanças
            System.out.println("\n--- Exemplo 6: Preenchendo formulário ---");

            campoUsuario.sendKeys("meu_usuario_teste");

            // Verificar o valor que foi digitado
            String valorDigitado = campoUsuario.getAttribute("value");
            System.out.println("Valor no campo usuário: " + valorDigitado);

            // Exemplo 7: Limpar campos
            System.out.println("\n--- Exemplo 7: Limpando campos ---");

            campoUsuario.clear();
            String valorAposLimpar = campoUsuario.getAttribute("value");
            System.out.println("Valor após limpar: '" + valorAposLimpar + "'");

            // Aguardar para visualizar
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("❌ Erro: " + e.getMessage());
            e.printStackTrace();

        } finally {
            driver.quit();
            System.out.println("\n=== EXEMPLOS FINALIZADOS ===");
        }
    }

    /**
     * Método auxiliar para capturar screenshot
     * @param driver - instância do WebDriver
     * @param caminhoArquivo - onde salvar o screenshot
     */
    private static void capturarScreenshot(WebDriver driver, String caminhoArquivo) {
        try {
            // Capturar screenshot como arquivo temporário
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File arquivoTemporario = screenshot.getScreenshotAs(OutputType.FILE);

            // Copiar para o destino desejado
            Files.copy(arquivoTemporario.toPath(), Paths.get(caminhoArquivo));

            System.out.println("✓ Screenshot salvo em: " + caminhoArquivo);

        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar screenshot: " + e.getMessage());
        }
    }
}