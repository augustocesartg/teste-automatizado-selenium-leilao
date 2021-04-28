package br.com.augustogiacomini.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class LeiloesPage {

    private static final String URL_LEILOES_NEW = "http://localhost:8080/leiloes/new";

    private WebDriver browser;

    public LeiloesPage(WebDriver browser) {
        this.browser = browser;
    }

    void quit() {
        this.browser.quit();
    }

    public CadastroLeilaoPage navigateToNewLeilao() {
        this.browser.navigate().to(URL_LEILOES_NEW);
        return new CadastroLeilaoPage(browser);
    }
}
