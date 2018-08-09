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

public class Domainr5HaneliNumaraCC extends BaseClass {

    private static String DomainExtension = ".cc";

    @Test
    public void CheckDomainTwoDigitCC() throws Exception {

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
        FileWriter writer = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\Domainr5HaneliNumaraCC.csv");

        for (int i = 0; i < Number.size(); i++) {

            for (int c = 0; c < Number.size(); c++) {

                for (int b = 0; b < Number.size(); b++) {

                    for (int n = 0; n < Number.size(); n++) {

                        for (int x = 0; x < Number.size(); x++) {

                            String domain = Number.get(i) + Number.get(c) + Number.get(b) + Number.get(n) + Number.get(x);

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
                }
            }
        }
        writer.close();
    }
}
