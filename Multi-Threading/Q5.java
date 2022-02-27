import java.util.concurrent.locks.ReentrantLock;

public class Q5 {
    public static void main(String[] args) throws InterruptedException {
        Q5 obj = new Q5();
        Account account1 = new Account("12345", 10000);
        Account account2 = new Account("123456", 20000);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                obj.lock(account1, account2);
                obj.transfer(account1, account2, 100);
                obj.unLock(account1, account2);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                obj.lock(account2, account1);
                obj.transfer(account2, account1, 100);
                obj.unLock(account2, account1);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Balance for both account: " + "Balance for account 1: "+account1.getAmount() + " Balance for account 2: "+account2.getAmount());
    }

    private void transfer(Account fromAccount, Account toAccount, Integer amount) {
        System.out.println("Transferring amount: " + amount + " from account: " + fromAccount.getAccountNumber() + " to account: " + toAccount.getAccountNumber());
        toAccount.setAmount(toAccount.getAmount() - amount);
        fromAccount.setAmount(fromAccount.getAmount() + amount);
    }

    private void lock(Account fromAccount, Account toAccount) {
        while (true) {
            Boolean fromAccountLocked = fromAccount.getLock().tryLock();
            Boolean toAccountLocked = toAccount.getLock().tryLock();
            if (fromAccountLocked && toAccountLocked) {
                return;
            }
            if(fromAccountLocked) {
                fromAccount.getLock().unlock();
            }
            if(toAccountLocked) {
                toAccount.getLock().unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void unLock(Account fromAccount, Account toAccount) {
        fromAccount.getLock().unlock();
        toAccount.getLock().unlock();
    }
}

class Account {
    private String accountNumber;
    private Integer amount;
    private ReentrantLock lock;

    public Account(String accountNumber, Integer amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.lock = new ReentrantLock();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ReentrantLock getLock() {
        return lock;
    }
}
