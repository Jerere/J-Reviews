package HarjoitusTyo.JReviews.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String tuoteTyyppi;
	private String tuoteNimi;
	private double tuoteHinta;
	private String tuoteLaatu;
	private String tuoteTiedot;
	private String arvosteluPaivaus;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "arvosanaid")
	private Arvosana arvosana;

	public Review() {
	}

	public Review(String tuoteTyyppi, String tuoteNimi, double tuoteHinta, String tuoteLaatu, String tuoteTiedot, String arvosteluPaivaus, Arvosana arvosana) {
		super();
		this.tuoteTyyppi = tuoteTyyppi;
		this.tuoteNimi = tuoteNimi;
		this.tuoteHinta = tuoteHinta;
		this.tuoteLaatu = tuoteLaatu;
		this.tuoteTiedot = tuoteTiedot;
		this.arvosteluPaivaus = arvosteluPaivaus;
		this.arvosana = arvosana;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTuoteTyyppi() {
		return tuoteTyyppi;
	}

	public void setTuoteTyyppi(String tuoteTyyppi) {
		this.tuoteTyyppi = tuoteTyyppi;
	}

	public String getTuoteNimi() {
		return tuoteNimi;
	}

	public void setTuoteNimi(String tuoteNimi) {
		this.tuoteNimi = tuoteNimi;
	}

	public double getTuoteHinta() {
		return tuoteHinta;
	}

	public void setTuoteHinta(double tuoteHinta) {
		this.tuoteHinta = tuoteHinta;
	}

	public String getTuoteLaatu() {
		return tuoteLaatu;
	}

	public void setTuoteLaatu(String tuoteLaatu) {
		this.tuoteLaatu = tuoteLaatu;
	}

	public String getTuoteTiedot() {
		return tuoteTiedot;
	}

	public void setTuoteTiedot(String tuoteTiedot) {
		this.tuoteTiedot = tuoteTiedot;
	}

	public String getArvosteluPaivaus() {
		return arvosteluPaivaus;
	}

	public void setArvosteluPaivaus(String arvosteluPaivaus) {
		this.arvosteluPaivaus = arvosteluPaivaus;
	}

	public Arvosana getArvosana() {
		return arvosana;
	}

	public void setArvosana(Arvosana arvosana) {
		this.arvosana = arvosana;
	}
	

	@Override
	public String toString() {
		if (this.arvosana != null)
			return "Review [id=" + id + ", tuoteTyyppi=" + tuoteTyyppi + ", tuoteNimi=" + tuoteNimi + ", tuoteHinta="
					+ tuoteHinta + ", tuoteLaatu=" + tuoteLaatu + ", tuoteTiedot=" + tuoteTiedot + ", arvosteluPaivaus="
					+ arvosteluPaivaus + " arvosana =" + this.getArvosana() + "]";

		else
			return "Review [id=" + id + ", tuoteTyyppi=" + tuoteTyyppi + ", tuoteNimi=" + tuoteNimi + ", tuoteHinta="
					+ tuoteHinta + ", tuoteLaatu=" + tuoteLaatu + ", tuoteTiedot=" + tuoteTiedot + ", arvosteluPaivaus="
					+ arvosteluPaivaus + "]";
	}

}
