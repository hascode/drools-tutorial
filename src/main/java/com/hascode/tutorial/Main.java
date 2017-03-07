package com.hascode.tutorial;

import com.hascode.tutorial.boundary.BookService;

public class Main {

    public static void main(String[] args) {
        BookService srv = new BookService();
        srv.order("aaa", 30);
    }

}
