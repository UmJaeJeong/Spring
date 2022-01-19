package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements  MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequennce = 0L;

    public MemoryMemberRepository(){
    }

    public Member save(Member member) {
        member.setId(++sequennce);
        store.put(member.getid(), member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Optional<Member> findByName(String name){
        return store.values().stream().filter((member)-> {
            return member.getName().equals(name);
        }).findAny();
    }

    public List<Member> findAll() {
        return new ArrayList(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
