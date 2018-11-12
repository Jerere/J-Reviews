package HarjoitusTyo.JReviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import HarjoitusTyo.JReviews.Controller.JReviewsController;
import HarjoitusTyo.JReviews.Controller.UserDetailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JReviewsApplicationTests {

	@Autowired
	private JReviewsController controller;

	@Autowired
	private UserDetailServiceImpl userdetails;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(userdetails).isNotNull();
	}
}