package paws.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import paws.service.UserDetailService;


import static org.springframework.security.config.http.SessionCreationPolicy.ALWAYS;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfiguration {
    /**
     * отвечает за извлечение пользователя: из БД, файла и т.д
     * Пользователь, полученный из БД сравнивается с пользователем из формы или токена
     */
    private final UserDetailService userDetailService;

    public SecurityConfiguration(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    /**
     * шифрование паролей
     * проверка соответствия зашиврованного пароля и пароля в чистом виде
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> {
            request.requestMatchers(
                    antMatcher("/"),
                    antMatcher("/test"),
                    antMatcher("/account/registration")
            ).permitAll();
            request.requestMatchers(
                    antMatcher("/shelters")
            ).hasAnyRole("USER", "SUPER_USER");
            request.anyRequest().authenticated();
        });

        http.userDetailsService(userDetailService);
        http.formLogin(Customizer.withDefaults());
        http.sessionManagement(session -> session.sessionCreationPolicy(ALWAYS));
        http.logout(logout -> logout.logoutSuccessUrl("/"));

        return http.build();
    }
}
