package hello.core.member;

public class Member {

    //회원이 가져야 할 변수
    private Long id;
    private String name;
    private Grade grade;

    // 생성자(Constructor) 선언
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // private 변수 참조를 위한 getter, setter 선언
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
