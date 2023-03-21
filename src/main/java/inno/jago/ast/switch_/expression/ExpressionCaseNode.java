package inno.jago.ast.switch_.expression;

import inno.jago.ast.StatementListNode;
import inno.jago.ast.StatementNode;
import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// exprCaseClause      :   exprSwitchCase COLON statementList;
@Getter
@Setter
public class ExpressionCaseNode extends Entity {

    private ExpressionSwitchCaseNode expressionSwitchCaseNode;
    private StatementListNode statementListNode;
}
