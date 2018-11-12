package HarjoitusTyo.JReviews;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import HarjoitusTyo.JReviews.Model.Arvosana;
import HarjoitusTyo.JReviews.Model.ArvosanaRepository;
import HarjoitusTyo.JReviews.Model.Review;
import HarjoitusTyo.JReviews.Model.ReviewRepository;
import HarjoitusTyo.JReviews.Model.User;
import HarjoitusTyo.JReviews.Model.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JReviewsRepositoryTest {

	@Autowired
	private ReviewRepository rRepo;
	
	@Autowired
	private ArvosanaRepository aRepo;
	
	@Autowired
	private UserRepository uRepo;
	
	// CREATE TESTS
	
	@Test
	public void createNewReview() {
		Review review = new Review("Test Review", "test", 20.0, "test", "test", "test", new Arvosana("testi arvosana"));
		rRepo.save(review);
		assertThat(review.getId()).isNotNull();
	}
	
	@Test
	public void createNewArvosana() {
		Arvosana arvosana = new Arvosana("Testi arvosana 123");
		aRepo.save(arvosana);
		assertThat(arvosana.getArvosanaid()).isNotNull();
	}
	
	@Test
	public void createNewUser() {
		User user = new User("test user", "test password", "usertest");
		uRepo.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	// SEARCH TEST
	
	@Test
	public void findbyTuoteNimiShouldReturnTuoteTyyppi() {
		List<Review> tuoteNimi = rRepo.findByTuoteNimi("Jaffa");
		assertThat(tuoteNimi).hasSize(1);
		assertThat(tuoteNimi.get(0).getTuoteTyyppi()).isEqualTo("Elintarvike");
	}
	
	@Test
	public void findByArvosanaShouldReturnId() {
		List<Arvosana> arvosana = aRepo.findByArvosana("5/5");
		assertThat(arvosana).hasSize(1);
		assertThat(arvosana.get(0).getArvosanaid()).isEqualTo(4);
	}
	
	@Test
	public void findByusernameShouldReturnRole() {
		User user = uRepo.findByUsername("user");
		assertThat(user.getRole()).isEqualTo("USER");
	}
	
	// DELETE TESTS
	
	@Test
	public void deleteReview() {
		List<Review> review = rRepo.findByTuoteNimi("Jaffa");
		assertThat(review).hasSize(1);
		rRepo.delete(review.get(0));
		
		List<Review> deletedReview = rRepo.findByTuoteNimi("Jaffa");
		assertThat(deletedReview).hasSize(0);
		
	}
	@Test
	public void deleteUser() {
		User username = uRepo.findByUsername("admin");
		assertThat(username).isNotNull();
		uRepo.delete(username);
		
		User deletedUsername = uRepo.findByUsername("admin");
		assertThat(deletedUsername).isNull();
	}
	
	@Test
	public void deleteArvosana() {
		List<Arvosana> arvosana = aRepo.findByArvosana("Hyvä");
		assertThat(arvosana).isNotNull();
		aRepo.delete(arvosana.get(0));
		
		List<Arvosana> deletedArvosana = aRepo.findByArvosana("Hyvä");
		assertThat(deletedArvosana).hasSize(0);
	}
}