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

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public Index index() {
        return indexService.get(2);
    }
}
