package info.navidlabs.L01ExpresionLanguage;

import info.navidlabs.L01ExpresionLanguage.gen.ExprLexer;
import info.navidlabs.L01ExpresionLanguage.gen.ExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class TestGrammar {
	public static void test01(String inputFile) throws Exception {
		InputStream is = new FileInputStream(inputFile);
		ANTLRInputStream input = new ANTLRInputStream(is);
		ExprLexer lexer = new ExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprParser parser = new ExprParser(tokens);
		ParseTree tree = parser.prog(); // parse; start at prog
		System.out.println(tree.toStringTree(parser)); // print tree as text
	}
}