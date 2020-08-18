package com.xbl.ecommerce.index;

import com.xbl.ecommerce.index.entity.Index;
import org.springframework.stereotype.Component;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

@Component
public class IndexService {
    private IndexRepository indexRepository;
    private FeatureManager manager;

    public IndexService(IndexRepository indexRepository, FeatureManager manager) {
        this.indexRepository = indexRepository;
        this.manager = manager;
    }

    public Index get(Integer id) {
        Index index = indexRepository.get(id);
        if (manager.isActive(new NamedFeature("FOO"))) {
            index.setName(index.getName() + " is active");
        }
        return index;
    }
}
