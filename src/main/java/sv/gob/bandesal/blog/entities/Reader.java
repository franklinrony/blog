package sv.gob.bandesal.blog.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the READERS database table.
 *
 */
@Entity
@Table(name = "READERS", schema = "BANDESAL")
public class Reader implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableGenerator(name = "READER_SQ", table = "SECUENCIAS", pkColumnName = "NOMBRE",
            valueColumnName = "VALOR", pkColumnValue = "READER_ID_SQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "READER_SQ")
    private Long id;

    private String name;

    //bi-directional many-to-many association to Blog
    @ManyToMany(mappedBy = "readers")
    private List<Blog> blogs;

    public Reader() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return this.blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

}
