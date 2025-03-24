package entities;

import java.lang.*;

public class Authority extends User {
    
    private String authorityType;

    public Authority() {}

    public Authority(String userId, String name, String email, String phoneNo, String gender, int age, String address, int role, String securityAns, String password, String authorityType) {
        super(userId, name, email, phoneNo, gender, age, address, role, securityAns, password); 
        this.authorityType = authorityType;
    }

    public void setAuthorityType(String authorityType) {
        this.authorityType = authorityType;
    }

    public String getAuthorityType() {
        return this.authorityType;
    }

    
    public String toString(){ // Call parent and then add rest of the data
        return super.toStringUser() + "," + this.authorityType;
    }

    public Authority formAuthority(String authorityInfoLine) {
        String[] authorityInfo = authorityInfoLine.split(",");
        if (authorityInfo.length < 11) {
            System.out.println("Missing info to form an Authority.");
            return null;
        }
    
        try {
            Authority authority = new Authority();
            authority.setUserId(authorityInfo[0]);
            authority.setName(authorityInfo[1]);
            authority.setEmail(authorityInfo[2]);
            authority.setPhoneNo(authorityInfo[3]);
            authority.setGender(authorityInfo[4]);
            authority.setAge(Integer.parseInt(authorityInfo[5]));
            authority.setAddress(authorityInfo[6]);
            authority.setRole(Integer.parseInt(authorityInfo[7]));
            authority.setSecurityAns(authorityInfo[8]);
            authority.setPassword(authorityInfo[9]);
            authority.setAuthorityType(authorityInfo[10]);
            return authority;
        } catch (Exception e) {
            System.out.println("Error in parsing authorityInfoLine.");
            return null;
        }
    }
    
}
