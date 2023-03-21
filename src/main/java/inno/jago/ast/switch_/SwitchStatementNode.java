package inno.jago.ast.switch_;

import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

// SwitchStmt = ExprSwitchStmt | TypeSwitchStmt

// switchStmt          :   exprSwitchStmt | typeSwitchStmt;
@Getter
@Setter
public class SwitchStatementNode extends Entity {

    private SwitchStmtNode statementNode;
}
