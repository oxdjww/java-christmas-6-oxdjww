package christmas.domain.dish;

import christmas.domain.constants.Category;

public abstract class Dish {
    private final String name;
    private final int price;
    private final Category category;

    protected Dish(final String name, final int price, final Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public Category getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        return String.format(this.name + "(" + formatNumberWithComma(this.price) + ")");
    }

    private static String formatNumberWithComma(int number) {
        String numberStr = String.valueOf(number);
        int length = numberStr.length();

        StringBuilder formattedNumber = new StringBuilder();

        for (int i = 0; i < length; i++) {
            formattedNumber.append(numberStr.charAt(i));

            int remainingDigits = length - i - 1;
            if (remainingDigits > 0 && remainingDigits % 3 == 0) {
                formattedNumber.append(',');
            }
        }

        return formattedNumber.toString();
    }
}
