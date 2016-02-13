package lml.domain;

import java.io.Serializable;

/**
 * @Auther: Lmlj
 * @Date: 2016/2/13.
 */
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
