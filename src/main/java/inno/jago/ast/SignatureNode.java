package inno.jago.ast;

import inno.jago.ast.entity.Entity;
import inno.jago.ast.parameter.ParametersNode;
import lombok.Getter;
import lombok.Setter;

/*
 * signature           :   parameters ( result )?;
*/
@Getter
@Setter
public class SignatureNode extends Entity {
    private ParametersNode parameters;
    private ResultNode result;

    public SignatureNode(ParametersNode parameters) {
        if (parameters == null) {
            System.out.println("parameters should not be null");
            return;
        }
        this.parameters = parameters;
        this.parameters.setParent(this);
        Entity.reportParsing("SIGNATURE");
    }

    public SignatureNode(ParametersNode parameters, ResultNode result) {
        this(parameters);
        if (result != null) {
            result.setParent(this);
        }
    }
}
