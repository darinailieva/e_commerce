package com.brainstars.ecommerce.services;

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

import static com.brainstars.ecommerce.Factory.createProduct;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTests {
    @Mock
    ProductRepository mockRepository;

    @InjectMocks
    ProductServiceImpl mockService;

    @Test
    public void getAll_should_Return_EmptyList_With_Name_DESC() {
        //Arrange
        String orderBy = "name";
        Pageable pageable = PageRequest.of(0, 1);
        Mockito.when(mockRepository.findAllOrderByNameDESC(orderBy, pageable))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(orderBy, Sort.Direction.DESC, pageable);

        //Assert
        Assert.assertTrue(mockRepository.findAllOrderByNameDESC(orderBy, pageable).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_Quantity_DESC() {
        //Arrange
        String orderBy = "quantity";
        Pageable pageable = PageRequest.of(0, 1);
        Mockito.when(mockRepository.findAllOrderByQuantityDESC(orderBy, pageable))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(orderBy, Sort.Direction.DESC, pageable);

        //Assert
        Assert.assertTrue(mockRepository.findAllOrderByQuantityDESC(orderBy, pageable).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_CreatedDate_DESC() {
        //Arrange
        String orderBy = "createdDate";
        Pageable pageable = PageRequest.of(0, 1);
        Mockito.when(mockRepository.findAllOrderByCreatedDateDESC(orderBy, pageable))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(orderBy, Sort.Direction.DESC, pageable);

        //Assert
        Assert.assertTrue(mockRepository.findAllOrderByCreatedDateDESC(orderBy, pageable).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_LastModifiedDate_DESC() {
        //Arrange
        String orderBy = "lastModifiedDate";
        Pageable pageable = PageRequest.of(0, 1);
        Mockito.when(mockRepository.findAllOrderByLastModifiedDateDESC(orderBy, pageable))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(orderBy, Sort.Direction.DESC, pageable);

        //Assert
        Assert.assertTrue(mockRepository.findAllOrderByLastModifiedDateDESC(orderBy, pageable).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_Id_DESC() {
        //Arrange
        String orderBy = "";
        Pageable pageable = PageRequest.of(0, 1);
        Mockito.when(mockRepository.getAllDESC())
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(orderBy, Sort.Direction.DESC, pageable);

        //Assert
        Assert.assertTrue(mockRepository.getAllDESC().isEmpty());
    }


    @Test
    public void getAll_should_Return_EmptyList_With_Name_ASC() {
        //Arrange
        String orderBy = "name";
        Pageable pageable = PageRequest.of(0, 1);
        Mockito.when(mockRepository.findAllOrderByNameASC(orderBy, pageable))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(orderBy, Sort.Direction.ASC, pageable);

        //Assert
        Assert.assertTrue(mockRepository.findAllOrderByNameASC(orderBy, pageable).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_Quantity_ASC() {
        //Arrange
        String orderBy = "quantity";
        Pageable pageable = PageRequest.of(0, 1);
        Mockito.when(mockRepository.findAllOrderByQuantityASC(orderBy, pageable))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(orderBy, Sort.Direction.ASC, pageable);

        //Assert
        Assert.assertTrue(mockRepository.findAllOrderByQuantityASC(orderBy, pageable).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_CreatedDate_ASC() {
        //Arrange
        String orderBy = "createdDate";
        Pageable pageable = PageRequest.of(0, 1);
        Mockito.when(mockRepository.findAllOrderByCreatedDateASC(orderBy, pageable))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(orderBy, Sort.Direction.ASC, pageable);

        //Assert
        Assert.assertTrue(mockRepository.findAllOrderByCreatedDateASC(orderBy, pageable).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_LastModifiedDate_ASC() {
        //Arrange
        String orderBy = "lastModifiedDate";
        Pageable pageable = PageRequest.of(0, 1);
        Mockito.when(mockRepository.findAllOrderByLastModifiedDateASC(orderBy, pageable))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(orderBy, Sort.Direction.ASC, pageable);

        //Assert
        Assert.assertTrue(mockRepository.findAllOrderByLastModifiedDateASC(orderBy, pageable).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_Id_ASC() {
        //Arrange
        String orderBy = "";
        Pageable pageable = PageRequest.of(0, 1);
        Mockito.when(mockRepository.getAllASC())
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(orderBy, Sort.Direction.ASC, pageable);

        //Assert
        Assert.assertTrue(mockRepository.getAllASC().isEmpty());
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
