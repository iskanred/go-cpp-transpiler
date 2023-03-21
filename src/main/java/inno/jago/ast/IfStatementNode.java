package inno.jago.ast;

import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

// ifStmt              :   IF ( simpleStmt END )? expression block ( ELSE ( ifStmt | block ) )?;

// IfStmt = "if" ?( SimpleStmt ";" ) Expression Block ? ElsePart
@Getter
@Setter
public class IfStatementNode extends Entity {
}
