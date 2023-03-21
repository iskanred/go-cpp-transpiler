package inno.jago.ast.declaration;

import inno.jago.ast.entity.Entity;
import inno.jago.ast.constant.ConstDeclarationNode;
import inno.jago.ast.variable.VarDeclarationNode;
import lombok.Getter;
import lombok.Setter;

// Declaration = ConstDecl | TypeDecl | VarDecl
@Getter
@Setter
public class DeclarationNode extends Entity {

    private ConstDeclarationNode constDecl;
    private TypeDeclarationNode typeDecl;
    private VarDeclarationNode varDecl;

    public DeclarationNode(ConstDeclarationNode node) {
        if (node == null) {
            System.out.println("ConstDeclarationNode should not be null");
            return;
        }

        this.constDecl = node;
        this.constDecl.setParent(this);
        Entity.reportParsing("DECLARATION");
    }

    public DeclarationNode(TypeDeclarationNode node) {
        if (node == null) {
            System.out.println("TypeDeclarationNode should not be null");
            return;
        }

        this.typeDecl = node;
        this.typeDecl.setParent(this);
        Entity.reportParsing("DECLARATION");
    }

    public DeclarationNode(VarDeclarationNode node) {
        if (node == null) {
            System.out.println("VarDeclarationNode should not be null");
            return;
        }

        this.varDecl = node;
        this.varDecl.setParent(this);
        Entity.reportParsing("DECLARATION");
    }

}
