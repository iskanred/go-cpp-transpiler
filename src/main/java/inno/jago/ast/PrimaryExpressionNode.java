package inno.jago.ast;

import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

// primaryExpr         :   operand | conversion | methodExpr | primaryExpr selector
//                    |   primaryExpr index | primaryExpr slice | primaryExpr typeAssertion
//	                |   primaryExpr arguments;
@Getter
@Setter
public class PrimaryExpressionNode extends Entity {
}
