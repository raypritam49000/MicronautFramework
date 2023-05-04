package micronaut.example.java.techie.config;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import org.modelmapper.ModelMapper;

@Factory
public class AppConfig {
    
   @Bean
   public ModelMapper modelMapper(){
      return new ModelMapper();
   }
}