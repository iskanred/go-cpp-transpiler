package inno.jago.ast;
/*
statement           :   declaration | labeledStmt | simpleStmt
                    |   goStmt | returnStmt | breakStmt | continueStmt
                    |   gotoStmt | fallthroughStmt | block | ifStmt
                    |   switchStmt | selectStmt | forStmt | deferStmt;
 */

import inno.jago.ast.*;
import inno.jago.ast.declaration.DeclarationNode;
import inno.jago.ast.entity.Entity;
import inno.jago.ast.for_.ForStatementNode;
import inno.jago.ast.switch_.SwitchStatementNode;

public class StatementNode extends Entity {
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
