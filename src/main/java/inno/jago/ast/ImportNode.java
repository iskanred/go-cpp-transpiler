package inno.jago.ast;

public class ImportNode extends Entity {

    private String path;
    private String alias;
    private boolean importAll;

//    importDecl          :   IMPORT ( importSpec | L_PAREN ( importSpec END )* ( importSpec ( END )? )? R_PAREN );
//    importSpec          :   ( DOT | packageName )? importPath;
//    importPath          :   STRING_LIT;
}
