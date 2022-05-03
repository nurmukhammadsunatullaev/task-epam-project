package com.epam.esm.entity.base;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class BaseTest {

    @Test
    public void getIdTest(){
        long id = 2L;
        Base base = new Base();
        base.setId(id);
        assertEquals(id, base.getId());
    }

}
