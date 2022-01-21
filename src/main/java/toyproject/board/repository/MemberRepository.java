package toyproject.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import toyproject.board.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
    List<Member> findAll();
}

//    private final EntityManager em;
//
//
//    @Transactional
//    public void saveMember(Member member){
//        em.persist(member);
//    }
//
//    public Member findOne(Long id){
//        return em.find(Member.class, id);
//    }
//
//    public List<Member> findAll(){
//        return em.createQuery("select m from Member m")
//                .getResultList();
//    }
//
//    public List<Member> findByName(String username) {
//        return em.createQuery("select m from Member m where m.username = :username", Member.class)
//                .setParameter("username", username)
//                .getResultList();
//    }
