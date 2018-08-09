package GenerateString;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderGenerateString {

    @Test
    public void generate() {

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


        int Count = 0;
        for (int i = 0; i < alphabet.size(); i++) {

            for (int x = 0; x < alphabet.size(); x++) {

                for (int z = 0; z < alphabet.size(); z++) {

                    for (int c = 0; c < alphabet.size(); c++) {
                        System.out.println(Count++ + " " + alphabet.get(i) + alphabet.get(x) + alphabet.get(z) + alphabet.get(c));
                    }
                }
            }

        }

    }
}
