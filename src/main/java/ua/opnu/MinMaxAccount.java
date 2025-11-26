package ua.opnu;

public class MinMaxAccount extends BankingAccount {

    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        int initial = getBalance();
        minBalance = initial;
        maxBalance = initial;
    }

    @Override
    public void credit(int amount) {
        super.credit(amount);
        updateMinMax();
    }

    @Override
    public void debit(int amount) {
        super.debit(amount);
        updateMinMax();
    }

    private void updateMinMax() {
        int current = getBalance();
        if (current < minBalance) {
            minBalance = current;
        }
        if (current > maxBalance) {
            maxBalance = current;
        }
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }
}
