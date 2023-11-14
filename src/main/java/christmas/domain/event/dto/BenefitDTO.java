package christmas.domain.event.dto;

public record BenefitDTO(int dDayDiscountAmount, int specialDiscountAmount, int weekDayDiscountAmount,
                         int weekendDiscountAmount,
                         int freeChampagneDiscountAmount) {
}
