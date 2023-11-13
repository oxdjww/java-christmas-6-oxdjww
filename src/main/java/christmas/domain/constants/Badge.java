package christmas.domain.constants;

public enum Badge {
    별(5000),
    트리(10000),
    산타(20000),
    ;
    private final int benefitAmout;

    Badge(final int benefitAmount) {
        this.benefitAmout = benefitAmount;
    }

    public int getBenefitAmout() {
        return this.benefitAmout;
    }
}
