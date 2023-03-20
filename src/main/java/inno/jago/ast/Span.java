package inno.jago.ast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Span {
    @Getter
    @Setter
    private Pos begin;

    @Getter
    @Setter
    private Pos end;

    public Span(Span span) {
        begin = span.begin;
        end = span.end;
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
