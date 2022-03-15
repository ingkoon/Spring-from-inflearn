package jpabook.jpashop.sevice;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //-> 읽기 전용에 대한 성능 향상을 위해 readonly true를 삽입한다 + 데이터 변경은 트랜잭셔널 안에 있어야 한다.
@RequiredArgsConstructor//-> final이 있는 필드에 대해서 생성자를 만들고 등록
public class MemberService {

    //값 변경을 방지하기 위해 final을 넣는 것을 권장한다.
    private final MemberRepository memberRepository;

    // 생성자는 두개가 아니면 자동으로 autowired수행한다

    // 회원 가입
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 회원 단일 조회일
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
