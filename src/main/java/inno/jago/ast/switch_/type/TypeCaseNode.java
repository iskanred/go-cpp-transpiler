package inno.jago.ast.switch_.type;

import inno.jago.ast.StatementListNode;
import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

// typeSwitchCase COLON statementList;
@Getter
@Setter
public class TypeCaseNode extends Entity {

    private TypeSwitchCaseNode typeSwitchCaseNode;
    private StatementListNode statementListNode;
}
