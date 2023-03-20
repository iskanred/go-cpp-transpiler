package inno.jago.ast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class PackageNode extends Entity {
    @Getter
    @Setter
    private String name;
}
