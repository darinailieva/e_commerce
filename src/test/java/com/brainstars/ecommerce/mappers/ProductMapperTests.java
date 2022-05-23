package com.brainstars.ecommerce.mappers;

import com.brainstars.ecommerce.models.dtos.CategoryResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.brainstars.ecommerce.Factory.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductMapperTests {
    @Test
    public void convertToProductFromCreateRequest() {
        //Arrange
        var request = createProductCreateRequest();

        //Act
        var product = ProductMapper.convertToProductFromCreateRequest(request);

        //Assert
        Assert.assertNotNull(request);
        Assert.assertEquals(request.getName(), product.getName());
        Assert.assertEquals(request.getDescription(), product.getDescription());
        Assert.assertEquals(request.getQuantity(), product.getQuantity());
    }

    @Test
    public void convertToProductFromUpdateRequest() {
        //Arrange
        var request = createProductUpdateRequest();
        var product = createProduct();

        //Act
        product = ProductMapper.convertToProductFromUpdateRequest(request, product);

        //Assert
        Assert.assertNotNull(request);
        Assert.assertEquals(request.getName(), product.getName());
        Assert.assertEquals(request.getDescription(), product.getDescription());
    }

}
