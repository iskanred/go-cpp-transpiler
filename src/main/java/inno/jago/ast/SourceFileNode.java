package inno.jago.ast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class SourceFileNode {

    @Getter
    @Setter
    private PackageNode packageNode;

//    private List<ImportNode>

//    private List<r>

//    packageClause ( END ) ( importDecl ( END ) )* ( topLevelDecl ( END ) )* EOF;
}