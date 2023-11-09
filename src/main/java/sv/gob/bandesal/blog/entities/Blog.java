package sv.gob.bandesal.blog.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the BLOGS database table.
 *
 */
@Entity
@Table(name = "BLOGS", schema = "BANDESAL")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableGenerator(name = "BLOG_SQ", table = "SECUENCIAS", pkColumnName = "NOMBRE",
            valueColumnName = "VALOR", pkColumnValue = "BLOG_ID_SQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "BLOG_SQ")
    private Long id;

    private String description;

    private String title;

    //bi-directional many-to-many association to Reader
    @ManyToMany
    @JoinTable(
            name = "BLOGS_READERS",
             joinColumns = {
                @JoinColumn(name = "BLOGS_ID")
            },
             inverseJoinColumns = {
                @JoinColumn(name = "READERS_ID")
            }
    )
    private List<Reader> readers;

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }   

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Reader> getReaders() {
        return this.readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

}
