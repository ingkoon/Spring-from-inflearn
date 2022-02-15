package Koon.sDiary.server.repository;

import Koon.sDiary.server.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository{
    private EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findById(String userId) {
        User user = em.find(User.class, userId);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findBynickName(String nickName) {
        List<User> result = em.createQuery("select u from User u where u.nikcName = :nickName", User.class).setParameter("nickName", nickName).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();

    }

}
