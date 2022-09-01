package config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"dao","model","service","utils"})
@PropertySource("DB.properties")
@EnableAspectJAutoProxy //×¢½â¿ª·¢
public class SpringConfig {
}
