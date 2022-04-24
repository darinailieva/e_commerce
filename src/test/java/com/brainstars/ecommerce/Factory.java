package com.brainstars.ecommerce;

import com.brainstars.ecommerce.models.Product;
import com.brainstars.ecommerce.models.dtos.ProductCreateRequest;
import com.brainstars.ecommerce.models.dtos.ProductUpdateRequest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class Factory {
    public static Product createProduct()  {
        Date createdDate = null;
        Date updatedDate = null;
        
      try {
          createdDate = new SimpleDateFormat("YYYY/MM/DD").parse("2022-04-22");
          updatedDate = new SimpleDateFormat("YYYY/MM/DD").parse("2022-04-23");
      } catch (ParseException e){
          System.out.println(e.getMessage());
      }
        return new Product(1001, "Dell 56", "Laptop", "Description Laptop", 5, createdDate, updatedDate);
    }

    public static ProductCreateRequest createProductCreateRequest(){
        return new ProductCreateRequest("Dell 56", "Laptop", "Description Laptop", 3);
    }

    public static ProductCreateRequest createWrongProductCreateRequest(){
        return new ProductCreateRequest(null, "Laptop", "Description Laptop", -1);
    }

    public static ProductUpdateRequest createProductUpdateRequest(){
        return new ProductUpdateRequest("Dell", "Monitor", "Laptop");
    }

    public static List<Object[]> createObjects(){
        List<Object[]> objects = new ArrayList<>();
        Object[] laptops = {"Laptop", 5};
        Object[] monitors = {"Monitor", 2};
        objects.add(laptops);
        objects.add(monitors);
        return objects;
    }
}
