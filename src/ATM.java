import java.util.Scanner;

public class ATM extends bankAccount {
    public ATM(String customerName, String accountNumber, double balance, String cardId) {
        super(customerName, accountNumber, balance, cardId);
        this.getCardID();
        this.getCustomName();
        this.getAccountNumber();
        this.getBalance();
    }

    private boolean checkCardId() {
        Scanner scanner_cardId = new Scanner(System.in);
        System.out.print("กรุณาใส่รหัสบัตร ATM : ");
        String input_cardId = scanner_cardId.next();

        if (input_cardId.equals(getCardID())) {
            return true;
        } else {
            return false;
        }
    }

    public void checkTransaction() {
        System.out.print("ชื่อบัญชี : ");
        System.out.println(getCustomName());
        System.out.println("===================");
        System.out.println("กรุณาเลือกธุรกรรมของคุณ");
        System.out.println("1. ฝากเงิน");
        System.out.println("2. ถอนเงิน");
        System.out.println("3. เช็คยอด");
        System.out.println("4. ยกเลิกธุรกรรม");
        System.out.println("===================");

        Scanner select_tran = new Scanner(System.in);

        boolean cancel_tran = false;
        while (!cancel_tran) {
            System.out.print("เลือกธุรกรรมของคุณ : ");
            char select_req = select_tran.next().charAt(0);
            System.out.println();
            switch (select_req) {
                case '1':
                    Scanner deposit_req = new Scanner(System.in);
                    System.out.print("กรุณาระบุจำนวนเงินที่ต้องการฝาก : ");
                    double deposit_inp = deposit_req.nextDouble();
                    System.out.println(deposit(deposit_inp));
                    System.out.println("ทำรายการเสร็จสิ้น ขอบคุณที่ใช้บริการ");
                    System.out.println("===================");
                    System.out.println("ขอบคุณที่ใช้บริการ ATM CPE Bank");
                    break;
                case '2':
                    Scanner withdraw_req = new Scanner(System.in);
                    System.out.print("กรุณาระบุจำนวนเงินที่ต้องการถอน : ");
                    double withdraw_inp = withdraw_req.nextDouble();
                    System.out.println(withDraw(withdraw_inp));
                    System.out.println("ทำรายการเสร็จสิ้น ขอบคุณที่ใช้บริการ");
                    System.out.println("===================");
                    System.out.println("ขอบคุณที่ใช้บริการครับ ATM CPE Bank");
                    break;
                case '3':
                    System.out.print("ยอดเงินคงเหลือของคุณตอนนี้ : ");
                    System.out.println(getBalance());
                    System.out.println("===================");
                    System.out.println("ขอบคุณที่ใช้บริการครับ ATM CPE Bank");
                    break;
                default:
                    cancel_tran = true;
                    System.out.println("ยกเลิกการทำธุรกรรมของคุณ");
                    System.out.println("===================");
                    System.out.println("ขอบคุณที่ใช้บริการ ATM CPE Bank");
                    break;
            }
        }
    }

    public void insertCard() {
        for (int round_check = 1; round_check <= 5; round_check++) {
            if (checkCardId()) {
                checkTransaction();
                break;
            } else if (round_check == 5) {
                System.out.println("คุณใส่รหัสไม่ถูกต้อง หลายครั้งเกินไป");
                break;
            } else {
                System.out.println("คุณใส่รหัสไม่ถูกต้อง กรุณาลองใหม่อีกครั้ง");
                continue;
            }
        }
    }

    public static void main(String[] args) {
        ATM acc1 = new ATM("Mr.Earth", "120-222-999", 90000.00, "780880");
        ATM acc2 = new ATM("Mrs.Pim", "120-333-888", 235000.00, "150550");

        System.out.println("====CPE Bank====");
        System.out.println("ยินดีต้อนรับ");
        System.out.println();

        Scanner acc_num_req = new Scanner(System.in);
        System.out.print("กรุณาป้อนเลขบัญชี : ");
        String acc_num_inp = acc_num_req.next();

        if (acc_num_inp.equals(acc1.getAccountNumber())) {
            acc1.insertCard();
        } else if (acc_num_inp.equals(acc2.getAccountNumber())) {
            acc2.insertCard();
        }
    }
}