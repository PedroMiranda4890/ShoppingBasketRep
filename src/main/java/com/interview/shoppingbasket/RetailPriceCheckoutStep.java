package com.interview.shoppingbasket;

public class RetailPriceCheckoutStep implements CheckoutStep {
    private PricingService pricingService;
    
    private double retailTotal;

    public RetailPriceCheckoutStep(PricingService pricingService) {
        this.pricingService = pricingService;
        
    }

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        retailTotal = 0.0;


        for (BasketItem basketItem: basket.getItems()) {
        
            int quantity = basketItem.getQuantity();
            double price = pricingService.getPrice(basketItem.getProductCode());
           
            for(Promotion promotion: checkoutContext.getPromotions()) {
                
                price = applyPromotion(promotion, basketItem, price);
                
            }
            basketItem.setProductRetailPrice(price);
            retailTotal = retailTotal + quantity*price;
            
        }
        
        checkoutContext.setRetailPriceTotal(retailTotal);
        
    }

    public double applyPromotion(Promotion promotion, BasketItem item, double price) {
        /*
         * Implement applyPromotion method
         * 
         *
         */
        double retailTotal1;
        
        //verifiy if has to applyPromotion for this item
        if (promotion.doPromotion(item)) {
            
            retailTotal1 = promotion.aplicaPromotion(price, item.getQuantity());
        }else{
            retailTotal1 = price;
        }
        
        //System.out.println("AP - Retail Total   " + retailTotal);
        return retailTotal1;
    }
}

