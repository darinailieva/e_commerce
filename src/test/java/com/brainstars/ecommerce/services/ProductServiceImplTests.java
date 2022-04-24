package com.brainstars.ecommerce.services;

import com.brainstars.ecommerce.exceptions.EntityNotFoundException;
import com.brainstars.ecommerce.exceptions.InsufficientQuantityException;
import com.brainstars.ecommerce.models.Product;
import com.brainstars.ecommerce.repository.ProductRepository;
import com.brainstars.ecommerce.services.impls.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Optional;

import static com.brainstars.ecommerce.Factory.createProduct;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTests {
    @Mock
    ProductRepository mockRepository;

    @InjectMocks
    ProductServiceImpl mockService;

    @Test
    public void getAll_should_Return_EmptyList() {
        //Arrange
        String name = "Dell";
        Pageable pageable = PageRequest.of(0, 1, Sort.Direction.DESC, "quantity");
        Mockito.when(mockRepository.findAllByOrderByName(name, pageable))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(name, pageable);

        //Assert
        Assert.assertTrue(mockRepository.findAllByOrderByName(name, pageable).isEmpty());
    }

    @Test
    public void getById_should_Return_WhenProductExists() {
        //Arrange
        Product expectedProduct = createProduct();
        Mockito.when(mockRepository.findById(anyInt()))
                .thenReturn(Optional.of(expectedProduct));
        //Act
        Product returnedProduct = mockService.getById(anyInt());

        //Assert
        Assert.assertSame(expectedProduct, returnedProduct);
    }

    @Test(expected = EntityNotFoundException.class)
    public void getById_Throws_whenProductDoesNotExist() {
        //Act
        mockService.getById(anyInt());
    }


    @Test
    public void getAllByCategories_should_Return_EmptyList() {
        //Arrange
        Mockito.when(mockRepository.findAllByCategories())
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAllByCategories();

        //Assert
        Assert.assertTrue(mockRepository.findAllByCategories().isEmpty());
    }

    @Test
    public void createProduct_should_AddInRepository() {
        //Arrange
        Product product = createProduct();

        //Act
        mockService.createProduct(product);

        //Assert
        Mockito.verify(mockRepository, Mockito.times(1)).save(product);
    }

    @Test
    public void updateProduct_should_AddInRepository() {
        //Arrange
        Product product = createProduct();

        //Act
        mockService.updateProduct(product);

        //Assert
        Mockito.verify(mockRepository, Mockito.times(1)).save(product);
    }

    @Test(expected = InsufficientQuantityException.class)
    public void updateProduct_throws_WhenQuantityIsInsufficient() {
        //Arrange
        Product product = createProduct();
        int quantity = 10;

        //Act
        mockService.updateProduct(product, quantity);
    }

    @Test
    public void updateProduct_should_AddInRepository_WhenQuantityIsSufficient() {
        //Arrange
        Product product = createProduct();
        int quantity = 2;

        //Act
        mockService.updateProduct(product, quantity);

        //Assert
        Mockito.verify(mockRepository, Mockito.times(1)).save(product);
    }

    @Test
    public void deleteProduct_should_DeleteFromRepository() {
        //Arrange
        Product product = createProduct();

        //Act
        mockService.deleteProduct(product);

        //Assert
        Mockito.verify(mockRepository, Mockito.times(1)).delete(product);
    }
}
