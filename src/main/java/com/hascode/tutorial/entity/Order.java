package com.hascode.tutorial.entity;

public class Order {
    private final String bookId;
    private final int quantity;
    private boolean processed;

    public Order(String bookId, int quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public String toString() {
        return "Order [bookId=" + bookId + ", quantity=" + quantity + ", processed=" + processed + "]";
    }

}
