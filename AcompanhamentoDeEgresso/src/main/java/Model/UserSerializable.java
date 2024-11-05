package  Model;

import java.util.List;
import java.util.Date;

public class UserSerializable implements Serializable {

    @Override
    public boolean emailCheck(String email, List<User> users) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addUser(User user, List<User> users) {
        if (!emailCheck(user.getEmail(), users)) {
            users.add(user);
            System.out.println("Usuario adicionado com sucesso: " + user.getName());
        } else {
            System.out.println("Email ja existe: " + user.getEmail());
        }
    }
 
    @Override
    public boolean login(String email, String password, List<User> users) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("login realizado com sucesso: " + user.getName());
                return true;
            }
        }
        System.out.println("Falha: login ou senha invalidos.");
        return false;
    }

    @Override
    public void updateEgress(Date birthDate, Date startDate, Date endDate, String[] socialMedia, boolean visibility, List<User> users) {
        for (User user : users) {
            if (user instanceof Egress) {
                Egress egressUser = (Egress) user;
                egressUser.setBirthDate(birthDate);
                egressUser.setStartDate(startDate);
                egressUser.setEndDate(endDate);
                egressUser.setSocialMedias(List.of(socialMedia));
                egressUser.setPerfilType(visibility ? "public" : "private");
                System.out.println("Egresso " + egressUser.getName() + " updated successfullyatualizado com sucesso.");
                return;
            }
        }
        System.out.println("Egresso não encontrado.");
    }

    @Override
    public void updateEgress(String email, String password, Date birthDate, Date startDate, Date endDate, String[] socialMedia, boolean visibility, List<User> users) {
        for (User user : users) {
            if (user instanceof Egress && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                Egress egressUser = (Egress) user;
                egressUser.setBirthDate(birthDate);
                egressUser.setStartDate(startDate);
                egressUser.setEndDate(endDate);
                egressUser.setSocialMedias(List.of(socialMedia));
                egressUser.setPerfilType(visibility ? "public" : "private");
                System.out.println("Egresso " + egressUser.getName() + " atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Egress nao encontrado ou credenciais invalidas.");
    }
}
