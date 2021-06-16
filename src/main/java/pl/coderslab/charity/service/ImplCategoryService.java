package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.CategoryRepository;

@Service
public class ImplCategoryService implements CategoryService{

    private final CategoryRepository categoryRepository;

    public ImplCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
