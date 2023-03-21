package inno.jago.ast.switch_.type;

import inno.jago.ast.PrimaryExpressionNode;
import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

// typeSwitchGuard     :   ( IDENTIFIER DECLARE_ASSIGN )? primaryExpr DOT L_PAREN TYPE R_PAREN;
@Getter
@Setter
public class TypeSwitchGuardNode extends Entity {

    private String identifier;
    private PrimaryExpressionNode primaryExpressionNode;
    private String type; // todo: точно String?
}
