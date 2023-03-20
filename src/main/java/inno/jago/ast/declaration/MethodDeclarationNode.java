package inno.jago.ast.declaration;

import inno.jago.ast.BlockNode;
import inno.jago.ast.entity.Entity;
import inno.jago.ast.SignatureNode;
import inno.jago.ast.parameter.ParametersNode;
import lombok.Getter;
import lombok.Setter;

/*
methodDecl          :   FUNC receiver methodName signature ( functionBody )?;
receiver            :   parameters;

receiver = parameters
functionBody = block
 */
@Getter
@Setter
public class MethodDeclarationNode extends Entity {
    private ParametersNode parameters;
    private String methodName;
    private SignatureNode signature;
    private BlockNode functionBody; // optional

    public MethodDeclarationNode(ParametersNode parameters, String methodName, SignatureNode signature) {
        if (parameters == null) {
            System.out.println("parameters should not be null");
            return;
        }
        if (methodName == null) {
            System.out.println("methodName should not be null");
            return;
        }
        if (signature == null) {
            System.out.println("signature should not be null");
            return;
        }
        this.parameters = parameters;
        this.methodName = methodName;
        this.signature = signature;

        this.parameters.setParent(this);
        this.signature.setParent(this);
        Entity.reportParsing("METHOD DECLARATION");
    }

    public MethodDeclarationNode(ParametersNode parameters, String methodName, SignatureNode signature, BlockNode functionBody) {
        this(parameters, methodName, signature);
        if (functionBody != null) {
            this.functionBody = functionBody;
            this.functionBody.setParent(this);
        }
    }
}
