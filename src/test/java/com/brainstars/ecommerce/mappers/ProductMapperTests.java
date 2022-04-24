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
        Assert.assertEquals(request.getCategory(), product.getCategory());
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
        Assert.assertEquals(request.getCategory(), product.getCategory());
        Assert.assertEquals(request.getDescription(), product.getDescription());
    }

    @Test
    public void convertToCategoryResponse() {
        //Arrange
        List<Object[]> objects = createObjects();

        //Act
        List<CategoryResponse> categoryResponses = ProductMapper.convertToCategoryResponse(objects);

        //Assert
        Assert.assertEquals(objects.get(0)[0], categoryResponses.get(0).getCategory());
        Assert.assertEquals(objects.get(0)[1], categoryResponses.get(0).getProductsAvailable());
        Assert.assertEquals(objects.get(1)[0], categoryResponses.get(1).getCategory());
        Assert.assertEquals(objects.get(1)[1], categoryResponses.get(1).getProductsAvailable());

    }


}
