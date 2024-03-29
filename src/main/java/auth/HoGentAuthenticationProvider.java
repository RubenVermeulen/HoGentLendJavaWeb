package auth;

import domain.Gebruiker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import service.GebruikerDao;
import static util.Utils.*;

@Component
public class HoGentAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private GebruikerDao gebruikerdao;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        List<Gebruiker> beheerders = gebruikerdao.getAllBeheerders();
        Gebruiker gebruiker = null;

        for (Gebruiker g : beheerders) {
            if (g.getEmail().equalsIgnoreCase(name)) {
                gebruiker = g;
                break;
            }
        }

        if (gebruiker == null) {
            return null;
        }

        try {
            if (connectToHoGent(name, password)) {
                List<GrantedAuthority> grantedAuths = new ArrayList<>();
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
                Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);

                return auth;
            } else {
                return null;
            }
        } catch (IOException|JSONException e) {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private boolean connectToHoGent(String username, String password) throws IOException, JSONException {

        String url = "https://studservice.hogent.be/auth/" + username + "/" + hash256(password);

        JSONObject json = readJsonFromUrl(url);

        if (json.getString("TYPE").equalsIgnoreCase("personeel")) {
            return true;
        } else {
            return false;
        }
    }

}
