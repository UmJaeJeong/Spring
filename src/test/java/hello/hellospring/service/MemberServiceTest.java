package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//테스트 같은 경우는 한글로도 많이 사용하고 있음
class MemberServiceTest {

    MemberService memberService;

    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    //테스트 같은경우 예외도 확인해야함
    @Test
    void join() {
        //given 상화이 주어졌다 이데이터 기반으로 검증하는구나?
        Member member = new Member();
        member.setName("김지연");

        //when  언제? 이걸 검증?
        Long saveId = memberService.join(member);

        //then 이러케 실행 됬다 이렇게 결과가 나왔구나
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void duplicatedMemberException(){
        //given
        Member member1 = new Member();
        member1.setName("김지연");
        Member member2 = new Member();
        member2.setName("김지연");
        //when
        memberService.join(member1);
 /*
        try{
            memberService.join(member2);
            fail();
        }catch(IllegalStateException e){

        }*/

        //종문법을 제공함
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertThat(illegalStateException.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then
    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}