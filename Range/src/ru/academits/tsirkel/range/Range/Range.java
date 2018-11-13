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
        if (range.from > this.to || range.to < this.from) {
            return null;
        } else {
            if (this.from >= range.from) {
                if (range.to >= this.to) {
                    return new Range(this.from, this.to);
                } else {
                    return new Range(this.from, range.to);
                }
            } else {
                if (range.to >= this.to) {
                    return new Range(range.from, this.to);
                } else {
                    return new Range(range.from, range.to);
                }
            }
        }
    }

    public Range[] getUnion(Range range) {
        if (range.from > this.to || range.to < this.from) {
            return new Range[] {this, range};
        } else {
            if (this.from >= range.from) {
                if (range.to >= this.to) {
                    return new Range[] {range};
                } else {
                    return new Range[] {new Range(range.from, this.to)};
                }
            } else {
                if (range.to >= this.to) {
                    return new Range[] {new Range(this.from, range.to)};
                } else {
                    return new Range[] {this};
                }
            }
        }
    }

    public Range[] getComplement(Range range) {
        if (range.from > this.to || range.to < this.from) {
            return new Range[] {this};
        } else {
            if (this.from >= range.from) {
                if (range.to >= this.to) {
                    return new Range[0];
                } else {
                    return new Range[] {new Range(range.to, this.to)};
                }
            } else {
                if (range.to >= this.to) {
                    return new Range[] {new Range(this.from, range.from)};
                } else {
                    return new Range[] {new Range(this.from, range.from), new Range(range.to, this.to)};
                }
            }
        }
    }
}
