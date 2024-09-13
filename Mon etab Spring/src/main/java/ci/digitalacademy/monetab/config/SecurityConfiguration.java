package ci.digitalacademy.monetab.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final SetupVerificationFilter setupVerificationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Désactiver la protection CSRF
                .authorizeHttpRequests(authz -> authz
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/public/**").permitAll()
                        .requestMatchers("/", "/AddSchool").permitAll() // Autoriser l'accès à la page de paramétrage et l'ajout d'école
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .requestMatchers("/v3/api-docs/**").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/api/students").permitAll()

                        .anyRequest().authenticated()  // Les autres pages nécessitent une authentification

                )
                .formLogin(form -> form
                        .loginPage("/login").permitAll()  // Autoriser l'accès à la page de connexion
                        .defaultSuccessUrl("/Dashboard", true)  // Rediriger vers /app-setting après une connexion réussie
                        .failureUrl("/login?error=true")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )
                // Ajouter le filtre personnalisé avant UsernamePasswordAuthenticationFilter
                .addFilterBefore(setupVerificationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
