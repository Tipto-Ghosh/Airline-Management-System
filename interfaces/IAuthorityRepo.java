package interfaces;

import java.lang.*;
import entities.*;

public interface IAuthorityRepo {
   
    boolean addAuthority(Authority a);
	boolean removeAuthority(String userId);
	boolean updateAuthority(Authority a);
	Authority searchAuthorityByUserId(String id);
	Authority[] getAllAuthority();
     
}