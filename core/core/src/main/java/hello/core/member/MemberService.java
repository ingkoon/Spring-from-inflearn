package hello.core.member;

// 서비스에 대한 역할
public interface MemberService {

    void join(Member member);
    Member findMember(Long memberId);
}
