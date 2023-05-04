package micronaut.example.java.techie.dtos;

public class PersonDTO {
    private Long id;
    private String name;
    private String city;
    private String age;
    private String email;
    private String phone;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, String city, String age, String email, String phone) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public PersonDTO(String name, String city, String age, String email, String phone) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
