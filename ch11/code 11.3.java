// 코드 11.3  프록시를 가지는 저장소를 EntityManager에 주입하기

package com.habuma.spittr.persistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.habuma.spittr.domain.Spittr;
import com.habuma.spittr.domain.Spittle;

@Repository
@Transactional
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceContext
    private EntityManager em;  // EntityManager 주입

    public void addSpitter(Spitter spitter) {
	em.persist(spitter);  // EntityManager 사용
    }

    public Spitter getSpitterById(long id) {
	return em.find(Spitter.class, id);
    }

    public void saveSpitter(Spitter spitter) {
	em.merge(spitter);
    }

}
