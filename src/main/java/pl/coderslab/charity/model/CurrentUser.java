package pl.coderslab.charity.model;

import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Setter
public class CurrentUser extends User {
    private pl.coderslab.charity.model.User user;

    public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities, pl.coderslab.charity.model.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public pl.coderslab.charity.model.User getUser() {
        return user;
    }

}
