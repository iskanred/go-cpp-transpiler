package inno.jago.ast.typechecker

import inno.jago.common.WrongNumberOfExpressionsException
import inno.jago.createAST
import inno.jago.semantic.NonCastableTypeException
import inno.jago.semantic.SemanticException
import inno.jago.semantic.TypeChecker
import inno.jago.semantic.WrongTypeException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class TypeCheckerTest {
    @Test
    fun `reassign variable to different type`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/variable/invalid_type_variable_reassign.go"))
        assertThrows<WrongTypeException> { typeChecker.startTypeCheck() }
    }

    @Test
    fun `call function with invalid number of arguments`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/fun/invalid_argument_number.go"))
        assertThrows<SemanticException> { typeChecker.startTypeCheck() }
    }

    @Test
    fun `call function with invalid argument type`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/fun/invalid_argument_type.go"))
        assertThrows<WrongTypeException> { typeChecker.startTypeCheck() }
    }

    @Test
    fun `non-bool if condition`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/if/invalid_if_condition.go"))
        assertThrows<WrongTypeException> { typeChecker.startTypeCheck() }
    }

    @Test
    fun `invalid elems in an array initialisation - string`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/array/invalid_array_data.go"))
        assertThrows<SemanticException> { typeChecker.startTypeCheck() }
    }
    @Test
    fun `invalid elems in an array initialisation - double`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/array/invalid_array_data_2.go"))
        assertThrows<SemanticException> { typeChecker.startTypeCheck() }
    }
    @Test
    fun `non-castable error`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/conversion/non_castable_error.go"))
        assertThrows<NonCastableTypeException> { typeChecker.startTypeCheck() }
    }
    @Test
    fun `values casted correctly`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/conversion/valid.go"))
        assertDoesNotThrow { typeChecker.startTypeCheck() }
    }
    @Test
    fun `implicit cast`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/conversion/implicit_cast.go"))
        assertThrows<WrongTypeException> { typeChecker.startTypeCheck() }
    }
    @Test
    fun `valid length of an array`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/array/valid.go"))
        assertDoesNotThrow { typeChecker.startTypeCheck() }
    }
    @Test
    fun `explicit cast that does nothing`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/conversion/expilicit_cast_that_does_nothing.go"))
        assertDoesNotThrow { typeChecker.startTypeCheck() }
    }
    @Test
    fun `explicit casts`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/conversion/explicit_casts.go"))
        assertDoesNotThrow { typeChecker.startTypeCheck() }
    }
    @Test
    fun `implicit cast that works`() {
        val typeChecker = TypeChecker(createAST("src/test/resources/tests/type_checker/conversion/implicit_cast_that_works.go"))
        assertDoesNotThrow { typeChecker.startTypeCheck() }
    }

}
