package hello.core.member;

//역할을 위한 리포지토리 인터페이스
public interface MemberRepository {
    void save(Member member);
     Member findById(Long memberId);
}
