package com.interview.shoppingbasket;

public abstract class Promotion {
   
    private String productCode;

    //constructor
    public Promotion(String pc){
        this.productCode = pc;
    }

    //method called through polimorfism. 
    public abstract double aplicaPromotion(double price, int quantity);    

    public boolean doPromotion(BasketItem item) {
        
        return item.getProductCode().equals(productCode);
        
    }

    //GETTER
    public String getProductCode(){
        return this.productCode;
    }
}
