package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 서비스에 대한 구현체
@Component
public class MemberServiceImpl implements MemberService{


    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
            memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
