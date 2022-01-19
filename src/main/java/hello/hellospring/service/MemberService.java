package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
//Ctrl+Shift+T  Test 클래스 및 경로 자동 생성 -> 클래스 이름 클릭 후 사용
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    //외부에서 넣어줄수 있게 변경 이것을 의존성주입이라고 한다. DI
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        vaildateDuplicateMember(member);
        this.memberRepository.save(member);
        return member.getid();
    }

    private void vaildateDuplicateMember(Member member) {
        this.memberRepository.findByName(member.getName()).ifPresent((m)-> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Member> findMember() {
        return this.memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return this.memberRepository.findById(memberId);
    }
}
