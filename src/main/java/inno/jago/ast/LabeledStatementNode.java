package inno.jago.ast;

import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;


// LabeledStmt = Label ":" Statement

// labeledStmt         :   label COLON statement;
@Getter
@Setter
public class LabeledStatementNode extends Entity {
}
