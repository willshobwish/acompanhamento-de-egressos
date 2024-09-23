import java.util.Date;
import java.util.List;

public class Egress extends User {
    private Date birthDate;
    private Date startDate;
    private Date endDate;
    private List<String> socialMedias;
    private String perfilType;

    public Egress(String name, String email, String password, Date birthDate, Date startDate, Date endDate,
            List<String> socialMedias, String perfilType) {
        super(name, email, password);
        this.birthDate = birthDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.socialMedias = socialMedias;
        this.perfilType = perfilType;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<String> getSocialMedias() {
        return socialMedias;
    }

    public void setSocialMedias(List<String> socialMedias) {
        this.socialMedias = socialMedias;
    }

    public String getPerfilType() {
        return perfilType;
    }

    public void setPerfilType(String perfilType) {
        this.perfilType = perfilType;
    }
}
