package com.xbl.ecommerce.index;

import com.xbl.ecommerce.index.entity.Index;
import org.springframework.stereotype.Component;

@Component
public class IndexService {
    private IndexRepository indexRepository;

    public IndexService(IndexRepository indexRepository) {
        this.indexRepository = indexRepository;
    }

    public Index get(Integer id) {
        return indexRepository.get(id);
    }
}
