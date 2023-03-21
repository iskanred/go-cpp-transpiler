package inno.jago.ast.switch_.expression;

import inno.jago.ast.SimpleStatementNode;
import inno.jago.ast.expression.ExpressionNode;
import inno.jago.ast.switch_.SwitchStmtNode;
import lombok.Getter;
import lombok.Setter;

// exprSwitchStmt      :   SWITCH ( simpleStmt END )? ( expression )? L_CURLY ( exprCaseClause )* R_CURLY;
@Getter
@Setter
public class ExpressionSwitchStatementNode extends SwitchStmtNode {

    private SimpleStatementNode simpleStatementNode;
    private ExpressionNode expressionNode;
    private ExpressionCaseNode expressionCaseNode;
}
