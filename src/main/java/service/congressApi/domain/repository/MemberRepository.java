package service.congressApi.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import service.congressApi.domain.statistics.Member;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }


    public List<Member> findByNameAndParty(String name, String party){
        return em.createQuery("select m from Member m where m.name = :name" +
                        " and m.partyName = :partyName", Member.class)
                .setParameter("name", name)
                .setParameter("partyName", party)
                .getResultList();
    }



    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }



}
