package inno.jago.lexer;

import lombok.Setter;

public class Token {
    @Setter
    public Span span;
    public String image;
    public TokenCode code;
    public Object value;

    public Token(TokenCode c) {
        code = c;
    }

    public Token(TokenCode c, String i) {
        this(c);
        this.image = i;
    }

    public Token(TokenCode c, String i, Object v) {
        this(c, i);
        this.value = v;
    }

    public void report() {
        this.span.report();
        System.out.print(" " + code.toString() + " ");
        if (image != null) {
            System.out.print(image + " ");
        }
        if (value != null) {
            System.out.print(value);
        }
    }
}
