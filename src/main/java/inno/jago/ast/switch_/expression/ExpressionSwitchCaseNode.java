package inno.jago.ast.switch_.expression;

import inno.jago.ast.entity.Entity;
import inno.jago.ast.expression.ExpressionListNode;
import inno.jago.ast.expression.ExpressionNode;
import lombok.Getter;
import lombok.Setter;

// exprSwitchCase      :   CASE expressionList | DEFAULT;
@Getter
@Setter
public class ExpressionSwitchCaseNode extends Entity {

    private ExpressionListNode expressionListNode;
}
