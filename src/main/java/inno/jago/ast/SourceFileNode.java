package inno.jago.ast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class SourceFileNode extends Entity {

    @Getter
    @Setter
    private PackageNode packageNode;

//    private List<ImportNode>

//    private List<r>

//    packageClause ( END ) ( importDecl ( END ) )* ( topLevelDecl ( END ) )* EOF;
}
