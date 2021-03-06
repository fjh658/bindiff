package com.google.common.math;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.math.*;

@GwtCompatible
final class MathPreconditions
{
    static int checkPositive(@Nullable final String s, final int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(new StringBuilder(26 + String.valueOf(s).length()).append(s).append(" (").append(n).append(") must be > 0").toString());
        }
        return n;
    }
    
    static long checkPositive(@Nullable final String s, final long n) {
        if (n <= 0L) {
            throw new IllegalArgumentException(new StringBuilder(35 + String.valueOf(s).length()).append(s).append(" (").append(n).append(") must be > 0").toString());
        }
        return n;
    }
    
    static BigInteger checkPositive(@Nullable final String s, final BigInteger bigInteger) {
        if (bigInteger.signum() <= 0) {
            final String value = String.valueOf(bigInteger);
            throw new IllegalArgumentException(new StringBuilder(15 + String.valueOf(s).length() + String.valueOf(value).length()).append(s).append(" (").append(value).append(") must be > 0").toString());
        }
        return bigInteger;
    }
    
    static int checkNonNegative(@Nullable final String s, final int n) {
        if (n < 0) {
            throw new IllegalArgumentException(new StringBuilder(27 + String.valueOf(s).length()).append(s).append(" (").append(n).append(") must be >= 0").toString());
        }
        return n;
    }
    
    static long checkNonNegative(@Nullable final String s, final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException(new StringBuilder(36 + String.valueOf(s).length()).append(s).append(" (").append(n).append(") must be >= 0").toString());
        }
        return n;
    }
    
    static BigInteger checkNonNegative(@Nullable final String s, final BigInteger bigInteger) {
        if (bigInteger.signum() < 0) {
            final String value = String.valueOf(bigInteger);
            throw new IllegalArgumentException(new StringBuilder(16 + String.valueOf(s).length() + String.valueOf(value).length()).append(s).append(" (").append(value).append(") must be >= 0").toString());
        }
        return bigInteger;
    }
    
    static double checkNonNegative(@Nullable final String s, final double n) {
        if (n < 0.0) {
            throw new IllegalArgumentException(new StringBuilder(40 + String.valueOf(s).length()).append(s).append(" (").append(n).append(") must be >= 0").toString());
        }
        return n;
    }
    
    static void checkRoundingUnnecessary(final boolean b) {
        if (!b) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
    
    static void checkInRange(final boolean b) {
        if (!b) {
            throw new ArithmeticException("not in range");
        }
    }
    
    static void checkNoOverflow(final boolean b) {
        if (!b) {
            throw new ArithmeticException("overflow");
        }
    }
}
