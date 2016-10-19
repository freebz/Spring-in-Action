// 코드 11.2  순수 JPA 저장소는 어떤 스프링 템플릿도 사용하지 않는다.

package com.habuma.spittr.persistence;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.habuma.spittr.domain.Spitter;
import com.habuma.spittr.domain.Spittle;

@Repository
@Transactional
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceUnit
    private EntityManagerFactory emf;  // EntityManagerFactory 주입

    public void addSpitter(Spitter spitter) {
	emf.createEntityManager().persist(spitter);  // EntityManager 생성 및 사용
    }

    public Spitter getSpitterById(long id) {
	return emf.createEntityManager().find(Spitter.class, id);
    }

    public void saveSpitter(Spitter spitter) {
	emf.createEntityManager().merge(spitter);
    }

}
