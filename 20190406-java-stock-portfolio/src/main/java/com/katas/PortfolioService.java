package com.katas;

public class PortfolioService {
    private final OperationsRepository operationsRepository;

    public PortfolioService(OperationsRepository operationsRepository) {
        this.operationsRepository = operationsRepository;
    }

    public void buyShares(String company, int amount) {
        Operation operation = new Operation(company, amount);
        operationsRepository.save(operation);
    }

    public void sellShares(String company, int amount) {
        Operation operation = new Operation(company, -amount);
        operationsRepository.save(operation);
    }

    public void print() {

    }
}
