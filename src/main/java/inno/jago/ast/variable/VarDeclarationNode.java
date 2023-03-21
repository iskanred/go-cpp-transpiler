package inno.jago.ast.variable;

import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// VarDecl = "var" VarSpec | "var" "(" *( VarSpec ";" ) ")"
// varDecl             :   VAR ( varSpec | L_PAREN ( ( varSpec END ) )* ( varSpec ( END )? )? R_PAREN );
@Getter
@Setter
public class VarDeclarationNode extends Entity {

    private List<VarSpecNode> varSpecs;

    public VarDeclarationNode(List<VarSpecNode> varSpecs) {
        if (varSpecs == null) {
            System.out.println("varSpecs should not be null");
            return;
        }
        for (var varSpec : varSpecs) {
            varSpec.setParent(this);
        }
        Entity.reportParsing("VARIABLE DECLARATION");
    }

}
