package christmas.domain.constants;

public enum Badge {
    별(5_000),
    트리(10_000),
    산타(20_000),
    ;
    private final int benefitAmount;

    Badge(final int benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public int getBenefitAmout() {
        return this.benefitAmount;
    }
}
