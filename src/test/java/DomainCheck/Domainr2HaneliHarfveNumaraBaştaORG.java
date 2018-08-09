package DomainCheck;

import BasePackage.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Domainr2HaneliHarfveNumaraBaştaORG extends BaseClass {

    private static String DomainExtension = ".org";

    @Test
    public void CheckDomainTwoDigitCC() throws Exception {

        List<String> alphabet = new ArrayList<String>();
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");
        alphabet.add("d");
        alphabet.add("e");
        alphabet.add("f");
        alphabet.add("g");
        alphabet.add("h");
        alphabet.add("i");
        alphabet.add("j");
        alphabet.add("k");
        alphabet.add("l");
        alphabet.add("m");
        alphabet.add("n");
        alphabet.add("p");
        alphabet.add("r");
        alphabet.add("s");
        alphabet.add("t");
        alphabet.add("u");
        alphabet.add("v");
        alphabet.add("y");
        alphabet.add("z");
        alphabet.add("q");
        alphabet.add("w");
        alphabet.add("x");

        List<String> Number = new ArrayList<String>();
        Number.add("0");
        Number.add("1");
        Number.add("2");
        Number.add("3");
        Number.add("4");
        Number.add("5");
        Number.add("6");
        Number.add("7");
        Number.add("8");
        Number.add("9");


        driver.get("https://domainr.com/");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        FileWriter writer = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\Domainr2HaneliHarfveNumaraBaştaORG.csv");

        for (int i = 0; i < alphabet.size(); i++) {

            for (int x = 0; x < Number.size(); x++) {

                String domain = Number.get(x) + alphabet.get(i);

                WebElement search = driver.findElement(By.id("query"));

                wait.until(visibilityOf(search));
                search.clear();
                search.sendKeys(domain + DomainExtension);
                Thread.sleep(3000);
                String Result = driver.findElement(By.cssSelector("#results > div:nth-child(1)")).getAttribute("class");

                if (Result.equals("result active")) {
                    writer.append('\n');
                    writer.append(domain + DomainExtension + " = Bu domain şuan da kullanılıyor");
                } else if (Result.equals("result undelegated") || Result.equals("result undelegated inactive")) {
                    writer.append('\n');
                    writer.append(domain + DomainExtension + " = BU DOMAIN BOŞTA !!!");
                } else if (Result.equals("result active parked marketed")) {
                    writer.append('\n');
                    writer.append(domain + DomainExtension + " = Bu domain şuan da başka bir kişi/firma tarafından satılık");
                } else if (Result.equals("result reserved") || Result.equals("result undelegated reserved")) {
                    writer.append('\n');
                    writer.append(domain + DomainExtension + " = Bu domain şuan da reserve edilmiş");
                }
                writer.flush();
            }

        }

        writer.close();
    }

}
