package entities;
import java.lang.*;

public class Client extends User {
    private String membershipType;

    public Client() {
    }

    public Client(String userId, String name, String email, String phoneNo, String gender, int age, String address, int role, String securityAns, String password, String membershipType) {
        super(userId, name, email, phoneNo, gender, age, address, role, securityAns, password);
        this.membershipType = membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getMembershipType() {
        return this.membershipType;
    }

    public String toStringClient() {
        return this.userId + "," + this.name + "," + this.email + "," + this.phoneNo + "," + this.gender + "," + this.age + "," + this.address + "," + this.role + "," + this.securityAns + "," + this.password + "," + this.membershipType + "\n";
    }

    public Client formClient(String clientInfoLine) {
        String[] clientInfo = clientInfoLine.split(",");
        if (clientInfo.length < 11) {
            System.out.println("Missing Data In Client");
            return null;
        }

        try {
            Client client = new Client();
            client.setUserId(clientInfo[0]);
            client.setName(clientInfo[1]);
            client.setEmail(clientInfo[2]);
            client.setPhoneNo(clientInfo[3]);
            client.setGender(clientInfo[4]);
            client.setAge(Integer.parseInt(clientInfo[5]));
            client.setAddress(clientInfo[6]);
            client.setRole(Integer.parseInt(clientInfo[7]));
            client.setSecurityAns(clientInfo[8]);
            client.setPassword(clientInfo[9]);
            client.setMembershipType(clientInfo[10]);
            return client;
        } catch (Exception e) {
            System.out.println("Some Error In Client Class");
            return null;
        }
    }
}
