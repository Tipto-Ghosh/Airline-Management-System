package entities;
import java.lang.*;
public class User {
    protected String userId, name, email, phoneNo, gender, address, securityAns, password;
    protected int age, role;

    public User() {
    }

    public User(String userId, String name, String email, String phoneNo, String gender, int age, String address, int role, String securityAns, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.role = role;
        this.securityAns = securityAns;
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setSecurityAns(String securityAns) {
        this.securityAns = securityAns;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public String getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    public String getAddress() {
        return this.address;
    }

    public int getRole() {
        return this.role;
    }

    public String getSecurityAns() {
        return this.securityAns;
    }

    public String getPassword() {
        return this.password;
    }

    public String toStringUser() {
        return this.userId + "," + this.name + "," + this.email + "," + this.phoneNo + "," + this.gender + "," + this.age + "," + this.address + "," + this.role + "," + this.securityAns + "," + this.password + "\n";
    }

    public User formUser(String infoLine) {
        String[] info = infoLine.split(","); // Save all the user info in a String array
        if (info.length < 10) {
            System.out.println("Error: infoLine does not contain enough data to form a User.");
            return null;
        }

        User user = new User();
        user.setUserId(info[0]);
        user.setName(info[1]);
        user.setEmail(info[2]);
        user.setPhoneNo(info[3]);
        user.setGender(info[4]);
        user.setAge(Integer.parseInt(info[5]));
        user.setAddress(info[6]);
        user.setRole(Integer.parseInt(info[7]));
        user.setSecurityAns(info[8]);
        user.setPassword(info[9]);

        return user;
    }
}

