package inno.jago.ast.expression;

import inno.jago.lexer.Token;
import inno.jago.lexer.TokenCode;
import lombok.AllArgsConstructor;

/*
binary_op           :   LOGICAL_OR | LOGICAL_AND | rel_op | add_op | mul_op;
rel_op              :   EQUALS | NOT_EQUALS | LESS | LESS_OR_EQUALS | GREATER | GREATER_OR_EQUALS;
add_op              :   PLUS | MINUS | OR | CARET;
mul_op              :   ASTERISK | DIV | MOD | LSHIFT | RSHIFT | AMPERSAND | BIT_CLEAR;

unary_op            :   PLUS | MINUS | EXCLAMATION | CARET | ASTERISK | AMPERSAND | RECEIVE;
 */
@AllArgsConstructor
public enum Operator {
    LOGICAL_OR(TokenCode.LOGICAL_OR),
    LOGICAL_AND(TokenCode.LOGICAL_AND),
    EQUALS(TokenCode.EQUALS),
    NOT_EQUALS(TokenCode.NOT_EQUALS),
    LESS,
    LESS_OR_EQUAL,
    GREATER,
    GREATER_OR_EQALS,
    PLUS,
    MINUS,
    OR,
    CARET,
    ASTERISK,
    DIV,
    MOD,
    LSHIFT,
    RSHIFT,
    AMPERSAND,
    BIT_CLEAR,
    EXCLAMATION,
    RECEIVE

    private final TokenCode tokenCode;
}
