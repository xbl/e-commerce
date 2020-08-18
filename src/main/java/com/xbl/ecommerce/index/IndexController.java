package com.xbl.ecommerce.index;

import com.xbl.ecommerce.index.entity.Index;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value="/discount", method= RequestMethod.GET)
    public double discount() {
        return indexService.getDiscount();
    }
}
