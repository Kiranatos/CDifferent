package net.kiranatos.softserve.jom.s5.t5;

class InsufficientAmountException extends RuntimeException {    
    private double amount;

    public InsufficientAmountException(double amount) {        
        super("Sorry, but you are short $" + amount);
        this.amount = amount;
    }
    
    public double getAmount(){
        return amount;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
