package com.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ramón Arcos Morales,Miguel Akira Lopez Asano.
 *         <p>
 *         Product controller, with REST endpoints that handle Category objects
 *         </p>
 */

@RestController
public class CtrlProduct {

    /**
     * Retrieves an array of categories.
     * 
     * @return an array of Category objects.
     */
    @RequestMapping("/category")
    @GetMapping
    public Category[] getCategory() {
        // We are adding some categories for testing purposes.
        Category[] categories = {
                new Category(1, "dollar", "usd", 1),
                new Category(2, "peso", "mxn", 1),
                new Category(3, "euro", "eur", 1),
                new Category(4, "yen", "jpy", 1)
        };
        return categories;
    }

}
