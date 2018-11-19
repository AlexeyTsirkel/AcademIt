package ru.academits.tsirkel.vector.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) throw new IllegalArgumentException("Размерность вектора задана не положительным числом!");
        this.components = new double[n];
    }

    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        this.components = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) throw new IllegalArgumentException("Размерность вектора задана не положительным числом!");
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

    public Vector addVector(Vector vector) {
        Vector newVector = new Vector(vector.getSize() >= this.getSize() ? vector : this);
        for (int i = 0; i < Math.min(vector.getSize(), this.getSize()); ++i) {
            newVector.components[i] = this.components[i] + vector.components[i];
        }
        return newVector;
    }

    public Vector subtractVector(Vector vector) {
        Vector newVector = new Vector(Math.max(this.getSize(), vector.getSize()), this.components);
        for (int i = 0; i < Math.min(newVector.getSize(), vector.getSize()); ++i) {
            newVector.components[i] -= vector.components[i];
        }
        return newVector;
    }

    public Vector multiplyVector(int num) {
        Vector vector = new Vector(this);
        for (int i = 0; i < vector.getSize(); ++i) {
            vector.components[i] *= num;
        }
        return vector;
    }

    public Vector turnVector() {
        Vector vector = new Vector(this);
        for (int i = 0; i < vector.getSize(); ++i) {
            vector.components[i] *= -1;
        }
        return vector;
    }

    public double getLength() {
        double length = 0;
        for (double e : this.components) {
            length += Math.pow(e, 2);
        }
        return Math.sqrt(length);
    }

    public Vector setComponent(int index, double comp) {
        Vector newVector = new Vector(this);
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс задан отрицательным числом!");
        }
        if (index < newVector.components.length) {
            newVector.components[index] = comp;
            return newVector;
        } else {
            throw new ArrayIndexOutOfBoundsException("Индекс задан числом большим, либо равным длине диапазона!");
        }
    }

    public double getComponent(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс задан отрицательным числом!");
        }
        if (index < this.components.length) {
            return this.components[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Индекс задан числом большим, либо равным длине диапазона!");
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + getSize();
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
        return getSize() == vector.getSize() && (components != null && Arrays.equals(components, vector.components));
    }

    public static Vector addVectorStatic(Vector vector1, Vector vector2) {
        return new Vector(vector1).addVector(vector2);
    }

    public static Vector subtractVectorStatic(Vector vector1, Vector vector2) {
        return new Vector(vector1).subtractVector(vector2);
    }

    public static double scalarMultiply(Vector vector1, Vector vector2) {
        double sum = 0;
        for (int i = 0; i < (vector1.getSize() >= vector2.getSize() ? vector1.getSize() : vector2.getSize()); ++i) {
            sum += vector1.components[i] * vector2.components[i];
        }
        return sum;
    }
}
