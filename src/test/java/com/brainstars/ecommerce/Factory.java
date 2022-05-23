package com.brainstars.ecommerce;

import com.brainstars.ecommerce.models.Category;
import com.brainstars.ecommerce.models.Product;
import com.brainstars.ecommerce.models.dtos.CategoryCreateRequest;
import com.brainstars.ecommerce.models.dtos.ProductCreateRequest;
import com.brainstars.ecommerce.models.dtos.ProductUpdateRequest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class Factory {
    public static Category createCategory(){
        return new Category(2001, "Laptop", new ArrayList<>());
    }

    public static CategoryCreateRequest createCategoryCreateRequest(){
        return new CategoryCreateRequest("Laptop");
    }

    public static List<Category> createCategories(){
        List<Category> categories = new ArrayList<>();
        Category category = createCategory();
        categories.add(category);
        return categories;
    }


    public static Product createProduct()  {
        Date createdDate = null;
        Date updatedDate = null;
        Category category = createCategory();
        
      try {
          createdDate = new SimpleDateFormat("YYYY/MM/DD").parse("2022-04-22");
          updatedDate = new SimpleDateFormat("YYYY/MM/DD").parse("2022-04-23");
      } catch (ParseException e){
          System.out.println(e.getMessage());
      }
        return new Product(1001, "Dell 56", "Description Laptop", 5, createdDate, updatedDate, category);
    }

    public static ProductCreateRequest createProductCreateRequest(){
        return new ProductCreateRequest("Dell 56", "Description Laptop", 3);
    }

    public static ProductCreateRequest createWrongProductCreateRequest(){
        return new ProductCreateRequest(null, "Description Laptop", -1);
    }

    public static ProductUpdateRequest createProductUpdateRequest(){
        return new ProductUpdateRequest("Dell", "Monitor", "Laptop");
    }

}
