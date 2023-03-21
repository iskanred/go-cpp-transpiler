package inno.jago.ast;

import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


// statementList       :   ( statement END )* (statement (END)?)?;
@Getter
@Setter
public class StatementListNode extends Entity {
    private List<StatementNode> statementNodeList;
}
