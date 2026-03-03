package com.example.moviles.lists

import com.example.moviles.R



class ProductViewModel {
    fun getProducts(): List<ProductModel> {
        var ProductList = mutableListOf<ProductModel>()
        ProductList.add(ProductModel(imageProduct = R.drawable.mac, nombre = "Macbook",  precio = 2000.0))
        ProductList.add(ProductModel(imageProduct = R.drawable.mac, nombre = "Macbook",  precio = 2000.0))
        ProductList.add(ProductModel(imageProduct = R.drawable.mac, nombre = "Macbook",  precio = 2000.0))
        ProductList.add(ProductModel(imageProduct = R.drawable.mac, nombre = "Macbook",  precio = 2000.0))
        ProductList.add(ProductModel(imageProduct = R.drawable.mac, nombre = "Macbook",  precio = 2000.0))
        ProductList.add(ProductModel(imageProduct = R.drawable.mac, nombre = "Macbook",  precio = 2000.0))
        return ProductList
    }
}