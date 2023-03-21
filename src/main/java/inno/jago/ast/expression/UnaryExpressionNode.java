package inno.jago.ast.expression;

import lombok.Getter;
import lombok.Setter;

/*
unaryExpr           :   primaryExpr | unary_op unaryExpr;
 */

@Getter
@Setter
public class UnaryExpressionNode extends ExpressionNode {
    private String operator;
    private ExpressionNode operand;

    public UnaryExpressionNode(String operator, ExpressionNode operand) {
        if (operator == null ) {
            System.out.println("String operator should not be null");
            return;
        }
        if (operand == null) {
            System.out.println("ExpressionNode operand should not be null");
            return;
        }

        this.operator = operator;
        this.operand = operand;

        this.operand.setParent(this);
    }

}
