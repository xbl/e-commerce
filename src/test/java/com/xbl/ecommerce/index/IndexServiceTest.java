package com.xbl.ecommerce.index;

import com.xbl.ecommerce.index.entity.Index;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IndexServiceTest {

    @Test
    public void given_id_was_1_when_called_get_method_then_return_expected_index() {
        Index expectedIndex = new Index();
        expectedIndex.setName("hello");
        expectedIndex.setId(1);

        IndexService indexService = new IndexService(id -> {
            Index index = new Index();
            index.setName("hello");
            index.setId(1);
            return index;
        }, null);

        Index index = indexService.get(1);
        assertEquals(expectedIndex, index);
    }
}
