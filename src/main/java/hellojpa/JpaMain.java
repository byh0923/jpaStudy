package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            
            /*// 비영속 상태
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            // 영속 상태
            System.out.println("===BEFORE===");
            em.persist(member);
            System.out.println("===AFTER===");*/

            /*Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            // 쓰기 지연 SQL 저장소에 쌓아둠
            em.persist(member1);
            em.persist(member2);*/

            // 플러시 관련
            /*Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush();*/

            Member member = em.find(Member.class, 150L);
            member.setName("AAA");

            // 준영속 상태 만드는 방법
            /*em.detach(member);
            em.clear();
            em.close();*/
            Member member2 = em.find(Member.class, 150L);


            // 실제 쿼리 날라감
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
