package streams.abhi.account;

public class AccountMovementType {

    String accountId;

    String accountBal;

    String accountIdentifier;


    String accountName;

    String accountDesc;

    public AccountMovementType(String accountId, String accountBal, String accountIdentifier, String accountName, String accountDesc) {
        this.accountId = accountId;
        this.accountBal = accountBal;
        this.accountIdentifier = accountIdentifier;
        this.accountName = accountName;
        this.accountDesc = accountDesc;
    }

    public AccountMovementType() {
    }

    @Override
    public String toString() {
        return "AccountMovementType{" +
                "accountId='" + accountId + '\'' +
                ", accountBal='" + accountBal + '\'' +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountDesc='" + accountDesc + '\'' +
                '}';
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountBal() {
        return accountBal;
    }

    public void setAccountBal(String accountBal) {
        this.accountBal = accountBal;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }
}
