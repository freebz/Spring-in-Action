// 코드 11.1  하이버네이트 세션에 의해 활성화된 스프링으로부터 해방된 하이버네이트 저장소

@Repository
public class HibernateSpitterRepository implements SpitterRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateSpitterRepository(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;  // 세션 팩토리 주입
    }

    private Session currentSession() {
	return sessionFactory.getCurrentSession();  // 세션 팩토리에서 현재 세션 추출
    }

    public long count() {
	return findAll().size();
    }

    public Spitter save(Spitter spitter) {
	Serializable id = currentSession().save(spitter);  // 현재 세션 사용
	return new Spitter((Long) id,
			   spitter.getUsername(),
			   spitter.getPassword(),
			   spitter.getFullName(),
			   spitter.getEmail(),
			   spitter.isUpdateByEmail());
    }

    public Spitter findOne(long id) {
	return (Spitter) currentSession().get(Spitter.class, id);
    }

    public Spitter findByUsername(String username) {
	return (Spitter) currentSession()
	    .createCriteria(Spitter.class)
	    .add(Restrictions.eq("username", username))
	    .list().get(0);
    }

    public List<Spitter> findAll() {
	return (List<Spitter>) currentSession()
	    .createCriteria(Spitter.class).list();
    }

}
