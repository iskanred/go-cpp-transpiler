package inno.jago.lexer;

import inno.jago.ast.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Pos extends Entity {

    private long line;

    private int symbol;

    void report() {
        System.out.print(line + ":" + symbol);
    }
}