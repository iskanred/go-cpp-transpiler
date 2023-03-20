package inno.jago.ast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Pos {

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