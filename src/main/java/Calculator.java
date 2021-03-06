/**
 * @name        Simple Java Calculator
 * @file        Calculator.java
 * @author      SORIA Pierre-Henry
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

import static java.lang.Double.NaN;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {


    public enum BiOperatorModes {
        /**
        *NORMAL        operator for normal.
        *ADD           operator for add.
        *MINUS         operator for minus.
        *MULTIPLY      operator for multiply.
        *DIVIDE        operator for divide.
        *XPOWEROFY     operator for xpowerofy.
        */
        NORMAL, ADD, MINUS, MULTIPLY, DIVIDE, XPOWEROFY
    }

    public enum MonoOperatorModes {
        /**
        *SQAURE         operator for square.
        *SQUAREROOT     operator for squareroot.
        *ONEDIVIDEDBY   operator for onedividedbt.
        *COS            operator for cos.
        *SIN            operator for sin.
        *TAN            operator for tan.
        *LOG            operator for log.
        *RATE           operator for rate.
        *ABS            operator for abs.
        */
        SQUARE, SQUAREROOT, ONEDIVIDEDBY, COS, SIN, TAN, LOG, RATE, ABS
    }

    /**
    *num1               variable for first number on calculation
    *num2               variable for first number on calculation
    */
    private Double num1, num2;
    /**
    *mode                variable for operator mode and default value is normal.
    */
    private BiOperatorModes mode = BiOperatorModes.NORMAL;

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.NORMAL) {
            return num2;
        }
        if (mode == BiOperatorModes.ADD) {
            if (num2 != 0) {
                return num1 + num2;
            }

            return num1;
        }
        if (mode == BiOperatorModes.MINUS) {
            return num1 - num2;
        }
        if (mode == BiOperatorModes.MULTIPLY) {
            return num1 * num2;
        }
        if (mode == BiOperatorModes.DIVIDE) {
            return num1 / num2;
        }
        if (mode == BiOperatorModes.XPOWEROFY) {
            return pow(num1, num2);
        }

        // never reach
        throw new Error();
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode == BiOperatorModes.NORMAL) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.NORMAL, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.NORMAL;

        return NaN;
    }

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode == MonoOperatorModes.SQUARE) {
            return num * num;
        }
        if (newMode == MonoOperatorModes.SQUAREROOT) {
            return Math.sqrt(num);
        }
        if (newMode == MonoOperatorModes.ONEDIVIDEDBY) {
            return 1 / num;
        }
        if (newMode == MonoOperatorModes.COS) {
            return Math.cos(num);
        }
        if (newMode == MonoOperatorModes.SIN) {
            return Math.sin(num);
        }
        if (newMode == MonoOperatorModes.TAN) {
            if (num == 0 || num % java.lang.Math.PI == 0) {
                return 0.0;
            }
            if ((num * 180 / java.lang.Math.PI) % 90 == 0 && (num * 180 / java.lang.Math.PI) % 180 != 0) {
                return NaN;
            }

            return Math.tan(num);
        }
        if (newMode == MonoOperatorModes.LOG) {
            return log10(num);
        }
        if (newMode == MonoOperatorModes.RATE) {
           return num / 100;
        }
        if (newMode == MonoOperatorModes.ABS) {
            return Math.abs(num);
        }

        // never reach
        throw new Error();
    }

}
