package inno.jago.ast.expression;


import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

/*
 Expression = UnaryExpr | Expression binary_op Expression
 expressionList      :   expression ( COMMA expression )* ;
 */
public abstract class ExpressionNode extends Entity {

}
