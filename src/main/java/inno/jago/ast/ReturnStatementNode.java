package inno.jago.ast;

import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;


// ReturnStmt = "return" ?ExpressionList

// returnStmt          :   RETURN ( expressionList )?;
@Getter
@Setter
public class ReturnStatementNode extends Entity {
}
