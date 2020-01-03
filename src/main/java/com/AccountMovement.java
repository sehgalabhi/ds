package streams.abhi.account;

public class AccountMovement {

    String accountId;

    String accountBal;

    String accountIdentifier;

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

    @Override
    public String toString() {
        return "AccountMovement{" +
                "accountId='" + accountId + '\'' +
                ", accountBal='" + accountBal + '\'' +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                '}';
    }
}
