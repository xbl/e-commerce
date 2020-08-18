package com.xbl.ecommerce.index;

import com.xbl.ecommerce.index.entity.Index;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

@RestController
@RequestMapping(value="/")
public class IndexController {

    private IndexService indexService;
    private FeatureManager manager;

    public IndexController(IndexService indexService, FeatureManager manager) {
        this.indexService = indexService;
        this.manager = manager;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public Index index() {
        Index index = this.indexService.get(2);
        if (manager.isActive(new NamedFeature("FOO"))) {
            index.setName(index.getName() + " is active");
        }
        return index;
    }
}
