package inno.jago.ast.declaration;

import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

/*
topLevelDecl        :   declaration | functionDecl | methodDecl;
 */
@Getter
@Setter
public class TopLevelDeclarationNode extends Entity {

    private DeclarationNode declaration;
    private FunctionDeclarationNode functionDeclaration;
    private MethodDeclarationNode methodDeclaration;

    public TopLevelDeclarationNode(DeclarationNode node) {
        if (node == null) {
            System.out.println("DeclarationNode should not be null");
            return;
        }

        this.declaration = node;
        this.declaration.setParent(this);
        reportParsing();
    }

    public TopLevelDeclarationNode(FunctionDeclarationNode node) {
        if (node == null) {
            System.out.println("FunctionDeclarationNode should not be null");
            return;
        }

        this.functionDeclaration = node;
        this.functionDeclaration.setParent(this);
        reportParsing();
    }

    public TopLevelDeclarationNode(MethodDeclarationNode node) {
        if (node == null) {
            System.out.println("MethodDeclarationNode should not be null");
            return;
        }

        this.methodDeclaration = node;
        this.methodDeclaration.setParent(this);
        reportParsing();
    }

    private static void reportParsing() {
        Entity.reportParsing("TOP_LEVEL DECLARATION");
    }
}
