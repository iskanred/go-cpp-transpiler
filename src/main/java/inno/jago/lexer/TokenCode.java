package inno.jago.lexer;


import inno.jago.GoLexer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TokenCode {

    DUMMY(-2),
    EOS(-1),
    ERROR(-3),
    GENERAL_COMMENT(GoLexer.GENERAL_COMMENT),
    LINE_COMMENT(GoLexer.LINE_COMMENT),
    END(GoLexer.END),
    WHITESPACE(GoLexer.WHITESPACE),
    BREAK(GoLexer.BREAK),
    DEFAULT(GoLexer.DEFAULT),
    FUNC(GoLexer.FUNC),
    INTERFACE(GoLexer.INTERFACE),
    SELECT(GoLexer.SELECT),
    CASE(GoLexer.CASE),
    DEFER(GoLexer.DEFER),
    GO(GoLexer.GO),
    MAP(GoLexer.MAP),
    STRUCT(GoLexer.STRUCT),
    CHAN(GoLexer.CHAN),
    ELSE(GoLexer.ELSE),
    GOTO(GoLexer.GOTO),
    PACKAGE(GoLexer.PACKAGE),
    SWITCH(GoLexer.SWITCH),
    CONST(GoLexer.CONST),
    FALLTHROUGH(GoLexer.FALLTHROUGH),
    IF(GoLexer.IF),
    RANGE(GoLexer.RANGE),
    TYPE(GoLexer.TYPE),
    CONTINUE(GoLexer.CONTINUE),
    FOR(GoLexer.FOR),
    IMPORT(GoLexer.IMPORT),
    RETURN(GoLexer.RETURN),
    VAR(GoLexer.VAR),
    L_PAREN(GoLexer.L_PAREN),
    R_PAREN(GoLexer.R_PAREN),
    L_CURLY(GoLexer.L_CURLY),
    R_CURLY(GoLexer.R_CURLY),
    L_BRACKET(GoLexer.L_BRACKET),
    R_BRACKET(GoLexer.R_BRACKET),
    ASSIGN(GoLexer.ASSIGN),
    COMMA(GoLexer.COMMA),
    SEMI(GoLexer.SEMI),
    COLON(GoLexer.COLON),
    DOT(GoLexer.DOT),
    PLUS_PLUS(GoLexer.PLUS_PLUS),
    MINUS_MINUS(GoLexer.MINUS_MINUS),
    DECLARE_ASSIGN(GoLexer.DECLARE_ASSIGN),
    ELLIPSIS(GoLexer.ELLIPSIS),
    LOGICAL_OR(GoLexer.LOGICAL_OR),
    LOGICAL_AND(GoLexer.LOGICAL_AND),
    EQUALS(GoLexer.EQUALS),
    NOT_EQUALS(GoLexer.NOT_EQUALS),
    LESS(GoLexer.LESS),
    LESS_OR_EQUALS(GoLexer.LESS_OR_EQUALS),
    GREATER(GoLexer.GREATER),
    GREATER_OR_EQUALS(GoLexer.GREATER_OR_EQUALS),
    PLUS(GoLexer.PLUS),
    MINUS(GoLexer.MINUS),
    CARET(GoLexer.CARET),
    ASTERISK(GoLexer.ASTERISK),
    AMPERSAND(GoLexer.AMPERSAND),
    OR(GoLexer.OR),
    DIV(GoLexer.DIV),
    MOD(GoLexer.MOD),
    LSHIFT(GoLexer.LSHIFT),
    RSHIFT(GoLexer.RSHIFT),
    BIT_CLEAR(GoLexer.BIT_CLEAR),
    EXCLAMATION(GoLexer.EXCLAMATION),
    RECEIVE(GoLexer.RECEIVE),
    IDENTIFIER(GoLexer.IDENTIFIER),
    INT_LIT(GoLexer.INT_LIT),
    FLOAT_LIT(GoLexer.FLOAT_LIT),
    IMAGINARY_LIT(GoLexer.IMAGINARY_LIT),
    RUNE_LIT(GoLexer.RUNE_LIT),
    STRING_LIT(GoLexer.STRING_LIT);

    @Getter
    private final int value;
}
