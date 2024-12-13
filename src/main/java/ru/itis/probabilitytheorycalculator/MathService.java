package ru.itis.probabilitytheorycalculator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class MathService {
    public BigDecimal comWithoutRep(BigInteger n, BigInteger k) {
        BigInteger a = factorial(n);
        BigInteger b = factorial(k) .multiply(factorial(n.subtract(k)));
        return new BigDecimal(a).divide(new BigDecimal(b), 8, RoundingMode.HALF_UP);
    }

    public BigDecimal comWithRep(BigInteger n, BigInteger k) {
        return comWithoutRep(n.add(k).subtract(BigInteger.valueOf(1)), k);
    }

    public BigInteger perWithoutRep(BigInteger n) {
        return factorial(n);
    }

    public BigDecimal perWithRep(BigInteger...args) {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        for (BigInteger i : args) {
            a = a.add(i);
            b = b.multiply(factorial(i));
        }
        return new BigDecimal(factorial(a)).divide(new BigDecimal(b), 8, RoundingMode.HALF_UP);
    }

    public BigDecimal placeWithoutRep(BigInteger n, BigInteger k) {
        return new BigDecimal(factorial(n)).divide(new BigDecimal(factorial(n.subtract(k))), 8, RoundingMode.HALF_UP);
    }

    public BigInteger placeWithRep(BigInteger n, BigInteger k) {
        return n.pow(k.intValue());
    }

    public BigDecimal urnModel(BigInteger n, BigInteger m, BigInteger k, BigInteger r) {
        BigDecimal a = comWithoutRep(m, r);
        BigDecimal b = comWithoutRep(n.subtract(m), k.subtract(r));
        BigDecimal c = comWithoutRep(n, k);

        return a.multiply(b).divide(c, 8, RoundingMode.HALF_UP);
    }

    private static BigInteger factorial(BigInteger n) {
        if (n.intValue() == 0 || n.intValue() == 1) {
            return BigInteger.valueOf(1);
        }
        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
    }
}
