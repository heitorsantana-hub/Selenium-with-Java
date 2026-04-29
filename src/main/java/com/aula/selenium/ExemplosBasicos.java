package com.aula.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import io.github.bonigarcia.wdm.WebDriverManager;

import javax.swing.plaf.TableHeaderUI;
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
            String caminhoArquivo = "file:///Users/heitorreis/selenium-aula/index.html";
            driver.get(caminhoArquivo);

            System.out.println("=== EXEMPLOS DE FUNCIONALIDADES BÁSICAS ===");

            //Exemplo 1: Obtendo informações da página
            System.out.println("\n--- Exemplo 1: Informações da página ---");
            System.out.println("Título: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());

            Thread.sleep(1000);


            //Exemplo 2: Verificar a existencia dos elementos
            System.out.println("\n--- Exemplo 2: Verificando elementos ---");

            WebElement campoUser = driver.findElement(By.id("username"));
            System.out.println("O campo do usuario está visivel? " + campoUser.isDisplayed());
            System.out.println("O campo do usuario está habilitaod? " + campoUser.isEnabled());

            Thread.sleep(1000);


            // Exemplo 3: Obter atributos dos elementos
            System.out.println("\n--- Exemplo 3: Atributos dos elementos ---");

            String placeholder = campoUser.getAttribute("placeholder");
            System.out.println("Placeholder do usuário: " + placeholder);

            String tipoInput = campoUser.getAttribute("type");
            System.out.println("Tipo do input: " + tipoInput);

            Thread.sleep(1000);


            // Exemplo 4: Trabalhar com CSS
            System.out.println("\n--- Exemplo 4: Informações de CSS ---");

            String corFundo = campoUser.getCssValue("backgound-color");
            System.out.println("Cor de fundo do campo: " + corFundo);

            Thread.sleep(1000);


            // Exemplo 5: Capturar screenshot (foto da tela)
            System.out.println("\n--- Exemplo 5: Capturando screenshot ---");

            capturarScreenshot(driver, "/Users/heitorreis/selenium-aula/screenshot-teste.png");

            Thread.sleep(1000);


            // Exemplo 6: Preencher o formulário e verificar mudanças
            System.out.println("\n--- Exemplo 6: Preenchendo formulário ---");

            campoUser.sendKeys("meu_usuario_teste");

            Thread.sleep(1000);

            // Verificar o valor inserido
            String value = campoUser.getAttribute("value");
            System.out.println("Valor no campo Usuario: " + value);

            // Exemplo 7: Limpar campos
            System.out.println("\n--- Exemplo 7: Limpando campos ---");

            campoUser.clear();
            String valorAposLimpar = campoUser.getAttribute("value");
            System.out.println("Valor após limpar: " + valorAposLimpar);

            Thread.sleep(3000);

        }
        catch (Exception e){
            System.out.println("🚫 Erro: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            driver.quit();
            System.out.println("\n---Exemplos Finalizados ---");
        }
    }

    /**
     * Método auxiliar para capturar screenshot
     * @param driver - instância do WebDriver
     * @param caminhoArquivo - onde salvar o screenshot
     */
    private static void capturarScreenshot(WebDriver driver, String caminhoArquivo) {
        try {

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File fileTemp = screenshot.getScreenshotAs(OutputType.FILE);

            //Copia o arquivo para o destino desejado
            Files.copy(fileTemp.toPath(), Paths.get(caminhoArquivo));

            System.out.println("Print salva em: " + caminhoArquivo);

        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar screenshot: " + e.getMessage());
        }
    }

}
