package database;

/*
 * Copyright
 */
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Factorial results JPA.
 * <p>
 * Suppress DataClass violation because it's a class for working with ORM.
 *
 * @since 0.0.1
 */
@Entity
@Table(schema = "public", name = "factorial_results")
@SuppressWarnings("PMD.DataClass")
public class FactorialResultsJpa {

    /**
     * Id of results row.
     * Autogenerated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private long id;

    /**
     * Calculation algorithm.
     */
    @ManyToOne()
    @JoinColumn(name = "factorial_id")
    private FactorialJpa factorial;

    /**
     * Date of calculation.
     */
    @Column(name = "date")
    private Date date;

    /**
     * Value for which need to calculate a factorial.
     */
    @Column(name = "value")
    private long value;

    /**
     * Result of calculation.
     */
    @Column(name = "result")
    private long result;

    /**
     * Empty constructor for ORM.
     * Don't use it
     */
    protected FactorialResultsJpa() {
        //Empty constructor for creation using ORM.
    }

    /**
     * Constructor with filling the data.
     *
     * @param fact Factorial algoritm.
     * @param val Value to calculate.
     * @param res Result of calculation.
     */
    public FactorialResultsJpa(
            final FactorialJpa fact,
            final long val,
            final long res) {
        this.factorial = fact;
        this.value = val;
        this.result = res;
        this.date = new Date();
    }

    /**
     * Get ID of row.
     *
     * @return Id.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Get factorial type.
     *
     * @return Factorial type.
     */
    public FactorialJpa getFactorial() {
        return this.factorial;
    }

    /**
     * Get date of calculation.
     *
     * @return Calculation date.
     */
    public Date getDate() {
        return (Date) this.date.clone();
    }

    /**
     * Get value for which need to calculate a factorial.
     *
     * @return Value for which need to calculate a factorial.
     */
    public long getValue() {
        return this.value;
    }

    /**
     * Get result of calculation.
     *
     * @return Result of calculation.
     */
    public long getResult() {
        return this.result;
    }

}



