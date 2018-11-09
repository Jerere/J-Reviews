package HarjoitusTyo.JReviews.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Arvosana {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long arvosanaid;
	private String arvosana;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "arvosana")
	private List<Review> reviews;

	public Arvosana() {
	}

	public Arvosana(String arvosana) {
		super();
		this.arvosana = arvosana;
	}

	public long getArvosanaid() {
		return arvosanaid;
	}

	public void setArvosanaid(long arvosanaid) {
		this.arvosanaid = arvosanaid;
	}

	public String getArvosana() {
		return arvosana;
	}

	public void setArvosana(String arvosana) {
		this.arvosana = arvosana;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Arvosana [arvosanaid=" + arvosanaid + ", arvosana=" + arvosana + "]";
	}

}
