package com.aula.selenium;

/*
    Criando os primeiros testes com Selenium
    Esse programa deve abrir o chrome e abrir uma página
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.ExecutionException;

public class PrimeiroTeste {

    public static void main(String[] args) {
        System.out.println("Configurando o ChromeDriver...");
        WebDriverManager.chromedriver().setup(); //Apenas configuração do ChromeDriver

        WebDriver driver = new ChromeDriver();

        try{
            //Esse método embaixo maximiza a tela do navegador
            //Assim capturando todos os elementos com sucesso
            driver.manage().window().maximize();

            String caminhoArquivo = "file:///Users/heitorreis/selenium-aula/index.html";

            //Método get faz com que o navegador acesse alguma página
            System.out.println("Abrindo página do teste");
            driver.get(caminhoArquivo);

            //Obtendo titulo da página
            String title = driver.getTitle();
            System.out.println("Nome da página: " + title);

            //Aguardando 5 segundos para ele visualizar a página completa
            System.out.println("Aguardando 5 segundos...");
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println("Erro durante a execução: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            System.out.println("Fechando o navegador");
            driver.quit(); //Método fecha o navegadors
        }
    }

}
