package com.store.webStore.entity;

import java.util.List;

public class Response {
    private List<Product> productList;
    private List<ProductType> productTypeList;
    public Response(){}
    public Response(List<Product> productList, List<ProductType> productTypeList){
        this.productList = productList;
        this.productTypeList = productTypeList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<ProductType> getProductTypeList() {
        return productTypeList;
    }
}
