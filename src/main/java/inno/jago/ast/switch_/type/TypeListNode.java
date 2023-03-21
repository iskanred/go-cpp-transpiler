package inno.jago.ast.switch_.type;

import inno.jago.ast.entity.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// typeList            :   type ( COMMA type )*;
@Getter
@Setter
public class TypeListNode extends Entity {

    private List<String> typeList;
}
