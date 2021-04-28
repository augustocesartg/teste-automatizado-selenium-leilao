package br.com.augustogiacomini.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class LeilaoPage {

    private static final String URL_LOGIN = "http://localhost:8080/login";

    private WebDriver browser;

    LeilaoPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
    }

    void quit() {
        this.browser.quit();
    }

    void fillFormLogin(String username, String password) {
        this.browser.findElement(By.id("username")).sendKeys(username);
        this.browser.findElement(By.id("password")).sendKeys(password);
    }

    void submitFormLogin() {
        this.browser.findElement(By.id("login-form")).submit();
    }

    boolean isLoginPage() {
        return this.browser.getCurrentUrl().equals(URL_LOGIN);
    }

    String getUsernameLogged() {
        try {
            return this.browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    boolean isUserOrPasswordInvalid() {
        return this.browser.getPageSource().contains("Usuário e senha inválidos.");
    }

    void redirectToLeiloesPage() {
        this.browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    boolean isLoginErrorPage() {
        return this.browser.getCurrentUrl().equals(URL_LOGIN + "?error");
    }
}
