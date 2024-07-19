package info.navidlabs.L02LabeledExpressionLanguage;

import info.navidlabs.L02LabeledExpressionLanguage.gen.LabeledExprLexer;
import info.navidlabs.L02LabeledExpressionLanguage.gen.LabeledExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class TestGrammar {
	public static void test01(String inputFile) throws Exception {
		InputStream is = new FileInputStream(inputFile);
		ANTLRInputStream input = new ANTLRInputStream(is);
		LabeledExprLexer lexer = new LabeledExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LabeledExprParser parser = new LabeledExprParser(tokens);
		ParseTree tree = parser.prog(); // parse; start at prog
		System.out.println(tree.toStringTree(parser)); // print tree as text
	}
}
