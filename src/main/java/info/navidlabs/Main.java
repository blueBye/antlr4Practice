package info.navidlabs;

import info.navidlabs.L02LabeledExpressionLanguage.TestGrammar;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {return;}
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        switch (args[0]) {
            case "l02":
                String inputFile = classloader.getResource("test-files/l02-t01.txt").getPath();
                TestGrammar g = new TestGrammar();
                try{ g.test01(inputFile); }
                catch (Exception e) { return; }
                break;
        }
    }
}