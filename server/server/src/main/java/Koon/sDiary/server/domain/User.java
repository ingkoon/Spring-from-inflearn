package Koon.sDiary.server.domain;


import com.sun.istack.NotNull;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {

    // 자동으로 부여되는 아이디
    @Id @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    // 유저 입력 아이디
    @NotNull
    private String userId;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    // 유저 입력 패스워드
    @NotNull
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @NotNull
    private String nickname;


    // 유저 입력 생년월일
    @NotNull
    private Date birth;
    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    // 평균 감정 값
    @ColumnDefault("normal") //default normal
    private String emotion;
    public String getEmotion() {
        return emotion;
    }
    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }
}
