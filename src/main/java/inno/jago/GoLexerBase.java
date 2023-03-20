package inno.jago;

import org.antlr.v4.runtime.*;


public abstract class GoLexerBase extends Lexer {

    /**
     * Type of last token inside visible (not HIDDEN) channel
     */
    private int lastTokenType;


    public GoLexerBase(CharStream input) {
        /*
            Since Antlr does not recognize rules with EOF token inside,
             we have to add line separator to the end of input CharStream
             in the constructor of the lexer
         */
        super(CharStreams.fromString(input.toString() + System.lineSeparator()));
        lastTokenType = -4;
    }


    @Override
    public void emit(Token token) {
        super.emit(token);

        // return type of last token inside visible (not HIDDEN) channel
        if (_channel != HIDDEN)
            lastTokenType = token.getType();
    }


    protected int getLastTokenType() {
        return lastTokenType;
    }
}
