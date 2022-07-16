package bg.softuni.personalproject.model.entity.dto;

public class CartItemDto {
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public CartItemDto setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
