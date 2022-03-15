package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){ //-> jpa에서 아이템은 저장하기 전까지는 아이디가 없기 때문에(새로 생성한 객체) 영속성 컨테스트화 시킨다.
        if(item.getId() == null){
            em.persist(item);
        } else{
            em.merge(item); //-> 기존값이 있을 경우 merge를 수행하여 덮어 씌운다.
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
