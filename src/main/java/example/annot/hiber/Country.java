package example.annot.hiber;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    @Getter
    @Setter
    private int id;

    @Column(name="name", length=50, nullable = true)
    @Getter
    @Setter
    private  String name;

    @Column(name="continent", length=50, nullable = true)
    @Getter
    @Setter
    private String continent;

    @ManyToOne
    @JoinColumn(name="capital_id", foreignKey = @ForeignKey(name="CATEGORY_ID_FK"))
    @Getter
    @Setter
    private Capital capital;


}
