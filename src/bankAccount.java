public class bankAccount {
    private String customerName;
    private String accountNumber;
    private double balance;
    private String cardID;

    public bankAccount(String customerName, String accountNumber, double balance, String cardID) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.cardID = cardID;
    }

    public String getCustomName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            String toString_deposit_true = String.format("ยอดเงินคงเหลือ : " + getBalance());
            return toString_deposit_true;
        } else {
            String toString_deposit_false = String.format("ทำรายการไม่ถูกต้อง กรุณาลองใหม่อีกครั้ง");
            return toString_deposit_false;
        }
    }

    public String withDraw(double amount) {
        if (amount > 0 && amount <= balance) {
            setBalance(getBalance() - amount);
            String tostring_withdraw_true = String.format("ยอดเงินคงเหลือ : " + getBalance());
            return tostring_withdraw_true;
        } else {
            String toString_withdraw_false = String.format("ทำรายการไม่ถูกต้อง กรุณาลองใหม่อีกครั้ง");
            return toString_withdraw_false;
        }
    }
}