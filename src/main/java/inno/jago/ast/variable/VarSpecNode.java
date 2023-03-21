package inno.jago.ast.variable;

import inno.jago.ast.TypeNode;
import inno.jago.ast.entity.Entity;
import inno.jago.ast.expression.ExpressionListNode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// VarSpec = IdentifierList Type | IdentifierList Type "=" ExpressionList | IdentifierList "=" ExpressionList
// varSpec : identifierList ( type ( ASSIGN expressionList )? | ASSIGN expressionList );

// a, b, c ( int ( = 1, 2, 3)? | = 1, 2, 3)

@Getter
@Setter
public class VarSpecNode extends Entity {
    private List<String> identifierList;
    private TypeNode type;
    private ExpressionListNode expressionList;

    public VarSpecNode(List<String> identifierList) {
        if (identifierList == null) {
            System.out.println("identifierList should not be null");
            return;
        }
        this.identifierList = identifierList;
        Entity.reportParsing("VARIABLE SPEC");
    }

    public VarSpecNode(List<String> identifierList, TypeNode type, ExpressionListNode expressionList) {
        this(identifierList);
        this.type = type;
        this.expressionList = expressionList;

        if (this.type != null) {
            this.type.setParent(this);
        }
        if (this.expressionList != null) {
            this.expressionList.setParent(this);
        }
        Entity.reportParsing("VARIABLE SPEC");
    }
}
