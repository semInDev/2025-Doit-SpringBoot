package com.mysite.sbb.service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.domain.SiteUser;
import com.mysite.sbb.domain.constant.UserRole;
import com.mysite.sbb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String password, String email) {
        SiteUser siteUser = new SiteUser();
        siteUser.setUsername(username);
        siteUser.setEmail(email);
        //ser의 비밀번호는 보안을 위해 반드시 암호화하여 저장해야 한다.
        // 그러므로 스프링 시큐리티의 BCryptPasswordEncoder 클래스를 사용하여
        // 암호화하여 비밀번호를 저장했다.
        siteUser.setPassword(passwordEncoder.encode(password));
        //siteUser.setPassword(password);
        this.userRepository.save(siteUser);

        return siteUser;
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByUsername(username);
        if(siteUser.isPresent()) {
            return siteUser.get();
        }else{
            throw new DataNotFoundException("siteuser not found");
        }
    }
}
