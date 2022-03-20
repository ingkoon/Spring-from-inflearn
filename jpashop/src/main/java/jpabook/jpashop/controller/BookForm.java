package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {

    public Long id; //-> 수정을 위한 id
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;

}
