package com.interview.shoppingbasket;

public class Promotion21 extends Promotion{


    public Promotion21(String pc) {
        super(pc);
    }

    @Override 
    public double aplicaPromotion(double price, int quantity){

        if(quantity>=2){
           return price/2;
        }else{
            return price;
        }

    }

}
