package HarjoitusTyo.JReviews.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import HarjoitusTyo.JReviews.Model.ArvosanaRepository;
import HarjoitusTyo.JReviews.Model.Review;
import HarjoitusTyo.JReviews.Model.ReviewRepository;

@Controller
public class JReviewsController {

	@Autowired
	private ReviewRepository reviewrepository;
	@Autowired
	private ArvosanaRepository arvosanaRepository;

	// FIND ALL REVIEWS RESTFULLY
	@RequestMapping("/reviews")
	public @ResponseBody List<Review> findReviewRest() {
		return (List<Review>) reviewrepository.findAll();
	}

	// FIND REVIEW WITH ID RESTFULLY
	@RequestMapping("/reviews/{id}")
	public @ResponseBody Optional<Review> findReviewRest(@PathVariable("id") Long reviewId) {
		return reviewrepository.findById(reviewId);
	}

	// SHOW REVIEW LIST
	@RequestMapping(value = "/reviewlist", method = RequestMethod.GET)
	public String reviewController(Model model) {
		model.addAttribute("reviews", reviewrepository.findAll());
		return "frontPage";
	}

	// ADD REVIEW
	@RequestMapping(value = "/add")
	public String addReview(Model model) {
		model.addAttribute("review", new Review());
		model.addAttribute("arvosanat", arvosanaRepository.findAll());
		return "addReview";
	}

	// SAVE REVIEW
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Review review) {
		reviewrepository.save(review);
		return "redirect:reviewlist";
	}

	// DELETE REVIEW
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteReview(@PathVariable("id") Long reviewId, Model model) {
		reviewrepository.deleteById(reviewId);
		return "redirect:../reviewlist";
	}

	// EDIT REVIEW
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editReview(@PathVariable("id") Long reviewId, Model model) {
		model.addAttribute("review", reviewrepository.findById(reviewId));
		model.addAttribute("arvosanat", arvosanaRepository.findAll());
		return "editReview";
	}

	// FIND REVIEW
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String findReview(@PathVariable("id") Long reviewId, Model model) {
		model.addAttribute("review", reviewrepository.findById(reviewId));
		return "showReview";
	}
}
