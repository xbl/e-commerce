package com.xbl.ecommerce.index;

import com.xbl.ecommerce.index.entity.Index;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class IndexRepositoryTest {
    @Autowired
    private IndexRepository indexRepository;

    @Test
    public void given_ID_is_2_called_get_then_return_one_index_object() {
        Index expectedIndex = new Index();
        expectedIndex.setId(2);
        expectedIndex.setName("Sony Mobile");

        Index result = indexRepository.get(2);
        assertEquals(expectedIndex, result);
    }
}
