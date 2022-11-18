package com.epam.mjc;

import com.sun.jdi.connect.Connector;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {
    public static void main(String[] args) {
        String signatureStr = "public float mark()";

        int firstSemicolon = signatureStr.indexOf('(');
        int secondSemicolon = signatureStr.indexOf(')');

        String str1 = signatureStr.substring(0, firstSemicolon);
        String str2 = signatureStr.substring(firstSemicolon + 1, secondSemicolon);

        List<MethodSignature.Argument> arguments = new ArrayList<>();
        String[] arrFirst = str1.split(" ");
        String[] arr = str2.split(", ");
        MethodSignature methodSignature;

        if (arr[0].length() != 0) {
            for (int i = 0; i < arr.length; i++) {
                String[] currentArr = arr[i].split(" ");
                MethodSignature.Argument arg;
                arguments.add(arg = new MethodSignature.Argument(currentArr[0], currentArr[1]));
            }
            methodSignature = new MethodSignature(arrFirst[arrFirst.length - 1], arguments);
            if (arrFirst.length == 3) {
                methodSignature.setAccessModifier(arrFirst[0]);
                methodSignature.setReturnType(arrFirst[1]);
            } else {
                methodSignature.setReturnType(arrFirst[0]);
            }
        } else {
            methodSignature = new MethodSignature(arrFirst[arrFirst.length - 1]);
            if (arrFirst.length == 3) {
                methodSignature.setAccessModifier(arrFirst[0]);
                methodSignature.setReturnType(arrFirst[1]);
            } else {
                methodSignature.setReturnType(arrFirst[0]);
            }
        }



        System.out.println(methodSignature);
    }

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */


    public MethodSignature parseFunction(String signatureString) {

        int firstSemicolon = signatureString.indexOf('(');
        int secondSemicolon = signatureString.indexOf(')');

        String str1 = signatureString.substring(0, firstSemicolon);
        String str2 = signatureString.substring(firstSemicolon + 1, secondSemicolon);

        List<MethodSignature.Argument> arguments = new ArrayList<>();
        String[] arrFirst = str1.split(" ");
        String[] arr = str2.split(", ");
        MethodSignature methodSignature;

        if (arr[0].length() != 0) {
            for (int i = 0; i < arr.length; i++) {
                String[] currentArr = arr[i].split(" ");
                MethodSignature.Argument arg;
                arguments.add(arg = new MethodSignature.Argument(currentArr[0], currentArr[1]));
            }
            methodSignature = new MethodSignature(arrFirst[arrFirst.length - 1], arguments);
            if (arrFirst.length == 3) {
                methodSignature.setAccessModifier(arrFirst[0]);
                methodSignature.setReturnType(arrFirst[1]);
            } else {
                methodSignature.setReturnType(arrFirst[0]);
            }
        } else {
            methodSignature = new MethodSignature(arrFirst[arrFirst.length - 1]);
            if (arrFirst.length == 3) {
                methodSignature.setAccessModifier(arrFirst[0]);
                methodSignature.setReturnType(arrFirst[1]);
            } else {
                methodSignature.setReturnType(arrFirst[0]);
            }
        }



        return methodSignature;
    }
}
