package inno.jago.cppgen.statement

import inno.jago.ast.model.statement.AddOpSimpleAssignOperatorNode
import inno.jago.ast.model.statement.AssignmentNode
import inno.jago.ast.model.statement.EmptyStatementNode
import inno.jago.ast.model.statement.ExpressionStatementNode
import inno.jago.ast.model.statement.IncDecStatementNode
import inno.jago.ast.model.statement.MulOpSimpleAssignOperatorNode
import inno.jago.ast.model.statement.ShortVarDeclNode
import inno.jago.ast.model.statement.SimpleAssignOperatorNode
import inno.jago.ast.model.statement.SimpleStatementNode
import inno.jago.cppgen.expression.binary_expression.translateToCode
import inno.jago.cppgen.expression.translateToCode
import inno.jago.cppgen.type.translateToCode
import java.util.UUID

fun SimpleStatementNode.translateToCode(): String = when (this) {
    is AssignmentNode -> translateToCode() + ";"
    is EmptyStatementNode -> ";"
    is ExpressionStatementNode -> expression.translateToCode() + ";"
    is IncDecStatementNode -> translateToCode() + ";"
    is ShortVarDeclNode -> translateToCode() + ";"
}

fun AssignmentNode.translateToCode(): String {
    val translatedLeftExpressions = leftExpressions.map { it.translateToCode() }
    val translatedRightExpressions = rightExpressions.map { it.translateToCode() }

    var res = ""
    if (leftExpressions.size != rightExpressions.size) {
        res = "tie(${leftExpressions.joinToString()}) = ${rightExpressions.first()}"
    } else {
        translatedLeftExpressions.zip(translatedRightExpressions).forEach { (lhs, rhs) ->
            res += when (val it = assignOperator) {
                is SimpleAssignOperatorNode -> "$lhs = $rhs"
                is AddOpSimpleAssignOperatorNode -> "$lhs ${it.addOperator.translateToCode()}= $rhs"
                is MulOpSimpleAssignOperatorNode -> "$lhs ${it.mulOperator.translateToCode()}= $rhs"
            }
        }
    }

    return res
}

fun IncDecStatementNode.translateToCode(): String = when (type) {
    IncDecStatementNode.IncDec.INC -> "${expression.translateToCode()}++"
    IncDecStatementNode.IncDec.DEC -> "${expression.translateToCode()}--"
}

fun ShortVarDeclNode.translateToCode(): String {
    if (identifierList.size != expression.size) {
        TODO("Сделать для кортежей")
//        uniqueName = UUID.randomUUID().toString();
//        res += "auto $uniqueName = ${rightExpressions.first()}"
//        for (i in 0 until this.leftExpressions.size) {
//            res += ""
//        }
    }

    var res = ""
    identifierList.zip(expression.map { it.translateToCode() }).forEach { (identifier, expressionCode) ->
        if (identifier != "_") {
            res += "auto $identifier = $expressionCode"
        }
    }

    return res
}

