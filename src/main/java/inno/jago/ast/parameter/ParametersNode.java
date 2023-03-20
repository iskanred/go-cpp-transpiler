package inno.jago.ast.parameter;

import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*
parameters          :   L_PAREN ( parameterList ( COMMA )? )? R_PAREN;
parameterList       :   parameterDecl ( COMMA parameterDecl )*;
 */
@Getter
@Setter
public class ParametersNode extends Entity {
    // optional
    private List<ParameterDeclarationNode> parameterList;

    public ParametersNode(List<ParameterDeclarationNode> parameterList) {
        this.parameterList = parameterList;
        if (parameterList != null) {
            for (var param : parameterList) {
                param.setParent(this);
            }
        }
        Entity.reportParsing("PARAMETERS");
    }
}
