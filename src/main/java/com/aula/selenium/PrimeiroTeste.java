package com.aula.selenium;

// Importações necessárias
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Primeiro exemplo com Selenium
 * Este programa abre o navegador Chrome e acessa uma página
 */
public class PrimeiroTeste {

    public static void main(String[] args) {
        // Passo 1: Configurar o ChromeDriver automaticamente
        // WebDriverManager baixa e configura o driver do Chrome
        System.out.println("Configurando o ChromeDriver...");
        WebDriverManager.chromedriver().setup();

        // Passo 2: Criar uma instância do WebDriver para Chrome
        // Esta linha abre o navegador Chrome
        System.out.println("Abrindo o navegador Chrome...");
        WebDriver driver = new ChromeDriver();

        try {
            // Passo 3: Maximizar a janela do navegador
            // Isso garante que todos os elementos sejam visíveis
            driver.manage().window().maximize();

            // Passo 4: Navegar para nossa página de teste
            // Substitua pelo caminho correto da sua página HTML
            String caminhoArquivo = "file:///C:/selenium-aula/pagina-teste.html";
            // No Mac/Linux seria: "file:///home/usuario/selenium-aula/pagina-teste.html"

            System.out.println("Navegando para a página de teste...");
            driver.get(caminhoArquivo);

            // Passo 5: Obter e exibir o título da página
            String titulo = driver.getTitle();
            System.out.println("Título da página: " + titulo);

            // Passo 6: Aguardar 5 segundos para visualizar
            // Thread.sleep faz o programa pausar por 5000 milissegundos (5 segundos)
            System.out.println("Aguardando 5 segundos...");
            Thread.sleep(5000);

        } catch (Exception e) {
            // Se ocorrer algum erro, exibe a mensagem
            System.out.println("Erro durante a execução: " + e.getMessage());
            e.printStackTrace();

        } finally {
            // Passo 7: Fechar o navegador (sempre executado)
            // É importante sempre fechar o navegador para liberar recursos
            System.out.println("Fechando o navegador...");
            driver.quit();
        }

        System.out.println("Teste concluído!");
    }
}