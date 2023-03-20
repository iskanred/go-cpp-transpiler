package inno.jago.ast.parameter;

import inno.jago.ast.entity.Entity;
import inno.jago.ast.TypeNode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*
parameterDecl       :   ( identifierList )? ( ELLIPSIS )? type;
 */
@Getter
@Setter
public class ParameterDeclarationNode extends Entity {
    private List<String> identifierList;
    private TypeNode type;
    private boolean ellipsisSign;

    public ParameterDeclarationNode(TypeNode type) {
        if (type == null) {
            System.out.println("ParameterDeclarationNode should not be null");
            return;
        }
        this.type = type;
        this.type.setParent(type);
        Entity.reportParsing("PARAMETER DECLARATION");
    }

    public ParameterDeclarationNode(List<String> identifierList, TypeNode type, boolean ellipsisSign) {
        this(type);
        this.identifierList = identifierList;
        this.ellipsisSign = ellipsisSign;
    }
}
