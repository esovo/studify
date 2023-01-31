package com.ssafy.db.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ProfileImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String filePath;

    @OneToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    private User user;

    @Builder
    public ProfileImg(String name, String type, String filePath, User user){
        this.name = name;
        this.type = type;
        this.filePath = filePath;
        this.user = user;
    }

    public void updateProfileImg(MultipartFile multipartFile, String filePath) {
        this.name = multipartFile.getOriginalFilename();
        this.type = multipartFile.getContentType();
        this.filePath = filePath;
    }

}
