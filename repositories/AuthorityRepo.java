package repositories;

import java.lang.*;
import entities.*;
import interfaces.*;

public class AuthorityRepo implements IAuthorityRepo {

    private static final int MAX_AUTHORITIES = 100;
    private static final String FILE_PATH = "repositories/data/authority.txt";
    
    private void write(Authority[] authorityList) {
        String[] authorInfo = new String[MAX_AUTHORITIES];

        for (int i = 0; i < MAX_AUTHORITIES; i++) {
            if (authorityList[i] != null) {
                authorInfo[i] = authorityList[i].toString();
            }
        }

        FileIO f = new FileIO();
        f.writeFile(authorInfo, FILE_PATH);
    }

    public Authority[] getAllAuthority() {
        FileIO f = new FileIO();
        String[] authorInfo = f.readFile(FILE_PATH);
        
        Authority[] authorityList = new Authority[MAX_AUTHORITIES];
        Authority authorityTemplate = new Authority();

        for (int i = 0; i < authorInfo.length; i++) {
            if (authorInfo[i] != null && !authorInfo[i].isEmpty()) {
                authorityList[i] = authorityTemplate.formAuthority(authorInfo[i]);
            }
        }

        return authorityList;
    }

    public Authority searchAuthorityByUserId(String id) {
        Authority[] authorities = this.getAllAuthority();

        for (Authority authority : authorities) {
            if (authority != null && authority.getUserId().equals(id)) {
                return authority;
            }
        }

        return null;
    }

    public boolean addAuthority(Authority a) {
        Authority[] authorities = this.getAllAuthority();

        for (int i = 0; i < authorities.length; i++) {
            if (authorities[i] == null) {
                authorities[i] = a;
                this.write(authorities);
                return true;
            }
        }

        return false;
    }

    public boolean removeAuthority(String userId) {
        Authority[] authorities = this.getAllAuthority();
        
        for (int i = 0; i < authorities.length; i++) {
            if (authorities[i] != null && authorities[i].getUserId().equals(userId)) {
                authorities[i] = null;
                this.write(authorities);
                return true;
            }
        }

        return false;
    }

    public boolean updateAuthority(Authority a) {
        Authority[] authorities = this.getAllAuthority();

        for (int i = 0; i < authorities.length; i++) {
            if (authorities[i] != null && authorities[i].getUserId().equals(a.getUserId())) {
                authorities[i] = a;
                this.write(authorities);
                return true;
            }
        }

        return false;
    }
}
