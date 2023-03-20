package inno.jago.ast.constant;

import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/*
constDecl           :   CONST ( constSpec | L_PAREN ( constSpec END )* ( constSpec ( END )? )? R_PAREN );
 */
@Getter
@Setter
public class ConstDeclarationNode extends Entity {

    private List<ConstSpecNode> constSpecs;

    public ConstDeclarationNode(List<ConstSpecNode> constSpecs) {
        if (constSpecs == null) {
            System.out.println("constSpecs should not be null");
            return;
        }
        for (var constSpec : constSpecs) {
            constSpec.setParent(this);
        }
        Entity.reportParsing("CONST DECLARATION");
    }
}
