package paws.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import paws.service.JwtAuthenticationFilter;
import paws.service.UserDetailService;


import javax.security.auth.login.AccountException;
import static jakarta.servlet.DispatcherType.ERROR;
import static jakarta.servlet.DispatcherType.FORWARD;
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
    /**
     * Запросы проходят фильтр, где происходит обработка токена,
     * который присылает клиент
     */
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfiguration(UserDetailService userDetailService,
                                 JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.userDetailService = userDetailService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    /**
     * шифрование паролей
     * проверка соответствия зашиврованного пароля и пароля в чистом виде
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * Основа процесса аутентификации spring security
     * Делегирует аутентификацию провайдевам - AuthenticationProvider
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws AccountException {
        try {
            return config.getAuthenticationManager();
        } catch (Exception e) {
            throw new AccountException("AuthenticationManager not configured: " + e.getMessage());
        }
    }

    /**
     * AuthenticationProvider - провайдер, которому делегируеся процесс аутентификации
     * DaoAuthenticationProvider - реализация AuthenticationProvider, занимающаяся аутентификацией
     */
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);  // для получения пользователя из хранилища
        provider.setPasswordEncoder(passwordEncoder()); // для работы с паролями
        return provider;
    }

    /**
     * Настройки spring security:
     * выбор провайдера
     * способа аутентификации
     * безопасновть запросов
     * управление доступами
     */
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authenticationProvider(authenticationProvider())
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/account/registration", "/account/login", "/")// запросы
//                        .permitAll()// разрешены всем
//                        .dispatcherTypeMatchers(FORWARD, ERROR).permitAll()// для отображения html
//                        .requestMatchers("/shelters") // запросы
//                        .hasAnyRole("USER", "SUPER_USER") // разрешены только пользователям с указанными ролями
////                        .anyRequest().authenticated()
//                                .anyRequest().permitAll()
//                )
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                // запросы необходимо пропускать через фильтр
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> {
            request.requestMatchers(
                    antMatcher("/"),
                    antMatcher("/test"),
                    antMatcher("/account/registration"),
                    antMatcher("/account/login")
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
