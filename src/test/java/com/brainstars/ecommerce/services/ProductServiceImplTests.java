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
        PageRequest request = PageRequest.of(0, 1, Sort.Direction.DESC, orderBy);
        Mockito.when(mockRepository.getAllByOrderByNameDesc(request))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(request);

        //Assert
        Assert.assertTrue(mockRepository.getAllByOrderByNameDesc(request).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_Quantity_DESC() {
        //Arrange
        String orderBy = "quantity";
        PageRequest request = PageRequest.of(0, 1, Sort.Direction.DESC, orderBy);
        Mockito.when(mockRepository.getAllByQuantityDesc(request))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(request);

        //Assert
        Assert.assertTrue(mockRepository.getAllByQuantityDesc(request).isEmpty());
    }
    @Test
    public void getAll_should_Return_EmptyList_With_CreatedDate_DESC() {
        //Arrange
        String orderBy = "createdDate";
        PageRequest request = PageRequest.of(0, 1, Sort.Direction.DESC, orderBy);
        Mockito.when(mockRepository.getAllByCreatedDateDesc(request))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(request);

        //Assert
        Assert.assertTrue(mockRepository.getAllByCreatedDateDesc(request).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_LastModifiedDate_DESC() {
        //Arrange
        String orderBy = "lastModifiedDate";
        PageRequest request = PageRequest.of(0, 1, Sort.Direction.DESC, orderBy);
        Mockito.when(mockRepository.getAllByLastModifiedDateDesc(request))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(request);

        //Assert
        Assert.assertTrue(mockRepository.getAllByLastModifiedDateDesc(request).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_Id_DESC() {
        //Arrange
        String orderBy = "id";
        PageRequest request = PageRequest.of(0, 1, Sort.Direction.DESC, orderBy);
        Mockito.when(mockRepository.getAllByIdDesc(request))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(request);

        //Assert
        Assert.assertTrue(mockRepository.getAllByIdDesc(request).isEmpty());
    }
    @Test
    public void getAll_should_Return_EmptyList_With_Name_ASC() {
        //Arrange
        String orderBy = "name";
        PageRequest request = PageRequest.of(0, 1, Sort.Direction.ASC, orderBy);
        Mockito.when(mockRepository.getAllByOrderByNameAsc(request))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(request);

        //Assert
        Assert.assertTrue(mockRepository.getAllByOrderByNameAsc(request).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_Quantity_ASC() {
        //Arrange
        String orderBy = "quantity";
        PageRequest request = PageRequest.of(0, 1, Sort.Direction.ASC, orderBy);
        Mockito.when(mockRepository.getAllByQuantityAsc(request))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(request);

        //Assert
        Assert.assertTrue(mockRepository.getAllByQuantityAsc(request).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_CreatedDate_ASC() {
        //Arrange
        String orderBy = "createdDate";
        PageRequest request = PageRequest.of(0, 1, Sort.Direction.ASC, orderBy);
        Mockito.when(mockRepository.getAllByCreatedDateAsc(request))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(request);

        //Assert
        Assert.assertTrue(mockRepository.getAllByCreatedDateAsc(request).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_LastModifiedDate_ASC() {
        //Arrange
        String orderBy = "lastModifiedDate";
        PageRequest request = PageRequest.of(0, 1, Sort.Direction.ASC, orderBy);
        Mockito.when(mockRepository.getAllByLastModifiedDateAsc(request))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(request);

        //Assert
        Assert.assertTrue(mockRepository.getAllByLastModifiedDateAsc(request).isEmpty());
    }

    @Test
    public void getAll_should_Return_EmptyList_With_Id_ASC() {
        //Arrange
        String orderBy = "id";
        PageRequest request = PageRequest.of(0, 1, Sort.Direction.ASC, orderBy);
        Mockito.when(mockRepository.getAllByIdAsc(request))
                .thenReturn(new ArrayList<>());
        //Act
        mockService.getAll(request);

        //Assert
        Assert.assertTrue(mockRepository.getAllByIdAsc(request).isEmpty());
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
