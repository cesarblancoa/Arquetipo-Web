package com.google.generarPdf.po;

import com.google.generarPdf.dal.dto.DatosDTO;
import com.google.generarPdf.utils.Configuracion;
import com.google.generarPdf.utils.Selenium;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InicioPO {

    @FindBy(name="q")
    private WebElement searchTextBox;

    @FindBy(xpath="//*[@id=\"sbtc\"]/button")
    private WebElement searchButton;

    @FindBy(xpath="//*[@id=\"islrg\"]/div[1]/div[1]/a[1]/div[1]/img")
    private WebElement primeraImagen;


    public static WebDriver driver = Configuracion.driver;
    public static Actions act = new Actions(driver);

    public InicioPO() {
        PageFactory.initElements(driver, this);
    }

    public InicioPO buscarImagen(DatosDTO item) throws NoSuchElementException {
        searchTextBox.sendKeys(item.getItem()+ Keys.ENTER);
        return this;
    }

    public boolean descargarImagen() throws NoSuchElementException {
       /* act.contextClick(primeraImagen).pause(1000).sendKeys(
                Keys.ARROW_DOWN, Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ARROW_DOWN,Keys.ARROW_RIGHT,Keys.ARROW_DOWN, Keys.ARROW_DOWN,Keys.ARROW_RIGHT
        ).pause(500).sendKeys(Keys.ENTER).build().perform();
        */
        return true;
    }

    private void esperarPagina() {
        Selenium.esperarElemento("q","name",15);
    }
}
