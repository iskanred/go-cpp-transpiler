package inno.jago.ast.variable;

import inno.jago.ast.entity.Entity;
import inno.jago.ast.expression.ExpressionListNode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// ShortVarDeclarationNode : identifierList DECLARE_ASSIGN expressionList

@Getter
@Setter
public class ShortVarDeclarationNode extends Entity {
    private List<String> identifierList;
    private ExpressionListNode expressionList;

    public ShortVarDeclarationNode(List<String> identifierList, ExpressionListNode expressionList) {
        if (identifierList == null) {
            System.out.println("identifierList should not be null");
            return;
        }

        if (expressionList == null) {
            System.out.println("expressionList should not be null");
            return;
        }
        this.identifierList = identifierList;
        this.expressionList = expressionList;

        this.expressionList.setParent(this);
        Entity.reportParsing("SHORT VARIABLE DECLARATION");
    }

}
