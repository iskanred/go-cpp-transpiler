package inno.jago.ast.constant;

import inno.jago.ast.entity.Entity;
import inno.jago.ast.TypeNode;
import inno.jago.ast.expression.ExpressionListNode;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/*
constSpec           :   identifierList ( ( type )? ASSIGN expressionList )?;
 */
@Getter
@Setter
public class ConstSpecNode extends Entity {
    private List<String> identifierList;
    private TypeNode type;
    private ExpressionListNode expressionList;

    public ConstSpecNode(List<String> identifierList) {
        if (identifierList == null) {
            System.out.println("identifierList should not be null");
            return;
        }
        this.identifierList = identifierList;
        Entity.reportParsing("CONST SPEC");
    }

    public ConstSpecNode(List<String> identifierList, TypeNode type, ExpressionListNode expressionList) {
        this(identifierList);
        this.type = type;
        this.expressionList = expressionList;

        if (this.type != null) {
            this.type.setParent(this);
        }
        if (this.expressionList != null) {
            this.expressionList.setParent(this);
        }
    }
}
