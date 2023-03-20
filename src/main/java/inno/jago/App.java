package inno.jago;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        // Init part
        CharStream cs = CharStreams.fromFileName("sample.go");
        GoLexer lexer = new GoLexer(cs);
        CommonTokenStream stream = new CommonTokenStream(lexer);
        GoParser parser = new GoParser(stream);

        parser.sourceFile();

        if (parser.getNumberOfSyntaxErrors() == 0)
            System.out.println("The input GO program is syntactically correct");
        else
            System.out.println("The input GO program has " + parser.getNumberOfSyntaxErrors() + " syntax errors");
    }
}
