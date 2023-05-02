@file:Suppress("TooManyFunctions")
package inno.jago.semantic.analyzer.expression

import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.literal_operand.BasicLiteralNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.literal_operand.BoolLiteralNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.literal_operand.CompositeLiteralNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.literal_operand.DoubleLiteralNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.literal_operand.ElementNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.literal_operand.ExpressionElementNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.literal_operand.FunctionLiteralNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.literal_operand.IntegerLiteralNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.literal_operand.LiteralNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.literal_operand.LiteralValueElementNode
import inno.jago.ast.model.expression.unary_expression.primary_expression.operand.literal_operand.StringLiteralNode
import inno.jago.semantic.SemanticException
import inno.jago.semantic.analyzer.signature.toSemanticEntity
import inno.jago.semantic.analyzer.signature.toType
import inno.jago.semantic.analyzer.statement.toSemanticEntity
import inno.jago.semantic.model.ExpressionEntity
import inno.jago.semantic.model.ScopeNode
import inno.jago.semantic.model.Type
import inno.jago.semantic.model.toType

fun LiteralNode.toSemanticEntity(scope: ScopeNode): ExpressionEntity = when(this) {
    is BasicLiteralNode -> toSemanticEntity()
    is CompositeLiteralNode -> toSemanticEntity(scope)
    is FunctionLiteralNode -> toSemanticEntity(scope)
}

private fun BasicLiteralNode.toSemanticEntity(): ExpressionEntity = when(this) {
    is IntegerLiteralNode -> toSemanticEntity()
    is DoubleLiteralNode -> toSemanticEntity()
    is StringLiteralNode -> toSemanticEntity()
    is BoolLiteralNode -> toSemanticEntity()
}

private fun IntegerLiteralNode.toSemanticEntity() = ExpressionEntity(type = Type.IntegerType)

private fun DoubleLiteralNode.toSemanticEntity() = ExpressionEntity(type = Type.DoubleType)

private fun StringLiteralNode.toSemanticEntity() = ExpressionEntity(type = Type.StringType)

private fun BoolLiteralNode.toSemanticEntity() = ExpressionEntity(type = Type.BoolType)

private fun CompositeLiteralNode.toSemanticEntity(scope: ScopeNode): ExpressionEntity {
    val isAllIntElements = literalValue.elements
        .flatMap { it.toSemanticEntities(scope) }
        .all { it.type == Type.IntegerType }

    if (!isAllIntElements) {
        throw SemanticException("All array elements must be of type int")
    }

    return ExpressionEntity(type = literal.toType())
}

private fun ElementNode.toSemanticEntities(scope: ScopeNode): List<ExpressionEntity> = when(this) {
    is LiteralValueElementNode -> toSemanticEntities(scope)
    is ExpressionElementNode -> listOf(toSemanticEntity(scope))
}

private fun LiteralValueElementNode.toSemanticEntities(scope: ScopeNode): List<ExpressionEntity> =
    elements.flatMap { it.toSemanticEntities(scope) }

private fun ExpressionElementNode.toSemanticEntity(scope: ScopeNode) = expression.toSemanticEntity(scope)


private fun FunctionLiteralNode.toSemanticEntity(scope: ScopeNode) = ExpressionEntity(
    type = signature.toType()
).also { entity ->
    // create scope for function
    val functionScope = scope.createNewFuncScope(
        functionName = "anonymous",
        expectedReturnType = (entity.type as Type.FuncType).returnType
    )

    // analyze parameters
    signature.parameterNodes.forEach { paramNode ->
        paramNode.toSemanticEntity(functionScope)
    }

    functionBody.block.forEach { statementNode ->
        statementNode.toSemanticEntity(functionScope)
    }
}
