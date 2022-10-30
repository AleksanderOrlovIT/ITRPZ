package khai.edu.com;

import java.math.BigDecimal;

public interface MathOperations {
    int sum(BigDecimal a, BigDecimal b);

    int subtract(BigDecimal a, BigDecimal b);

    int multiple(BigDecimal a, BigDecimal b);

    int dividing(BigDecimal a, BigDecimal b);

    int modulo(BigDecimal a, BigDecimal b);
}
