package com.ehb.Elecrtonics.Controller;

import com.ehb.Elecrtonics.Model.Category;
import com.ehb.Elecrtonics.Model.User;
import com.ehb.Elecrtonics.Service.CategoryService;
import com.ehb.Elecrtonics.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category)
    {
        return categoryService.addCategory(category);
    }
    @GetMapping("/list")
    public Iterable<Category> listCategory()
    {
        return categoryService.listCategory();
    }
    @PostMapping("/update/{categoryId}")
    public String updateCategory(@PathVariable("categoryId") Integer catId,@RequestBody Category cat)
    {
        categoryService.editCategory(catId,cat);
        return "goed upgedate";
    }
}
