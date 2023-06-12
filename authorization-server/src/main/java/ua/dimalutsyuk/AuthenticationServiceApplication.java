package ua.dimalutsyuk;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(
        {
                @PropertySource("classpath:application.yml"),
                @PropertySource("classpath:.env")
        }

)
public class AuthenticationServiceApplication {
    public static void main(String[] args) {}
}
