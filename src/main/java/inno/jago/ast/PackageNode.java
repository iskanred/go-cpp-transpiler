package inno.jago.ast;

import inno.jago.ast.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
packageClause       :   PACKAGE packageName;
packageName         :   IDENTIFIER;
 */
@AllArgsConstructor
public class PackageNode extends Entity {
    @Getter
    @Setter
    private String name;
}
