package teste.mvp.com.apptestemvp.domain.entities;

/**
 * Created by softvaro on 28/08/17.
 */

public class Marca {

    private String name;
    private String fipe_name;
    private Long order;
    private String key;
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFipe_name() {
        return fipe_name;
    }

    public void setFipe_name(String fipe_name) {
        this.fipe_name = fipe_name;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "name='" + name + '\'' +
                ", fipe_name='" + fipe_name + '\'' +
                ", order=" + order +
                ", key='" + key + '\'' +
                ", id=" + id +
                '}';
    }
}
