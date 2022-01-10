package toyproject.board.domain.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import toyproject.board.domain.Member;
import toyproject.board.domain.Repository.MemberRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(@Valid Member member){
        validateDuplicateId(member);
        memberRepository.saveMember(member);
        return member.getId();
    }

    public Member findOne(Long id){
       return memberRepository.findOne(id);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    /**
     * 중복 아이디 검증
     */
    public void validateDuplicateId(Member member){
        List<Member> findMembers = memberRepository.findByName(member.getUsername());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 이름입니다. 다른 이름을 입력해주세요.");
        }
    }
}
