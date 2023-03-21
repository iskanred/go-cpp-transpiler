package inno.jago.ast.expression;

import inno.jago.ast.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/*
expressionList      :   expression ( COMMA expression )* ;
 */
@Getter
@Setter
public class ExpressionListNode extends Entity {

    private List<ExpressionNode> expressions;

    public ExpressionListNode(ExpressionNode expression) {
        this(arrayList(expression));
    }

    public ExpressionListNode(List<ExpressionNode> expressions) {
        if (expressions == null || expressions.size() == 0) {
            System.out.println("expressions should not be null nor empty");
            return;
        }

        this.expressions = expressions;

        for (var expression : this.expressions) {
            if (expression == null) {
                System.out.println("expression should not be null");
                return;
            }
            expression.setParent(this);
        }

        Entity.reportParsing("EXPRESSION LIST");
    }

    private static<T> ArrayList<T> arrayList(T element) {
        var list = new ArrayList<T>();
        list.add(element);
        return list;
    }
}
