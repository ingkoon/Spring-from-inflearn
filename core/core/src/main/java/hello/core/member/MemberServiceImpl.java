package hello.core.member;


// 서비스에 대한 구현체
public class MemberServiceImpl implements MemberService{


    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
            memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
