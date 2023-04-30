package inno.jago.semantic.analyzer.expression

import inno.jago.ast.model.expression.ExpressionNode
import inno.jago.ast.model.expression.unary_expression.ApplicationExpressionNode
import inno.jago.ast.model.expression.unary_expression.ConversionNode
import inno.jago.ast.model.expression.unary_expression.IndexExpressionNode
import inno.jago.ast.model.expression.unary_expression.PrimaryExpressionNode
import inno.jago.ast.model.expression.unary_expression.SelectorExpressionNode
import inno.jago.ast.model.expression.unary_expression.UnaryExpressionNode
import inno.jago.ast.model.expression.unary_expression.UnaryOrPrimaryExpression
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.ExpressionOperandNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.LiteralOperandNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.OperandNameNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.OperandNode
import inno.jago.ast.model.type.ArrayTypeNode
import inno.jago.exception.UnreachableCodeException
import inno.jago.semantic.NoSuchVariableInCurrentScopeException
import inno.jago.semantic.WrongTypeException
import inno.jago.semantic.model.EntityType
import inno.jago.semantic.model.ScopeNode
import inno.jago.semantic.model.SemanticEntity
import inno.jago.semantic.model.Type
import java.beans.Expression

fun UnaryOrPrimaryExpression.toSemanticEntity(scope: ScopeNode): SemanticEntity = when (this) {
    is UnaryExpressionNode -> toSemanticEntity(scope)
    is PrimaryExpressionNode -> toSemanticEntity(scope)
}

fun UnaryExpressionNode.toSemanticEntity(scope: ScopeNode): SemanticEntity {
    TODO()
}

@Suppress("CyclomaticComplexMethod")
fun PrimaryExpressionNode.toSemanticEntity(scope: ScopeNode): SemanticEntity = when (this) {
    is ExpressionOperandNode -> toSemanticEntity(scope)
    is ConversionNode -> TODO()
    is IndexExpressionNode -> toSemanticEntity(scope)
    is SelectorExpressionNode -> TODO()
    is ApplicationExpressionNode -> TODO()
    // делает iskanred
    is LiteralOperandNode -> toSemanticEntity(scope)
    is OperandNameNode -> toSemanticEntity(scope)
    is OperandNode -> TODO()
    else -> throw UnreachableCodeException()
}

fun IndexExpressionNode.toSemanticEntity(scope: ScopeNode): SemanticEntity  {
    val expr = primaryExpression.toSemanticEntity(scope)
    val index = expression.toSemanticEntity(scope)

    if (index.type !is Type.IntegerType) {
        throw WrongTypeException(Type.IntegerType, index)
    }

    if (expr.identifier != null) {
        val exprFromScope = scope.findVisibleEntity(expr.identifier)
        if (exprFromScope != null) {
            if (exprFromScope.type != expr.type) {
                throw WrongTypeException(Type.ArrayType(-1, Type.AnyType), index)
            }
        } else {
            throw NoSuchVariableInCurrentScopeException(expr.identifier, pos)
        }
    }

    if (expr.type !is Type.ArrayType) {
        throw WrongTypeException(Type.ArrayType(-1, Type.AnyType), index)
    }

    return SemanticEntity(expr.type, pos, EntityType.EXPRESSION)
}