package inno.jago.ast.for_;

import inno.jago.ast.entity.Entity;
import inno.jago.ast.expression.ExpressionListNode;
import inno.jago.ast.expression.ExpressionNode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
// rangeClause         :   ( expressionList ASSIGN | identifierList DECLARE_ASSIGN )? RANGE expression;
@Getter
@Setter
public class RangeClauseNode extends Entity {
    private ExpressionListNode expressionList;
    private List<String> identifierList;
    private ExpressionNode expressionNode;

    public RangeClauseNode(ExpressionNode expressionNode){
        if (expressionNode == null){
            System.out.println("expressionNode should not be null");
            return;
        }

        this.expressionNode = expressionNode;
        this.expressionNode.setParent(this);
        Entity.reportParsing("RANGE ClAUSE NODE");
    }

    public RangeClauseNode(ExpressionListNode expressionList, ExpressionNode expressionNode){

    }

    public RangeClauseNode(List<String>e identifierList, ExpressionNode expressionNode){

    }
}




