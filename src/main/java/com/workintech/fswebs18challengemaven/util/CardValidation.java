package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import org.springframework.stereotype.Component;

@Component
public class CardValidation {

    public static void validateCard(Card card){
        if(card.getType()!=null&&card.getValue()!=null){
            throw new IllegalArgumentException("Bir kart ya type ya da value'ya sahip olmalıdır.");
        }
        if(card.getType()== Type.JOKER){
            if(card.getValue()!=null||card.getColor()!=null){
                throw new IllegalArgumentException("JOKER kartında hem value hem de color null olmalıdır.");
            }
        }
    }
}
