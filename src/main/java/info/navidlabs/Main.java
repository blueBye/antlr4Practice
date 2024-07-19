package info.navidlabs;


public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {return;}
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String inputFile = null;

        switch (args[0]) {
            case "l01":
                inputFile = classloader.getResource("test-files/l01-t01.txt").getPath();
                info.navidlabs.L01ExpresionLanguage.TestGrammar g01 =
                        new info.navidlabs.L01ExpresionLanguage.TestGrammar();
                try{ g01.test01(inputFile); }
                catch (Exception e) { return; }
                break;

            case "l02":
                inputFile = classloader.getResource("test-files/l02-t01.txt").getPath();
                info.navidlabs.L02LabeledExpressionLanguage.TestGrammar g02 =
                        new info.navidlabs.L02LabeledExpressionLanguage.TestGrammar();
                try{ g02.test01(inputFile); }
                catch (Exception e) { return; }
                break;
        }
    }
}
