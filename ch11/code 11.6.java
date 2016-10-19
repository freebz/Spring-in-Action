// 코드 11.6  빈번한 Spitter 사용자에게 Elite 상태를 나타내기 위한 저장소

public class SpitterRepositoryImpl implements SpitterSweeper {

    @PersistenceContext
    private EntityManager em;

    public int eliteSweep() {
	String update =
	    "UPDATE Spitter spitter " +
	    "SET spitter.status = 'Elite' " +
	    "WHERE spitter.status = 'Newbie' " +
	    "AND spitter.id IN (" +
	    "SELECT s FROM Spitter s WHERE (" +
	    " SELECT COUNT(spittles) FROM s.spittles spittles) > 10000" +
	    ")";
	return em.createQuery(update).executeUpdate();
    }

}
