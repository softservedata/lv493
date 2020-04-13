package sergii.kryvenko.selenium;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oc_product_description")
public class ProductDescriprion implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
//    private Product id;

    /**
     * 
     */
    private static final long serialVersionUID = 1086719845024591078L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int language_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "tag")
    private String tag;

    @Column(name = "meta_title")
    private String meta_title;

    @Column(name = "meta_description")
    private String meta_description;

    @Column(name = "meta_keyword")
    private String meta_keyword;

    public ProductDescriprion() {
    }

    public ProductDescriprion(int language_id, String name, String description,
            String tag, String meta_title, String meta_description,
            String meta_keyword) {
        this.language_id = language_id;
        this.name = name;
        this.description = description;
        this.tag = tag;
        this.meta_title = meta_title;
        this.meta_description = meta_description;
        this.meta_keyword = meta_keyword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMeta_title() {
        return meta_title;
    }

    public void setMeta_title(String meta_title) {
        this.meta_title = meta_title;
    }

    public String getMeta_description() {
        return meta_description;
    }

    public void setMeta_description(String meta_description) {
        this.meta_description = meta_description;
    }

    public String getMeta_keyword() {
        return meta_keyword;
    }

    public void setMeta_keyword(String meta_keyword) {
        this.meta_keyword = meta_keyword;
    }

    @Override
    public String toString() {
        return "ProductDescriprion [id=" + id + ", name=" + name + "]";
    }

}
