package inno.jago.ast.declaration;

import inno.jago.ast.StatementNode;
import inno.jago.ast.entity.Entity;
import inno.jago.ast.SignatureNode;
import lombok.Getter;
import lombok.Setter;

/*
functionDecl        :   FUNC functionName signature ( functionBody )?;
 */
@Getter
@Setter
public class FunctionDeclarationNode extends Entity {
    private String functionName;

    private SignatureNode signatureNode;

    private StatementNode functionBody;

    public FunctionDeclarationNode(String functionName, SignatureNode signatureNode, StatementNode functionBody) {
        this.functionName = functionName;
        this.signatureNode = signatureNode;
        this.functionBody = functionBody;
    }
}
