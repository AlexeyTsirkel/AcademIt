package ru.academits.tsirkel.range.Range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return (number >= from && to >= number);
    }

    @Override
    public String toString() {
        return "[" + from + ", " + to + "]";
    }

    public Range getIntersection(Range range) {
        if (range.from >= this.to || range.to <= this.from) {
            return null;
        } else {
            return new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));
        }
    }

    public Range[] getUnion(Range range) {
        if (range.from > this.to || range.to < this.from) {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        } else {
            return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
        }
    }

    public Range[] getDifference(Range range) {
        if (range.from >= this.to || range.to <= this.from) {
            return new Range[]{new Range(this.from, this.to)};
        } else {
            if (this.from > range.from) {
                if (range.to >= this.to) {
                    return new Range[0];
                } else {
                    return new Range[]{new Range(range.to, this.to)};
                }
            } else {
                if (range.to > this.to) {
                    return new Range[]{new Range(this.from, range.from)};
                } else {
                    return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
                }
            }
        }
    }
}
