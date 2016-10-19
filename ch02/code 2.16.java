package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Confugration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CDConfig.class)
public class CDPlayerConfig {

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
	return new CDPlayer(compactDisc);
    }

}
