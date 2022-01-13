package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    public MemoryMemberRepositoryTest() {

    }

    @AfterEach
    public void afterEach() {
        this.repository.clearStore();
    }
    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");
        this.repository.save(member);
        Member result = (Member)this.repository.findById(member.getid()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    void findById() {
        Member member = new Member();
        member.setName("김지연");
        this.repository.save(member);
        Member result = this.repository.findByName(member.getName()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
    }

    @Test
    void findAll() {
    }

    @Test
    void clearStore() {
    }
}