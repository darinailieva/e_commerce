package com.brainstars.ecommerce.services;

import com.brainstars.ecommerce.models.Category;
import com.brainstars.ecommerce.models.Product;
import com.brainstars.ecommerce.repository.CategoryRepository;
import com.brainstars.ecommerce.services.impls.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static com.brainstars.ecommerce.Factory.createCategory;
import static com.brainstars.ecommerce.Factory.createProduct;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTests {
    @Mock
    CategoryRepository mockRepository;

    @InjectMocks
    CategoryServiceImpl mockService;

    @Test
    public void getAll_should_Return_EmptyList() {
        //Arrange
        Mockito.when(mockRepository.findAll())
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll();

        //Assert
        Assert.assertTrue(mockRepository.findAll().isEmpty());
    }

    @Test
    public void getById_should_Return_Entity() {
        //Arrange
        int categoryId = 2001;
        Category category = createCategory();
        Mockito.when(mockRepository.getById(categoryId))
                .thenReturn(category);
        //Act
        mockService.getById(categoryId);

        //Assert
        Assert.assertEquals(mockRepository.getById(categoryId), category);
    }

    @Test
    public void createCategory_should_AddInRepository() {
        //Arrange
        Category category = createCategory();

        //Act
        mockService.createCategory(category);

        //Assert
        Mockito.verify(mockRepository, Mockito.times(1)).save(category);
    }

    @Test
    public void addProductToCategory_should_AddInRepository() {
        //Arrange
        Category category = createCategory();
        Product product = createProduct();

        //Act
        mockService.addProductToCategory(category, product);

        //Assert
        Mockito.verify(mockRepository, Mockito.times(1)).save(category);
    }
}
