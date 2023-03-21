package inno.jago.ast;

import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;


// SimpleStmt = EmptyStmt
        // | ExpressionStmt
        // | SendStmt
        // | IncDecStmt
        // | Assignment
        // | ShortVarDecl

// simpleStmt          :   emptyStmt | expressionStmt | sendStmt
//                    |   incDecStmt | assignment | shortVarDecl;
@Getter
@Setter
public class SimpleStatementNode extends Entity {
}
