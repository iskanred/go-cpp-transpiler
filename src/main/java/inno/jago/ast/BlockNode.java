package inno.jago.ast;
/*
statement           :   declaration | labeledStmt | simpleStmt
                    |   goStmt | returnStmt | breakStmt | continueStmt
                    |   gotoStmt | fallthroughStmt | block | ifStmt
                    |   switchStmt | selectStmt | forStmt | deferStmt;
 */

import inno.jago.ast.declaration.DeclarationNode;
import inno.jago.ast.entity.Entity;

public class BlockNode extends Entity {
    // or
    DeclarationNode declarationNode;
    LabeledStatementNode labeledStatementNode;
    SimpleStatementNode simpleStatementNode;
    GoStatementNode goStatementNode;
    ReturnStatementNode returnStatementNode;
    FallthroughNode fallthroughNode; // terminal
    BlockNode blockNode;
    IfStatementNode ifStatementNode;
    SwitchStatementNode switchStatementNode;
    SelectStatementNode selectStatementNode;
    ForStatementNode forStatementNode;
    DeferStatementNode deferStatementNode;
}
