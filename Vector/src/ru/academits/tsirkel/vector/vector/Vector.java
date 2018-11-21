package ru.academits.tsirkel.vector.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) { throw new IllegalArgumentException("Размерность вектора задана не положительным числом!"); }
        this.components = new double[n];
    }

    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        this.components = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) { throw new IllegalArgumentException("Размерность вектора задана не положительным числом!"); }
        this.components = Arrays.copyOf(array, n);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < components.length; ++i) {
            if (i == components.length - 1) {
                sb.append(components[i]);
                break;
            }
            sb.append(components[i]).append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    public Vector doAddition(Vector vector) {
        if (this.getSize() < vector.getSize()) {
            this.components = Arrays.copyOf(this.components, vector.getSize());
        }
        for (int i = 0; i < vector.getSize(); ++i) {
            this.components[i] += vector.components[i];
        }
        return this;
    }

    public Vector doSubtract(Vector vector) {
        if (this.getSize() < vector.getSize()) {
            this.components = Arrays.copyOf(this.components, vector.getSize());
        }
        for (int i = 0; i < vector.getSize(); ++i) {
            this.components[i] -= vector.components[i];
        }
        return this;
    }

    public Vector doScalarMultiply(int num) {
        for (int i = 0; i < this.getSize(); ++i) {
            this.components[i] *= num;
        }
        return this;
    }

    public Vector doTurn() {
        return this.doScalarMultiply(-1);
    }

    public double getLength() {
        double length = 0;
        for (double e : this.components) {
            length += Math.pow(e, 2);
        }
        return Math.sqrt(length);
    }

    public Vector setComponent(int index, double comp) {
        if (index >= this.components.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс задан числом не входящим в длину диапазона!");
        } else {
            this.components[index] = comp;
            return this;
        }
    }

    public double getComponent(int index) {
        if (index < 0 || index >= this.components.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс задан числом не входящим в длину диапазона!");
        } else {
            return this.components[index];
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(components);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Vector vector = (Vector) obj;
        return Arrays.equals(components, vector.components);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        return new Vector(vector1).doAddition(vector2);
    }

    public static Vector getSubtract(Vector vector1, Vector vector2) {
        return new Vector(vector1).doSubtract(vector2);
    }

    public static double getScalarMultiply(Vector vector1, Vector vector2) {
        int minLength = Math.min(vector1.getSize(), vector2.getSize());
        double sum = 0;
        for (int i = 0; i < minLength; ++i) {
            sum += vector1.components[i] * vector2.components[i];
        }
        return sum;
    }
}
