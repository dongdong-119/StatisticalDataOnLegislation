package service.congressApi.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import service.congressApi.domain.statistics.Member;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }


    public Member findByName(String name){
        return em.find(Member.class, name);
    }


    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

}
