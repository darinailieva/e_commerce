package com.brainstars.ecommerce.mappers;

import com.brainstars.ecommerce.models.Category;
import com.brainstars.ecommerce.models.dtos.CategoryResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.brainstars.ecommerce.Factory.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryMapperTests {

    @Test
    public void convertFromCategoryCreateRequest() {
        //Arrange
        var request = createCategoryCreateRequest();

        //Act
        var category = CategoryMapper.convertFromCategoryCreateRequest(request);

        //Assert
        Assert.assertNotNull(request);
        Assert.assertEquals(request.getCategory(), category.getCategory());
    }

    @Test
    public void convertToCategoryResponse() {
        //Arrange
        List<Category> categories = createCategories();

        //Act
        List<CategoryResponse> categoryResponses = CategoryMapper.convertToCategoryResponse(categories);

        //Assert
        Assert.assertEquals(categories.get(0).getCategory(), categoryResponses.get(0).getCategory());
        Assert.assertEquals(categories.get(0).getProducts().size(), categoryResponses.get(0).getProductsAvailable());
    }
}
