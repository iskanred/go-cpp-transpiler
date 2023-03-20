package inno.jago.ast.expression;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryExpressionNode extends ExpressionNode {
    private String operator;
    private ExpressionNode leftOperand;
    private ExpressionNode rightOperand;

    public BinaryExpressionNode(String operator, ExpressionNode leftOperand, ExpressionNode rightOperand) {
        if (operator == null ) {
            System.out.println("String operator should not be null");
            return;
        }
        if (leftOperand == null) {
            System.out.println("ExpressionNode leftOperand should not be null");
            return;
        }
        if (rightOperand == null) {
            System.out.println("ExpressionNode rightOperand should not be null");
            return;
        }

        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;

        this.leftOperand.setParent(this);
        this.rightOperand.setParent(this);
    }
}
