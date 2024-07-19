package info.navidlabs;


public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {return;}
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String inputFile = null;

        switch (args[0]) {
            case "l01t01":
                inputFile = classloader.getResource("test-files/l01-t01.txt").getPath();
                info.navidlabs.L01ExpresionLanguage.TestGrammar g01t01 =
                        new info.navidlabs.L01ExpresionLanguage.TestGrammar();
                try{ g01t01.test01(inputFile); }
                catch (Exception e) { return; }
                break;

            case "l02t01":
                inputFile = classloader.getResource("test-files/l02-t01.txt").getPath();
                info.navidlabs.L02LabeledExpressionLanguage.TestGrammar g02t01 =
                        new info.navidlabs.L02LabeledExpressionLanguage.TestGrammar();
                try{ g02t01.test01(inputFile); }
                catch (Exception e) { return; }
                break;

            case "l02t02":
                inputFile = classloader.getResource("test-files/l02-t01.txt").getPath();
                info.navidlabs.L02LabeledExpressionLanguage.TestGrammar g02t02 =
                        new info.navidlabs.L02LabeledExpressionLanguage.TestGrammar();
                try{ g02t02.test02(inputFile); }
                catch (Exception e) { return; }
                break;
        }
    }
}
