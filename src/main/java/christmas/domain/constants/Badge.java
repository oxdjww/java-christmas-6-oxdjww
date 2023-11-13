package christmas.domain.constants;

public enum Badge {
    별(5000),
    트리(10000),
    산타(20000),
    ;
    private final int benefitAmount;

    Badge(final int benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public int getBenefitAmout() {
        return this.benefitAmount;
    }
}
