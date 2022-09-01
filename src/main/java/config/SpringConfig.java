package config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"dao","model","service","utils"})
@PropertySource("DB.properties")
@EnableAspectJAutoProxy //ע�⿪��
public class SpringConfig {
}
