package inno.jago.ast.entity;

import inno.jago.lexer.Span;
import inno.jago.lexer.Token;
import lombok.Getter;
import lombok.Setter;

public class Entity
{
    public static final int SHIFT = 4;
    public static boolean debug = false;
    public static boolean syntaxOnly = false;
    // All entities created by the program are assigned unique numbers.
    private static long count = 0;
    // Entity's unique number

    @Getter
    private final long uid;
    // Text coordinates of the entity

    @Getter
    private Span span;

    // // Tricks for resolving conflicts
    //
    // public static boolean inBlock = false;
    // public static boolean unAnnotatedTypeTaken = false;

    // Machinery for reporting
    // Managing references to parent nodes
    @Getter
    @Setter
    private Entity parent;

    // Constructors
    public Entity() {
        count++;
        uid = count;
    }

    public Entity(Span span) {
        this();
        this.span = span;
    }

    public Entity(Token token) {
        this();
        this.span = token.span;
    }

    public static void doShift(int sh) {
        for (int i = 1; i <= sh; i++) {
            System.out.print(" ");
        }
    }

    public void outUnique() {
        System.out.print(uid);
        System.out.print(":");
    }

    public void title(String n, int sh) {
        doShift(sh);
        outUnique();
        System.out.println(n);
    }

    public void report(int sh) { }

    public static void reportParsing(String title)
    {
        if ( !debug ) return;
        for ( int i=1; i<=20; i++ ) System.out.print(" ");
        System.out.println(title);
    }
}