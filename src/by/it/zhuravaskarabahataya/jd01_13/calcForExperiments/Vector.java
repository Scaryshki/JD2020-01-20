package by.it.zhuravaskarabahataya.jd01_13.calcForExperiments;

import java.util.Arrays;

class Vector extends Var implements Operation {
    private double[] values;

    public double[] getValues() {
        return values;
    }

    public Vector(double[] values) {
        this.values = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = values[i];
        }
    }

    public Vector(Vector vector) {
        this(vector.values);
    }

    public Vector(String strVector) {
        StringBuilder sb = new StringBuilder(strVector);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(0);
        String[] strArray = sb.toString().split(",");
        double[] doubleArray = new double[strArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(strArray[i]);
        }
        this.values = doubleArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double d : values) {
            sb.append(delimiter).append(d);
            delimiter = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        return other.add(this);
    }

    public Var add(Scalar other) throws CalcException {
        double[] result = Arrays.copyOf(values, values.length);
        double s =  other.getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] += s;
        }
        return new Vector(result);
    }

    public Var add(Vector other) throws CalcException {
        double[] result = Arrays.copyOf(values, values.length);
        if (this.values.length != ((Vector) other).values.length) {
            throw new CalcException("Разные размеры векторов " + this + " + " + other);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] += other.values[i];
        }
        return new Vector(result);
    }

    public Var add(Matrix other) throws CalcException {
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return other.sub(this);
    }

    @Override
    public Var sub(Scalar other) throws CalcException {
        double[] result = Arrays.copyOf(values, values.length);
        double s = ((Scalar) other).getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] -= s;
        }
        return new Vector(result);
    }

    @Override
    public Var sub(Vector other) throws CalcException {
        double[] result = Arrays.copyOf(values, values.length);
        if (this.values.length != ((Vector) other).values.length) {
            throw new CalcException("Разные размеры векторов " + this + " - " + other);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] -= other.values[i];
        }
        return new Vector(result);
    }

    @Override
    public Var sub(Matrix other) throws CalcException {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return other.mul(this);
    }

    @Override
    public Var mul(Scalar other) throws CalcException {
        double[] result = Arrays.copyOf(this.values, values.length);
        for (int i = 0; i < result.length; i++) {
            result[i] *= ((Scalar) other).getValue();
        }
        return new Vector(result);
    }

    @Override
    public Var mul(Vector other) throws CalcException {
        if (this.values.length != ((Vector) other).values.length) {
            throw new CalcException("Разные размеры векторов " + this + " * " + other);
        }
        int res = 0;
        for (int i = 0; i < values.length; i++) {
            res += values[i] * ((Vector) other).getValues()[i];
        }
        return new Scalar(res);
    }

    @Override
    public Var mul(Matrix other) throws CalcException {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return other.div(this);
    }

    @Override
    public Var div(Scalar other) throws CalcException {
        if ( other.getValue() == 0) {
            throw new CalcException("Деление на ноль");
        }
        double[] result = Arrays.copyOf(this.values, values.length);
        for (int i = 0; i < result.length; i++) {
            result[i] /= ((Scalar) other).getValue();
        }
        return new Vector(result);
    }

    @Override
    public Var div(Vector other) throws CalcException {
        return super.div(other);
    }

    @Override
    public Var div(Matrix other) throws CalcException {
        return super.div(other);
    }
}
