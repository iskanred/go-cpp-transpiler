package inno.jago.ast;

import inno.jago.ast.entity.Entity;

/*
    importDecl          :   IMPORT ( importSpec | L_PAREN ( importSpec END )* ( importSpec ( END )? )? R_PAREN );
    importSpec          :   ( DOT | packageName )? importPath;
    importPath          :   STRING_LIT;
 */
public class ImportNode extends Entity {

    private String path;
    private String alias;
    private boolean importAll;

    // todo: add constructor based on optionality
}
