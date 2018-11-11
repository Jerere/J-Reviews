package HarjoitusTyo.JReviews;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import HarjoitusTyo.JReviews.Model.Arvosana;
import HarjoitusTyo.JReviews.Model.ArvosanaRepository;
import HarjoitusTyo.JReviews.Model.Review;
import HarjoitusTyo.JReviews.Model.ReviewRepository;
import HarjoitusTyo.JReviews.Model.User;
import HarjoitusTyo.JReviews.Model.UserRepository;

@SpringBootApplication
public class JReviewsApplication {
	private static final Logger log = LoggerFactory.getLogger(JReviewsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JReviewsApplication.class, args);
	}

	@Bean
	public CommandLineRunner reviewDemo(ReviewRepository reviewrepository, ArvosanaRepository arvosanarepository, UserRepository userRepository) {
		return (args) -> {
			log.info("Hieman testidataa :) ");

			arvosanarepository.save(new Arvosana("Huono"));
			arvosanarepository.save(new Arvosana("Kohtalainen"));
			arvosanarepository.save(new Arvosana("Hyvä"));
			arvosanarepository.save(new Arvosana("5/5"));
			
			String lisatieto1 = "Hyvä langaton hiiri hintaansa nähden. Tilattu Kiinasta Ebayn kautta. Vuoden aikana vaihtanut paristot kerran.";
			String lisatieto2 = "Hyvän makuinen ja luotettava virvoke. Hinta hieman kallis omaan makuuni mutta suosittelen siitä huolimatta";

			reviewrepository.save(new Review("Elektroniikka", "2,4 Ghz Wireless Optical Mouse", 3.50, "Kohtalainen", lisatieto1, "30.10.2018", arvosanarepository.findByArvosana("Hyvä").get(0)));
			reviewrepository.save(new Review("Elintarvike", "Jaffa", 2.5, "Kiitettävä", lisatieto2, "06.10.2018", arvosanarepository.findByArvosana("Hyvä").get(0)));
			
			User user1 = new User("user", "$2a$10$SvpCwzfI4kWO4PDrtVGntOFp9fjK9PudHNHe.WT7HN7XB0HRrIYzi", "USER");
			User user2 = new User("admin", "$2a$10$koYgEIHUhmd1DrUY4KqD3uUHFQyG2MzdklR98Tpuv7XkYYGbRBXJe", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
				
			log.info("hae kaikki arvostelut");
			for (Review review : reviewrepository.findAll()) {
				log.info(review.toString());
			}
		};
	}

}
