package co.edu.escuelaing.arsw.bbapp;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import co.edu.escuelaing.arsw.bbapp.BBUser;

public class BBUserDetails implements UserDetails {
    private BBUser user;
    private final Set<GrantedAuthority> authorities;

    @SuppressWarnings("unchecked")
    public BBUserDetails(BBUser user, Collection<? extends GrantedAuthority> authorities) {
        this.user= user;
        this.authorities= (Set<GrantedAuthority>) authorities;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return user.getPass();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

}
