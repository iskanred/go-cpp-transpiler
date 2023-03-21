package inno.jago.ast.switch_.type;

import inno.jago.ast.SimpleStatementNode;
import inno.jago.ast.switch_.SwitchStmtNode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// typeSwitchStmt      :   SWITCH ( simpleStmt END )? typeSwitchGuard L_CURLY ( typeCaseClause )* R_CURLY;
@Getter
@Setter
public class TypeSwitchStatementNode extends SwitchStmtNode {

    private SimpleStatementNode simpleStatementNode;
    private TypeSwitchGuardNode typeSwitchGuardNode;
    private List<TypeCaseNode> typeCaseNode;

}
