package inno.jago.lexer;

import inno.jago.ast.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Pos extends Entity {

    @Getter
    @Setter
    private long line;

    @Getter
    @Setter
    private int symbol;


    void report() {
        System.out.print(line + ":" + symbol);
    }
}