package jpabook.jpashop.domain.Item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") //디폴트는 클래스의 이름으로 들어간다.
@Getter @Setter
public class Book extends Item{

    private String author;
    private String isbn;

}
