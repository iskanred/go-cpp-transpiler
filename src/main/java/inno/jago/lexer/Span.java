package inno.jago.lexer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Span {

    private Pos begin;

    private Pos end;

    public Span(Pos b, Pos e) {
        begin = b;
        end = e;
    }

    public Span(Span span) {
        begin = span.begin;
        end = span.end;
    }

    public Span(Token token) {
        begin = token.span.begin;
        end = token.span.end;
    }

    public Span(Token b, Token e) {
        begin = b.span.begin;
        end = e.span.end;
    }

    public void report() {
        System.out.print("(");
        begin.report();
        System.out.print(",");
        end.report();
        System.out.print(")");
    }

    @Override
    public String toString() {
        return "Line " + begin.getLine() + ", Char " + begin.getSymbol();
    }
}
