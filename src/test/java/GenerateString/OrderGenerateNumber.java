package GenerateString;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderGenerateNumber {

    @Test
    public void generate() {

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

        int Count = 0;
        for (int i = 0; i < Number.size(); i++) {

            for (int x = 0; x < Number.size(); x++) {

                for (int z = 0; z < Number.size(); z++) {

                    for (int c = 0; c < Number.size(); c++) {

                        for (int v = 0; v < Number.size(); v++) {

                            for (int n = 0; n < Number.size(); n++) {
                                System.out.println(Count++ + " " + Number.get(i) + Number.get(x) + Number.get(z) + Number.get(c) + Number.get(v) + Number.get(n));
                            }
                        }
                    }
                }
            }
        }
    }
}
