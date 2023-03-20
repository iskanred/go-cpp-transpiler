package inno.jago.ast;

import inno.jago.ast.declaration.TopLevelDeclarationNode;
import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*
sourceFile          :   packageClause ( END ) ( importDecl ( END ) )* ( topLevelDecl ( END ) )* EOF;
 */
@Getter
@Setter
public class SourceFileNode extends Entity {

    @Getter
    @Setter
    private PackageNode packageNode;

    private List<ImportNode> imports;

    private List<TopLevelDeclarationNode> topLevelDeclarations;

    // todo: add constructor base on optionality
}
