package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

// 스프링에서 제공하는 어노테이션
@Repository
@RequiredArgsConstructor
public class MemberRepository {

    //@PersistenceContext -> RequiredArgsConstructor에 의하여 사용하지 않아도된다.
    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    // 한 회원만 찾는다.
    public Member findOne(Long id){
        //type, pk
        return em.find(Member.class, id);
    }

    // 조회 결과 반환
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //특적 이름의 회원에 대한 조회
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
