package inno.jago.ast.expression;

import inno.jago.ast.entity.Entity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpressionListNode extends Entity {

    private List<ExpressionNode> expressions;

    public ExpressionListNode(List<ExpressionNode> expressions) {
        this.expressions = expressions;
    }

}
