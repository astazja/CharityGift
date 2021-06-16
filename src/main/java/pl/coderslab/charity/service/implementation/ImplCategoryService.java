package pl.coderslab.charity.service.implementation;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.service.CategoryService;

@Service
public class ImplCategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;

    public ImplCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
