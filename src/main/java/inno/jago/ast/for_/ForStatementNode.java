package inno.jago.ast.for_;

import inno.jago.ast.BlockNode;
import inno.jago.ast.entity.Entity;
import inno.jago.ast.ConditionNode;
import lombok.Getter;
import lombok.Setter;

// forStmt             :   FOR ( condition | forClause | rangeClause )? block;

@Getter
@Setter
public class ForStatementNode extends Entity {

    private ConditionNode condition;
    private ForClauseNode forClause;
    private RangeClauseNode rangeClause;
    private BlockNode blockNode;

    public ForStatementNode(BlockNode blockNode){
        if (blockNode == null) {
            System.out.println("Block should not be null");
            return;
        }

        this.blockNode = blockNode;
        this.blockNode.setParent(this);
        Entity.reportParsing("FOR STATEMENT DECLARATION");
    }


    public ForStatementNode(ConditionNode condition, BlockNode blockNode) {
        if (blockNode == null) {
            System.out.println("Block should not be null");
            return;
        }

        if (condition == null){
            System.out.println("Condition should not be null");
            return;
        }

        this.blockNode = blockNode;
        this.blockNode.setParent(this);

        this.condition = condition;
        this.condition.setParent(this);

        Entity.reportParsing("FOR STATEMENT DECLARATION");
    }

    public ForStatementNode(ForClauseNode forClause, BlockNode blockNode) {
        if (blockNode == null) {
            System.out.println("Block should not be null");
            return;
        }

        if (forClause == null){
            System.out.println("forClause should not be null");
            return;
        }

        this.blockNode = blockNode;
        this.blockNode.setParent(this);

        this.forClause = forClause;
        this.forClause.setParent(this);

        Entity.reportParsing("FOR STATEMENT DECLARATION");
    }

    public ForStatementNode(RangeClauseNode rangeClause, BlockNode blockNode) {
        if (blockNode == null) {
            System.out.println("Block should not be null");
            return;
        }

        if (rangeClause == null){
            System.out.println("rangeClause should not be null");
            return;
        }

        this.blockNode = blockNode;
        this.blockNode.setParent(this);

        this.rangeClause = rangeClause;
        this.rangeClause.setParent(this);

        Entity.reportParsing("FOR STATEMENT DECLARATION");
    }

}


// for condition {} << condition
// for {}  <<
// for i := 0; i < 5; i++ {}  << forClause
// for i := range ... {} << rangeClouse