package inno.jago.ast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class SourceFileNode {

    @Getter
    @Setter
    private List<PackageNode> packages;

//    private List<r>

//    packageClause ( END ) ( importDecl ( END ) )* ( topLevelDecl ( END ) )* EOF;
}
