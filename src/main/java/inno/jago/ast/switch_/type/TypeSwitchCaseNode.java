package inno.jago.ast.switch_.type;

import inno.jago.ast.entity.Entity;
import inno.jago.ast.expression.ExpressionListNode;
import lombok.Getter;
import lombok.Setter;

// CASE typeList | DEFAULT;

@Getter
@Setter
public class TypeSwitchCaseNode extends Entity {

    private TypeListNode typeListNode;
}